package design_module.AbstractFactoryPattern.filesystem.FolderFactory;

import design_module.AbstractFactoryPattern.filesystem.Folder.Folder;
import design_module.AbstractFactoryPattern.filesystem.Folder.LinuxFolder;

/**
 * @author moubin.mo
 * @date: 2021/2/11 22:55
 */

public class LinuxSystemFolderFactory implements FolderFactory{
	@Override
	public Folder createFolder() {
		return new LinuxFolder();
	}
}
