package design_module.BuilderPattern.testcase2.drivemethod;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 驱动模式抽象类
 * </p>
 */
public abstract class AbstractDrivingMethod {
	protected volatile static List<String> puzzles = new ArrayList();

	protected void addPuzzle(String puzzle) {
		puzzles.add(puzzle);
	}

	public void listPuzzles(String driveMethodType) {
		System.out.println(driveMethodType + ": \n " + StringUtils.join(puzzles, ","));
	}
}
