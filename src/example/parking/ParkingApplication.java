package example.parking;

import java.util.Scanner;

// !!!입력 했으면 검증을 해라!!!

// 주차 관리 프로그램
// 주차 등록
// 주차 확인
// 출차

// 데이터
// 차량번호, 차종, 주차공간, 층수, 입차 시간, 출차 시간, 요금, 차량 수,

// 층 수 : 10층, 층 당 30대, 경차 : 1000, 중대형 : 1500, SUV : 2000
// 장애인(임산부, 노약자, 유공자), 차량 높이, 장기 주차, 전기차, 주차 시간당 할인, 제휴할인
public class ParkingApplication {

	public static void main(String[] args) {

		// 주차 공간
		boolean[][] parkingSpaces = new boolean[10][30];
		// 주차한 차량 번호
		String[][] registerNumbers = new String[10][30];
		// 입차 시간
		int[][] getInTimes = new int[10][30];
		// 차종
		String[][] types = new String[10][30];

		// 전체 여유 공간
		int totalFreeSpace = 0;
		for (boolean[] layer : parkingSpaces) {
			for (boolean space : layer) {
				if (!space)
					totalFreeSpace++;
			}
		}
		System.out.println("여유 공간 : " + totalFreeSpace);

		// 층별 여유 공간
		int[] layerFreeSpaces = new int[10];
		for (int layer = 0; layer < parkingSpaces.length; layer++) {
			for (boolean space : parkingSpaces[layer]) {
				if (!space)
					layerFreeSpaces[layer]++;
			}
		}
		for (int layer = 0; layer < layerFreeSpaces.length; layer++) {
			System.out.println(layer + 1 + "층 여유 공간 : " + layerFreeSpaces[layer]);
		}

		Scanner scanner = new Scanner(System.in);

		// 입차
		System.out.print("차량 번호 : ");
		String registerNumber = scanner.nextLine();

		System.out.print("차종 : ");
		String type = scanner.nextLine();

		System.out.print("입차 시간 (0 ~ 24) : ");
		int getInTime = scanner.nextInt();

		System.out.print("주차 층 (0 ~ 9) : ");
		int parkingLayer = scanner.nextInt();

		System.out.print("주차 공간 (0 ~ 29) : ");
		int parkingSpace = scanner.nextInt();

		// 차량번호 검증
		if (registerNumber != null && registerNumber.isBlank()) {
			System.out.println("차량번호를 반드시 입력하세요.");
			return;
		}

		// 차종 검증
		if (type != null && !type.equals("경차") && !type.equals("중대형") && !type.equals("SUV")) {
			System.out.println("경차, 중대형, SUV 중에 하나를 입력하세요.");
			return;
		}

		// 입차시간 검증
		if (getInTime < 0 || getInTime > 24) {
			System.out.println("입차 시간은 0 ~ 24 사이어야 합니다.");
			return;
		}

		// 주차 층 검증
		if (parkingLayer < 0 || parkingLayer > 9) {
			System.out.println("주차 층은 0 ~ 9 사이어야 합니다.");
			return;
		}
		
		// 주차 공간 검증
		if (parkingSpace < 0 || parkingSpace > 29) {
			System.out.println("주차 공간은 0 ~ 29 사이어야 합니다.");
			return;
		}
		
		// 해당 주차 공간이 비었는지 검증
		if (parkingSpaces[parkingLayer][parkingSpace]) {
			System.out.println("이미 주차된 공간입니다.");
			return;
		}
		
		// 주차
		parkingSpaces[parkingLayer][parkingSpace] = true;
		registerNumbers[parkingLayer][parkingSpace] = registerNumber;
		getInTimes[parkingLayer][parkingSpace] = getInTime;
		types[parkingLayer][parkingSpace] = type;
		
		// 주차 위치 확인
		scanner = new Scanner(System.in);
		System.out.print("확인할 차량 번호 : ");
		registerNumber = scanner.nextLine();
		
		if (registerNumber != null && registerNumber.isBlank()) {
			System.out.println("차량번호를 반드시 입력하세요.");
			return;
		}
		
		boolean found = false;
		for (int layer = 0; layer < registerNumbers.length; layer++) {
			for (int space = 0; space < registerNumbers[layer].length; space++) {
				
				if (registerNumber.equals(registerNumbers[layer][space]) ) {
					System.out.println(layer + "층 " + space + "번에 위치합니다.");
					found = true;
					break;
				}
				
				/*if (registerNumbers[layer][space].equals(registerNumber)) {
					System.out.println(layer + "층 " + space + "번에 위치합니다.");
				}*/
			}
			if (found) break;
		}
		if (!found) {
			System.out.println("찾을 수 없는 차량 번호입니다.");
			return;
		}
		
		// 출차
		scanner = new Scanner(System.in);
		System.out.print("출차할 차량번호 : ");
		registerNumber = scanner.nextLine();
		
		System.out.println("출차 시간 : ");
		int leaveTime = scanner.nextInt();
		
		if (registerNumber != null && registerNumber.isBlank()) {
			System.out.println("차량번호를 반드시 입력하세요.");
			return;
		}
		
		if (leaveTime < 0 || leaveTime > 24) {
			System.out.println("출차 시간은 0 ~ 24 사이어야 합니다.");
			return;
		}
		
		found = false;
		int foundLayer = -1;
		int foundSpace = -1;
		for (int layer = 0; layer < registerNumbers.length; layer++) {
			for (int space = 0; space < registerNumbers[layer].length; space++) {
				if (registerNumber.equals(registerNumbers[layer][space])) {
					foundLayer = layer;
					foundSpace = space;
					found = true;
					break;
				}
			}
			if (found) break;
		}
		
		if (!found) {
			System.out.println("찾을 수 없는 차량 번호입니다.");
			return;
		}
		
		if (leaveTime < getInTimes[foundLayer][foundSpace]) {
			System.out.println("출차 시간이 입차 시간보다 작을 수 없습니다.");
			return;
		}
		
		// 최종 금액 : (출차시간 - 입차시간) * 차량별 금액
		int typeAmount = 
				types[foundLayer][foundSpace].equals("경차") ? 1000 :
				types[foundLayer][foundSpace].equals("중대형") ? 1500 : 2000;
		
		int result = (leaveTime - getInTimes[foundLayer][foundSpace]) * typeAmount;
		System.out.println("최종 금액은 " + result + "원 입니다.");
		
		parkingSpaces[foundLayer][foundSpace] = false;
		registerNumbers[foundLayer][foundSpace] = null;
		getInTimes[foundLayer][foundSpace] = 0;
		types[foundLayer][foundSpace] = null;
		
		
	}
}
