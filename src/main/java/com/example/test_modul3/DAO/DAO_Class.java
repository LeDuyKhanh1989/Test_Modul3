package com.example.test_modul3.DAO;

import com.example.test_modul3.model.Class;
import com.example.test_modul3.myConnection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Class implements DAO<Class> {

    private Connection connection;
    private String list = "select  * from Class;";
    private String findOne = "select  * from Class where id=?;";
    private String delete = "delete from Class where id = ?;";

    public DAO_Class() {
        connection = new MyConnection().getConnection();
    }

    @Override
    public List<Class> findAll() {
        List<Class> classList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(list);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                Class class1 = new Class(id,name);
                classList.add(class1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classList;
    }

    @Override
    public Class findOne(int id) {
        Class class1= null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(findOne)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_Class = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                class1 = new Class(id_Class,name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return class1;
    }

    @Override
    public void update(Class aClass) {

    }

    @Override
    public void create(Class aClass) {

    }

    @Override
    public void delete(int id) {

    }
}
