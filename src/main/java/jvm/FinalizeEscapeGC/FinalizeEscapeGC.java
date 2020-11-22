package jvm.FinalizeEscapeGC;

/**
 * REMARK
 *  JVM : 一次对象的自我拯救演示
 *  finalize 方法：任何一个对象的finalize方法都只会被系统自动调用一次（尽量避免使用它）
 *
 * @author: mmb
 * @date: 20-1-28
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes, i am still alive:) ");
    }

    @Override
    protected void finalize() throws Throwable {
        // 覆盖实现finalize方法
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次拯救自己
        SAVE_HOOK = null;
        System.gc(); //触发使用finalize()

        // 因为finalize方法优先级很低，所以暂停 0.5s 等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("first time check,no, i am dead :(");
        }

        // 下面这段代码和上面的完全相同，但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize方法优先级很低，所以暂停 0.5s 等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("second time check, no, i am dead :(");
        }

    }
}
