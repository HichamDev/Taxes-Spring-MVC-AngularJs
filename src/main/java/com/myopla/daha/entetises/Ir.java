package com.myopla.daha.entetises;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("IR")
public class Ir extends Taxe {

	public Ir() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ir(String title, Date dateTaxe, double montant, Entreprise entreprise) {
		super(title, dateTaxe, montant, entreprise);
		// TODO Auto-generated constructor stub
	}
	
	

}
