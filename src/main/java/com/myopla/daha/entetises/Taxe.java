package com.myopla.daha.entetises;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING,length=3)
public abstract class Taxe implements Serializable {
	@Id 
	@GeneratedValue
	private Long id;
	private String title;
	private Date dateTaxe;
	private double montant;
	@ManyToOne
	@JoinColumn(name="CODE_ENTR")
	private Entreprise entreprise;
	
	public Taxe() {
		super();
		// TODO Auto-generated constructor stub		
	}

	public Taxe(String title, Date dateTaxe, double montant, Entreprise entreprise) {
		super();
		this.title = title;
		this.dateTaxe = dateTaxe;
		this.montant = montant;
		this.entreprise = entreprise;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateTaxe() {
		return dateTaxe;
	}

	public void setDateTaxe(Date dateTaxe) {
		this.dateTaxe = dateTaxe;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	
	
	
	
	
}
