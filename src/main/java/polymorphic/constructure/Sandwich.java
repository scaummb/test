package polymorphic.constructure;

/**
 * <p>
 *     1、构造器调用与继承层级相关
 *     2、导出对象的成员变量初始化 优先于 导出对象的构造器初始化
 * </p>
 * @author momoubin
 * @date 2020/5/10
 */
public class Sandwich extends PortableLunch{
    private Bread bread = new Bread();
    private Cheese cheese = new Cheese();
    private Lettuce lettuce= new Lettuce();

    public Sandwich() {
        System.out.println("Sandwich");
    }

    public static void main(String[] args) {
        Sandwich sandwich = new Sandwich();

    }
}

class Meal {
    public Meal() {
        System.out.println("Meal");
    }
}
class Bread{
    public Bread() {
        System.out.println("Bread");
    }
}

class Cheese{
    public Cheese() {
        System.out.println("Cheese");
    }
}

class  Lettuce {
    public Lettuce() {
        System.out.println("Lettuce");
    }
}

class Lunch extends Meal{
    public Lunch() {
        System.out.println("Lunch");
    }
}

class PortableLunch extends Lunch{
    public PortableLunch() {
        System.out.println("PortableLunch");
    }
}


