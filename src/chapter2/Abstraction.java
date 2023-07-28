package chapter2;

// 추상화 : 설계단계에서 사용되는 기법, 구현을 할 수 없는 상황에서 기본적인 틀을 잡을 때 사용
// 추상클래스, 인터페이스

// 추상 클래스 : 추상 메서드를 포함하고 있는 클래스, 인스턴스를 생성할 수 없음 (미완성 클래스)
// 추상 메서드 : 선언부만 존재하고 구현부가 존재하지 않는 메서드 (미완성 메서드)
// 추상 클래스의 경우 반드시 확장하여 추상 메서드를 오버라이딩하여 구현한 후 인스턴스를 생성할 수 있음
abstract class Animal {
	String species;
	boolean fur;
	int legs;
	int wings;
	
	void walking(String destination) {
		System.out.println(destination + "로 걷는다.");
	}
	
	abstract void eating();
	abstract void sleep();
	
}

class Pig extends Animal {

	@Override
	void eating() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void sleep() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Abstraction {

	public static void main(String[] args) {
		Pig pig = new Pig(); // Animal은 사용할 수 없다 구현부에 구현이 없어서
	}

}
