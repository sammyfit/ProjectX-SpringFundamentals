package com.springdatajpa.projection.repository;

import com.springdatajpa.projection.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}