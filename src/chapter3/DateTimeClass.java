package chapter3;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// 날짜 및 시간 표현 방법
// 1. System.currentTimeMills();
// 2. Date 클래스
// 3. Calendar 클래스
// 4. LocalDateTime 클래스

public class DateTimeClass {

	public static void main(String[] args) {
		
		// 1. System.cuurentTimeMills();
		// 현재 운영체제의 시간을 1970년 1월 1일 0시 0분 0초 0밀리초 기준으로 경과한 시간을
		// 밀리초 기준으로 표현
		// 반환 타입 : long
		
		long start = System.currentTimeMillis();
		System.out.println("시작 시간 : " + start);
		
		/*for (int index = 0; index < 100; index++) {
			System.out.println("출력중...");
		}*/
		long end = System.currentTimeMillis();
		System.out.println("종료 시간 : " + end);
		
		System.out.println("경과 시간 : " + (end - start));
		
		// 2. Date 클래스
		// 초창기 자바에서부터 사용되어 오던 날짜 및 시간 관련 클래스
		// JDK 1.0 ~ JDK 1.1 -> 사용하지 않는 것을 권장하고 있음
		// 날짜를 표시하는 타입에서 사용됨
		
		Date date = new Date();
		System.out.println(date);
		
		date = new Date(123, 7, 1, 10, 10, 10);
		System.out.println(date);
		
		int year = 0;
		int month = 0;
		int dates= 0;
		year = date.getYear();
		month = date.getMonth();
		dates = date.getDate();
		System.out.println(year + " " + month + " " + dates);
		
		// 3. Calendar 클래스
		// Date 클래스를 대체하기 위해 나온 클래스, 추상 클래스 (GregorianCalendar 클래스 사용, getInstance() 메서드 사용)
		// JDK 8 버전까지 사용 되었음 - LocalDateTime으로 대체 되었음
		Calendar calendar = new GregorianCalendar();
		System.out.println(calendar);
		
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1; // MONTH는 0부터 시작
		dates = calendar.get(Calendar.DATE);
		System.out.println(year + " " + month + " " + dates);
		
		calendar.set(Calendar.YEAR, 2001);
		year = calendar.get(Calendar.YEAR);
		System.out.println(year + " " + month + " " + dates);
		
		// SimpleDateFormat 클래스
		// Date 타입의 인스턴스를 문자열로 표현하는 클래스
		// y : 연도, M : 월, d : 일, h : 시간, m : 분, s : 초
		// a : 오전/오후, E : 요일
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(simpleDateFormat.format(new Date()));
		
		// 4. LocalDateTime 클래스
		// JDK 8 이후에 나온 날짜 및 시간 관련 API 클래스
		// Date 클래스나 Calendar 클래스보다 직관적인 표현 및 연산이 가능
		
		// LocalTime 클래스 - 시간 관리 클래스
		// LocalDate 클래스 - 날짜 관리 클래스
		// LocalDateTime 클래스 - 날짜 및 시간 관리 클래스
		
		// now() : 현재시간 기준으로 인스턴스 생성
		LocalTime localTime1 = LocalTime.now();
		// of() : 특정 시간을 지정해서 인스턴스 생성
		LocalTime localTime2 = LocalTime.of(9, 33, 20);
		
		System.out.println(localTime1);
		System.out.println(localTime2);
		
		LocalDate localDate1 = LocalDate.now();
		LocalDate localDate2 = LocalDate.of(2023, 11, 30);
		
		System.out.println(localDate1);
		System.out.println(localDate2);
		
		LocalDateTime localDateTime1 = LocalDateTime.now();
		LocalDateTime localDateTime2 = LocalDateTime.of(localDate2, localTime2);
		
		System.out.println(localDateTime1);
		System.out.println(localDateTime2);
		
		// 특정 요소 가져오기 (get)
		// 해당 인스턴스에서 get~~~
		year = localDateTime1.getYear();
		month = localDateTime1.getMonthValue();
		dates = localDateTime1.getDayOfMonth();
		int hour = localDateTime1.getHour();
		int minute = localDateTime1.getMinute();
		int second = localDateTime1.getSecond();
		
		// 특정 요소 연산 (minus, plus)
		// 해당 인스턴스에서 minus~~~, plus~~~
		localDateTime2 = localDateTime2.minusYears(6).plusMonths(3).plusDays(10);
		System.out.println(localDateTime2);
		
		// 특정 요소 지정 (with)
		// 해당 인스턴스에서 with~~~
		localDateTime2 = localDateTime2.withHour(21).withMinute(10).withSecond(1);
		System.out.println(localDateTime2);
		
		// 날짜 및 시간 비교
		// isAfter() : 특정 인스턴스가 매개변수로 전달되는 날짜 인스턴스보다 이후인지
		// ifBefore() : 특정 인스턴스가 매개변수로 전달되는 날짜 인스턴스보다 이전인지
		// isEqual() : 특정 인스턴스가 매개변수로 전달되는 날짜 인스턴스와 같은지
		System.out.println(localDateTime1.isAfter(localDateTime2));
		System.out.println(localDateTime1.isBefore(localDateTime2));
		System.out.println(localDateTime1.until(localDateTime2, ChronoUnit.YEARS));
		
	}

}
