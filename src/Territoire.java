import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

public class Territoire {
	String nom;
	Territoire voisins[];
	protected ArrayList<Soldat> soldatListJoueur;
	protected ArrayList<Cavalier> cavalierListJoueur;
	protected ArrayList<Canon> canonListJoueur;
	public static ArrayList<Territoire> territoiresList;
	
	
	
	/*
	Alaska : Northwest Territory, Alberta, Kamchatka
	Northwest Territory : Alberta, Alaska , Ontario, Greenland
	Alberta : Alaska, Northwest Territory, Ontario, Western US
	Ontario : Northwest Territory, Alberta, Western US, Eastern US, Greenland, Quebec
	Greenland : Northwest Territory, Ontario, Quebec, Iceland
	Quebec : Ontario, Eastern US, Greenland
	Western US : Alberta, Ontario, Eastern US, Central America
	Eastern US : Western US, Ontario, Quebec, Central America
	Central America : Western US, Eastern US, Venezuela
	Venezuela : Central America, Brazil, Peru
	Peru : Venezuela, Brazil, Argentina
	Argentina : Peru, Brazil
	Brazil : Peru, Venezuela, Argentina, North Africa
	North Africa : Brazil, Egypt, East Africa, Congo, Western EU, Southern EU
	Congo : North Africa, East Africa, South Africa
	South Africa : Congo, East Africa, Madagascar
	Madagascar : South Africa, East Africa
	East Africa : North Africa, Egypt, Congo, South Africa
	Egypt : East Africa, North Africa, Southern EU, Middle East
	Southern EU : Western EU, Northern EU, Ukraine, Middle East
	Western EU : Southern EU, North Africa, Northern EU, Great Britain
	Great Britain : Western EU, Iceland, Scandinavia
	Iceland : Greenland, Scandinavia, Great Britain
	Scandinavia : Iceland, Great Britain, Northern EU, Ukrain
	Northern EU : Great Britain, Scandinavia, Western EU, Southern EU, Ukraine
	Ukraine : Scandinavia, Northern EU, Southern EU, Middle East, Afganistan, Ural
	Middle East : Egypt, East Africa, Southern EU, Ukraine, Afganistan, India
	Afganistan : Middle East, India, China, Ural, Ukraine
	Ural : Ukraine, Siberia, Afganistan, China
	Siberia : Ural, Yakutsk, Irkutsk, Mongolia, China
	China : Ural, Afganistan, India, Siam, Mongolia, Siberia
	India : Middle East, Afganistan, Siam, China
	Siam : India, China, Indonesia
	Mongolia : China, Siberia, Irkutsk, Kamchatka, Japan
	Yakutsk : Siberia, Irkutsk, Kamchatka
	Irkutsk : Siberia, Yakutsk, Kamchatka, Mongolia 
	Kamchatka : Yakutsk, Irkutsk, Mongolia, Alaska
	Japan : Mongolia, Kamchatka 
	Indonesia : Siam, New Guinea, Western Australia
	Western Australia : Indonesia, New Guinea, Eastern Australia
	Eastern Australia : Western Australia, New Guinea
	New Guinea : Indonesia, Eastern Australia, Western Australia
	*/
	
	
	
	   
	public Territoire(String nom, Territoire voisins[]) {
		this.nom = nom;
		this.voisins = voisins;
	}
	

	public static void attribuerTer(ArrayList<Territoire> territoiresList) {
		
		int j = 0; 
		Collections.shuffle(territoiresList); // mélange liste Territoires
		for (Territoire t : territoiresList){
			if (j==Plateau.joueurList.size()){
				j=0;
			}
			Plateau.joueurList.get(j).addTerritoire(t);
			//territoiresList.remove(t);
			j++;
		}
		
		for(Joueur l : Plateau.joueurList) {
			System.out.println(l.getNom());
			System.out.println(l.territoireListJoueur.size());
			
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


	
}