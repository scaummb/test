package design_module.VisitorPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/29 23:10
 */

public class TestVisitorPattern {
	public static void main(String[] args) {
		ComputerPart computer = new Computer();
		computer.accept(new ComputerPartDisplayVisitor());
	}
}
