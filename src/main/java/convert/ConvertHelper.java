package convert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author moubin.mo
 * @date: 2020/1/2 18:13
 */


public class ConvertHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConvertHelper.class);
	private static Map<Class<?>, Map<String, Method>> s_map = new HashMap();

	public ConvertHelper() {
	}

	public static <D> D convert(Object src, Class<D> clzDst) {
		if (src == null) {
			return null;
		} else {
			assert clzDst != null;

			Object dst = null;

			try {
				dst = clzDst.newInstance();
			} catch (InstantiationException var4) {
				LOGGER.error("Unexpected exception", var4);
				throw new RuntimeException("Unexpected exception", var4);
			} catch (IllegalAccessException var5) {
				LOGGER.error("Unexpected exception", var5);
				throw new RuntimeException("Unexpected exception", var5);
			}

			BeanUtils.copyProperties(src, dst);
			return (D) dst;
		}
	}

	private static Map<String, Method> getMethodLookupMap(Class<?> clz) {
		Map var1 = s_map;
		synchronized (s_map) {
			Map<String, Method> methodMap = (Map) s_map.get(clz);
			if (methodMap == null) {
				methodMap = new HashMap();
				Method[] var3 = clz.getMethods();
				int var4 = var3.length;

				for (int var5 = 0; var5 < var4; ++var5) {
					Method method = var3[var5];
					String methodName = method.getName();
					if (methodName.startsWith("set") && method.getParameterTypes() != null && method.getParameterTypes().length == 1) {
						method.setAccessible(true);
						((Map) methodMap).put(methodName, method);
					}
				}
			}

			return (Map) methodMap;
		}
	}

	private static Method findSetter(Class<?> clz, String methodName) {
		Map<String, Method> methodMap = getMethodLookupMap(clz);
		return (Method) methodMap.get(methodName);
	}
}
