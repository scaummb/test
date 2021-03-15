package set;

/**
 * @author moubin.mo
 * @date: 2020/7/5 09:42
 */

public class SetType {
	int i;

	public SetType(int i) {
		this.i = i;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof SetType && (i == ((SetType) obj).i);
	}
}
