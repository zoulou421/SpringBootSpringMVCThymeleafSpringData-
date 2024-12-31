package com.formationkilo.amiapp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class PatientDto {
    private Long id;
    private  String nom;
    private Date dateNaissance;
    private boolean malade;
    private int score;
}
