package com.example.test_modul3.controller;

import com.example.test_modul3.DAO.DAO_Class;
import com.example.test_modul3.DAO.DAO_Student;
import com.example.test_modul3.model.Class;
import com.example.test_modul3.model.Student;
import com.example.test_modul3.service.Student_Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "My_Servlet", value = "/My_Servlet")
public class My_Servlet extends HttpServlet implements IServlet{

    private DAO_Class DAO_class;
    private DAO_Student DAO_Student;
    private Student_Service Student_Service;


    public My_Servlet() {
        DAO_class = new DAO_Class();
        DAO_Student = new DAO_Student();
        Student_Service =new Student_Service();
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Class> classList = DAO_class.findAll();
        request.setAttribute("classList",classList);
        RequestDispatcher rq = request.getRequestDispatcher("/create.jsp");
        rq.forward(request,response);
    }

    @Override
    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> Student = DAO_Student.findAll();
        request.setAttribute( "Student", Student);
        RequestDispatcher rq = request.getRequestDispatcher("/Show_Student.jsp");
        rq.forward(request, response);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Class> classList = DAO_class.findAll();
        request.setAttribute("classList",classList);
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        Student student = DAO_Student.findOne(id);
        request.setAttribute("student",student);
        RequestDispatcher rq = request.getRequestDispatcher("/update.jsp");
        rq.forward(request,response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = DAO_Student.findOne(id);
        request.setAttribute("id",id);
        request.setAttribute("student",student);
        RequestDispatcher rq = request.getRequestDispatcher("/deleteConfirm.jsp");
        rq.forward(request,response);
    }

    @Override
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student_Service.create(request);
        display(request, response);
    }

    @Override
    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student_Service.update(request);
        display(request, response);
    }
    public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Student> studentList = DAO_Student.search(search);
        int number = studentList.size();
        if (number != 0) {
            request.setAttribute("studentList", studentList);
            RequestDispatcher rq = request.getRequestDispatcher("/search.jsp");
            rq.forward(request, response);
        } else {
            response.sendRedirect("/notFound.jsp");
        }
    }

    public void goback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        display(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                display(request, response);
                break;
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;

            case "goback":
                goback(request,response);
                break;
            case "deleteConfirm":
                deleteConfirm(request,response);
                break;
        }
    }

    public void deleteConfirm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student_Service.delete(request);
        display(request, response);
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "createPost":
                createPost(request, response);
                break;
            case "updatePost":
                updatePost(request, response);
                break;
            case "search":
                search(request, response);
                break;
        }
    }
}