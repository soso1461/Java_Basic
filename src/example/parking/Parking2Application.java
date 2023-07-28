package example.parking;

import java.util.Scanner;

// 주차 관리 프로그램

// 여유 공간 확인
// 입차
// 주차 확인
// 출차

// 데이터
// 차량번호, 차종, 주차공간, 층수, 입차 시간, 출차 시간, 요금

// 가지고 있는 데이터와 입력으로 받아오는 데이터 구분
// 가지고 있는 데이터 : 주차공간, 층수, 요금
// 입력으로 받아오는 데이터 : 차량번호, 차종, 입차시간, 출차 시간

// 층 수 : 10층, 층 당 30대, 경차 : 1000, 중대형 : 1500, SUV : 2000

// 장애인(임산부, 노약자, 유공자), 차량 높이, 장기 주차, 전기차, 주차 시간당 할인, 제휴할인
class ParkingSpace {
	String registerNumber;
	int getInTime;
	String type;
	
	// 생성자 만들기 !! 1. 클래스와 이름이 같아야한다 2. 반환 타입이 없어야 한다 !! 꼭 기억하기
	ParkingSpace(String registerNumber, int getInTime, String type) {
		this.registerNumber = registerNumber;
		this.getInTime = getInTime;
		this.type = type;
	}
}

class EnterCarDto {
	String registerNumber;
	String type;
	int getInTime;
	int layer;
	int space;
	
	EnterCarDto(String registerNumber, String type, int getInTime, int layer, int space) {		// 생성자로 이렇게 만들면 크게 2가지 문제가 있음   
		// 1. 반환 타입이 없음  
		// 2. 입력을 하다 오류가 뜨면 주차가 되면 안되는데 주차가 된다 (그래서 위의 class 변수에 초기값을 넣어도 된다 [하지만 이것은 너무 무식한 생각])
		
		this.registerNumber = registerNumber;
		this.type = type;
		this.getInTime = getInTime;
		this.layer = layer;
		this.space = space;
		/*try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("차량 번호 : ");
			this.registerNumber = scanner.nextLine();
			
			System.out.println("차종 : ");
			this.type = scanner.nextLine();
			
			System.out.println("입차 시간 (0 ~ 24) : ");
			this.getInTime = scanner.nextInt();
			
			System.out.println("주차 층 (0 ~ 9) : ");
			this.layer = scanner.nextInt();
			
			System.out.println("주차 공간 (0 ~ 29) : ");
			this.space = scanner.nextInt();
			
		} catch (Exception exception) {
			System.out.println("입력 오류입니다.");
//			return;			// 1. 그래서 이걸 지움
		}*/
	}
	
	static EnterCarDto getInstance() { // static을 해야 main에서 바로 사용 가능 // 반환은 EnterCarDto를 반환할 거임
		
		EnterCarDto instance = null;
		try {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("차량 번호 : ");
			String registerNumber = scanner.nextLine();
			
			System.out.println("차종 : ");
			String type = scanner.nextLine();
			
			System.out.println("입차 시간 (0 ~ 24) : ");
			int getInTime = scanner.nextInt();
			
			System.out.println("주차 층 (0 ~ 9) : ");
			int layer = scanner.nextInt();
			
			System.out.println("주차 공간 (0 ~ 29) : ");
			int space = scanner.nextInt();
			
			// todo : 사용자 입력 검증
			if (registerNumber == null || type == null) {
				System.out.println("입력 오류입니다.");
				return instance; // 이 리턴은 메서드를 종료시킴
			}
			
			// 		  차량 번호 (빈값인지 아닌지)
			if (registerNumber.isBlank()) {
				System.out.println("차량 번호를 반드시 입력하세요.");
				return instance;
			}
			
			//		  차종 (경차, 중대형, SUV로 입력했는지)
			boolean validType = type.equals("경차") || type.equals("중대형") || type.equals("SUV");
			if (!validType) { //이게 false면 
				System.out.println("경차, 중대형, SUV 중에 하나를 입력하세요.");
				return instance;
			}
			
			//		  입차 시간 (0 ~ 24 사이인지)
			if (getInTime < 0 || getInTime > 24) {
				System.out.println("입차 시간은 0 ~ 24 사이여야 합니다.");
				return instance;
			}
			
			//		  주차 층 (0 ~ 9 사이인지)
			if (layer < 0 || layer > 9) {
				System.out.println("주차 층은 0 ~ 9 사이여야 합니다.");
				return instance;
			}
			
			//		  주차 공간 (0 ~ 29 사이인지)
			if (space < 0 || space > 29) {
				System.out.println("주차 공간은 0 ~ 29 사이여야 합니다.");
				return instance;
			}
			
			instance = new EnterCarDto(registerNumber, type, getInTime, layer, space);
		} catch (Exception exception) {
			System.out.println("입력 오류입니다.");
		}
		return instance;
		
	}
}

