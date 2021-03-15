package design_module.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/4/26 16 :21
 *
 * @author moubin.mo
 */

//订阅主题
public class Subject {

	//观察者列表
	private List<Observer> observers = new ArrayList<Observer>();
	//主题变更内容
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

}
