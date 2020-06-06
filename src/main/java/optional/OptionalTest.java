package optional;

import com.alibaba.fastjson.JSON;

import java.util.Optional;

/**
 * <p>
 *      JDK8中引入了函数式编程，大大提高了我们编写代码的可读性，其中Optional则是为了避免NPE而生。
 * </p>
 * @author moubin.mo
 * @date: 2020/6/6 15:39
 */

public class OptionalTest {

	public static void main(String[] args) {
		Person person = new Person();
		Car car1 = new Car(new Wheel("suv"));
		person.setCar(car1);

		Person nullPerson = null;

		// method:ofNullable
		System.out.println(Optional.ofNullable(person));
		System.out.println(Optional.ofNullable(nullPerson));

		// method:map
		Optional<Car> car = Optional.ofNullable(person)
				.map(p -> p.getCar());
		System.out.println(JSON.toJSON(car));
		System.out.println(JSON.toJSON(car.get()));

		// method:null then set value
		String newCar = Optional.ofNullable(nullPerson)
				.map(p -> p.getCar())
				.map(car2 -> car2.getWheel())
				.map(wheel -> wheel.getBrand())
				.orElse("三轮车");
		System.out.println(newCar);

	}
}

class Wheel{

	private String brand;

	public Wheel(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}

class Car{
	private Wheel wheel;

	public Car(Wheel wheel) {
		this.wheel = wheel;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}
}

class Person{
	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}