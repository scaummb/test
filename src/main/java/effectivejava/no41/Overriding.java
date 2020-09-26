package effectivejava.no41;

/**
 * @author moubin.mo
 * @date: 2020/9/26 23:15
 */

public class Overriding {
	public static void main(String[] args) {
		Wine[] wines = {new Wine(), new SparklingWine(), new Champagne()};
		for (Wine wine : wines) {
			System.out.println(wine.name());
		}
	}
}

class Wine{
	String name(){return "wine";}
}

class SparklingWine extends Wine{
	@Override
	String name() {
		return "SparklingWine";
	}
}
class Champagne extends SparklingWine{
	@Override
	String name() {
		return "Champagne";
	}
}
