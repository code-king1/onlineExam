package com.sjri.onlineExam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sjri.onlineExam.entity.College;
import com.sjri.onlineExam.entity.Company;
import com.sjri.onlineExam.entity.LoginModel;
import com.sjri.onlineExam.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

	private Connection conn;

	public UserDao() {

		conn = DBUtil.getConnection();// connect to database
	}

	// Validates login with user input
	public boolean validateLogin(String em, String pw) {
		boolean canLogin = false;

		// Search database for email and password and return true if found
		try {
			PreparedStatement ps = conn.prepareStatement("select * from user where email=? and password=?");
			ps.setString(1, em);
			ps.setString(2, pw);

			ResultSet rs = ps.executeQuery();
			canLogin = rs.next(); // true if found else false
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return canLogin;
	}

	// returns user info from specified email for session
	public LoginModel userSession(String em) {
		LoginModel user = new LoginModel(); // create new user object
		try {
			PreparedStatement ps = conn.prepareStatement("select * from user where email=?");// search
																								// database
																								// for
																								// email
			ps.setString(1, em);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user.setUserID(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPsword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	// Creates a new user with input data
	public void createUser(LoginModel user) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into user(username,psword,email) values (?,?,?)");// add
																													// user
																													// to
																													// database
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPsword());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// update user with input data
	public void editAccount(LoginModel user) {
		try {
			PreparedStatement ps = conn.prepareStatement("update user set username=?, psword=?" + " where user_id=?"); // find
																														// user
																														// with
																														// id
																														// and
																														// update
																														// info
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPsword());
			ps.setInt(3, user.getUserID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remove user from database with specified id
	public void deleteAccount(int userid) {
		try {
			PreparedStatement ps = conn.prepareStatement("delete from user where user_id=?");
			ps.setInt(1, userid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// returns a list of all users
	public List<LoginModel> listUsers() {
		List<LoginModel> userList = new ArrayList<LoginModel>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from user");
			while (rs.next()) {
				LoginModel user = new LoginModel();
				user.setUserID(rs.getInt("userID"));
				user.setUsername(rs.getString("username"));
				user.setPsword(rs.getString("psword"));
				user.setEmail(rs.getString("email"));
				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

	// returns user info from specified id
	public LoginModel getUserByID(int userid) {
		LoginModel user = new LoginModel();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from user where user_id= ?");
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user.setUserID(rs.getInt("userID"));
				user.setUsername(rs.getString("username"));
				user.setPsword(rs.getString("psword"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public void saveUser(LoginModel user) {
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert into user(username,psword,email,role,address) values (?,?,?,?,?)");// add
			// user
			// to
			// database
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPsword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getRole());
			ps.setString(5, user.getAddress());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getLastIdOfCompany() {
		try {
			PreparedStatement ps = conn.prepareStatement("select max(id) from company");

			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public void saveCompany(Company company) {
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert into company(id,,company_name) values (?,?)");// add
			// user
			// to
			// database
			ps.setInt(1, company.getId());
			ps.setString(2, company.getCompanyName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveCollege(College college) {
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert into college(id,,college_name) values (?,?)");// add
			// user
			// to
			// database
			ps.setInt(1, college.getId());
			ps.setString(2, college.getCollegeName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}