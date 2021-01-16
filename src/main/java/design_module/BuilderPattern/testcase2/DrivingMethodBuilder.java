package design_module.BuilderPattern.testcase2;

import design_module.BuilderPattern.testcase2.drivemethod.DDDAbstractDrivingMethod;
import design_module.BuilderPattern.testcase2.drivemethod.AbstractDrivingMethod;
import design_module.BuilderPattern.testcase2.drivemethod.TDDAbstractDrivingMethod;

/**
 * <p>
 *     驱动方法构造器 DrivingMethodBuilder
 * </p>
 */
public class DrivingMethodBuilder {

	//构造DDDDrivingMethod
	public static AbstractDrivingMethod buildDDDDrivingMethod(){
		DDDAbstractDrivingMethod dddDrivingMethod = new DDDAbstractDrivingMethod();
		dddDrivingMethod.addDDDDrivingMethodPuzzle("1.通过 通用语言(Ubiquitous Language)去理解和消化领域知识");
		dddDrivingMethod.addDDDDrivingMethodPuzzle("2.从领域知识中提取和划分为一个一个的子领域（核心子域，通用子域，支撑子域）");
		dddDrivingMethod.addDDDDrivingMethodPuzzle("3.在子领域上建立模型");
		dddDrivingMethod.addDDDDrivingMethodPuzzle("4.再重复以上步骤，这样周而复始，构建出一套符合当前领域的模型");
		return dddDrivingMethod;
	}

	//构造TDDDrivingMethod
	public static AbstractDrivingMethod buildTDDDrivingMethod(){
		TDDAbstractDrivingMethod tddDrivingMethod = new TDDAbstractDrivingMethod();
		tddDrivingMethod.addTDDDrivingMethodPuzzle("1.先写功能测试，用户角度描述应用的新功能");
		tddDrivingMethod.addTDDDrivingMethodPuzzle("2.功能测试失败后，想办法推动开发，开发修改或编写代码让它通过（或者说至少让当前失败的测试通过）");
		tddDrivingMethod.addTDDDrivingMethodPuzzle("3.单元测试失败后，编写最少量的应用代码，刚好让单元测试通过。有时，要在第二步和第三步之前多次往复，直到我们觉得功能测试有一点进展为止");
		tddDrivingMethod.addTDDDrivingMethodPuzzle("4.再次运行功能测试，看是否通过，或者有没有进展");
		return tddDrivingMethod;
	}
}
