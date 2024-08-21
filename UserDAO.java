package JDBC_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import JDBC.JDBCUtil;

public class UserDAO {

	private Connection connection = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedstatement = null;

	private String user_List = "select * from member";
	private String user_Insert = "insert into member(user_id, user_pw, name, phone, birth, created_at) values(?,?,?,?,?,CURRENT_TIMESTAMP)";
	private String user_Update = "update member set  user_pw=?, phone=? where user_id=?";
	private String user_Delete = "delete from member where user_id = ?";

	// 회원 목록 조회
	public void getUserList() {
		try {
			connection = JDBCUtil.getConnection();
			preparedstatement = connection.prepareStatement(user_List);

			resultSet = preparedstatement.executeQuery();

			System.out.println("member 목록");

			while (resultSet.next()) {
				System.out.print(resultSet.getString("user_id") + " : ");
				System.out.print(resultSet.getString("user_pw") + " : ");
				System.out.print(resultSet.getString("name") + " : ");
				System.out.print(resultSet.getString("phone") + " : ");
				System.out.println(resultSet.getDate("birth"));
			}

		} catch (SQLException e) {
			System.out.println("데이터베이스 작업 중 오류 발생.");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, resultSet, preparedstatement);
		}
	}// end getUserList

	// 회원 등록
	public void InsertUser(String user_id, String user_pw, String name, String phone, LocalDate birth) {
		try {
			connection = JDBCUtil.getConnection();
			preparedstatement = connection.prepareStatement(user_Insert);

			preparedstatement.setString(1, user_id);
			preparedstatement.setString(2, user_pw);
			preparedstatement.setString(3, name);
			preparedstatement.setString(4, phone);
			Date sqlDate = Date.valueOf(birth);
			preparedstatement.setDate(5, sqlDate);

			int rowsInserted = preparedstatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("데이터베이스 작업 중 오류 발생.");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, resultSet, preparedstatement);
		}
	}// end InsertUser

	// 회원 정보 수정
	public void UpdateUser(String user_pw, String phone, String user_id) {
		try {
			connection = JDBCUtil.getConnection();
			preparedstatement = connection.prepareStatement(user_Update);

			preparedstatement.setString(1, user_pw);
			preparedstatement.setString(2, phone);
			preparedstatement.setString(3, user_id);

			int rowsInserted = preparedstatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("데이터베이스 작업 중 오류 발생.");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, resultSet, preparedstatement);
		}
	}// end UpdateUser

	// 회원 정보 삭제
	public void DeleteUser(String user_id) {
		try {
			connection = JDBCUtil.getConnection();
			preparedstatement = connection.prepareStatement(user_Delete);

			preparedstatement.setString(1, user_id);

			int rowsInserted = preparedstatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("데이터베이스 작업 중 오류 발생.");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, resultSet, preparedstatement);
		}

	}// end DeleteUser

}// end class
