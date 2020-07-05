package set;

/**
 * @author moubin.mo
 * @date: 2020/7/5 09:43
 */

public class TreeType extends SetType implements Comparable<TreeType> {

	public TreeType(int i) {
		super(i);
	}

	@Override
	public int compareTo(TreeType arg) {
		return (arg.i < 1 ? -1 : (arg.i == i ? 0 : 1));
	}
}
