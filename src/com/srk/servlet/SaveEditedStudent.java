package com.srk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srk.dao.StudentDAO;

import vo.Student;

public class SaveEditedStudent extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String stdId = request.getParameter("stdId");
        int id = Integer.parseInt(stdId);

        String stdname = request.getParameter("stdname");
        String stdaddrs = request.getParameter("stdaddrs");
        String stdage = request.getParameter("stdage");
        String stdqual = request.getParameter("stdqual");
        String stdpercent = request.getParameter("stdpercent");
        String stdyearpass = request.getParameter("stdyearpass");

        Student student = new Student();

        student.setStudentId(id);
        student.setStudentName(stdname);
        student.setStudentAddr(stdaddrs);
        student.setAge(stdage);
        student.setQualification(stdqual);
        student.setPercentage(stdpercent);
        student.setYearPassed(stdyearpass);

        int status = StudentDAO.updateStudent(student);

        if (status > 0) {
            response.sendRedirect("viewStudents");
        } else {
            out.println("Sorry! unable to update record");
        }

        out.close();
    }
}
