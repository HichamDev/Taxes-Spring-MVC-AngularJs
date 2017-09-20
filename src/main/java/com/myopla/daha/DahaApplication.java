package com.myopla.daha;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myopla.daha.dao.EntrepriseRepository;
import com.myopla.daha.dao.TaxeRepository;
import com.myopla.daha.entetises.Entreprise;
import com.myopla.daha.entetises.Ir;
import com.myopla.daha.entetises.Tva;

@SpringBootApplication
public class DahaApplication implements CommandLineRunner{
	@Autowired
	private EntrepriseRepository entrRepo; 
	@Autowired
	private TaxeRepository taxeRepo;
	public static void main(String[] args) {
		SpringApplication.run(DahaApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
//		Entreprise e1 = entrRepo.save(new Entreprise("R1","r1@mail.com","SARL"));
//		Entreprise e2 = entrRepo.save(new Entreprise("R2","r2@mail.com","SA"));
//		Entreprise e3 = entrRepo.save(new Entreprise("R3","r3@mail.com","SAt"));
//		Entreprise e4 = entrRepo.save(new Entreprise("R4","r4@mail.com","HICH"));
//		
//		taxeRepo.save(new Tva("TVA HAJAR", new Date(), 777, e1));
//		taxeRepo.save(new Tva("TVA niss", new Date(), 888, e2));
//		taxeRepo.save(new Ir("TVA kkk", new Date(), 999, e2));
//		taxeRepo.save(new Ir("IR VOITURE", new Date(), 111, e3));
		
	}
}
