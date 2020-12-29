package design_module.StatePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/29 23:41
 */

public class RunnableState implements State {
	@Override
	public void doAction(ThreadContext context) {
		context.setState(this);
	}
}
