package model;

//Mock : 테스트를 위한 모조 객체
public class MockDAO {
	public void regist(String info) {
		System.out.println("MockDAO regist 메서드에서 데이터베이스에 정보를 등록:"+info);
	}
}
