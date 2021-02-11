package design_module.AbstractFactoryPattern.filesystem.Folder;

/**
 * @author moubin.mo
 * @date: 2021/2/11 22:52
 */

public class LinuxFolder implements Folder{
	private String path = "/usr/bin";
	public String getPath() {
		return this.path;
	}
}
