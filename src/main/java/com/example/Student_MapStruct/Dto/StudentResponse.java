package com.example.Student_MapStruct.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentResponse {
    private Long id;
    private String name;
    private int age;
    private String address;
    private String school;
    private String classroom;
    private String studentCode;
    private String email;
    private boolean featured;
}
