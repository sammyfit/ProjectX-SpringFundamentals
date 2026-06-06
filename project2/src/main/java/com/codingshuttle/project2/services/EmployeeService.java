package com.codingshuttle.project2.services;

import com.codingshuttle.project2.dto.EmployeeDTO;
import com.codingshuttle.project2.entities.EmployeeEntity;
import com.codingshuttle.project2.repositories.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepo employeeRepo, ModelMapper modelMapper) {
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        return employeeRepo.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
    }

    public List<EmployeeDTO> getEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepo.findAll();
        return employeeEntities.stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmp) {
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmp, EmployeeEntity.class);
        EmployeeEntity savedEmployee = employeeRepo.save(toSaveEntity);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepo.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public boolean deleteEmployeeById(Long employeeId) {
        boolean exists = employeeRepo.existsById(employeeId);
        if(!exists) return false;
        employeeRepo.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
        boolean exists = employeeRepo.existsById(employeeId);
        if(!exists) return null;
        EmployeeEntity employeeEntity = employeeRepo.findById(employeeId).get();
        updates.forEach((field, value) -> {
            Field fieldToUpdate = ReflectionUtils.findField(EmployeeEntity.class, field);
            fieldToUpdate.setAccessible(true);
            ReflectionUtils.setField(fieldToUpdate, employeeEntity, value);
        });
        return modelMapper.map(employeeRepo.save(employeeEntity), EmployeeDTO.class);
    }
}
