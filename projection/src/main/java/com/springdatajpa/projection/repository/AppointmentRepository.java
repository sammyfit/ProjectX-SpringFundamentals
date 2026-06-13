package com.springdatajpa.projection.repository;

import com.springdatajpa.projection.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}