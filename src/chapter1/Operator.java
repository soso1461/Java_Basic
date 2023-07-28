package chapter1;

public class Operator {
	public static void main(String[] args) {
		// 연산자
		// 산술연산자, 대입연선자, 비교연산자, 논리연산자, 삼항연산자
		
		// 1. 산술연산자 : 사칙연산과 관련된 연산자
		int result;
		int a = 15;
		int b = 9;
		// + : 좌항에 우항을 더한 값을 반환
		result = 10 + 20;
		System.out.println(result);
		result = a + b;
		System.out.println(result);
		
		// - : 좌항에 우항을 뺀 값을 반환
		result = 10 - 20;
		System.out.println(result);
		result = a - b;
		System.out.println(result);
		
		// * : 좌항에 우항을 곱한 값을 반환
		result = 10 * 20;
		System.out.println(result);
		result = a * b;
		System.out.println(result);
		
		// / : 좌항에 우항을 나눈 값을 반환
		// 	   두 항이 모두 정수일 때는 나눈 값의 정수부만 반환
		//	   두 항 중 하나라도 실수이면 나눈 값이 그대로 저장
		result = 16 / 5;
		System.out.println(result);
		System.out.println(16 / 5.0);
		
		// % : 좌항에 우항을 나눈 나머지를 반환
		result = 16 % 5;
		System.out.println(result);
		
		// ++, -- : 증감 연산자로 피연산자를 1 증가 혹은 감소
		//			증감 연산자가 피연산자의 앞에 오느냐 뒤에 오느냐에 따라
		//			연산 되어지는 순서가 다름
		//			증감 연산자는 피연산자가 반드시 변수이어야함
		int c = 10;
		System.out.println(c);
		System.out.println(++c); // 먼저 값을 증가 시키고 연산 진행
		System.out.println(c++); // 연산 후에 값을 증가 시킴
		System.out.println(c);	// c : 12
		
		result = 10 + ++c;
		System.out.println(result); // result = 23, c = 13
		result = 20 - c++;			// result = 7, c = 13
		System.out.println(result);
		System.out.println(c);
		
		result = 20 - c-- + 10;		// result = 16 / c = 14
		System.out.println(result);
		System.out.println(c);
		
		int d = 10;
		d++;
		System.out.println("///////");
		System.out.println(d);
		System.out.println("///////");
		
		// 2. 대입 연산자 : 변수에 값을 할당할 때 사용하는 연산자
		// 좌항은 무조건 변수이어야 함
		// = : 좌항에 우항의 결과를 대입
		result = 5;
		// +=, -=, *=, /=, %= : 좌항에 우항과 좌항을 연산한 결과를 대입
		result += 3; // result = result + 3; result : 8
		result -= 2; // result = result - 2; result : 6
		result *= 2; // result = result * 2; result : 12
		result /= 5; // result = result / 5; result : 2
		result %= 3; // result = result % 3; result : 2
		
		// 10 += 3; // 이건 안됨 -> 좌항이 무조건 변수
		
		// 3. 비교 연산자 : 두 값을 비교하여 논리값의 결과를 반환하는 연산자
		// a : 15, b : 9
		boolean compareResult;
		
		// == : 좌항이 우항과 같은지를 비교
		compareResult = a == b;
		System.out.println(compareResult);
		
		// != : 좌항이 우항과 다른지를 비교
		compareResult = a != b;
		System.out.println(compareResult);
		
		// >, >= : 좌항이 우항보다 큰지, 크거나 같은지를 비교
		compareResult = a > b;
		System.out.println(compareResult);
		compareResult = a >= b;
		System.out.println(compareResult);
		
		// < , <= : 좌항이 우항보다 작은지, 크거나 같은지를 비교
		compareResult = a < b;
		System.out.println(compareResult);
		compareResult = a <= b;
		System.out.println(compareResult);

		char tmpC = 'a';
		compareResult = tmpC > a;
		System.out.println(compareResult);
		
		// 4. 논리 연산자 : 논리값을 조합 혹은 반전할 때 사용하는 연산자
		
		final boolean TRUE = true;
		final boolean FALSE = false;
		// &&(AND) : 좌항과 우항이 모두 true일 때 true, 하나라도 false면 false 반환
		compareResult = TRUE && TRUE;
		System.out.println(compareResult);
		compareResult = TRUE && FALSE;
		System.out.println(compareResult);
		compareResult = FALSE && TRUE;
		System.out.println(compareResult);
		
		// ||(OR) : 좌항과 우항 중 하나만 true라도 true, 모두 false면 false 반환
		compareResult = TRUE || TRUE;
		System.out.println(compareResult);
		compareResult = TRUE || FALSE;
		System.out.println(compareResult);
		compareResult = FALSE || FALSE;
		System.out.println(compareResult);
		
		// !(NOT) : 논리값을 반전시키는 연산자
		compareResult = !TRUE;
		System.out.println(compareResult);
		compareResult = !FALSE;
		System.out.println(compareResult);
		
		// 5. 삼항 연산자 : 논리 표현식의 결과에 따라 서로 다른 결과를 반환하는 연사낮
		/* 논리표현식 ? 참일때 결과(표현식) : 거짓일때 결과(표현식); */
		a = 9;
		String message = a > b ? "a는 b보다 큽니다" 
				: (a < b ? "a는 b보다 작습니다" : "a는 b와 같습니다.");
		System.out.println(message);
		
	}
}
