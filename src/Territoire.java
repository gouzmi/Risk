import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

public class Territoire {
	String nom;
	Territoire voisins[];
	public static ArrayList<Territoire> territoiresList;
	static Territoire voisin[] = new Territoire[2];
	static Territoire France = new Territoire("France",voisin);
	static Territoire Italie = new Territoire("Italie",voisin);
	static Territoire Espagne = new Territoire("Espagne",voisin);
	  
	
	   
	public Territoire(String nom, Territoire voisins[]) {
		this.nom = nom;
		this.voisins = voisins;
	}
	
	public static void attribuerTer() {
		
		territoiresList.add(France);
		territoiresList.add(Italie);
		territoiresList.add(Espagne);
		int j = 0; 
		Collections.shuffle(territoiresList); // mélange liste Territoires
		for (Territoire t : territoiresList){
			if (j==Joueur.joueurList.size()-1){
				j=0;
			}
			Joueur.joueurList.get(j).addTerritoire(t);
			territoiresList.remove(t);
			j++;
		}
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Territoire[] getVoisins() {
		return voisins;
	}

	public void setVoisins(Territoire[] voisins) {
		this.voisins = voisins;
	}

	public static ArrayList<Territoire> getTerritoiresList() {
		return territoiresList;
	}

	public static void setTerritoiresList(ArrayList<Territoire> territoiresList) {
		Territoire.territoiresList = territoiresList;
	}

	public static Territoire[] getVoisin() {
		return voisin;
	}

	public static void setVoisin(Territoire[] voisin) {
		Territoire.voisin = voisin;
	}
	
}