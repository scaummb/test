package set;

/**
 * @author moubin.mo
 * @date: 2020/7/5 09:42
 */

public class HashType extends SetType {

	public HashType(int i) {
		super(i);
	}

	@Override
	public int hashCode() {
		return i;
	}
}
