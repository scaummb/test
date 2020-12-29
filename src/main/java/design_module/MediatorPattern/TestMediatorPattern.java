package design_module.MediatorPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/29 15:14
 */
//测试中介者模式
public class TestMediatorPattern {
	public static void main(String[] args) {
		ProjectManagerA projectManagerA = new ProjectManagerA();
		projectManagerA.addDemand("手机屏幕背景色随着手机壳变化而变化！");
		ProjectManagerA projectManagerB = new ProjectManagerA();
		projectManagerB.addDemand("手机屏幕背景色随着用户心情变化而变化!");
		ProduceManager.showdemands();
	}
}
