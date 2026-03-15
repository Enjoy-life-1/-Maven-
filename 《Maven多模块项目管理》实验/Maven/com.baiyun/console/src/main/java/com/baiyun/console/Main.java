package com.baiyun.console;

import com.baiyun.entity.Student;
import com.baiyun.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final StudentService studentService = new StudentService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    add();
                    break;
                case "2":
                    update();
                    break;
                case "3":
                    deleteById();
                    break;
                case "4":
                    findById();
                    break;
                case "5":
                    listAll();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("无效选择");
            }
        }
        System.out.println("已退出");
    }

    private static void printMenu() {
        System.out.println("===== 学生信息管理系统 =====");
        System.out.println("1. 新增学生");
        System.out.println("2. 修改学生");
        System.out.println("3. 删除学生");
        System.out.println("4. 按ID查询学生");
        System.out.println("5. 列出所有学生");
        System.out.println("0. 退出");
        System.out.print("请选择：");
    }

    private static void add() {
        System.out.print("输入ID：");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.print("输入姓名：");
        String name = scanner.nextLine();
        System.out.print("输入年龄：");
        Integer age = Integer.parseInt(scanner.nextLine());
        Student student = new Student(id, name, age);
        studentService.addStudent(student);
        System.out.println("新增成功");
    }

    private static void update() {
        System.out.print("输入要修改的ID：");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.print("输入新姓名：");
        String name = scanner.nextLine();
        System.out.print("输入新年龄：");
        Integer age = Integer.parseInt(scanner.nextLine());
        Student student = new Student(id, name, age);
        studentService.updateStudent(student);
        System.out.println("修改成功");
    }

    private static void deleteById() {
        System.out.print("输入要删除的ID：");
        Long id = Long.parseLong(scanner.nextLine());
        studentService.deleteStudent(id);
        System.out.println("删除成功");
    }

    private static void findById() {
        System.out.print("输入要查询的ID：");
        Long id = Long.parseLong(scanner.nextLine());
        Student student = studentService.getStudent(id);
        System.out.println(student == null ? "未找到" : student);
    }

    private static void listAll() {
        List<Student> list = studentService.listAll();
        if (list.isEmpty()) {
            System.out.println("暂无数据");
        } else {
            for (Student s : list) {
                System.out.println(s);
            }
        }
    }
}