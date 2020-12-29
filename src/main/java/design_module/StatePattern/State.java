package design_module.StatePattern;

public interface State {
   //状态抽象，定义了所有状态都要有的行为
   public void doAction(ThreadContext context);
}