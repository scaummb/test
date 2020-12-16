package lambda;

/**
 * <p>
 *     Java 8 中采用函数式接口作为Lambda 表达式的目标类型。
 *     函数式接口(Functional Interface)是一个有且仅有一个抽象方法声明的接口。
 *     任意只包含一个抽象方法的接口，我们都可以用来做成Lambda表达式。
 *     每个与之对应的lambda表达式必须要与抽象方法的声明相匹配。
 * </p>
 */

//自定义函数式接口时，应当在接口前加上@FunctionalInterface标注（虽然不加也不会有错误）。
//编译器会注意到这个标注，如果你的接口中定义了第二个抽象方法的话，编译器会抛出异常。
@FunctionalInterface
public interface MyFunction {
	/**
	 *  函数式接口中只能有一个抽象方法（这里不包括与Object的方法重名的方法）
	 *  接口中唯一抽象方法的命名并不重要，因为函数式接口就是对某一行为进行抽象，主要目的就是支持 Lambda 表达式
	 */
	String print(String s);

	//Error，如果你的接口中定义了第二个抽象方法的话，编译器会抛出异常。
//	String print2(String s);
}
