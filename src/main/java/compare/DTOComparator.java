package compare;

import java.util.Comparator;

/**
 * @author moubin.mo
 * @date: 2020/4/8 17:29
 */

public class DTOComparator implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		if (o1 != null && o2 != null){
			DTO doc1 = (DTO) o1;
			DTO doc2 = (DTO) o2;
			if (doc1.getSortNum() != null && doc2.getSortNum() != null){
				return (((DTO) o1).getSortNum() - ((DTO) o2).getSortNum());
			}
		}
		return 0;
	}
}
