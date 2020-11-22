package localbus;

/**
 * @author moubin.mo
 * @date: 2020/11/16 20:08
 */

public interface LocalBusOneshotSubscriber extends LocalBusSubscriber {
	void onLocalBusListeningTimeout();
}
