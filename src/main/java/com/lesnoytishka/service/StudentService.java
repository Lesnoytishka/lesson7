package com.lesnoytishka.service;

import com.lesnoytishka.entity.Student;
import com.lesnoytishka.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student addOrUpdate(Student student) {
        return repository.save(student);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public List<Student> findAll() {
        return repository.findAll();
    }
}
