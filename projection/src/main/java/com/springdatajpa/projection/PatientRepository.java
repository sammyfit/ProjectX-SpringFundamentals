package com.springdatajpa.projection;

import com.springdatajpa.projection.dto.BloodGroupStats;
import com.springdatajpa.projection.dto.CPatientInfo;
import com.springdatajpa.projection.dto.IPatientInfo;
import com.springdatajpa.projection.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p.id as id, p.name as name, p.email as email from Patient p")
    List<IPatientInfo> getAllPatientInfo();

    @Query("select new com.springdatajpa.projection.dto.CPatientInfo(p.id, p.name) " + "from Patient p")
    List<CPatientInfo> getAllPatientsInfoConcrete();

    @Query("select new com.springdatajpa.projection.dto.BloodGroupStats(p.bloodGroup, " +  "COUNT(p)) from Patient p group by p.bloodGroup order by COUNT(p)")
    List<BloodGroupStats> getBloodGroupStats();

    @Modifying
    @Transactional
    @Query("UPDATE Patient p set p.name = :name where p.id = :id")
    int updatePatientNameById(@Param("name") String name, @Param("id") Long id);
}
