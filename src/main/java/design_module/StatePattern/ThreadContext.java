package design_module.StatePattern;

//保管线程状态的数据
public class ThreadContext {
   private State state;
 
   public ThreadContext(){
      state = null;
   }
 
   public void setState(State state){
      this.state = state;     
   }
 
   public State getState(){
      return state;
   }
}