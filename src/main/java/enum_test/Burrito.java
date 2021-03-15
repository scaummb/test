package enum_test;

/**
 * <p>swith中使用enum</p>
 *
 * @author momoubin
 * @date 2020/5/4
 */
public class Burrito {
	Spiciness degree;

	public Burrito(Spiciness degree) {
		this.degree = degree;
	}

	public void describe() {
		System.out.println("This burrito is ");
		switch (degree) {
			case HOT:
				System.out.println("Hot");
				break;
			case MILD:
				System.out.println("MILD");
				break;
			case MEDIUM:
				System.out.println("MEDIUM");
				break;
			case FLAMING:
				System.out.println("FLAMING");
				break;
			default:
				System.out.println("may be too hot!!");
				break;
		}
	}

	public static void main(String[] args) {
		Burrito burrito = new Burrito(Spiciness.NOT),
				burrito1 = new Burrito(Spiciness.MEDIUM),
				burrito2 = new Burrito(Spiciness.FLAMING);
		burrito.describe();
		burrito1.describe();
		burrito2.describe();
	}
}
