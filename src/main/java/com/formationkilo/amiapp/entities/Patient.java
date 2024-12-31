package com.formationkilo.amiapp.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
 @AllArgsConstructor @NoArgsConstructor
 @Getter @Setter
public class Patient implements Serializable{
	    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @NotEmpty
	    @Size(min = 2, max = 50)
	    private  String nom;

	    @Temporal(TemporalType.DATE)
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date dateNaissance;
	    private boolean malade;
	    @DecimalMin("5")
	    private int score;

}
