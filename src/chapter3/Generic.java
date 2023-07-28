package chapter3;

import java.util.ArrayList;
import java.util.List;

class A {
	int a;
}

class B {
	int b;
}

class C {
	int c;
}

class Result<Type> {
	int code;
	String message;
	String name;
	Type age;
	
	void print() {
		System.out.println("안녕");
	}
	
	<Parameter> void print(Parameter parameter) { // 이렇게 제네릭을 지정할 수 있다
		
	}
}

public class Generic {
	
	List<?> createList(int number, boolean flag) {
		if (flag) {
			List<Integer> list = new ArrayList<Integer>();
			for (int index = 0; index < number; index++) {
				list.add(index);
			} return list;
		} else {
			List<String> list = new ArrayList<String>();
			for (int index = 0; index < number; index++) {
				list.add(Integer.toString(index));
			} return list;
		}
	}

	public static void main(String[] args) {
//		Result<Integer> result = new Result<Integer>(); // 이러면 지금 Type age;가 Integer age;가 됐음
//		result.age = 10;
		
		List<?> list = new ArrayList<Integer>(); // '?'를 넣어 Integer든 String이든 뭐든 넣고 싶을 떄를 위해 ? 를 사용
		
		
	}
}
