package com.myopla.daha.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myopla.daha.dao.EntrepriseRepository;
import com.myopla.daha.entetises.Entreprise;

@RestController
public class TaxeRestController {
	
	@Autowired
	private EntrepriseRepository entrepRepo;
	
	@RequestMapping("/listeentreprise")
	public Page<Entreprise> listEntreprise(
			@RequestParam(name="motCle", defaultValue="")String motCle,
			@RequestParam(name="page", defaultValue="0")  int page,
			@RequestParam(name="size", defaultValue="5") int size){
		return entrepRepo.cherche("%"+motCle+"%", 
						new PageRequest(page, size));
	}
	
	

}
