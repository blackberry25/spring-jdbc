package com.spring.jdbc;

import javax.sql.DataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"}) //for autowiring
public class configJDBC {
    @Bean(name={"ds"})
    public DataSource getDataSource(){
        DriverManagerDataSource dsr=new DriverManagerDataSource();
        dsr.setDriverClassName("com.mysql.jdbc.Driver");
        dsr.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        dsr.setUsername("root");
        dsr.setPassword("root");
        return dsr;
    }
    @Bean("jdbcTemp")
    public JdbcTemplate getTemplate(){
        JdbcTemplate jdbctemp=new JdbcTemplate();
        jdbctemp.setDataSource(getDataSource());
        return jdbctemp;
    }
    // @Bean("StudentDao") // when there is no  autowiring
    // public StudentDao getStudentDao(){
    //     StudentDaoImpl stdao= new StudentDaoImpl();
    //     stdao.setJdbcTemplate(getTemplate());
    //     return stdao;

    // }
    
}
