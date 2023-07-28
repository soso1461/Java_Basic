package chapter2;

class Human {
	String name;
	int age;
	String address;
	
//	Human(String name, int age, String address) {
//		this.name = name;
//		this.age = age;
//		this.address = address;
//	}
	
	void eat() {
		System.out.println("밥을/를 먹는다.");
	}
}

// 직업 2개를 예시로 만듦
class Teacher extends Human {
//	String name;
//	int age;
//	String address;
	String school;
	int gradeClass;
	
	// 만약 부모 클래스의 기본 생성자가 없으면 자식 클래스에서 반드시 생성자를 만들어서 부모 클래스를 호출 해야함
//	Teacher(String name, int age, String address, String school, int gradeClass) {
//		super(name, age, address);
//		this.name = name;
//		this.age = age;
//		this.address = address;
//		this.school = school;
//		this.gradeClass = gradeClass;
//	}
//	
//	void eat(String food) {
//		System.out.println(food + "을/를 먹는다.");
//	}
	
	void teaching() {
		System.out.println(gradeClass + "에서 수업을 한다.");
	}
	
	@Override
	void eat() {
		System.out.println(school + "에서 밥을 먹습니다.");
	}	// 오버라이딩
	
	void eat(String food) {
		System.out.println(school + "에서 " + food + "을/를 먹습니다.");
	}	// 오버로드
}

class Police {
	String name;
	int age;
	String address;
	String position;
	String area;
	
	void eat(String food) {
		System.out.println(food + "을/를 먹는다.");
	}
	
	void patrol() {
		System.out.println(area + "를 순찰합니다.");
	}
}


public class Inheritance {

	public static void main(String[] args) {
		
		Human human = new Human();
		Teacher teacher = new Teacher();
		teacher.name = "선생님1";
		teacher.school = "한국고등학교";
		System.out.println(teacher.name);
		
		human.eat();
		teacher.eat();
		teacher.eat("밥");

	}

}
