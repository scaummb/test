package design_module.BuiderPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/27 17:38
 */
//测试建造者模式
public class TestBuiderPattern {
	public static void main(String[] args) {
		MealBuilder mealBuilder = new MealBuilder();
		Meal vegMeal = mealBuilder.prepareVegMeal();
		System.out.println("Veg Meal");
		vegMeal.showItems();
		System.out.println("Total Cost: " +vegMeal.getCost());

		Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
		System.out.println("Non-Veg Meal");
		nonVegMeal.showItems();
		System.out.println("Total Cost: " +nonVegMeal.getCost());
	}
}
