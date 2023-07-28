package chapter1;

import java.util.Scanner;

// 제어문
// 프로그램의 흐름을 제어하고, 조건에 따라서 코드의 실행 여부를 결정하는 구문

public class Controll {

	public static void main(String[] args) {
		// 조건문
		// 특정 조건에 만족할 때 특정 코드를 실행하도록 하는 구문
		// if, else, switch

		// 1. if : 조건을 검사하여 해당 조건의 결과에 따라 실행 여부를 결정
		/* if (조건) {실행할 코드} */
		int age = 10;

		if (age > 19) {
			System.out.println("성인입니다.");
		}
		System.out.println("if문 외부");

		// 2. else : if문의 조건이 거짓일 경우 특정 코드 실행
		if (age > 19) {
			System.out.println("성인입니다.");
		} else {
			System.out.println("미성년자입니다.");
		}

		int number = 0;
		
		if (number > 0) {
			System.out.println("양수입니다.");
		} else if (number < 0) {
			System.out.println("음수입니다.");
		} else {
			System.out.println("0입니다.");
		} 
		
		// 3. switch : 특정 변수 혹은 표현식의 값에 따라 실행할 코드의 범위를 결정
		/* switch (표현식)) {
		case 값1:
			값1일 때부터 실행되는 코드
		case 값2:
			값2일 때부터 실행되는 코드
			break;
		case 값3:
			값3일 때부터 실행되는 코드
		default:
			기본적으로 실행되는 코드
		}
		*/
		
		int day = 2;
		switch (day) {
		case 1:
			System.out.println("일요일");
		case 2:
			System.out.println("월요일");
		case 3:
			System.out.println("화요일");
		case 4:
			System.out.println("수요일");
			break;
		case 5:
			System.out.println("목요일");
		case 6:
			System.out.println("금요일");
		case 7:
			System.out.println("토요일");
			break;
		default:
			System.out.println("한 주 끝!");
		}
		
		// 반복문
		// 특정 코드를 여러 번 실행하도록 하는 구문
		// for, while
		
		// 1. for : 반복횟수가 정해져 있을 때 사용하는 반복문
		/* for (조건에 사용될 변수 초기화; 조건문; 증감식) { 반복할 구문 } */
		
		// 특정 코드를 몇번 반복하고자 할 때 
//		System.out.println("이 문장은 10번 출력됩니다.");
		
		for (int count = 0; count < 100; count++) {
			System.out.println("이 문장은 100번 출력됩니다.");
		}
		
		// 특정한 순서를 가지고 반복하고자 할 때 
		// 3 * n = (3 * n)
//		System.out.println(" 3 * 1 = 3");
//		System.out.println(" 3 * 2 = 6");
//		System.out.println(" 3 * 3 = 9");
//		System.out.println(" 3 * 4 = 12");
//		System.out.println(" 3 * 5 = 15");
//		System.out.println(" 3 * 6 = 18");
//		System.out.println(" 3 * 7 = 21");
//		System.out.println(" 3 * 8 = 24");
//		System.out.println(" 3 * 9 = 27");
		
		for (int n = 1; n <= 9; n++)
		{
			System.out.println("3 * " + n + " = "+ 3 * n);
		}
		
		// 배열에 접근할 때 / 배열을 초기화할 때
		int[] numbers = new int[10];
//		number = 0;
//		for (int item: numbers) {
//			System.out.println(number);
//			item = number++;
//		}
		for (int index = 0; index < numbers.length; index++)
		{
			numbers[index] = index;
		}
		for (int index = 0; index < numbers.length; index++) {
			System.out.println(numbers[index]);
		}
		
		// foreach (향상된 for 문)
		// for (반복할 배열의 요소 타입 변수명: 반복할배열) { ... }
		// foreach 반복문은 읽기전용, 값을 바꿀 수는 없음
		for (int item: numbers) {
			System.out.println(item);
		}
		
		// example
		// 네자리수 이 수의 모든 자리 수를 다 더한 값은?
		number = 7654;
		int a = number % 10;
		int b = (number % 100) / 10;
		int c = (number % 1000) / 100;
		int d = (number % 10000) / 1000;
		System.out.println(a + b + c + d);
		// (number % (10^n)) / 10 ^ (n - 1)
		
		int sum = 0;
		for (int n = 1; n <= 4; n++) {
			// 10^n = Math.pow(10, n)
			sum += (number % Math.pow(10, n)) / Math.pow(10, n-1);
		}
		System.out.println(sum);
		
		int[] exam = new int[]{7, 6, 5 ,4};
		int result = 0;
		for (int index = 0; index < exam.length; index++)
		{
			result += exam[index];
		}
		System.out.println(result);
		
		// 2. while : 반복 횟수가 정해져 있지 않을 때 사용하는 반복문
		/* while (조건) { 반복 실행할 코드 } */
		
		number = 0;
		while (number < 10) {
			System.out.println(number);
			number++;
		}

		number = 0;
		while (number < 10){
			if (number == 9) break;
			if (number % 2 == 1) {
				number++;
				continue;
			}
			System.out.println(number);
			number ++;
		}
		
		while (true) {
			Scanner sc = new Scanner(System.in);
			int inputNumber = sc.nextInt();
			if (inputNumber == -1)
				break;
			System.out.println("입력한 수 : "+ inputNumber);
			
		}
	}
}
