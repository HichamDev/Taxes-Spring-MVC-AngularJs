package com.myopla.daha.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myopla.daha.dao.EntrepriseRepository;
import com.myopla.daha.dao.TaxeRepository;
import com.myopla.daha.entetises.Entreprise;

@Controller
public class TaxeController {
	
	@Autowired
	private EntrepriseRepository entreRepo;
	@Autowired
	private TaxeRepository taxesRepo;

	@RequestMapping(value="/entreprise", method=RequestMethod.GET)
	public String index(Model model, 
			@RequestParam(name="motCle", defaultValue="") String motCle,
			@RequestParam(name="page", defaultValue="0") int p, 
			@RequestParam(name="size", defaultValue="5")int s){
		
		Page<Entreprise> pageEntreprise = entreRepo.cherche("%"+motCle+"%", new PageRequest(p, s));
		model.addAttribute("listsEntrep",pageEntreprise.getContent());
		int[] pages = new int[pageEntreprise.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourant", p);
		model.addAttribute("motCle", motCle);
		return "entreprise";
	}
	
	@RequestMapping(value="/formEntreprise")
	public String formEntreprise(Model model){
		model.addAttribute("entreprise", new Entreprise());
		
		return "formEntreprise";
	}
	
	@RequestMapping(value="/saveEntreprise")
	public String save(Model model,
			@Valid Entreprise e,
			BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return "formEntreprise";
		}
		else{
			entreRepo.save(e);		
			return "redirect:/entreprise";
		}
			
		
	}
	
	@RequestMapping(value="/taxes" ,method=RequestMethod.GET)
	public String taxes(Model model, 
			@RequestParam(name="code", defaultValue="-1")Long code){
		Entreprise e= new Entreprise();
		e.setCode(code);
		if(code!=-1){
			model.addAttribute("taxes", taxesRepo.findByEntreprise(e));		
			model.addAttribute("entrs", entreRepo.findAll());
		}else{
			model.addAttribute("entrs", entreRepo.findAll());
			model.addAttribute("taxes", taxesRepo.findAll());	
		}
		
				
		return "taxes";
	}
	
	
}
