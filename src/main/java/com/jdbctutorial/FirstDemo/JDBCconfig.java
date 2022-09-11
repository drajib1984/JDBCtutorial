package com.jdbctutorial.FirstDemo;

import com.jdbctutorial.FirstDemo.Service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JDBCconfig {
    @Bean("dataSource")
    public DriverManagerDataSource managerDataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        return driverManagerDataSource;
    }
    @Bean("jdbcTemplate")
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(managerDataSource());
        return template;
    }
    @Bean("service")
    public StudentService getStudentService(){
        StudentService service = new StudentService();
        service.setJdbcTemplate(jdbcTemplate());
        return service;
    }
}
