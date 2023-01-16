package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.FacultyNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create(Faculty faculty) {
        faculty.setId(null);
        return facultyRepository.save(faculty);
    }
    public Faculty update (Faculty faculty) {
        Faculty oldfaculty = facultyRepository.findById(faculty.getId())
                .orElseThrow(FacultyNotFoundException::new);
        oldfaculty.setName(faculty.getName());
        oldfaculty.setColor(faculty.getColor());
        return facultyRepository.save(oldfaculty);
    }

    public Faculty read(long id) {
        return facultyRepository.findById(id)
                .orElseThrow(FacultyNotFoundException::new);
    }

    public Faculty delete(long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(FacultyNotFoundException::new);
        facultyRepository.delete(faculty);
        return faculty;
    }

    public List<Faculty> facultiesByColor(String color) {
        return facultyRepository.findALLByColor(color);

    }

    public List<Faculty> facultiesByColorOrName(String colorOrName) {
        return facultyRepository.findAllByColorIgnoreCaseOrNameIgnoreCase(colorOrName, colorOrName);
    }

    public List<Student> getFacultyStudents(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(FacultyNotFoundException::new)
                .getStudents();
    }
}
