package ca.csf.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ca.csf.formes.ElementGraphique;
import ca.csf.formes.Rectangle;
import ca.csf.modele.ModeleDessin;

class ModeleDessintest {

	@Test
	void constructeurDefaut() {
		ModeleDessin md = new ModeleDessin();
		assertEquals(640, md.getLargeur());
		assertEquals(360, md.getHauteur());
	}
	
	@Test
	void constructeurInitialisation() {
		ModeleDessin md = new ModeleDessin(600, 300);
		assertEquals(600, md.getLargeur());
		assertEquals(300, md.getHauteur());
		assertEquals(0, md.getCompte());
	}
	
	@Test
	void constructeurInvalid() {
		assertThrows(IllegalArgumentException.class, () -> new ModeleDessin(-600, 300));
		assertThrows(IllegalArgumentException.class, () -> new ModeleDessin(600, -300));
	}
	
	@Test
	void ajouter() {
		ModeleDessin md = new ModeleDessin();
		ElementGraphique el = new Rectangle();  
		md.ajouter(el);
		assertEquals(1, md.getCompte());
	}
	
	@Test
	void ajouterListeElements() {
		ModeleDessin md = new ModeleDessin();
		ArrayList<ElementGraphique> egList = new ArrayList<ElementGraphique>();  
		ElementGraphique a = new Rectangle(); 
		ElementGraphique b = new Rectangle(); 
		ElementGraphique c = new Rectangle(); 
		egList.add(a);
		egList.add(b);
		egList.add(c);
		md.ajouter(egList);
		assertEquals(3, md.getCompte());
	}
	
	@Test
	void ajouterListeElementsInvalid() {
		ModeleDessin md = new ModeleDessin();
		final ArrayList<ElementGraphique> egList = null;
		assertThrows(IllegalArgumentException.class, () -> md.ajouter(egList));
	}
	
	@Test
	void inserer() {
		ModeleDessin md = new ModeleDessin();
		ElementGraphique el = new Rectangle();
		md.inserer(0, el);
		assertEquals(0, md.getIndiceDe(el));
	}
	
	@Test
	void insererIndiceInvalid() {
		ModeleDessin md = new ModeleDessin();
		final ArrayList<ElementGraphique> egList = null;
		assertThrows(IllegalArgumentException.class, () -> md.ajouter(egList));
	}
	
	@Test
	void retirer() {
		ModeleDessin md = new ModeleDessin();
		ElementGraphique el = new Rectangle();  
		md.ajouter(el);
		md.retirer(el);
		assertEquals(0, md.getCompte());
	}
	
	
}
