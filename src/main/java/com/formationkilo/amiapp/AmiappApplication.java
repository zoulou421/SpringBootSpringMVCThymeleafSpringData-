package com.formationkilo.amiapp;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.formationkilo.amiapp.dto.PatientDto;
import com.formationkilo.amiapp.service.IPatientService;

@SpringBootApplication
public class AmiappApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmiappApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(IPatientService patientService) {
		return args->{
			/*patientService.saveDto(new PatientDto(null,"Bonevy1",new Date(),false,12));
			patientService.saveDto(new PatientDto(null,"Bonevy2",new Date(),true,13));
			patientService.saveDto(new PatientDto(null,"Bonevy3",new Date(),false,14));
			patientService.saveDto(new PatientDto(null,"Bonevy4",new Date(),true,15));
			patientService.saveDto(new PatientDto(null,"Bonevy5",new Date(),false,16));
			patientService.saveDto(new PatientDto(null,"Bonevy6",new Date(),true,17));*/
			
			
			patientService.listePatientDto().forEach(p->{
				System.out.println(p.getNom());
			});
		};
	}

}
