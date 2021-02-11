
package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentDao {
    public int insert(Student s);
    public int change(Student s);
    public int delete(Student s);
    public Student getStudent(int sid);
    public List<Student> getAllStudent();
}
