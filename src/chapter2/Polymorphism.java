package chapter2;

// 다형성 : 하나의 객체가 여러가지 형태를 가질 수 있는 것
// 오버로딩, 오버라이딩, 업캐스팅, 다운캐스팅 이렇게 존재

// 조상클래스(인터페이스) 타입 변수에 자손클래스(인터페이스를 구현한 클래스) 타입 인스턴스를 저장하는 것
class Super {
	int a;
	int b;
}

class Sub extends Super {
	int c;
	int d;
}

public class Polymorphism {

	public static void main(String[] args) {
		Super sp1 = new Super();
		Sub sb1 = new Sub();
		sb1.a = 1;
		sb1.b = 2;
		sb1.c = 3;
		sb1.d = 4;
		
		Super sp2 = sb1;
		System.out.println(sp2.a);
		System.out.println(sp2.b);
		//System.out.println(sp2.c);
		
		Sub sb2 = (Sub) sp2;
		//Sub sb2 = (Sub) sp1;
		System.out.println(sb2.c);		// 3, 4가 나옴 칸이 없었는데
		System.out.println(sb2.d);
		
	}

}
