package com.sjri.onlineExam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjri.onlineExam.dao.SubjectDao;
import com.sjri.onlineExam.entity.Subject;

@WebServlet(name = "addSubject", urlPatterns = { "/addSubject" })
public class SubjectController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SubjectDao dao;

	public SubjectController() {
		dao = new SubjectDao();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String subjectName = req.getParameter("subject");
		int companyId=(int)req.getSession().getAttribute("companyId");
		boolean isSubjectExist = dao.findSubjectByName(subjectName);
		if (isSubjectExist) {
			out.write("Already Exist");
		} else {
			int lastSubjectId = dao.findLastSubjectId();
			Subject subject = new Subject();
			subject.setSubjectName(subjectName);
			subject.setId(lastSubjectId + 1);
			subject.setCompanyId(companyId);
			dao.saveSubject(subject);
		}
	}
}
