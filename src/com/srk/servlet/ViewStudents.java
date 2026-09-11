package com.srk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srk.dao.StudentDAO;
import vo.Student;

@WebServlet("/viewStudents")
public class ViewStudents extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        List<Student> list = StudentDAO.getAllStudents();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Students List</title>");

        out.println("<style>");

        out.println("* {");
        out.println("    box-sizing: border-box;");
        out.println("    margin: 0;");
        out.println("    padding: 0;");
        out.println("    font-family: Arial, sans-serif;");
        out.println("}");

        out.println("body {");
        out.println("    min-height: 100vh;");
        out.println("    background: linear-gradient(135deg, #667eea, #764ba2);");
        out.println("    padding: 40px 20px;");
        out.println("}");

        out.println(".container {");
        out.println("    max-width: 1200px;");
        out.println("    margin: auto;");
        out.println("}");

        out.println(".header {");
        out.println("    background: white;");
        out.println("    border-radius: 18px;");
        out.println("    padding: 25px 30px;");
        out.println("    margin-bottom: 20px;");
        out.println("    display: flex;");
        out.println("    justify-content: space-between;");
        out.println("    align-items: center;");
        out.println("    box-shadow: 0 10px 30px rgba(0,0,0,0.15);");
        out.println("}");

        out.println(".header h1 {");
        out.println("    color: #111827;");
        out.println("    font-size: 28px;");
        out.println("    margin-bottom: 6px;");
        out.println("}");

        out.println(".header p {");
        out.println("    color: #6b7280;");
        out.println("    font-size: 14px;");
        out.println("}");

        out.println(".register-btn {");
        out.println("    background: linear-gradient(135deg, #5b6cff, #8b5cf6);");
        out.println("    color: white;");
        out.println("    text-decoration: none;");
        out.println("    padding: 12px 18px;");
        out.println("    border-radius: 10px;");
        out.println("    font-weight: bold;");
        out.println("    font-size: 14px;");
        out.println("}");

        out.println(".card {");
        out.println("    background: white;");
        out.println("    border-radius: 18px;");
        out.println("    padding: 20px;");
        out.println("    box-shadow: 0 10px 30px rgba(0,0,0,0.15);");
        out.println("    overflow-x: auto;");
        out.println("}");

        out.println("table {");
        out.println("    width: 100%;");
        out.println("    border-collapse: collapse;");
        out.println("    min-width: 950px;");
        out.println("}");

        out.println("th {");
        out.println("    background: #f5f3ff;");
        out.println("    color: #4c1d95;");
        out.println("    padding: 15px 12px;");
        out.println("    text-align: left;");
        out.println("    font-size: 13px;");
        out.println("}");

        out.println("td {");
        out.println("    padding: 14px 12px;");
        out.println("    border-bottom: 1px solid #eeeeee;");
        out.println("    color: #374151;");
        out.println("    font-size: 14px;");
        out.println("}");

        out.println("tr:hover td {");
        out.println("    background: #fafaff;");
        out.println("}");

        out.println(".edit-btn {");
        out.println("    display: inline-block;");
        out.println("    background: #eef2ff;");
        out.println("    color: #4338ca;");
        out.println("    text-decoration: none;");
        out.println("    padding: 7px 12px;");
        out.println("    border-radius: 7px;");
        out.println("    font-size: 13px;");
        out.println("    font-weight: 600;");
        out.println("    margin-right: 5px;");
        out.println("}");

        out.println(".delete-btn {");
        out.println("    display: inline-block;");
        out.println("    background: #fef2f2;");
        out.println("    color: #dc2626;");
        out.println("    text-decoration: none;");
        out.println("    padding: 7px 12px;");
        out.println("    border-radius: 7px;");
        out.println("    font-size: 13px;");
        out.println("    font-weight: 600;");
        out.println("}");

        out.println(".delete-btn:hover {");
        out.println("    background: #fee2e2;");
        out.println("}");

        out.println(".edit-btn:hover {");
        out.println("    background: #e0e7ff;");
        out.println("}");

        out.println("@media (max-width: 700px) {");

        out.println("    body {");
        out.println("        padding: 20px 10px;");
        out.println("    }");
        out.println("    }");
out.println("    .header {");
out.println("        flex-direction: column;");
        out.println("    .header {");
        out.println("        flex-direction: column;");
        out.println("        align-items: flex-start;");
        out.println("        gap: 18px;");
        out.println("    }");

        out.println("    .header h1 {");
        out.println("        font-size: 23px;");
        out.println("    }");

        out.println("}");

        out.println("</style>");
        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container'>");

        out.println("<div class='header'>");

        out.println("<div>");
        out.println("<h1>Students List</h1>");
        out.println("<p>Manage all registered students</p>");
        out.println("</div>");

        out.println("<a class='register-btn' href='index.jsp'>+ Register Student</a>");

        out.println("</div>");

        out.println("<div class='card'>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Full Name</th>");
        out.println("<th>Address</th>");
        out.println("<th>Age</th>");
        out.println("<th>Qualification</th>");
        out.println("<th>Percentage</th>");
        out.println("<th>Year Passed</th>");
        out.println("<th>Actions</th>");
        out.println("</tr>");

        for (Student student : list) {

            out.println("<tr>");

            out.println("<td>" + student.getStudentId() + "</td>");
            out.println("<td>" + student.getStudentName() + "</td>");
            out.println("<td>" + student.getStudentAddr() + "</td>");
            out.println("<td>" + student.getAge() + "</td>");
            out.println("<td>" + student.getQualification() + "</td>");
            out.println("<td>" + student.getPercentage() + "</td>");
            out.println("<td>" + student.getYearPassed() + "</td>");

            out.println("<td>");

            out.println("<a class='edit-btn' href='editStudent?stdId="
                    + student.getStudentId() + "'>Edit</a>");

            out.println("<a class='delete-btn' href='deleteStudent?stdId="
                    + student.getStudentId()
                    + "' onclick=\"return confirm('Are you sure you want to delete this student?');\">Delete</a>");

            out.println("</td>");

            out.println("</tr>");
        }

        out.println("</table>");

        out.println("</div>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
