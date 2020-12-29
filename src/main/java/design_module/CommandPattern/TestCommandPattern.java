package design_module.CommandPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/28 23:17
 */

public class TestCommandPattern {
	public static void main(String[] args) {
		//某只股票
		Stock abcStock = new Stock();
		BuyStockCommand buyStockOrder = new BuyStockCommand(abcStock);
		SellStockCommand sellStockOrder = new SellStockCommand(abcStock);

		CommandExecutor commandExecutor = new CommandExecutor();
		commandExecutor.takeOrder(buyStockOrder);
		commandExecutor.takeOrder(sellStockOrder);

		//执行命令
		commandExecutor.placeOrders();
	}
}
