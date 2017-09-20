package com.myopla.daha.entetises;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TVA")
public class Tva extends Taxe {

	public Tva() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tva(String title, Date dateTaxe, double montant, Entreprise entreprise) {
		super(title, dateTaxe, montant, entreprise);
		// TODO Auto-generated constructor stub
	}

	
}
