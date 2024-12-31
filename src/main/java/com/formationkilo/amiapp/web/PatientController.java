package com.formationkilo.amiapp.web;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
  
  
  //whitout pagination nor keyword
  @GetMapping(path="/index")
  public String patients(Model model) {
	  
	  List<PatientDto>patients=patientService.listePatientDto();
	  model.addAttribute("listPatients", patients);
	  return "patients";
  }
  
  
//With Pagination only
  
  @GetMapping(path="/indexV2")
  public String patientsV2(Model model,
		  @RequestParam(name="page",defaultValue="0")int page, 
		  @RequestParam(name="size",defaultValue="5")int size) {
	  
	  Page<PatientDto>patientsPage=patientService.listePatientDtoPage(page, size);
	  model.addAttribute("listPatientsV2", patientsPage.getContent());
	  model.addAttribute("pages", new int[patientsPage.getTotalPages()]);
	  model.addAttribute("currentPage", page);

	  return "patients";
  }
  
 
  //With Pagination +Keyword seach
  @GetMapping(path="/indexV3")
  public String patientsV3(Model model,
		  @RequestParam(name="page",defaultValue="0")int page, 
		  @RequestParam(name="size",defaultValue="5")int size,
		  @RequestParam(name="keyword",defaultValue="")String keyword
		  ) {
	  
	  Page<PatientDto>patientsPage=patientService.findByNomContainsDto(keyword, PageRequest.of(page, size));
	  model.addAttribute("listPatientsV3", patientsPage.getContent());
	  model.addAttribute("pages3", new int[patientsPage.getTotalPages()]);
	  model.addAttribute("currentPage3", page);
	  model.addAttribute("keyword", keyword);

	  return "patients";
  }
  @GetMapping(path="/delete")
  public String deleteController(Long id) {
	  patientService.deleteByDto(id);
	  return "redirect:/indexV3";
  }
	
}
