package JDBC_DAO;

public class UpdateUserTest_DAO {
	public static void main(String[] args) {
		//객체 생성
		UserDAO dao = new UserDAO();
		
		//회원 정보 수정
		dao.UpdateUser("1234", "01077778888", "cc");
		
		//회원 정보 조회
		dao.getUserList();
	}

}
