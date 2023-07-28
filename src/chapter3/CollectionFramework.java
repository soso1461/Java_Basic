package chapter3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;

// Collection Framework
// 데이터를 저장하는 구조를 제공하는 표준화된 인터페이스 및 클래스
// 저장, 검색, 수정, 삭제에 대한 기능을 제공
// [List, Set, Map], Queue, Stack

public class CollectionFramework {

	public static void main(String[] args) {
		
		// List 인터페이스
		// 순서가 있고 중복을 허용하는 데이터 저장 구조를 표현할 때 사용
		
		// 1. ArrayList 구현체
		// 내부적인 인덱스를 사용하여 요소를 저장 - 인덱스로의 접근이 빠름
		List<Integer> arrayList = new ArrayList<Integer>(); // <> 안에 '참조형 타입'만 넣을 수 있음 ex) Integer, Double ...
		// []
		// list에 데이터 추가 - add();
		arrayList.add(10);
		// [10]
		arrayList.add(12);
		// [10, 12]
		arrayList.add(1, 13); // 1번 인덱스에 13라고 넣겠다 !주의! 원래 있던 1번 인덱스의 12가 없어지는게 아니고 12가 2번 인덱스로 밀린다
		// [10, 13, 12]
		//arrayList.add("10"); 문자열이기에 안들어감
		System.out.println(arrayList);
		
		// list에 요소 불러오기 - get();
		System.out.println(arrayList.get(2)); // 2번 인덱스를 가져오겠다 -> 12
		
		// list에 요소 수정 - set();
		arrayList.set(1, 100); // 1번 인덱스의 값을 100으로 바꾸겠다.
		// [10, 100, 12]
		System.out.println(arrayList);
//		arrayList.set(4, 100);
//		System.out.println(arrayList);
		
		// list에 요소 삭제하기 - remove();
		arrayList.remove(0);
		System.out.println(arrayList);
		
		Integer element = 1234;
		System.out.println(arrayList);
		arrayList.remove(element);
		System.out.println(arrayList);
		
		// 2. LinkedList 구현체
		// 내부적인 이중 연결 리스트(요소와 요소의 관계가 맺어져 있음)를 사용하여 요소를 저장 - 데이터 추가, 삭제가 빠름, But 인덱스로의 접근이 느림
		List<Integer> linkedList = new LinkedList<Integer>();
		
		// Set 인터페이스
		// 순서가 없고 중복을 허용하지 않는 데이터 저장 구조를 표현할 때 사용
		
		// 1. HashSet
		// 해싱 기법을 이용해서 요소를 저장 - 검색 속도가 빠름
		Set<Integer> hashSet = new HashSet<Integer>();
		
		// set에 데이터 추가 - add();
		System.out.println("////////////////////////////");
		hashSet.add(99);
		hashSet.add(77);
//		hashSet.add(1, 0); // 몇번 인덱스에 넣겠다가 안됨
		hashSet.add(99); // 똑같은 데이터가 추가가 되지 않음
		System.out.println(hashSet);
		
		// set에 데이터 존재 여부 - contains();
		System.out.println(hashSet.contains(99));
		
		// set에 데이터 삭제 - remove();
		hashSet.remove(99);
		System.out.println(hashSet);
		
		// set에 구조의 사이즈 확인 - size();
		System.out.println(hashSet.size());
		
		// 2. LinkedHashSet
		// 해싱 기법과 요소와 요소간의 연결을 이용해서 요소를 저장 - 추가, 삭제 빠름
		Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
		
		// 3. TreeSet
		// Tree 구조를 사용하여 요소를 저장 - 요소가 정렬되어 저장 // TreeSet을 쓰면 오름차순으로 정렬된다 정도로만 알면 된다.
		Set<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(99);
		treeSet.add(77);
		System.out.println(treeSet);
		
		// map 인터페이스
		// key와 value를 한 쌍으로 요소를 가지는 구조이며, 순서가 없고 key에 대해서 중복을 허용하지 않음
		
		// 1. HashMap 구현체
		// 해싱 기법을 이용하여 데이터를 저장 - 검색 속도 빠름
		Map<String, String> hashMap = new HashMap<String, String>();
		
		// map에 데이터 추가, 수정 - put();
		hashMap.put("banana", "바나나"); //(  ,  ) 첫번째는 key, 두번째는 value를 받음
		System.out.println(hashMap);
		hashMap.put("apple", "사과");
		System.out.println(hashMap); // {banana=바나나, apple=사과}
		hashMap.put("apple", "사과1");
		System.out.println(hashMap); // {banana=바나나, apple=사과1}
		// add는 누적한다 느낌이고 put은 있으면 바꾸고 없으면 추가한다라는 느낌
		
		// map에 데이터 읽기 - get();
		System.out.println(hashMap.get("apple")); // 얘는 인덱스 번호가 없어서 key를 넣어줘야함
		System.out.println(hashMap.get("orange"));
		
		// map에 키 존재 여부 - containsKey();
		System.out.println(hashMap.containsKey("apple"));
		System.out.println(hashMap.containsKey("apple1"));
		
		// map에 데이터 삭제 - remove();
		hashMap.remove("apple");
		System.out.println(hashMap);
		
		// 2. LinkedHashMap 구현체
		// 해싱 기법과 요소와 요소간의 연결하여 데이터를 저장 - 추가, 삭제가 빠름
		Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		
		// 3. TreeMap 구현체
		// 트리 기법을 이용하여 데이터를 저장 - key를 기준으로 정렬되어 저장됨
		Map<String, String> treeMap = new TreeMap<String, String>();
		
		System.out.println("=====================================");
		
		// 로또 : 순서가 없고 중복이 없다 / 6자리 수
		Set<Integer> lotto = new HashSet<Integer>();
		Random random = new Random();
		
		while(lotto.size() < 6) {
			lotto.add(random.nextInt(45) + 1);
			
		}
			
		
		/*lotto.add(random.nextInt(45) + 1);
		lotto.add(random.nextInt(45) + 1);
		lotto.add(random.nextInt(45) + 1);
		lotto.add(random.nextInt(45) + 1);
		lotto.add(random.nextInt(45) + 1);
		lotto.add(random.nextInt(45) + 1);*/ // 그냥 이렇게 하면 중복된 숫자는 안나와서 4개나 5개가 출력될 수 있음
		
		System.out.println(lotto); 
		
		// 연금복권 : 7자리, 첫번째 자리는 1~5까지만, 나머지는 중복을 허용해서 0 ~ 9
		List<Integer> youngeom = new ArrayList<Integer>();
		for (int count = 0; count < 7; count ++) {
			if (count == 0) {
				youngeom.add(random.nextInt(5) + 1);
				continue;
			}
			
			youngeom.add(random.nextInt(10));
			
		}
		System.out.println(youngeom);
		
		System.out.println(UUID.randomUUID().toString());
		
		System.out.println(System.currentTimeMillis());
		
		
	}

}
