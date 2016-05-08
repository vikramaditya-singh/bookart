package com.bookart.dao;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.bookart.model.User;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class BookartDAO {

	private DataSource dataSource;

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String createUser = "CREATE TABLE IF NOT EXISTS USER(USERID VARCHAR(20) NOT NULL ,FIRSTNAME VARCHAR(100) NOT NULL,LASTNAME VARCHAR(40) NOT NULL,AGE INT NOT NULL,EMAILID VARCHAR(50),MOBILENO VARCHAR(20),PRIMARY KEY ( USERID ))";

	private String insertUser = "INSERT INTO USER(userId,firstName,lastName,age,emailId,mobileNo) VALUES (?,?,?,?,?,?)";
	private String retrieveUser = "select firstName, emailid from User where userid = ?";

	public Connection createConnection() {

		MysqlDataSource mysqlDS = new MysqlDataSource();
		mysqlDS.setURL("jdbc:mysql://localhost:3306/bookart");
		mysqlDS.setUser("vikram");
		mysqlDS.setPassword("India@123");

		try {
			con = mysqlDS.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void createtable() {
		try {
			ps = con.prepareStatement(createUser);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// rs.close();
				ps.close();
				// con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void save() {
		try {

			User emp = new User();
			emp.setAge(23);
			emp.setEmailId("test@gmail.com");
			emp.setFirstName("testfirstName");
			emp.setLastName("testLastName");
			emp.setMobileNumber("123456789");
			emp.setUserId("testID");

			ps = con.prepareStatement(insertUser);
			ps.setInt(4, emp.getAge());
			ps.setString(2, emp.getFirstName());
			ps.setString(3, emp.getLastName());
			ps.setString(6, emp.getMobileNumber());
			ps.setString(5, emp.getEmailId());
			ps.setString(1, emp.getUserId());
			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Employee saved with id=" + emp.getUserId());
			} else
				System.out.println("Employee save failed with id=" + emp.getUserId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public User retrieveData(String userId) {

		User model = new User();
		try {
			ps = con.prepareStatement(retrieveUser);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			if (rs.next()) {
				model.setFirstName(rs.getString("firstName"));
				model.setEmailId(rs.getString("emailid"));
				model.setAge(rs.getInt("age"));
				model.setLastName("lastname");
				model.setMobileNumber("mobileNo");
				model.setUserId("userId");
				
				System.out.println("Employee Found::" + model.getFirstName());
			} else {
				System.out.println("No Employee found with id=" + model.getFirstName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return model;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		BookartDAO dao = new BookartDAO();

		dao.createConnection();
		dao.createtable();
		dao.save();
	}

}
