package com.myopla.daha.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myopla.daha.entetises.Entreprise;
import com.myopla.daha.entetises.Taxe;

public interface TaxeRepository extends JpaRepository<Taxe, Long> {
	
	public List<Taxe> findByEntreprise(Entreprise e);

}
