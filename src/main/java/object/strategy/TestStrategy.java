package object.strategy;

/**
 * @author moubin.mo
 * @date: 2020/10/29 16:56
 */

public class TestStrategy {
	public static void main(String[] args) {
		SyncStrategy strategy = new SyncOrganizationStrategyOnDelete();
		System.out.println(strategy.getClass());
		// class object.strategy.SyncOrganizationStrategyOnDelete
	}
}
