package design_module.StatePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/29 23:42
 */

public class BlockState implements State {
	@Override
	public void doAction(ThreadContext context) {
		context.setState(this);
	}
}
