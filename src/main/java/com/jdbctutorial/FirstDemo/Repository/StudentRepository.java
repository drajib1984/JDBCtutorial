package com.jdbctutorial.FirstDemo.Repository;

import com.jdbctutorial.FirstDemo.Entity.Student;

import java.util.List;

public interface StudentRepository {

    public void createStudent(Student student);

    public void updateStudent(Student student);

    public void deleteStudent(Student student);

    public Student getStudent(int id);

    public List<Student> getAllStudent();


}
