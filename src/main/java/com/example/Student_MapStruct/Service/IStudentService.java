package com.example.Student_MapStruct.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.Student_MapStruct.Dto.StudentRequest;
import com.example.Student_MapStruct.Dto.StudentResponse;

public interface IStudentService {
    public List<StudentResponse> getAll();

    public Page<StudentResponse> getAll(Pageable pageable);

    public StudentResponse getById(Long id);

    public StudentResponse create(StudentRequest request);

    public StudentResponse update(StudentRequest request, Long id);

    public void delete(Long id);

    public Page<StudentResponse> getFeatured(Pageable pageable);

    public Page<StudentResponse> getByName(String name, Pageable pageable);

    public Page<StudentResponse> getByAge(int age, Pageable pageable);

    public Page<StudentResponse> getByClassroom(String classroom, Pageable pageable);

    public Page<StudentResponse> getByStudentcode(String studentcode, Pageable pageable);

    public Page<StudentResponse> getBySchool(String school, Pageable pageable);

    public Page<StudentResponse> getByEmail(String email, Pageable pageable);

    public Page<StudentResponse> getByAddress(String address, Pageable pageable);
}
