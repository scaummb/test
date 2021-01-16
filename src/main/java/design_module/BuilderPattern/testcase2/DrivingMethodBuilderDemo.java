package design_module.BuilderPattern.testcase2;

import design_module.BuilderPattern.testcase2.drivemethod.AbstractDrivingMethod;

/**
 * @author moubin.mo
 * @date: 2021/1/16 14:35
 */

public class DrivingMethodBuilderDemo {
	public static void main(String[] args) {
		AbstractDrivingMethod dddAbstractDrivingMethod = DrivingMethodBuilder.buildDDDDrivingMethod();
		dddAbstractDrivingMethod.listPuzzles("dddDrivingMethod");

		AbstractDrivingMethod tddAbstractDrivingMethod = DrivingMethodBuilder.buildTDDDrivingMethod();
		tddAbstractDrivingMethod.listPuzzles("tddDrivingMethod");
	}
}
