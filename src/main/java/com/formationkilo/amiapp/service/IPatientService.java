package com.formationkilo.amiapp.service;

import java.util.List;

import com.formationkilo.amiapp.dto.PatientDto;

public interface IPatientService {
 public void saveDto(PatientDto patientDto);
 public void deleteDto(PatientDto patientDto);
 public void updateDto();
 public List<PatientDto> listePatientDto();
}
