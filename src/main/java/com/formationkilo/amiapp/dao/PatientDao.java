package com.formationkilo.amiapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formationkilo.amiapp.entities.Patient;

@Repository
public interface PatientDao extends JpaRepository<Patient, Long>{

	Page<Patient>findByNomContains(String kw, PageRequest pageRequest);
}
