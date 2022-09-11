package com.jdbctutorial.FirstDemo.Controller;

import com.jdbctutorial.FirstDemo.Entity.Student;
import com.jdbctutorial.FirstDemo.JDBCconfig;
import com.jdbctutorial.FirstDemo.Service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        System.out.println("My program started");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JDBCconfig.class);



        //insert query
//        String insert = "insert into student(id,name,city) values(?,?,?)";
        //fire the query
//        int update = template.update(insert, 103, "RANJAN CHATTERJEE", "Dharmangar");
//        System.out.println("No of record inserted "+update);


        StudentService studentService = context.getBean("service", StudentService.class);
//Creating student details
//        Student student = new Student();
//        student.setId(104);
//        student.setName("RANDHIR PAUL");
//        student.setCity("Rajbari");
//        service.createStudent(student);

//Updating student details with ID
//        Student student1 = new Student();
//        student1.setId(104);
//        student1.setName("SUDHIR DEY");
//        student1.setCity("Kolaghat");
//        service.updateStudent(student1);

//Deleting by ID
//            Student student2 = new Student();
//            student2.setId(104);
//            service.deleteStudent(student2);
//Get student by ID
//        Student student = service.getStudent(103);
//        System.out.println(student);

//Get all student details

        List<Student> allStudent = studentService.getAllStudent();
        System.out.println(allStudent.stream().collect(Collectors.toList()));
    }
}
