package com.example.test_modul3.DAO;

import java.util.List;

public interface DAO <E>{
    List<E> findAll () ;
    E findOne (int id) ;
    void update (E e) ;
    void create (E e) ;
    void delete (int id) ;
}
