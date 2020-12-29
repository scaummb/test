package design_module.StatePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/29 23:43
 */

public class TestStatePattern {
	public static void main(String[] args) {
		ThreadContext threadContext = new ThreadContext();

		NewState newState = new NewState();
		newState.doAction(threadContext);
		System.out.println(threadContext.getState());
		RunnableState runnableState = new RunnableState();
		runnableState.doAction(threadContext);
		System.out.println(threadContext.getState());
		BlockState blockState = new BlockState();
		blockState.doAction(threadContext);
		System.out.println(threadContext.getState());
		WaitingState waitingState = new WaitingState();
		waitingState.doAction(threadContext);
		System.out.println(threadContext.getState());
		TimedWaitingState timedWaitingState = new TimedWaitingState();
		timedWaitingState.doAction(threadContext);
		System.out.println(threadContext.getState());
		TerminaledState terminaledState = new TerminaledState();
		terminaledState.doAction(threadContext);
		System.out.println(threadContext.getState());

	}
}
