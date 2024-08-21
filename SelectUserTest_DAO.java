package JDBC_DAO;

public class SelectUserTest_DAO {
	
	public static void main(String[] args) {
		
		//객체 생성
		UserDAO dao = new UserDAO();
		// 회원 목록 조회
		dao.getUserList();
	}

}
