package design_module.principles;

/**
 * @author moubin.mo
 * @date: 2021/1/3 21:48
 */

public class LiskovSubstitutionPrinciple {
	public static void main(String[] args) {
		//使用Shape的子类Triangle 的实例来替换Shape的实例，程序工作正常
		working(new FemaleCoderPeople());
	}
	private static void working(CoderPeople shape){
		System.out.println("开始写代码");
		shape.coding();
		System.out.println("结束写代码");
	}
}
//写代码的人
class CoderPeople {
	public void coding(){
		//...
	}
}
//程序媛
class FemaleCoderPeople extends CoderPeople{
	@Override
	public void coding() {
		//...
	}
}