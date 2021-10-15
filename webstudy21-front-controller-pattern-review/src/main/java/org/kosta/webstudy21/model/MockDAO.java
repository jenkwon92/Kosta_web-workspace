package org.kosta.webstudy21.model;

public class MockDAO {
	private static MockDAO instance =new MockDAO();
	private MockDAO() {}
	public static MockDAO getInstance() {
		return instance;
	}
	public String findProductById(String id){
		String productInfo = null;
		if(id.equals("1"))
			productInfo = id+"새우깡 농심";
		return productInfo;
	}
}
