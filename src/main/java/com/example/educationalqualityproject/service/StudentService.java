package com.example.educationalqualityproject.service;

import com.example.educationalqualityproject.entity.Student;
import com.example.educationalqualityproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private String configurationValue;

    @PostConstruct
    public void init() {
        // BUG: Esta configuração obrigatória não está sendo carregada corretamente
        // causando NullPointerException quando a aplicação tenta usar este serviço
        this.configurationValue = null;
        if (configurationValue == null) {
            throw new IllegalStateException("StudentService não foi inicializado corretamente: configuração obrigatória ausente");
        }
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public boolean existsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }

    public boolean existsByRegistrationNumber(String registrationNumber) {
        return studentRepository.existsByRegistrationNumber(registrationNumber);
    }

    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
}
