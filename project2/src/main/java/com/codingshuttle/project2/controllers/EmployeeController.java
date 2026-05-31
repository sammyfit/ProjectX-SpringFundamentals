package com.codingshuttle.project2.controllers;


import com.codingshuttle.project2.dto.EmployeeDTO;
import com.codingshuttle.project2.entities.EmployeeEntity;
import com.codingshuttle.project2.repositories.EmployeeRepo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    /*@GetMapping(path = "/getSecretMessage")
    public String getMySuperSecretMessage() {
        return "Secret message: #asd55667(i23%";
    }*/

    private final EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getEmployees(@RequestParam(required = false) Integer age,
                                             @RequestParam(required = false) String sortBy) {
        return employeeRepo.findAll();
    }

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity inputEmp){
        return employeeRepo.save(inputEmp);
    }

    @PutMapping
    public String updateEmployee(){
        return "Updated by Put";
    }

}
