package com.formationkilo.amiapp.web;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
  
  
  @GetMapping(path="/indexV2")
  public String patientsV2(Model model,
		  @RequestParam(name="page",defaultValue="0")int page, 
		  @RequestParam(name="size",defaultValue="5")int size) {
	  
	  Page<PatientDto>patientsPage=patientService.listePatientDtoPage(page, size);
	  model.addAttribute("listPatientsV2", patientsPage.getContent());
	  return "patients";
  }
	
}
