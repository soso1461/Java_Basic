package chapter2;

import chapter2_1.Modifier2; // 다른 패키지에 있는걸 데려오려면 import 해야한다.

// 제어자 : 클래스, 메서드, 변수에 부가적인 성질을 추가하는 키워드
// 접근제어자, 일반제어자(비접근제어자)

// 접근제어자 : 클래스, 메서드, 변수에 대한 접근 위치 제어
// public - 모든 곳에서 접근 가능
// protected - 같은 패키지 내부 혹은 상속 받은 클래스에서만 접근 가능
// default - 같은 패키지 내부에서 접근 가능
// private - 클래스 내부에서만 접근 가능

// 비접근제어자(일반제어자) : 접근에 대한 제어가 아닌 동작에 대한 제어
// final - 클래스, 메서드, 변수에서 사용 가능 / 클래스에서 사용하면 확장 불가능, 메서드에서 사용하면 오버라이딩(재정의) 불가능, 변수에서 사용하면 재할당 불가능
// static - 메서드, 변수에서 사용 가능 / 인스턴스 생성 없이 클래스 단위로 접근 가능하도록 함
// abstract - 클래스, 메서드 사용 가능 / 메서드에서 사용하면 추상적(구현부가 없는) 메서드를 의미, 클래스에서 사용하면 추상메서드를 포함하고 있는 클래스임을 의미

// private을 사용하면 굳이 final을 쓸 필요가 없다(어차피 접근조차 불가능)
final class FinalClass {
	int member;
	
}

class SuperClass {
	final int member1; // final의 다른 의미는 이걸 나는 필수로 한다라는 의미도 있음
	
	static int member2;
	
//	abstract void method1(); // 이걸 사용하려면 class 앞에 abstract 붙여야함
	
	void method1() {
		member1 = 10;
	}
	
	static void method2() {
		
	}
}

class SubClass extends SuperClass {
	
	@Override
	final void method1() {
		
	}
}

class Modifier3 extends Modifier2 {
	
	String defaultVariable;
	private String privateVariable;
	
	void method1() {
		super.protectedVariable = "protected"; // 상속받은 클래스 내에서만 가능해서 여기만 가능
		 									   // extends로 상속
		super.defaultVariable = "default";
		super.privateVariable = "private";
		this.privateVariable = "private"; // 바로 위에 class에 선언해줘서 class 내부에서만 사용 가능하다를 증명
	}
}

// 캡슐화 : '무결성'을 보장해주는게 캡슐화 -> 이 데이터는 바뀌지 않는다라는 것을 보장함 -> 보장해주기 위해 데이터를 은닉함
class Medicine1 {
	private int kp;	//private를 붙여 이 데이터가 바뀌지 않는다를 보장
	private int usp;
	
	Medicine1(int kp, int usp) {
		this.kp = kp;
		this.usp = usp;
	}
	
	int getKp() {
		return this.kp;
	}
	
	int getUsp() {
		return this.usp;
	}
	
	void setKp(int kp) {
		this.kp = kp;
	}
	
	void setUsp(int usp) {
		this.usp = usp;
	}
}

public class Modifier {

	public static void main(String[] args) {
		Modifier2 instance1 = new Modifier2();
		instance1.publicVariable = "public";
		instance1.protectedVariable = "protected";
		instance1.defaultVariable = "default";
		instance1.privateVariable = "private";
		
		Modifier3 instance2 = new Modifier3();
		instance2.protectedVariable = "protected"; // '상속받은 클래스에서만!' 접근 가능이다
		instance2.defaultVariable = "default";
		instance2.privateVariable = "private";
		
		SuperClass.member2 = 10;
		SuperClass.method2();
		
		Medicine1 medicine1 = new Medicine1(300, 250);
		System.out.println(medicine1.getKp()); //값을 불러올 수는 있으나 변경 못함(무결성 보장 가능) 
		System.out.println(medicine1.getUsp());
		medicine1.setKp(200);
		medicine1.setUsp(150);
	}

}
