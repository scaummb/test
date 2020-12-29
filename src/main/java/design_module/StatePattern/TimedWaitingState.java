package design_module.StatePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/29 23:43
 */

public class TimedWaitingState implements State {
	@Override
	public void doAction(ThreadContext context) {
		context.setState(this);
	}
}
