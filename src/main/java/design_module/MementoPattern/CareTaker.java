package design_module.MementoPattern;

import java.util.ArrayList;
import java.util.List;

//小贴心（提醒你哪些事情没有干）
public class CareTaker {
	// 备忘录列表(实战中，甚至可以改为业务对象列表)，核心是“备忘录小提醒”会持有备忘状态数据的容器
	private List<Memento> mementoList = new ArrayList<Memento>();

	public void add(Memento state) {
		mementoList.add(state);
	}

	public Memento get(int index) {
		return mementoList.get(index);
	}
}