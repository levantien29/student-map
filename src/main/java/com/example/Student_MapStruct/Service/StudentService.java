package com.example.Student_MapStruct.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Student_MapStruct.Dto.StudentRequest;
import com.example.Student_MapStruct.Dto.StudentResponse;
import com.example.Student_MapStruct.Exception.BadRequestException;
import com.example.Student_MapStruct.Exception.ResourceNotFoundException;
import com.example.Student_MapStruct.Mapper.StudentMapper;
import com.example.Student_MapStruct.Model.Student;
import com.example.Student_MapStruct.Repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private final StudentRepository repository;
    private final StudentMapper mapper;

    @Override
    public List<StudentResponse> getAll() {
        return mapper.toList(repository.findAll());
    }

    @Override
    public Page<StudentResponse> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toResponse);
    }

    @Override
    public StudentResponse getById(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không có Student có id = " + id));
        return mapper.toResponse(student);
    }

    @Override
    public StudentResponse create(StudentRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new ResourceNotFoundException("Email đã tồn tại, Vui lòng thêm email khác");
        }
        if (repository.existsByStudentCode(request.getStudentCode())) {
            throw new ResourceNotFoundException("Mã sinh viên đã tồn tại, Vui lòng thêm mã sinh viên khác");
        }
        Student student = mapper.toEntity(request);
        return mapper.toResponse(repository.save(student));
    }

    @Override
    public StudentResponse update(StudentRequest request, Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sinh viên có id = " + id));
        if (repository.existsByEmailAndIdNot(request.getEmail(), id)) {
            throw new BadRequestException("Email đã được thêm, Vui lòng nhập email khác");
        }
        if (repository.existsByStudentCodeAndIdNot(request.getStudentCode(), id)) {
            throw new BadRequestException("Mã sinh viên đã được sử dụng, Vui lòng thêm mã khác !");
        }
        mapper.toUpdate(student, request);
        return mapper.toResponse(repository.save(student));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Id không tồn tại");
        }
        repository.deleteById(id);
    }

    @Override
    public Page<StudentResponse> getByName(String name, Pageable pageable) {
        Page<Student> page = repository.findByNameContainingIgnoreCase(name, pageable);
        if (page.isEmpty()) {
            throw new BadRequestException("Tên không tồn tại");
        }
        return page.map(mapper::toResponse);
    }

    @Override
    public Page<StudentResponse> getFeatured(Pageable pageable) {
        return repository.findByFeaturedTrue(pageable).map(mapper::toResponse);
    }

    @Override
    public Page<StudentResponse> getByAge(int age, Pageable pageable) {
        Page<Student> page = repository.findByAge(age, pageable);
        if (page.isEmpty()) {
            throw new BadRequestException("Tuổi không tồn tại");
        }
        return page.map(mapper::toResponse);
    }

    @Override
    public Page<StudentResponse> getByClassroom(String classroom, Pageable pageable) {
        Page<Student> page = repository.findByClassroomContainingIgnoreCase(classroom, pageable);
        if (page.isEmpty()) {
            throw new BadRequestException("Lớp không tồn tại");
        }
        return page.map(mapper::toResponse);
    }

    @Override
    public Page<StudentResponse> getByStudentcode(String studentcode, Pageable pageable) {
        Page<Student> page = repository.findByStudentCodeContainingIgnoreCase(studentcode, pageable);
        if (page.isEmpty()) {
            throw new BadRequestException("Mã sinh viên không tồn tại");
        }
        return page.map(mapper::toResponse);
    }

    @Override
    public Page<StudentResponse> getBySchool(String school, Pageable pageable) {
        Page<Student> page = repository.findBySchoolContainingIgnoreCase(school, pageable);
        if (page.isEmpty()) {
            throw new BadRequestException("Trường không tồn tại");
        }
        return page.map(mapper::toResponse);
    }

    @Override
    public Page<StudentResponse> getByEmail(String email, Pageable pageable) {
        Page<Student> page = repository.findByEmailContainingIgnoreCase(email, pageable);
        if (page.isEmpty()) {
            throw new BadRequestException("Email không tồn tại");
        }
        return page.map(mapper::toResponse);
    }

    @Override
    public Page<StudentResponse> getByAddress(String address, Pageable pageable) {
        Page<Student> page = repository.findByAddressContainingIgnoreCase(address, pageable);
        if (page.isEmpty()) {
            throw new BadRequestException("Địa chỉ không tồn tại");
        }
        return page.map(mapper::toResponse);
    }
}