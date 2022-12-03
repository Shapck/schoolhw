package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @PostMapping
    public ResponseEntity<Faculty> create(@RequestBody Faculty faculty) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(facultyService.create(faculty));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> read(@PathVariable("id") long id) {
        return ResponseEntity.ok(facultyService.read(id));
    }

    @PutMapping
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.update(faculty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Faculty> delete(@PathVariable("id") long id) {
        return ResponseEntity.ok(facultyService.delete(id));
    }

    @GetMapping()
    public List<Faculty> facultiesByColor(@RequestParam("color") String color) {
        return facultyService.facultiesByColor(color);
    }


}
