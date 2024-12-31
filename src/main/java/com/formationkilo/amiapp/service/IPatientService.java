package com.formationkilo.amiapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestParam;

import com.formationkilo.amiapp.dto.PatientDto;

public interface IPatientService {
 public void saveDto(PatientDto patientDto);
 public void deleteDto(PatientDto patientDto);
 public void updateDto();
 public List<PatientDto> listePatientDto();
 
 public Page<PatientDto> listePatientDtoPage(int page,int size);
 
 
}
