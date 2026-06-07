package com.codingshuttle.project2.dto;

import com.codingshuttle.project2.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name of the Employee cannot be empty")
    @Size(min = 3, max = 10, message = "Number of characters in name should be in range 3-10")
    private String name;

    @NotBlank(message = "Email of the Employee cannot be empty")
    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "Age of the Employee cannot be empty")
    @Max(value = 80, message = "Age cannot be greater than 80")
    @Min(value = 18, message = "Age cannot be less than 18")
    private Integer age;

    @NotBlank(message = "Role of the Employee cannot be empty")
    //@Pattern(regexp = "^(ADMIN|USER)$", message="Role of Employee can be USER or ADMIN")
    @EmployeeRoleValidation
    private String role; //ADMIN or USER

    @NotNull(message = "Salary of Employee cannot be empty")
    @Positive(message = "Salary of Employee should be positive")
    @Digits(integer = 6, fraction = 2, message = "Salary of Employee should be in form XXXXXX.YY")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.99")
    private Double salary;

    @PastOrPresent(message = "Date of joining of Employee cannot be future dated")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be Active")
    @JsonProperty("isActive")
    private Boolean isActive;

}
