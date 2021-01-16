package design_module.BuilderPattern.testcase1;

/**
 * @author moubin.mo
 * @date: 2020/12/27 17:36
 */
//一顿饭 构造过程的封装类
public class MealBuilder {
	//构造素餐
	public Meal prepareVegMeal (){
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}
	//构造荤餐
	public Meal prepareNonVegMeal (){
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}
