package chapter1;

import java.util.Scanner;

public class ConsoleIO {

	public static void main(String[] args) {
		// Java의 콘솔을 이용한 입출력
		
		// 출력
		/* System.out 객체의 println() 또는 print() 메서드를 사용 */
		// println() : 줄바꿈이 이뤄지는 출력
		// print() : 줄바꿈이 이뤄지지 않는 출력
		System.out.print("출력입니다.");
		System.out.println("출력입니다.");
		
		// 입력
		/* java.util.Scanner 클래스를 사용 */
		// Scanner 클래스를 import를 하여 사용
		// System.in 객체를 Scanner에 포함하여야 함
		Scanner scanner = new Scanner(System.in); // Scanner를 그냥은 못쓰고 import를 해야지만 사용 가능
		// 각 타입별 입력 메서드
		// int - nextInt();
		// double - nextDouble();
		// String - nextLine();
		System.out.print("문장을 입력하세요 : ");
		String string = scanner.nextLine();
		System.out.println("입력하신 문장은 '" + string + "' 입니다. ");
		
		int number = scanner.nextInt();
		System.out.println(number);
		
		
		
	}
}
