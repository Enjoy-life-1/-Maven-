package com.baiyun.dao;

import com.baiyun.entity.Student;

import java.util.*;

public class StudentDaoImpl implements StudentDao {

    private final Map<Long, Student> store = new HashMap<>();

    @Override
    public void add(Student student) {
        store.put(student.getId(), student);
    }

    @Override
    public void update(Student student) {
        store.put(student.getId(), student);
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    @Override
    public Student findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(store.values());
    }
}