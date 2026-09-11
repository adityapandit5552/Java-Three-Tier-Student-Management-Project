package com.srk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.Student;

public class StudentDAO {

    public static Connection getConnection() throws Exception {
        Connection con = null;

        InitialContext ctx = new InitialContext();

        Context envCtx = (Context) ctx.lookup("java:comp/env");

        DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");

        con = ds.getConnection();

        return con;
    }

    public static void main(String[] args) {
    }

    public static int saveStudent(Student student) {
        int status = 0;

        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                "insert into students(student_name,student_addr,student_age,student_qual,student_percent,student_year_passed) values (?,?,?,?,?,?)"
            );

            ps.setString(1, student.getStudentName());
            ps.setString(2, student.getStudentAddr());
            ps.setString(3, student.getAge());
            ps.setString(4, student.getQualification());
            ps.setString(5, student.getPercentage());
            ps.setString(6, student.getYearPassed());

            status = ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static int updateStudent(Student student) {
        int status = 0;

        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                "update students set student_name=?,student_addr=?,student_age=?,student_qual=?,student_percent=?,student_year_passed=? where student_id=?"
            );

            ps.setString(1, student.getStudentName());
            ps.setString(2, student.getStudentAddr());
            ps.setString(3, student.getAge());
            ps.setString(4, student.getQualification());
            ps.setString(5, student.getPercentage());
            ps.setString(6, student.getYearPassed());
            ps.setInt(7, student.getStudentId());

            status = ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static int deleteStudent(int studentId) {
        int status = 0;

        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                "delete from students where student_id=?"
            );

            ps.setInt(1, studentId);

            status = ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Student getStudentById(int studentId) {
        Student student = new Student();

        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                "select * from students where student_id=?"
            );

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student.setStudentId(rs.getInt(1));
                student.setStudentName(rs.getString(2));
                student.setStudentAddr(rs.getString(3));
                student.setAge(rs.getString(4));
                student.setQualification(rs.getString(5));
                student.setPercentage(rs.getString(6));
                student.setYearPassed(rs.getString(7));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    public static List<Student> getAllStudents() {
        List<Student> list = new ArrayList<Student>();

        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                "select * from students"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();

                student.setStudentId(rs.getInt(1));
                student.setStudentName(rs.getString(2));
                student.setStudentAddr(rs.getString(3));
                student.setAge(rs.getString(4));
                student.setQualification(rs.getString(5));
                student.setPercentage(rs.getString(6));
                student.setYearPassed(rs.getString(7));

                list.add(student);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
