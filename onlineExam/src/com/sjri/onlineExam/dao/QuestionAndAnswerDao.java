package com.sjri.onlineExam.dao;

import java.sql.Connection;

import com.sjri.onlineExam.entity.Answer;
import com.sjri.onlineExam.entity.Question;
import com.sjri.onlineExam.util.DBUtil;


public class QuestionAndAnswerDao {

	private Connection conn;

	public QuestionAndAnswerDao() {

		conn = DBUtil.getConnection();// connect to database
	}

	public int findLastQuestionId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void saveQuestion() {
		// TODO Auto-generated method stub
		
	}

	public void saveQuestion(Question qes) {
		// TODO Auto-generated method stub
		
	}

	public void saveAnswer(Answer answer) {
		// TODO Auto-generated method stub
		
	}

	public int findLastAnswerId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
