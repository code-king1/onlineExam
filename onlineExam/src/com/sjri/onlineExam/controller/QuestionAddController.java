package com.sjri.onlineExam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjri.onlineExam.dao.QuestionAndAnswerDao;
import com.sjri.onlineExam.entity.Answer;
import com.sjri.onlineExam.entity.Question;

@WebServlet(name = "AddQuestion", urlPatterns = { "/AddQuestion" })
public class QuestionAddController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private QuestionAndAnswerDao dao;

	public QuestionAddController() {
		dao = new QuestionAndAnswerDao();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* Get Qestion Data from form */
		String question = req.getParameter("question");
		String subId = req.getParameter("subId");

		Question qes = new Question();
		qes.setQuestion(question);
		qes.setSubjectId(Integer.parseInt(subId));
		int lastQuestionId = dao.findLastQuestionId();
		int qId = lastQuestionId + 1;
		qes.setId(qId);
		int lastAnswerId = dao.findLastAnswerId();
		int ansId = lastAnswerId + 1;
		qes.setAnswerId(ansId);
		dao.saveQuestion(qes);

		/* Get Answer Detail From Form */
		String option1 = req.getParameter("option1");
		String option2 = req.getParameter("option2");
		String option3 = req.getParameter("option3");
		String option4 = req.getParameter("option4");
		String correctAnswer = req.getParameter("correctAnswer");

		Answer answer = new Answer();
		answer.setCorrectAnswer(correctAnswer);
		answer.setQuestionId(qId);
		answer.setOption1(option1);
		answer.setOption2(option2);
		answer.setOption3(option3);
		answer.setOption4(option4);
		answer.setId(ansId);
		dao.saveAnswer(answer);

	}
}
