package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.core.exceptions.BusinessException;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public StudentService(List<Student> students) {
        this.students = students;
    }

    public StudentService() {
        students.add(new Student(1, "Engin"));
        students.add(new Student(2, "Gökberk"));
        students.add(new Student(3, "Osman"));
    }

    public void add(Student student) {
        for (Student studenti : students) {
            if (studenti.getName() == student.getName()) {
                throw new BusinessException("İsim Tekrar Edemez");
            }
        }
        students.add(student);
    }

    public int size() {
        return this.students.size();
    }

    public Student add(int id, String name) {
        checkIfStudentNameExists(name);

        students.add(new Student(id, name));
        return students.get(students.size() - 1);
    }

    private void checkIfStudentNameExists(String name) {
        for (Student student : students) {
            if (name == student.getName()) {
                throw new BusinessException("İsim Tekrar Edemez");
            }
        }
    }
}
