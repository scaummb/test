package design_module.BuilderPattern.testcase2.drivemethod;

/**
 * <p>
 *     领域驱动设计（Domain-Driven Design，简称DDD）
 *     目的是对软件所涉及到的领域进行建模，以应对系统规模过大时引起的软件复杂性的问题。
 *     1.整个过程大概是这样的，开发团队和领域专家一起通过 通用语言(Ubiquitous Language)去理解和消化领域知识，
 *     2.从领域知识中提取和划分为一个一个的子领域（核心子域，通用子域，支撑子域），
 *     3.并在子领域上建立模型，
 *     4.再重复以上步骤，这样周而复始，构建出一套符合当前领域的模型。
 * </p>
 */
public class DDDAbstractDrivingMethod extends AbstractDrivingMethod {

	//添加DDD（领域驱动设计）的步骤
	public void addDDDDrivingMethodPuzzle(String puzzle) {
		super.addPuzzle(puzzle);
	}
}
