package com.formationkilo.amiapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.formationkilo.amiapp.dao.PatientDao;
import com.formationkilo.amiapp.dto.PatientDto;
import com.formationkilo.amiapp.mapper.IPatientMapper;


@Service
public class PatientService implements IPatientService {
	
	@Autowired
	private IPatientMapper patientMapper;
	
	@Autowired
	private PatientDao patientDao;

	@Override
	public void saveDto(PatientDto patientDto) {
		patientDao.save(patientMapper.toEntity(patientDto));
		
	}

	@Override
	public void deleteDto(PatientDto patientDto) {
		patientDao.delete(patientMapper.toEntity(patientDto));
	}

	@Override
	public void updateDto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PatientDto> listePatientDto() {
		return patientMapper.toDto(patientDao.findAll());
	}

	@Override
	public Page<PatientDto> listePatientDtoPage(int page,int size) {
	  return patientMapper.toPage(patientDao.findAll(PageRequest.of(page, size)));
	}

	
	

	

}
