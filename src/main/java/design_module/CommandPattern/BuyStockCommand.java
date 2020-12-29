package design_module.CommandPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/28 23:14
 */
//买入股票命令
public class BuyStockCommand implements Command {
	private Stock abcStock;

	public BuyStockCommand(Stock abcStock){
		this.abcStock = abcStock;
	}

	public void execute() {
		abcStock.buy();
	}
}