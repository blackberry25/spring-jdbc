package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
@Component("StudentDao") // for autowiring
public class StudentDaoImpl implements StudentDao {

    @Autowired // for autowiring
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Student s) {
        String query= "insert into Student(id,name,city) values(?,?,?)";
        int r=this.jdbcTemplate.update(query, s.getId(),s.getName(),s.getCity());

        return r;
    }
    @Override
    public int change(Student s) {
         String query ="update student set name=?,city=? where id=?";
         int r=this.jdbcTemplate.update(query,s.getName(),s.getCity(),s.getId());
         return r;
    }
    @Override
    public int delete(Student s) {
       String query="delete from student where id=? ";
       int r=this.jdbcTemplate.update(query, s.getId());
       return r;
    }
     
	@Override
	public Student getStudent(int sid) {
         String query="select* from student where id=?";
         RowMapper<Student> rowMapper=new RowMapperImpl();
         Student s= this.jdbcTemplate.queryForObject(query, rowMapper, sid);
		return s;
    }
    

	@Override
	public List<Student> getAllStudent() {
        String query= "select* from student";
         List<Student>lis =this.jdbcTemplate.query(query,new RowMapperImpl());
        return lis;
        
    }
    
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public StudentDaoImpl() {
    }

    


   

    
    
   
    
}
