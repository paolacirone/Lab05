package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class Model {

	DizionarioDAO d; 
	RicercaParola r;
	
	public Model() {
		d= new DizionarioDAO();
		r= new RicercaParola();
	}
	
	public boolean esisteNelDizionario(String parola) {
		return d.esisteNelDizionario(parola);
	}
	
	public List<String> anagrammi(String parola) {
		return r.anagrammi(parola);
	}


	
	
}
