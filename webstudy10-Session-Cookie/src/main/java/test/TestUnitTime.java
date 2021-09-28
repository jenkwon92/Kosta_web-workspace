package test;

import java.util.Date;

/*
 * 쿠키에 저장할 시간 정보를 테스트
 */
public class TestUnitTime {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.toString()); //쿠키는 공란을 허용하지 않는다 
		//공란은 -으로 대체
		String time = date.toString().replace(" ", "-");
		System.out.println(time); 
	}
}
