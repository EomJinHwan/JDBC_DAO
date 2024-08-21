package JDBC_DAO;

public class DeleteUserTest_DAO {
	public static void main(String[] args) {

		// 객체 생성
		UserDAO dao = new UserDAO();

		// 회원 정보 삭제
		dao.DeleteUser("cc");

		// 목록조회
		dao.getUserList();
	}

}
