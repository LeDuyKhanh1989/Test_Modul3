package com.example.test_modul3.DAO;

import com.example.test_modul3.model.Class;
import com.example.test_modul3.model.Student;
import com.example.test_modul3.myConnection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAO_Student implements DAO<Student> {

    private Connection connection;
    private DAO_Class DAO_Class;

    private String list = "select  * from Student;";
    private String findOne = "select  * from Student where id=?; ";
    private String create = "insert into Student (name, email, dateOfBirth, address, phoneNumber, id_Class) values (?,?,?,?,?,?);";
    private String update = "update Student set name = ?,email =?,dateOfBirth=?,address=?,phoneNumber=?,id_Class=? where id=?;";
    private String delete = "delete from Student where id = ?;";
    private  String search = "select * from Student where name LIKE ?;";


    public DAO_Student() {
        connection = new MyConnection().getConnection();
        DAO_Class = new DAO_Class();
    }

    @Override
    public List<Student> findAll() {
        List<Student> Students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(list);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                int id_Class = Integer.parseInt(resultSet.getString("id_Class"));
                Class class1 = DAO_Class.findOne(id_Class);
                Student student = new Student(id, name, email, dateOfBirth, address, phoneNumber, class1);
                Students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Students;
    }

    @Override
    public Student findOne(int id) {
        Student student = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(findOne);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                int id_Class = Integer.parseInt(resultSet.getString("id_Class"));
                Class class2 = DAO_Class.findOne(id_Class);
                student = new Student(id, name, email, dateOfBirth, address, phoneNumber, class2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void update(Student student) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            int id_Class = student.getClassName().getId();
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getDateOfBirth());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhoneNumber());
            preparedStatement.setInt(6, id_Class);
            preparedStatement.setInt(7,student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> search(String name){
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(search)) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String name1 = resultSet.getString("name");
                String email = resultSet.getString("email");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                int id_Class = Integer.parseInt(resultSet.getString("id_Class"));
                Class class1 = DAO_Class.findOne(id_Class);

                Student student = new Student(id,name1,email,dateOfBirth,address,phoneNumber,class1);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    @Override
    public void create(Student student) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(create)) {
            int id = student.getClassName().getId();
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getDateOfBirth());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhoneNumber());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
