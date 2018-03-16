package com.sjri.onlineExam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sjri.onlineExam.entity.Answer;
import com.sjri.onlineExam.entity.Question;
import com.sjri.onlineExam.util.DBUtil;

public class QuestionAndAnswerDao {

	private Connection conn;

	public QuestionAndAnswerDao() {

		conn = DBUtil.getConnection();// connect to database
	}

	public int findLastQuestionId() {
		try {
			PreparedStatement ps = conn.prepareStatement("select max(id) from question");

			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public void saveQuestion(Question qes) {
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert into question(id,subject_id,question,answer_id) values (?,?,?,?)");// add
			ps.setInt(1, qes.getId());
			ps.setInt(2, qes.getSubjectId());
			ps.setString(3, qes.getQuestion());
			ps.setInt(4, qes.getAnswerId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveAnswer(Answer answer) {
		try {
			PreparedStatement ps = conn.prepareStatement(
					"insert into answer(id,question_id,option1,option2,option3,option4,correct_answer) values (?,?,?,?,?,?,?)");// add
			ps.setInt(1, answer.getId());
			ps.setInt(2, answer.getQuestionId());
			ps.setString(3, answer.getOption1());
			ps.setString(4, answer.getOption2());
			ps.setString(5, answer.getOption3());
			ps.setString(6, answer.getOption4());
			ps.setString(7, answer.getCorrectAnswer());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int findLastAnswerId() {
		try {
			PreparedStatement ps = conn.prepareStatement("select max(id) from answer");

			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

}
