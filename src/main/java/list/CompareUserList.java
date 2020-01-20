package list;

import java.util.ArrayList;

/**
 * @author moubin.mo
 * @date: 2020/1/19 10:14
 */

public class CompareUserList {
	public static void main(String[] args) {
		ArrayList<Long> olds = new ArrayList<>();
		ArrayList<Long> news = new ArrayList<>();
		olds.addAll(new ArrayList(){{add(1);add(2);add(3);}});
		news.addAll(new ArrayList(){{add(4);add(2);add(3);}});
		ArrayList<Long> oldscopy = (ArrayList<Long>) olds.clone();
		oldscopy.removeAll(news);
		// 被剔除的人
		System.out.println(olds);
		System.out.println(oldscopy);
	}
}
