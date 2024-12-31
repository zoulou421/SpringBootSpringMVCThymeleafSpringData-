package com.formationkilo.amiapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.formationkilo.amiapp.dto.PatientDto;
import com.formationkilo.amiapp.entities.Patient;

@Mapper(componentModel = "spring") 
public interface IPatientMapper {

    PatientDto toDto(Patient patient);
    Patient toEntity(PatientDto patientDto);
    List<PatientDto> toDto(List<Patient> listPatient);
    List<Patient> toEntity(List<PatientDto> listPatientDto);

    // Corrected method signature for Page mapping
    default Page<PatientDto> toPage(Page<Patient> pagePatient) {
        return pagePatient.map(this::toDto);
    }
    

}
