package design_module.principles;

/**
 * @author moubin.mo
 * @date: 2021/1/3 22:50
 */

public class InterfaceSegregationPrinciple {
	public static void main(String[] args) {
		CoderMan coderMan = new CoderMan();
		coderMan.movingBrick(new StoneBrick());
		coderMan.movingBrick(new SilverBrick());
		coderMan.movingBrick(new GoldBrick());
	}
}
//搬砖的程序员
class CoderMan{
	void movingBrick(Brick brick){
		//....
	}
}
//砖头
interface Brick{
}
//石头砖头
class StoneBrick implements Brick{
}
//银砖头
class SilverBrick implements Brick{
}
//金砖头
class GoldBrick implements Brick{
}