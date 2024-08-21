package JDBC_DAO;

import java.time.LocalDate;

public class InsertUserTest_DAO {
	public static void main(String[] args) {
		// 객체 생성
		UserDAO dao = new UserDAO();
		// 회원 등록
		LocalDate birth = LocalDate.of(2014, 1, 1);
		dao.InsertUser("ssss", "1456", "o", "01022228888", birth);
		
		// 목록 조회
		dao.getUserList();
	}

}
