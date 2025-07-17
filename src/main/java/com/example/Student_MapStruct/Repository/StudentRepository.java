package com.example.Student_MapStruct.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Student_MapStruct.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);

    boolean existsByStudentCodeAndIdNot(String studentcode, Long id);

    boolean existsByStudentCode(String studentcode);

    Page<Student> findByFeaturedTrue(Pageable pageable);

    Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Student> findByAge(int age, Pageable pageable);

    Page<Student> findByClassroomContainingIgnoreCase(String classroom, Pageable pageable);

    Page<Student> findByStudentCodeContainingIgnoreCase(String studentcode, Pageable pageable);

    Page<Student> findBySchoolContainingIgnoreCase(String school, Pageable pageable);

    Page<Student> findByEmailContainingIgnoreCase(String email, Pageable pageable);

    Page<Student> findByAddressContainingIgnoreCase(String address, Pageable pageable);
}
