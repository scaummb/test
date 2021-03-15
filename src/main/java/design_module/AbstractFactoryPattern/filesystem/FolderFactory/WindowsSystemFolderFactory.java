package design_module.AbstractFactoryPattern.filesystem.FolderFactory;

import design_module.AbstractFactoryPattern.filesystem.Folder.Folder;
import design_module.AbstractFactoryPattern.filesystem.Folder.WindowFolder;

/**
 * @author moubin.mo
 * @date: 2021/2/11 22:57
 */

public class WindowsSystemFolderFactory implements FolderFactory {
	@Override
	public Folder createFolder() {
		return new WindowFolder();
	}
}
