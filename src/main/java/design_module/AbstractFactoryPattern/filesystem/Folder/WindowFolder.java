package design_module.AbstractFactoryPattern.filesystem.Folder;

/**
 * @author moubin.mo
 * @date: 2021/2/11 22:52
 */

public class WindowFolder implements Folder {
	private String path = "/C:/file";

	public String getPath() {
		return this.path;
	}
}
