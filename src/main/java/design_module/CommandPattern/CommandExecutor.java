package design_module.CommandPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2020/12/28 23:16
 */

public class CommandExecutor {
	private List<Command> orderList = new ArrayList<Command>();

	public void takeOrder(Command order){
		orderList.add(order);
	}

	public void placeOrders(){
		for (Command order : orderList) {
			order.execute();
		}
		orderList.clear();
	}
}
