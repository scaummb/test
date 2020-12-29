package design_module.MediatorPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/29 15:12
 */

public class ProjectManagerB implements ProjectManager {
	@Override
	public void addDemand(String demand) {
		ProduceManager.addDemend(new Demand("项目经理B 提了需求：" + demand));
	}
}
