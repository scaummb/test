package design_module.AbstractFactoryPattern.filesystem.FolderFactory;

import design_module.AbstractFactoryPattern.filesystem.Folder.Folder;

/**
 * @author moubin.mo
 * @date: 2021/2/11 23:07
 */

public interface FolderFactory {
	Folder createFolder();
}
