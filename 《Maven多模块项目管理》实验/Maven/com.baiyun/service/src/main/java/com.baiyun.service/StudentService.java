package com.baiyun.service;

import com.baiyun.dao.StudentDao;
import com.baiyun.dao.StudentDaoImpl;
import com.baiyun.entity.Student;

import java.util.List;

public class StudentService {

    private final StudentDao studentDao = new StudentDaoImpl();

    private void validate(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("学生不能为空");
        }
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("姓名不能为空");
        }
    }

    public void addStudent(Student student) {
        validate(student);
        studentDao.add(student);
    }

    public void updateStudent(Student student) {
        validate(student);
        studentDao.update(student);
    }

    public void deleteStudent(Long id) {
        studentDao.deleteById(id);
    }

    public Student getStudent(Long id) {
        return studentDao.findById(id);
    }

    public List<Student> listAll() {
        return studentDao.findAll();
    }
}