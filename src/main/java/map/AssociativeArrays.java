package map;

/**
 * 自定义实现Map，利用Object二维数组
 *
 * @author moubin.mo
 * @date: 2020/7/13 23:43
 */

public class AssociativeArrays<K, V> {
	private Object[][] pairs;
	private int index;

	public AssociativeArrays(int length) {
		pairs = new Object[length][2];
	}

	public void put(K key, V value) {
		if (index >= pairs.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		pairs[index++] = new Object[]{key, value};
	}

	@SuppressWarnings("unchecked")
	public V get(K key) {
		for (int i = 0; i < index; i++) {
			if (key.equals(pairs[i][0])) {
				return (V) pairs[i][1];
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < index; i++) {
			stringBuilder.append(pairs[i][0].toString());
			stringBuilder.append(" : ");
			stringBuilder.append(pairs[i][1].toString());
			if (i < index - 1) {
				stringBuilder.append("\n");
			}
		}

		return stringBuilder.toString();
	}


}
