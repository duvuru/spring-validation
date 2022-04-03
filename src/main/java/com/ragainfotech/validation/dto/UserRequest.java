package com.ragainfotech.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "Name shoudn't be null")
    private String name;
    @Email (message = "Invalid email address provided")
    private String email;
    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number entered")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(95)
    private int age;
    @NotBlank
    private String nationality;
}
