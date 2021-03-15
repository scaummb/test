//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Utils;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;

public class ReflectionHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionHelper.class);

	public ReflectionHelper() {
	}

	public static List<Field> getFlattenFields(Class<?> type) {
		List<Field> fields = new ArrayList();

		for (Class clz = type; clz != null && clz != Object.class; clz = clz.getSuperclass()) {
			if (clz.getDeclaredFields() != null) {
				Field[] var3 = clz.getDeclaredFields();
				int var4 = var3.length;

				for (int var5 = 0; var5 < var4; ++var5) {
					Field f = var3[var5];
					fields.add(f);
				}
			}
		}

		return fields;
	}

	public static List<Method> getFlattenMethods(Class<?> type) {
		List<Method> methods = new ArrayList();

		for (Class clz = type; clz != null && clz != Object.class; clz = clz.getSuperclass()) {
			if (clz.getDeclaredMethods() != null) {
				Method[] var3 = clz.getDeclaredMethods();
				int var4 = var3.length;

				for (int var5 = 0; var5 < var4; ++var5) {
					Method m = var3[var5];
					methods.add(m);
				}
			}
		}

		return methods;
	}

	public static Type[] getGenericFieldParameterizedTypeArgumentTypes(Field field) {
		Type type = field.getGenericType();
		return type != null && type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
	}

	public static Set<Class<?>> getClassesInPackage(String packageName) {
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		return getClassesInPackage(loader, packageName);
	}

	public static Set<Class<?>> getClassesInPackage(ClassLoader loader, String packageName) {
		Set<Class<?>> classes = new HashSet();
		String path = packageName.replace('.', '/');

		try {
			Enumeration<URL> resources = loader.getResources(path);
			if (resources != null) {
				while (true) {
					while (true) {
						String filePath;
						do {
							if (!resources.hasMoreElements()) {
								return classes;
							}

							filePath = ((URL) resources.nextElement()).getFile();
							if (filePath.indexOf("%20") > 0) {
								filePath = filePath.replaceAll("%20", " ");
							}
						} while (filePath == null);

						if (filePath.indexOf("!") > 0 && filePath.indexOf(".jar") > 0) {
							String jarPath = filePath.substring(0, filePath.indexOf("!")).substring(filePath.indexOf(":") + 1);
							if (jarPath.indexOf(":") >= 0) {
								jarPath = jarPath.substring(1);
							}

							classes.addAll(getClassesFromJARFile(jarPath, path));
						} else {
							classes.addAll(getClassesFromDirectory(new File(filePath), packageName));
						}
					}
				}
			}
		} catch (IOException var7) {
			LOGGER.debug("Encountered IOException", var7);
		} catch (ClassNotFoundException var8) {
			;
		}

		return classes;
	}

	public static Set<Class<?>> getClassesFromDirectory(File directory, String packageName) throws ClassNotFoundException {
		Set<Class<?>> classes = new HashSet();
		if (directory.exists()) {
			String[] var3 = directory.list();
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				String file = var3[var5];
				if (file.endsWith(".class")) {
					String name = packageName + '.' + stripFilenameExtension(file);

					try {
						Class<?> clazz = Class.forName(name);
						classes.add(clazz);
					} catch (Throwable var9) {
						LOGGER.error("Error in loading class: " + name);
					}
				} else {
					File f = new File(directory.getPath() + "/" + file);
					if (f.isDirectory()) {
						if (LOGGER.isDebugEnabled()) {
							LOGGER.debug("Scan classes in directory: " + f.getPath());
						}

						classes.addAll(getClassesFromDirectory(f, packageName + "." + file));
					}
				}
			}
		}

		return classes;
	}

	public static Set<Class<?>> getClassesFromJARFile(String jar, String packageName) throws IOException, ClassNotFoundException {
		LOGGER.info("Load class from jar: " + jar);
		Set<Class<?>> classes = new HashSet();
		JarInputStream jarFile = new JarInputStream(new FileInputStream(jar));

		JarEntry jarEntry;
		do {
			jarEntry = jarFile.getNextJarEntry();
			if (jarEntry != null) {
				String className = jarEntry.getName();
				if (className.endsWith(".class")) {
					className = stripFilenameExtension(className);
					if (className.startsWith(packageName)) {
						try {
							Class<?> clz = Class.forName(className.replace('/', '.'));
							classes.add(clz);
						} catch (ClassNotFoundException var7) {
							LOGGER.warn("ClassNotFound {}", className.replace('/', '.'));
						} catch (NoClassDefFoundError var8) {
							LOGGER.warn("NoClassDefFound {}", className.replace('/', '.'));
						}
					}
				}
			}
		} while (jarEntry != null);

		IOUtils.closeQuietly(jarFile);
		return classes;
	}

	public static Set<Class<?>> loadClassesInJar(String pathToJar) {
		Set<Class<?>> classes = new HashSet();
		JarFile jarFile = null;

		try {
			jarFile = new JarFile(pathToJar);
			Enumeration<JarEntry> e = jarFile.entries();
			URL[] urls = new URL[]{new URL("jar:file:" + pathToJar + "!/")};
			URLClassLoader var5 = URLClassLoader.newInstance(urls);

			while (e.hasMoreElements()) {
				JarEntry je = (JarEntry) e.nextElement();
				if (!je.isDirectory() && je.getName().endsWith(".class")) {
					String className = je.getName().substring(0, je.getName().length() - 6);
					className = className.replace('/', '.');

					try {
						Class<?> c = Class.forName(className);
						classes.add(c);
					} catch (Exception var18) {
						LOGGER.error("Unable to find class {}", className);
					}
				}
			}
		} catch (Exception var19) {
			LOGGER.error("Exception", var19);
		} finally {
			if (jarFile != null) {
				try {
					jarFile.close();
				} catch (IOException var17) {
					;
				}
			}

		}

		return classes;
	}

	private static String stripFilenameExtension(String file) {
		return file.substring(0, file.lastIndexOf(46));
	}
}
