package com.jdbctutorial.FirstDemo.Service;

import com.jdbctutorial.FirstDemo.Entity.Student;
import com.jdbctutorial.FirstDemo.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentService implements StudentRepository {

    private JdbcTemplate jdbcTemplate;
    @Override
    public void createStudent(Student student) {
        String query="insert into student(id,name,city) values(?,?,?)";
        this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
    }

    @Override
    public void updateStudent(Student student) {
        String query = "update student set name=?,city=? where id=?";
        this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
    }

    @Override
    public void deleteStudent(Student student) {
        String query = "delete from student where id=?";
        this.jdbcTemplate.update(query,student.getId());
    }

    @Override
    public Student getStudent(int id) {
        String query = "select*from student where id=?";
        RowMapper<Student> rowMapper= new RowMapperService();
       return this.jdbcTemplate.queryForObject(query, rowMapper,id);
    }

    @Override
    public List<Student> getAllStudent() {
        String query = "select*from student";
        return this.jdbcTemplate.query(query,new RowMapperService());
    }
}
