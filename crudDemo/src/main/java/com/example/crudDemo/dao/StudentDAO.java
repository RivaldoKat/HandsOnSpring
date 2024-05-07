package com.example.crudDemo.dao;

import com.example.crudDemo.entitty.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student student);

    void delete(Integer Id);

    int deleteAll();

}
