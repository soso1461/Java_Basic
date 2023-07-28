package chapter2;

class Human1 {
	String name;
	int age;
}

public class JVM {
	
	static void function(int age, Human1 you) {
		age = 30;
		you.age = 30;
	}

	public static void main(String[] args) {
		
		Human1 you = new Human1();
		you.name = "홍길동";
		you.age = 20;
		
		int age = 20;
		
		function(age, you);
		System.out.println(age);		// 20 나옴 얘는 원본이 바뀌지 않아 20
		System.out.println(you.age);	// 30 나옴 얘는 주소가 바뀌는 거라서 그대로 내려옴
		
		// 
		
	}

}
