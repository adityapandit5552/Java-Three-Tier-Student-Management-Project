package com.srk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srk.dao.StudentDAO;

import vo.Student;

public class RegistrationController extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String age = request.getParameter("age");
        String qual = request.getParameter("qual");
        String percent = request.getParameter("percent");
        String yop = request.getParameter("yop");

        if (fullname.isEmpty()
                || address.isEmpty()
                || age.isEmpty()
                || qual.isEmpty()
                || percent.isEmpty()
                || yop.isEmpty()) {

            RequestDispatcher rd =
                    request.getRequestDispatcher("index.jsp");

            out.println(
                    "<font color=red>Please fill all the fields</font>");

            rd.include(request, response);

        } else {

            Student student = new Student();

            student.setStudentName(fullname);
            student.setStudentAddr(address);
            student.setAge(age);
            student.setQualification(qual);
            student.setPercentage(percent);
            student.setYearPassed(yop);

            int status = StudentDAO.saveStudent(student);

            if (status > 0) {
                response.sendRedirect("viewStudents");
            } else {
                out.println("Sorry! unable to save record");
            }
        }

        out.close();
    }
}
