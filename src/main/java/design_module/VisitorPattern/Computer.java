package design_module.VisitorPattern;

public class Computer implements ComputerPart {
   
   ComputerPart[] parts;

   //构造器：初始化访客可以执行的行为：鼠标、显示器 而 键盘(不授权)
   public Computer(){
      parts = new ComputerPart[] {new Mouse(), new Monitor()};
   } 
 
   @Override
   public void accept(ComputerPartVisitor computerPartVisitor) {
      for (int i = 0; i < parts.length; i++) {
         parts[i].accept(computerPartVisitor);
      }
      computerPartVisitor.visit(this);
   }
}