class FindCarDto {
	int floor;
	int space;
	
	FindCarDto(int floor, int space) {
		this.floor = floor;
		this.space = space;
	}
}

public class Parking2Application {
	
	static final int LIGHT_FARE = 1000;
	static final int HEAVY_FARE = 1500;
	static final int SUV_FARE = 2000;
	
	static final ParkingSpace[][] PARKING_SPACES = new ParkingSpace[10][30];

	public static void main(String[] args) {
		while(true) {
			
			// -1이 만약 오면(input 클래스 메서드에서 -1를 return 했기 때문에) : 잘못된 값 / 0~5 : 정상 값
			int selectedMethod = input();
			if (selectedMethod == -1) continue;
			
			if (selectedMethod == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			
			if (selectedMethod == 1) {getAllFreeSpace();}
			if (selectedMethod == 2) {getFloorFreeSpace();}
			if (selectedMethod == 3) {enterCar();}
			if (selectedMethod == 4) {checkParking();}
			if (selectedMethod == 5) {outCar();}
			}
		}
	
	
	static int input() { 	// 클래스 메서드 생성
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("작업을 선택하세요. (1. 전체 주차공간 확인, 2. 층별 주차공간 확인, 3. 입차, 4. 차량확인, 5. 출차, 0. 종료) :");
		
		int selectedMethod = -1;
		// 정수가 아니라 예로 1`로 오타가 났을 때를 대비해 예외 선언
		try {
			selectedMethod = scanner.nextInt();
		} catch (Exception exception) {
			System.out.println("잘못된 입력입니다.");
			return -1; // 잘못 되었을 때에 -1를 return 해서 input에 -1이 반환 되면 int selectedMethod = input() 여기에 -1이 반환되어
					   // 그 밑에 if (selectedMethod == -1) continue;로 처리해 다시 입력할 수 있도록 하고 있다.
		}			
		
		boolean validInput = selectedMethod < 0 || selectedMethod > 5;
		if (validInput) {
			System.out.println("잘못된 입력입니다.");
			return -1;
		}
		
		return selectedMethod;
	}

	static void getAllFreeSpace() {		// 클래스 메서드 생성
		// todo : 전체 여유공간 출력
		int sum = 0;
		for (ParkingSpace[] floor: PARKING_SPACES) {
			for (ParkingSpace space: floor) {
				if (space == null) sum++;
			}
		}
		
		System.out.println("전체 여유 공간 : " + sum);
	}
	
	static void getFloorFreeSpace() {
		// todo : 층별 여유공간 출력
		int[] freeSpaces = new int[10];
		
		for (int layer = 0; layer < PARKING_SPACES.length; layer++) {
			for (ParkingSpace space : PARKING_SPACES[layer]) {
				if (space == null) freeSpaces[layer]++;
			}
		}
		
		for (int layer = 0; layer < freeSpaces.length; layer++) {
			System.out.println(layer + 1 + "층의 여유 공간 : " + freeSpaces[layer]);
		}
	}
	
	static void enterCar() {
		// todo : 사용자로부터 입력 (차량 번호, 차종, 입차 시간, 주차 층, 주차 공간)
		/*String registerNumber = null;
		String type = null;
		int getInTime = -1;
		int layer = -1;
		int space = -1;*/  // 이걸 밑과 같이 클래스로 하나로 줄임
		//EnterCarDto dto = new EnterCarDto();
		EnterCarDto dto = EnterCarDto.getInstance();
		if (dto == null) return;
		
		/*try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("차량 번호 : ");
			dto.registerNumber = scanner.nextLine();
			
			System.out.println("차종 : ");
			dto.type = scanner.nextLine();
			
			System.out.println("입차 시간 (0 ~ 24) : ");
			dto.getInTime = scanner.nextInt();
			
			System.out.println("주차 층 (0 ~ 9) : ");
			dto.layer = scanner.nextInt();
			
			System.out.println("주차 공간 (0 ~ 29) : ");
			dto.space = scanner.nextInt();
			
		} catch (Exception exception) {
			System.out.println("입력 오류입니다.");
			return;
		}*/		// 코드를 최대한으로 줄이기 위해 생성자로 만듦
		
		
		//		  해당 공간이 비어있는지
		if (PARKING_SPACES[dto.layer][dto.space] != null) {
			System.out.println("이미 주차된 공간입니다.");
			return;
		}
		
		// todo : 입차 처리
//		ParkingSpace parkingSpace = new ParkingSpace(registerNumber, getInTime, type); // 생성자로 밑의 3개의 코드 줄이기 // ** 그리고 이걸 또 줄일 수 있다(밑의 코드 참조).
//		parkingSpace.registerNumber = registerNumber;
//		parkingSpace.type = type;
//		parkingSpace.getInTime = getInTime;
		
//		PARKING_SPACES[layer][space] = parkingSpace;		// 이거를 밑으로 바꿔서 또 줄일 수 있음
		PARKING_SPACES[dto.layer][dto.space] = new ParkingSpace(dto.registerNumber, dto.getInTime, dto.type);		// ** 이렇게 줄여짐
		
		
	}
	
	// 1. 입력 2. 검증 3. 프로세스 4. 출력
	static void checkParking() {
		// todo : 주차 확인
		Scanner scanner = new Scanner(System.in);
		System.out.println("차량 번호를 입력하세요.");
		String registerNumber = scanner.nextLine();
		
		if (registerNumber == null) {
			System.out.println("입력 오류입니다.");
			return;
		}
		
		if (registerNumber.isBlank()) {
			System.out.println("차량 번호를 반드시 입력해주세요.");
			return;
		}
		
		/*int foundFloor = -1;
		int foundSpace = -1;
		
		for (int floor = 0; floor < PARKING_SPACES.length; floor++) {
			for (int space = 0; space < PARKING_SPACES[floor].length; space++) {
				
				if (PARKING_SPACES[floor][space] == null) continue;
					
				if (registerNumber.equals(PARKING_SPACES[floor][space].registerNumber)) {
					
					foundFloor = floor;
					foundSpace = space;
					break;
				}
			}
			if (foundFloor != -1 && foundSpace != -1) break;
		}*/
		
		FindCarDto findCarDto = findCar(registerNumber);
		
		if (findCarDto == null) {
			System.out.println("찾을 수 없는 차량 번호입니다.");
			return;
		}
		
		System.out.println(findCarDto.floor + "층 " + findCarDto.space + "번에 위치합니다.");
	}
	
	// 차량 번호, 출차시간 입력 -> 입력 검증 -> 주차공간 해당 차량 찾기 -> 존재하는 차량인지 검증 -> 
	// 입력한 출차 시간이 입차 시간보다 작은지 검증 -> 정산 -> 주차공간에서 차량 제거
	static void outCar() {
		// todo : 출차 처리
		String registerNumber = null;
		int outTime = -1;
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("차량번호 : ");
			registerNumber = scanner.nextLine();
			System.out.println("출차 시간 (0 ~ 24) : ");
			outTime = scanner.nextInt();
		} catch (Exception exception) {
			System.out.println("입력 오류입니다.");
			return;
		}
		
		if (registerNumber == null) {
			System.out.println("입력 오류입니다.");
			return;
		}
		
		if (registerNumber.isBlank()) {
			System.out.println("차량번호는 반드시 입력해주세요.");
			return;
		}
		
		if (outTime < 0 || outTime > 24) {
			System.out.println("출차 시간은 (0 ~ 24) 사이어야 합니다.");
			return;
		}
		
		FindCarDto findCarDto = findCar(registerNumber);
		if (findCarDto == null) {
			System.out.println("찾을 수 없는 차량번호입니다.");
			return;
		}
		
		ParkingSpace parkingSpace = PARKING_SPACES[findCarDto.floor][findCarDto.space];
		if (parkingSpace.getInTime < outTime) {
			System.out.println("출차 시간이 입차 시간보다 작을 수 없습니다.");
			return;
		}
		
		int typePayment = parkingSpace.type.equals("경차") ? LIGHT_FARE : 
			parkingSpace.type.equals("중대형") ? HEAVY_FARE : SUV_FARE;
		int payment = (outTime - parkingSpace.getInTime) * typePayment;
		System.out.println("최종 금액은 " + payment + "원 입니다.");
		
		PARKING_SPACES[findCarDto.floor][findCarDto.space] = null;
		
	}
	
	static FindCarDto findCar(String registerNumber) {
		FindCarDto dto = null;
		
		for (int floor = 0; floor < PARKING_SPACES.length; floor++) {
			for (int space = 0; space < PARKING_SPACES[floor].length; space++) {
				
				if (PARKING_SPACES[floor][space] == null) continue;
	
				if (registerNumber.equals(PARKING_SPACES[floor][space].registerNumber)) {
					dto = new FindCarDto(floor, space);
					break;
				}
			}
			if (dto != null) break;
		}
		
		return dto;
		
	}
}
