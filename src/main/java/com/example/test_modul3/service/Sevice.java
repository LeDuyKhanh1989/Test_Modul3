package com.example.test_modul3.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface Sevice <E>{
    List<E> findAll () ;
    E findOne (HttpServletRequest request) throws ServletException, IOException;
    void update (HttpServletRequest request) throws ServletException, IOException ;
    void create (HttpServletRequest request) throws ServletException, IOException ;
}
