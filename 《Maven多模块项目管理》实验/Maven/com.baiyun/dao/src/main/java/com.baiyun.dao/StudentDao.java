package com.baiyun.dao;

import com.baiyun.entity.Student;

import java.util.List;

public interface StudentDao {
    void add(Student student);

    void update(Student student);

    void deleteById(Long id);

    Student findById(Long id);

    List<Student> findAll();
}