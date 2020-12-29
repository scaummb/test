package design_module.BuiderPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/27 17:36
 */
//一顿饭 构造过程的封装类
public class MealBuilder {
	public Meal prepareVegMeal (){
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}

	public Meal prepareNonVegMeal (){
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}
