package design_module.VisitorPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/29 23:07
 */

public interface ComputerPart {
	public void accept(ComputerPartVisitor computerPartVisitor);
}
