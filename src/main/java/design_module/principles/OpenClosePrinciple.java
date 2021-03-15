package design_module.principles;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2021/1/3 21:09
 */

public class OpenClosePrinciple {
}

//公司工作
class Company {
	private List<Coder> coders = new ArrayList<>();

	void working() {
		for (Coder code : coders) {
			code.coding();
		}
	}
}

//程序员
interface Coder {
	void coding();
}

//程序媛
class FemaleCoder implements Coder, Salary {
	@Override
	public void coding() {
		//...
	}

	@Override
	public void raise() {
		//...我要加薪
	}
}

//程序猿
class MaleCoder implements Coder {
	@Override
	public void coding() {
		//...
	}
}

//待遇福利
interface Salary {
	//涨工资动作
	void raise();
}


