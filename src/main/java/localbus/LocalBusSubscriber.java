package localbus;

/**
 * @author moubin.mo
 * @date: 2020/11/16 20:09
 */

public interface LocalBusSubscriber {
	LocalBusSubscriber.Action onLocalBusMessage(Object var1, String var2, Object var3, String var4);

	public static enum Action{
		none,
		cancelSubscription;

		Action() {
		}
	}
}
