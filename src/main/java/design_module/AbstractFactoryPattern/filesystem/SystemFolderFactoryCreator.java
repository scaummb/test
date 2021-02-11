package design_module.AbstractFactoryPattern.filesystem;


import design_module.AbstractFactoryPattern.filesystem.FolderFactory.LinuxSystemFolderFactory;
import design_module.AbstractFactoryPattern.filesystem.FolderFactory.WindowsSystemFolderFactory;

/**
 * <p>
 *     抽象工厂接口
 * </p>
 */

public interface SystemFolderFactoryCreator {
	WindowsSystemFolderFactory getWindowsFolderFactory();
	LinuxSystemFolderFactory getLinuxFolderFactory();
}
