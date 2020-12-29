package design_module.BuiderPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/27 17:28
 */
//纸质包装打包
public class PaperWrapper implements Packing {
	@Override
	public String pack() {
		return "PaperWrapper";
	}
}
