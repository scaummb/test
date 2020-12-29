package design_module.MediatorPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/29 15:06
 */

public class ProjectManagerA implements ProjectManager {
	@Override
	public void addDemand(String demand) {
		ProduceManager.addDemend(new Demand("项目经理A 提了需求：" + demand));
	}
}
