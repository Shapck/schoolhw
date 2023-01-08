package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.create(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> read(@PathVariable("id") long id) {
        return ResponseEntity.ok(studentService.read(id));
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.update(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> delete(@PathVariable("id") long id) {
        return ResponseEntity.ok(studentService.delete(id));
    }
    @GetMapping()
    public List<Student> studentsByAge(@RequestParam("age") int age) {
        return studentService.studentsByAge(age);
    }

    @GetMapping(params = {"min", "max"})
    public List<Student> findByAgeBetween(@RequestParam("min") int min,
                                         @RequestParam("max") int max) {
        return studentService.findByAgeBetween(min,max);
    }

    @GetMapping("/{id}/faculty")
    public Faculty getStudentFaculty(@PathVariable("id") long id) {
        return studentService.getStudentFAculty(id);
    }


}
