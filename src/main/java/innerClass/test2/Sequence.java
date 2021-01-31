package innerClass.test2;

//外围类
public class Sequence {
    //数组,私有对象
    private Object[] items;
    private int next = 0;
    //构造器
    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    //外围类构造内部类的方法
    public Selector selector() {
        return new SequenceSelector();
    }

    //内部类，私有描述符
    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean end() {
            //这里直接访问的是外围类的私有成员变量哦！
            return i == items.length;
        }
        @Override
        public Object current() {
            //这里直接访问的是外围类的私有成员变量哦！
            return items[i];
        }
        @Override
        public void next() {
            //这里直接访问的是外围类的私有成员变量哦！
            if (i < items.length) {
                i++;
            }
        }

    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        //获取内部类
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}