package bigdecimal;

import java.math.BigDecimal;

/**
 * @author moubin.mo
 * @date: 2020/8/19 01:00
 */

public class TestBigDecimal {
	public static void main(String[] args) {
		test3();
		test4();
		test5();
	}

	private static void test3(){
		System.out.println(1.03 - 0.43);
		System.out.println(1.00 - 9 * 0.1);
	}

	/**
	 * <p>货架上依次有10美分、20美分、30美分、40美分等差价格递增的糖果，你手上有1美元（1美元=100美分）
	 * 那么你能买多少颗糖果呢？
	 * bigdecimal 进行货币计算
	 * </p>
	 */
	private static void test5(){
		final BigDecimal TEN_CENTS = new BigDecimal("0.1");
		int itemsBought = 0;
		BigDecimal funds = new BigDecimal("1.00");

		for (BigDecimal price = TEN_CENTS;
			funds.compareTo(price) >= 0;
			price = price.add(TEN_CENTS)){
			itemsBought++;
			funds = funds.subtract(price);
		}
		System.out.println(itemsBought + " items bought.");
		System.out.println("Change：$" + funds);
	}

	/**
	 * <p>货架上依次有10美分、20美分、30美分、40美分等差价格递增的糖果，你手上有1美元（1美元=100美分）
	 * 那么你能买多少颗糖果呢？
	 * float/double 进行货币计算
	 * </p>
	 */
	private static void test4(){
		double funds = 1.00;
		int itemsBought = 0;
		for (double price = 0.10; funds >= price; price += 0.10){
			funds -= price;
			itemsBought++;
		}
		System.out.println(itemsBought + " items bought.");
		System.out.println("Change：$" + funds);
	}

	private static void test2(){
		BigDecimal bigDecimal = new BigDecimal(0.01);
		System.out.println("intVal = " + bigDecimal.intValue());
		System.out.println("scale = " + bigDecimal.scale());
	}

	private static void test(){
		BigDecimal bigDecimal = new BigDecimal("-100.01");
		System.out.println("intVal = " + bigDecimal.intValue());
		System.out.println("scale = " + bigDecimal.scale());
	}

	private static void test1(){
		BigDecimal valueSec = new BigDecimal(1000000);
		BigDecimal valueFir = new BigDecimal(1000000);
		BigDecimal valueThi = new BigDecimal(-1000000);

		//尽量用字符串的形式初始化
		BigDecimal stringFir = new BigDecimal("0.005");
		BigDecimal stringSec = new BigDecimal("1000000");
		BigDecimal stringThi = new BigDecimal("-1000000");

		//加法
		BigDecimal addVal = valueFir.add(valueSec);
		System.out.println("加法用value结果：" + addVal);
		BigDecimal addStr = stringFir.add(stringSec);
		System.out.println("加法用string结果：" + addStr);

		//减法
		BigDecimal subtractVal = valueFir.subtract(valueSec);
		System.out.println("减法value结果：" + subtractVal);
		BigDecimal subtractStr = stringFir.subtract(stringSec);
		System.out.println("减法用string结果：" + subtractStr);

		//乘法
		BigDecimal multiplyVal = valueFir.multiply(valueSec);
		System.out.println("乘法用value结果：" + multiplyVal);
		BigDecimal multiplyStr = stringFir.multiply(stringSec);
		System.out.println("乘法用string结果：" + multiplyStr);

		//绝对值
		BigDecimal absVal = valueThi.abs();
		System.out.println("绝对值用value结果：" + absVal);
		BigDecimal absStr = stringThi.abs();
		System.out.println("绝对值用string结果：" + absStr);

		//除法
		BigDecimal divideVal = valueSec.divide(valueFir, 20, BigDecimal.ROUND_HALF_UP);
		System.out.println("除法用value结果：" + divideVal);
		BigDecimal divideStr = stringSec.divide(stringFir, 20, BigDecimal.ROUND_HALF_UP);
		System.out.println("除法用string结果：" + divideStr);

	}

}
