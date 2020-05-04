package constructor;

import Utils.PrintUtils;

import java.lang.reflect.Constructor;

/**
 * <p>
 *     构造器是特殊类型的方法，因为没有返回值。
 *     当只存在唯一一个构造器时，创建这个对象就必须符合构造器参数列表。
 *          1)如果你的类没有构造器，编译器会帮你创建一个无参构造器
 *          2)如果你的类以及定义了一个构造器，编译器会忽略你的无参构造器
 * </p>
 * @author momoubin
 * @date 2020年5月3日17:32:45
 */
public class Tree {

    private int height;
    public Tree(int i) {
        height = i;
    }

    // 添加无参构造器，反射创建对象则不会报错
    public Tree() {
    }

    @Override
    public String toString() {
        return "Tree{" +
                "height=" + height +
                '}';
    }

    public static void main(String[] args) {
//        new Tree();
        new Tree(11);
        // 反射创建对象
        Class<Tree> targetClass = Tree.class;
        try{
            // 如果只有无参构造器，会出现异常 InstantiationException|NoSuchMethodException
            Tree tree = targetClass.newInstance();
            PrintUtils.printObjects(tree);
            // 反射调用有参构造器，可以避免 无对应构造器的异常
            Constructor<Tree> cons = targetClass.getConstructor(int.class);
            Tree tree1 = cons.newInstance(12);
            PrintUtils.printObjects(tree1);
        } catch (Exception ex){
            PrintUtils.printObjects(ex);
        }
    }
}
