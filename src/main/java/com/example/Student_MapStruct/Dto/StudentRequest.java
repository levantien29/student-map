package com.example.Student_MapStruct.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class StudentRequest {
    @NotBlank(message = "Tên không được để trống")
    private String name;

    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 6, message = "Tuổi phải lớn hơn 5")
    private Integer age;

    @NotBlank(message = "Lớp học không được để trống")
    private String classroom;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    @NotBlank(message = "Trường không được để trống")
    private String school;

    @NotBlank(message = "Mã sinh viên không được để trống")
    private String studentCode;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotBlank(message = "mật khẩu không được để trống")
    @Size(min = 6, max = 20, message = "Mật khẩu phải có độ dài từ 6 đến 20 ký tự")
    private String password;

    @NotNull(message = "Nổi bật không được để trống")
    private Boolean featured;
}
