package design_module.BuilderPattern.testcase2.drivemethod;

/**
 * <p>
 *     TDD是测试驱动开发（Test-Driven Development）
 *     是敏捷开发中的一项核心实践和技术，也是一种设计方法论。TDD的原理是在开发功能代码之前，先编写单元测试用例代码，测试代码确定需要编写什么产品代码。TDD虽是敏捷方法的核心实践，但不只适用于XP（Extreme Programming），同样可以适用于其他开发方法和过程。
 *     1.先写功能测试，用户角度描述应用的新功能
 *	   2.功能测试失败后，想办法编写代码让它通过（或者说至少让当前失败的测试通过）此时，使用一个或多个单元测试，定义希望代码实现的效果，保证为应用中的每一行代码（至少）编写一个单元测试
 *	   3.单元测试失败后，编写最少量的应用代码，刚好让单元测试通过。有时，要在第二步和第三步之前多次往复，直到我们觉得功能测试有一点进展为止
 *	   4.再次运行功能测试，看是否通过，或者有没有进展。这一步可能促使我们编写一些新的单元测试和代码等
 * </p>
 */
public class TDDAbstractDrivingMethod extends AbstractDrivingMethod {

	//添加TDD（测试驱动）的步骤
	public void addTDDDrivingMethodPuzzle(String puzzle) {
		super.addPuzzle(puzzle);
	}
}
