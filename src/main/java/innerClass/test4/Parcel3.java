package innerClass.test4;

public class Parcel3 {
    //静态内部类
    public static class Contents{
    }
    //非静态内部类
    class Destination{
    }

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        //非静态内部类，需要外围类的引用来创建
        Parcel3.Destination d = p.new Destination();
        //静态内部类，通过外围类名来直接创建
        Parcel3.Contents c = new Parcel3.Contents();
    }
}