package design_module.MementoPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/29 22:42
 */
//备忘录
public class Memento {
	private String state;

	public Memento(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
}
