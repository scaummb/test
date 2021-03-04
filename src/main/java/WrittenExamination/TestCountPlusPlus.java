package WrittenExamination;

/**
 * <p>
 *     不如count= count++；我们都知道count++是后自增，这是明确的。但是JVM在处理的时候会将次语句处理为，
 *		 1.执行count=count（count=0）; JVM把count的值（其值为0）拷贝到临时变量区。   
 * 		2.再执行count++;  ，
 * 		3.当count++运行完毕，存存放在临时变量区的count=0的拷贝值（一直从未改变过）又赋给了count。所以最后结束，count还是原来的最初值。
 *
 * 	Java中变量分为静态变量，实例变量，临时变量。
 * 他们在JVM中存储的位置如下：
 * 静态变量    位于方法区
 * 实例变量    作为对象的一部分，保存在堆中。
 * 临时变量    保存于栈中，栈随线程的创建而被分配。
 *
 * 运行时数据区主要包括五个部分：程序计数器，方法区，本地方法栈，虚拟机栈，堆
 *
 * 程序计数器（线程私有）：程序计数器是一小块内存空间，当前JVM执行的字节码的行号，线程私有.JVM就准确的知道每个程序执行到了哪里了。
 * 虚拟机栈（线程私有）：虚拟机栈就是所谓的栈内存，线程私有，与线程的生命周期相同，线程结束，它（栈帧）也亡了。
 * 		局部变量表:操作数栈，动态链接， 方法出口
 * 本地方法栈（线程私有）：本地方法栈和虚拟机栈类似，只不过是本地方法栈中执行的是Native方法，Native方法就是所谓的用其他编程语言实现的方法，例如c语言。
 * 堆：（线程共享），对象存放，JVM所管理的内存中的最大的一块，线程共享，虚拟机启动时创建。此区域唯一用途——存储对象实例。(jdk7之后，常量池挪到堆里面)
 * 		（1）Eden Space 伊甸园 （2）Survivor Space 幸存者区(To Survivor、 From Survivor，这个两个区域的空间大小是一样的。)
 * 		（3）Old Gen老年代(当老年代被放满的之后，虚拟机会进行垃圾回收，称之为Major GC。)
 * 方法区：用于存储类加载信息、常量池、静态变量（static）、即时编译器编译后的代码等。
 * </p>
 */

public class TestCountPlusPlus {
	public static void main(String[] args) {
		int i = 1;
		i = i++;
		int j = i++;
		int k = i + ++i * i++;
		System.out.println("i = " + i);
		System.out.println("j = " + j);
		System.out.println("k = " + k);
	}
}
