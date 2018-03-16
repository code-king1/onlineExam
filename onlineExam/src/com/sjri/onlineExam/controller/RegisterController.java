package com.sjri.onlineExam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjri.onlineExam.dao.UserDao;
import com.sjri.onlineExam.entity.College;
import com.sjri.onlineExam.entity.Company;
import com.sjri.onlineExam.entity.LoginModel;
import com.sjri.onlineExam.util.AppConstant;

@WebServlet(name = "Register", urlPatterns = { "/Register" }) // set in web.xml
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;

	public RegisterController() {
		super();
		dao = new UserDao(); // create new data object

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginModel user = new LoginModel(); // create new user object
		PrintWriter pwOut = response.getWriter();

		// get input from jsp and store it in user object
		String registerType = request.getParameter("registerType");

		System.out.println("Register Type : " + registerType);
		String password = request.getParameter("pass");
		String confirmPass = request.getParameter("confirmPass");
		if (!password.equals(confirmPass))
			pwOut.println("Error");
		if (AppConstant.COMPANY.equals(registerType)) {
			String companyName = request.getParameter("companyOrCollegeName");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String address = request.getParameter("address");

			user.setAddress(address);
			user.setRole(AppConstant.COMPANY);
			user.setEmail(email);
			user.setUsername(username);
			user.setPsword(password);
			dao.saveUser(user);
			int companyId = dao.getLastIdOfCompany();
			Company company = new Company();
			company.setCompanyName(companyName);
			company.setId(companyId);
			dao.saveCompany(company);

			// save company and company user details
		} else {
			String collegeName = request.getParameter("companyOrCollegeName");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String address = request.getParameter("address");

			user.setAddress(address);
			user.setRole(AppConstant.STUDENT);
			user.setEmail(email);
			user.setUsername(username);
			user.setPsword(password);
			dao.saveUser(user);
			int companyId = dao.getLastIdOfCompany();
			College college = new College();
			college.setCollegeName(collegeName);
			college.setId(companyId);
			dao.saveCollege(college);
		}
		// }

	}

}
