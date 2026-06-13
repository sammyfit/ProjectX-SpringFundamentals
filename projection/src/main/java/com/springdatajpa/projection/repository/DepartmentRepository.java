package com.springdatajpa.projection.repository;

import com.springdatajpa.projection.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}