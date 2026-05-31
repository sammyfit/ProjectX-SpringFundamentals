package com.codingshuttle.project2.controllers;


import com.codingshuttle.project2.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    /*@GetMapping(path = "/getSecretMessage")
    public String getMySuperSecretMessage() {
        return "Secret message: #asd55667(i23%";
    }*/

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return new EmployeeDTO(id, "Samrat", "samratcruze@gmail.com",31, LocalDate.of(2024, 1, 2), true);
    }

    @GetMapping
    public String getEmployees(@RequestParam(required = false) Integer age,
                               @RequestParam(required = false) String sortBy) {
        return "Hi Age " + age + " " + sortBy;
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmp){
        inputEmp.setId(100L);
        return inputEmp;
    }

    @PutMapping
    public String updateEmployee(){
        return "Updated by Put";
    }

}
