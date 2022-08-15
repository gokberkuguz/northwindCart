package com.etiya.northwind.businessTests;

import com.etiya.northwind.business.abstracts.MathService;
import com.etiya.northwind.business.abstracts.Student;
import com.etiya.northwind.business.abstracts.StudentService;
import com.etiya.northwind.core.exceptions.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import java.util.ArrayList;
import java.util.List;

public class StudentServiceTest {
    StudentService studentService;

    @BeforeEach
    public void setup() {
        studentService = new StudentService();
    }

    @Test
    public void add_new_student() {
        int id = 4;
        String name = "Berkay";
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(1, "Engin"));
        expected.add(new Student(2, "Gökberk"));
        expected.add(new Student(3, "Osman"));
        expected.add(new Student(id,name));


        Student actual = studentService.add(id, name);

        Assertions.assertEquals(expected.get(expected.size()-1).getId(), actual.getId());
        Assertions.assertEquals(expected.get(expected.size()-1).getName(), actual.getName());


    }

    @Test
    public void students_size_should_increase_one_when_added() {

        Student student = new Student(4,"Ali");
        int studentSize = this.studentService.size();
        int expected = studentSize+1;

        this.studentService.add(student);
        int actual = this.studentService.size();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void students_name_shouldnt_repeated() {

        Student student = new Student(4,"Veli");
        int studentSize = this.studentService.size();
        int expected = studentSize+1;

        this.studentService.add(student);
        int actual = this.studentService.size();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void student_name_can_not_be_duplicated_when_added(){
        Student student = new Student(4,"Osman");

        Executable executable = () -> this.studentService.add(student);

        Assertions.assertThrows(BusinessException.class,executable);

    }
}
