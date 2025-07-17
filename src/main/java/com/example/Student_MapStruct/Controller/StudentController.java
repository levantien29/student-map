package com.example.Student_MapStruct.Controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student_MapStruct.Dto.StudentRequest;
import com.example.Student_MapStruct.Dto.StudentResponse;
import com.example.Student_MapStruct.Service.IStudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService service;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<StudentResponse>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(@Valid @RequestBody StudentRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponse> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/featured")
    public ResponseEntity<Page<StudentResponse>> getFeatured(Pageable pageable) {
        return ResponseEntity.ok(service.getFeatured(pageable));
    }

    @GetMapping("/name")
    public ResponseEntity<Page<StudentResponse>> getName(@RequestParam String name, Pageable pageable) {
        return ResponseEntity.ok(service.getByName(name, pageable));
    }

    @GetMapping("/age")
    public ResponseEntity<Page<StudentResponse>> getAge(int age, Pageable pageable) {
        return ResponseEntity.ok(service.getByAge(age, pageable));
    }

    @GetMapping("/classroom")
    public ResponseEntity<Page<StudentResponse>> getClassroom(@RequestParam String classroom, Pageable pageable) {
        return ResponseEntity.ok(service.getByClassroom(classroom, pageable));
    }

    @GetMapping("/studentcode")
    public ResponseEntity<Page<StudentResponse>> getStudentcode(String studentcode, Pageable pageable) {
        return ResponseEntity.ok(service.getByStudentcode(studentcode, pageable));
    }

    @GetMapping("/school")
    public ResponseEntity<Page<StudentResponse>> getSchool(String school, Pageable pageable) {
        return ResponseEntity.ok(service.getBySchool(school, pageable));
    }

    @GetMapping("/email")
    public ResponseEntity<Page<StudentResponse>> getEmail(String email, Pageable pageable) {
        return ResponseEntity.ok(service.getByEmail(email, pageable));
    }

    @GetMapping("/address")
    public ResponseEntity<Page<StudentResponse>> getAddress(String address, Pageable pageable) {
        return ResponseEntity.ok(service.getByAddress(address, pageable));
    }
}
