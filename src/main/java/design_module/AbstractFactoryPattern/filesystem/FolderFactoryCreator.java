package design_module.AbstractFactoryPattern.filesystem;

import design_module.AbstractFactoryPattern.filesystem.FolderFactory.LinuxSystemFolderFactory;
import design_module.AbstractFactoryPattern.filesystem.FolderFactory.WindowsSystemFolderFactory;

/**
 * <p>
 *     抽象工厂类
 * </p>
 */

public class FolderFactoryCreator implements SystemFolderFactoryCreator {
	@Override
	public WindowsSystemFolderFactory getWindowsFolderFactory() {
		return new WindowsSystemFolderFactory();
	}

	@Override
	public LinuxSystemFolderFactory getLinuxFolderFactory() {
		return new LinuxSystemFolderFactory();
	}
}
