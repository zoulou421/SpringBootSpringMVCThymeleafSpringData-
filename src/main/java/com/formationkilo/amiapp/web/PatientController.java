package com.formationkilo.amiapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.formationkilo.amiapp.dto.PatientDto;
import com.formationkilo.amiapp.service.IPatientService;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class PatientController {
	
  private IPatientService patientService;
  
  
  @GetMapping(path="/index")
  public String patients(Model model) {
	  
	  List<PatientDto>patients=patientService.listePatientDto();
	  model.addAttribute("listPatients", patients);
	  return "patients";
  }
	
}
