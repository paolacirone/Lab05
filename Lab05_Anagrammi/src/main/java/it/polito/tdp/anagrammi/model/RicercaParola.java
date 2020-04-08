package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class RicercaParola {

	private List<String> soluzione;
	DizionarioDAO d= new DizionarioDAO();

	public List<String> anagrammi(String parola) {

		this.soluzione = new ArrayList<String>();

		parola.toLowerCase();

		List<Character> disponibili = new ArrayList<>();

		for (int i = 0; i < parola.length(); i++) {
			disponibili.add(parola.charAt(i));
		}

		cerca("", 0, disponibili);

		return this.soluzione;

	}

	private void cerca(String parziale, int livello, List<Character> disponibili) {

		if (disponibili.size() == 0) {
			if(!soluzione.contains(parziale)) //evito i duplicati
			this.soluzione.add(parziale);
		}
		
		//if(!d.esisteNelDizionario(parziale)) {
		//	return;
		//}

		
			
		
		for (Character ch : disponibili) {

			String tentativo = parziale + ch;
			List<Character> rimanenti = new ArrayList<>(disponibili); // è ugaule all precedente meno il carattere ch
			rimanenti.remove(ch); // non è possibile rimuovere da quella su cui sto iterando

			cerca(tentativo, livello + 1, rimanenti);
		}

	}

}
