package com.spring.jdbc;

import java.util.List;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.SocketUtils;
import org.springframework.util.SystemPropertyUtils;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "program started..");

        // below are some old method without using spring 
        // // spring jdbc=>jdbc template
        // ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        // JdbcTemplate template =context.getBean("jdbcTemplate",JdbcTemplate.class);
        // // insert query 
        // String query= "insert into Student(id,name,city) values(?,?,?)";

        // // fire query 
        // int result =template.update(query,5,"blackberry gupta","mirjapur");
        // System.out.println("number of record inserted..." +result);

        // new method  with using xml
        // ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        // StudentDao stD=context.getBean("StudentDao", StudentDao.class);


        //  without using xml or with using configeration 
          ApplicationContext context= new AnnotationConfigApplicationContext(configJDBC.class);
          StudentDao stD=context.getBean("StudentDao", StudentDao.class);


        // Student stu=new Student();
        // stu.setId(33);;
        // stu.setCity("Gaziabad");
        // stu.setName("Aman Mishra");

        // int result= stD.insert(stu);
        // System.out.println("student added "+ result);


        // for update 
        // Student stu=new Student();
        // stu.setId(32);;
        // stu.setCity("Kanpur");
        // stu.setName("Aman");

        // int result= stD.change(stu);
        //  System.out.println("student data updated ...." + result);

        //  for deletion 
        // Student stu=new Student();
        // stu.setId(32);;
        // stu.setCity("Kanpur");
        // stu.setName("Aman");

        // int result= stD.delete(stu);
        // System.out.println("student data deleted ...." + result);

        
        // for selecting data from databases
        // Student s=stD.getStudent(1);
        // System.out.println(s);

        // for selecting multiple object 
        List<Student> l=stD.getAllStudent();
        for(Student temp: l){
            System.out.println(temp);
        }

        
    }
}
