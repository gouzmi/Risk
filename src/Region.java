import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

public class Region {
	String nom;
	Territoire territoires[];
	
	//Constructeur 
	
	public Region(String nom, Territoire territoires[]) {
		this.nom = nom;
		this.territoires = territoires;
	}
	
	
	
	// Getters et Setters
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Territoire[] getTerritoires() {
		return territoires;
	}
	public void setTerritoires(Territoire[] territoires) {
		this.territoires = territoires;
	}
	
	

}
