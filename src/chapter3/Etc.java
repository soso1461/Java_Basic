package chapter3;

// 열거형 타입 (enum)
// 제한된 선택을 하도록 강제하는 타입

enum Gender {
	MALE, FEMALE
}

public class Etc {
	
	/*static void printGender(String gender) { // 그냥 사용한 것
		if (gender.equals("남")) {
			System.out.println("남자입니다.");
		} if (gender.equals("여")) {
			System.out.println("여자입니다.");
		}
	}*/

	static void printGender(Gender gender) {	// 열거형을 사용한 것
		if (gender.equals(Gender.MALE)) {
			System.out.println("남자입니다.");
		} if (gender.equals(Gender.FEMALE)) {
			System.out.println("여자입니다.");
		}
	}
	
	public static void main(String[] args) {
//		printGender("여");						// 그냥 사용한 것(이렇게 하면 남을 적을지 남자를 적을지 여를 적을지 모른다)
		printGender(Gender.FEMALE);				// 열거형을 사용한 것
		
	}

}
