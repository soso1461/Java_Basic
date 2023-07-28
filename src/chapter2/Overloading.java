package chapter2;

// 오버로딩
// 같은 이름의 메서드를 여러 개 생성할 수 있도록 해주는 것

// 오버로딩 조건
// 이름이 같아야 함, 매개변수의 조합(타입, 개수, 순서)이 달라야함 (매개변수의 이름은 영향을 미치지 않음)
// 반환타입만이 다를 경우 오버로딩이 성립하지 않는다.
// 같은 클래스 내에서만 발생

public class Overloading {
	
	// 물건 금액 입력하면 총 금액
	double purchase(int productPrice) {
		double sum = productPrice * 1.1;
		return sum;
	} // 물건을 하나만 구매 했을 때
	
	double purchase(int product1Price, int product2Price) {
		double sum = (product1Price + product2Price) * 1.1;
		return sum;
	} // 물건을 두개 구매 했을 때
	
	double purchase(double product1Price, int product2Price) {
		double sum = (product1Price + product2Price) * 1.1;
		return sum;
	}
	
	double purchase(int product1Price, double product2Price) {
		double sum = (product1Price + product2Price) * 1.1;
		return sum;
	}
	
	// 매개변수의 이름은 오버로딩에 영향을 미치지 않음
	/* double purchase(int price) {
		double sum = price * 1.1;
		return sum;
	} */
	
	// 반환타입은 오버로딩에 영향을 미치지 않음
	/* int purchase(int productPrice) {
		int sum = (int) (productPrice * 1.1);
		return sum;
	} */
	
	//////////////////////////////////////////////
	// 메서드의 매개변수가 많아질 때의 문제
	// 학생 : 학번, 이름, 나이, 전화번호, 수업, 성적 
	
	static void studentInfoPrint(
		String studentNumber, String name, int age, String telNumber, String course, String grade
		) {
		System.out.println("학번 : " + studentNumber);
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("전화번호 : " + telNumber);
		System.out.println("수업 : " + course);
		System.out.println("성적 : " + grade);	
	}
	static void studentInfoPrint(Dto dto) {
			System.out.println("학번 : " + dto.studentNumber);
			System.out.println("이름 : " + dto.name);
			System.out.println("나이 : " + dto.age);
			System.out.println("전화번호 : " + dto.telNumber);
			System.out.println("수업 : " + dto.course);
			System.out.println("성적 : " + dto.grade);	
		}
	
	//////////////////////////////////////////////

	public static void main(String[] args) {
		// 매개변수에 일일이 값을 집어넣었는데 나중에 많아지면 이 값이 학번인지 전화번호인지 찾기가 힘듦
		studentInfoPrint("1232131", "홍길동", 30, "010-1234-5678", "경영학원론", "A+");
		
		Dto dto = new Dto();
		dto.studentNumber = "123123";
		dto.name = "홍길동";
		dto.age = 30;
		dto.telNumber = "010-1234-1234";
		dto.course = "경영학원론";
		dto.grade = "A+";
		// 이렇게 일일이 다 적어주는 것도 노가다의 느낌이 있음 -> 그래서 그것을 해결해 주는 것이 생성자
		
		studentInfoPrint(dto); // 넘겨줘서 실행시키기
	}
}

class Dto {
	String studentNumber; 
	String name; 
	int age; 
	String telNumber; 
	String course; 
	String grade;
}


