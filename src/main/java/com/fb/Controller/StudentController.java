package com.fb.Controller;

import com.fb.model.Student;
import com.fb.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;


    @GetMapping("/all")
    public List<Student> getAllStudents() throws InterruptedException, ExecutionException {
        return studentService.getAllStudents();
    }

    @GetMapping("/{name}")
    public Student getStudent(@PathVariable("name") String name) throws InterruptedException, ExecutionException {
        return studentService.getStudentDetails(name);
    }

    @PostMapping
    public String createStudent(@RequestBody Student Student) throws InterruptedException, ExecutionException {
        return studentService.saveStudentDetails(Student);
    }

    @PutMapping
    public String updateStudent(@RequestBody Student Student) throws InterruptedException, ExecutionException {
        return studentService.updateStudentDetails(Student);
    }

    @DeleteMapping
    public String deleteStudent(@RequestParam String name) {
        return studentService.deleteStudent(name);
    }
}
