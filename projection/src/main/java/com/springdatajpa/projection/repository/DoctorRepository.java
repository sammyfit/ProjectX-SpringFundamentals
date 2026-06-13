package com.springdatajpa.projection.repository;

import com.springdatajpa.projection.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}