package design_module.MediatorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2020/12/29 14:57
 */
//产品经理
public class ProduceManager {

	private static List<Demand> demendList = new ArrayList<Demand>();

	public static void showdemands() {
		System.out.println("看看项目经理都提了哪些雷人需求......");
		for (Demand demand : demendList) {
			System.out.println(demand.getDescription());
		}
	}

	public static void addDemend(Demand demand) {
		demendList.add(demand);
	}
}
