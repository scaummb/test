package innerClass.test3;

/**
 * <p>
 *    希望其他对象创建其某个内部类的对象，使用.new获得对外部类对象的引用。
 * </p>
 */
public class DotNew {
    //外围类仅仅提供了一个内部类，但是没有开放任何方法给客户端来调用，以达到从内部类的目的。
    public class Inner{
    }

    public static void main(String[] args) {
        //这种情况，因为外围类没有提供获取内部类Inner的方法，但我们又需要创建这个内部类，那就使用.new
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();
    }
}