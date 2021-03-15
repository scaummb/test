package design_module.CommandPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/28 23:15
 */
//出售股票命令
public class SellStockCommand implements Command {
	private Stock abcStock;

	public SellStockCommand(Stock abcStock) {
		this.abcStock = abcStock;
	}

	public void execute() {
		abcStock.sell();
	}
}
