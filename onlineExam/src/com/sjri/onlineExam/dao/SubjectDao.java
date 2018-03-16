package com.sjri.onlineExam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sjri.onlineExam.entity.Subject;
import com.sjri.onlineExam.util.DBUtil;

public class SubjectDao {

	private Connection conn;

	public SubjectDao() {

		conn = DBUtil.getConnection();// connect to database
	}

	public boolean findSubjectByName(String subject) {
		boolean isSubjectExist = false;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from subject where name=?");
			ps.setString(1, subject);

			ResultSet rs = ps.executeQuery();
			isSubjectExist = rs.next(); // true if found else false
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isSubjectExist;
	}

	public int findLastSubjectId() {
		try {
			PreparedStatement ps = conn.prepareStatement("select max(id) from subject");

			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public void saveSubject(Subject subject) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into subject(id,name,companyId) values (?,?,?)");// add
			ps.setInt(1, subject.getId());
			ps.setString(2, subject.getSubjectName());
			ps.setInt(3, subject.getCompanyId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
