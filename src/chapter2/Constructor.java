package chapter2;

// 생성자
// 클래스의 인스턴스를 생성할 때 호출되는 메서드
// 생성자의 이름은 클래스의 이름과 동일하고 반환 타입을 지정하지 않음

class Dog {
	String breed;
	String name;
	int age;
	
	Dog() {
		breed = "진돗개";
		name = "누렁이";
		age = 1;
		System.out.println("Dog 인스턴스 생성!");
	}
	
	// this : 현재 인스턴스를 지칭하는 키워드 / 위에 선언한 class 의 변수를 지칭하는 키워드
	Dog(String breed, String name, int age) {
		this.breed = breed;
		this.name = name;
		this.age = age;
	}
	
	Dog(Dog dog) {
		breed = dog.breed;
		name = dog.name;
		age = dog.age;
	}
}

public class Constructor {

	public static void main(String[] args) {
		Dog dog1 = new Dog(); // 생성자가 하나도 없다면 이거는 오류 안뜸 왜냐? 자바는 자동으로 생성자가 생성 되기 때문에
		Dog dog2 = new Dog();
		Dog dog3 = new Dog("포메라니안", "봄", 8);
		
		dog2.name = "나비";
		System.out.println(dog1.breed);
		System.out.println(dog1.name);
		System.out.println(dog1.age);
		
		dog1.name = "구렁이";
		
		System.out.println(dog3.breed);
		System.out.println(dog3.name);
		System.out.println(dog3.age);
		
		Dog dog = new Dog();
		
//		dog = dog3;				// !!! 여기서는 이렇게 dog에 dog3 주소를 넣어서
//		dog.name = "여름";				// !!! dog3에 "봄"이 -> "여름"으로 변하지만
//		System.out.println("//////");
//		System.out.println(dog3.name);
		
		dog.breed = dog3.breed;			// !!! 여기서는 dog에 dog3의 주소값을 넣은 것이 아님
		dog.name = dog3.name;
		dog.age = dog3.age;
		
		dog.name = "여름";				// !!! 그래서 여기서는 dog만 바꿔줘서 dog3는 "봄" 그대로이다.
//		System.out.println(dog3.name);
		
		
	}

}
