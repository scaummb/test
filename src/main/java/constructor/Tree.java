package constructor;

import Utils.PrintUtils;

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

    public static void main(String[] args) {
//        new Tree();
        new Tree(11);
        // 反射创建对象
        Class<Tree> targetClass = Tree.class;
        try{
            // 调用无参构造器，会出现异常 InstantiationException|NoSuchMethodException
            Tree tree = targetClass.newInstance();
            PrintUtils.printObjects(tree);
        } catch (Exception ex){
            PrintUtils.printObjects(ex);
        }
    }
}
