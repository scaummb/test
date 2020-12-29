package design_module.MementoPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/29 22:42
 */
//修改对象
public class Originator {
	private String state;

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	//保存到备忘录
	public Memento saveToStateMemento(){
		return new Memento(state);
	}

	//从备忘录查找备份数据
	public void getStateFromMemento(Memento memento){
		state = memento.getState();
	}
}
