package com.example.Student_MapStruct.Mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import com.example.Student_MapStruct.Dto.StudentRequest;
import com.example.Student_MapStruct.Dto.StudentResponse;
import com.example.Student_MapStruct.Model.Student;
//tự động tạo ra 1 bean để có thể inject vào class khác bằng autowired
@Mapper(componentModel = "spring")
public interface StudentMapper {
    // list
    public List<StudentResponse> toList(List<Student> student);

    // theem
    // Yêu cầu MapStruct tạo hàm map từ StudentRequest → Student
    public Student toEntity(StudentRequest request);

    // response
    public StudentResponse toResponse(Student student);

    // update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    // @MappingTarget"Cập nhật vào object này", không tạo object mới
    public void toUpdate(@MappingTarget Student student, StudentRequest request);
}
