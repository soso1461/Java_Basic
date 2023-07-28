package chapter2;

// 인터페이스 : 클래스가 구현해야 하는 메서드들을 정의하는 것
// 사용측과 개발측의 분리를 위해 사용됨
// 모든 메서드가 추상메서드로 작성이 되어있음
// 모든 변수는 정적 상수로 작성이 되어있음

public interface Aircon {
	// 전원
	public abstract void power();
	// 풍량 조절
	public abstract int airVolumeControl();
	// 풍향 조절
	public abstract String windDirectionControl();
	// 온도 조절
	public abstract int temperatureControl();
	// 모드 변경
	public abstract String modeChange();
	// 예약 기능
	public abstract void scheduleTernation();
	
}
