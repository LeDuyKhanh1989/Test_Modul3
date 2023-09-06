package com.example.test_modul3.service;

import com.example.test_modul3.DAO.DAO_Class;
import com.example.test_modul3.DAO.DAO_Student;
import com.example.test_modul3.model.Class;
import com.example.test_modul3.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class Student_Service implements Sevice<Student> {
    private DAO_Class DAO_Class;

    private DAO_Student DAO_Student;

    public Student_Service() {
        DAO_Student = new DAO_Student();
        DAO_Class = new DAO_Class();
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = DAO_Student.findAll();
        return studentList;
    }

    @Override
    public Student findOne(HttpServletRequest request) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = DAO_Student.findOne(id);
        return student;
    }

    @Override
    public void update(HttpServletRequest request) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        int id_Class = Integer.parseInt(request.getParameter("id_Class"));
        Class class1 = DAO_Class.findOne(id_Class);
        Student student =new Student(id,name,email,dateOfBirth,address,phoneNumber,class1);
        DAO_Student.update(student);
    }

    @Override
    public void create(HttpServletRequest request) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        int id_Class = Integer.parseInt(request.getParameter("id_Class"));
        Class class1 = DAO_Class.findOne(id_Class);
        Student student = new Student(name, email, dateOfBirth, address, phoneNumber, class1);
        DAO_Student.create(student);
    }

    public void delete(HttpServletRequest request) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Student student = DAO_Student.findOne(id);
        if (student != null) {
            DAO_Student.delete(id);
        }
    }
}
