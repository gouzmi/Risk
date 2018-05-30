import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

public class Territoire {
	String nom;
	Territoire voisins[];
<<<<<<< HEAD
=======
	public static ArrayList<Territoire> territoiresList;
	static Territoire voisin[] = new Territoire[2];
	static Territoire Alaska = new Territoire("Alaska",voisin);
	static Territoire NorthwestTerritory = new Territoire("NorthwestTerritory",voisin);
	static Territoire Alberta = new Territoire("Alberta",voisin);
	static Territoire Ontario = new Territoire("Ontario",voisin);
	static Territoire Greenland = new Territoire("Greenland",voisin);
	
	
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
	SIam : India, China, Indonesia
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

	
>>>>>>> 6b6a295c73bf2b23e9bb8602e50f1d0b89ce00fa
	   
	public Territoire(String nom, Territoire voisins[]) {
		this.nom = nom;
		this.voisins = voisins;
	}
	
<<<<<<< HEAD
	
=======
	public static void attribuerTer() {
		
		territoiresList.add(Alaska);
		territoiresList.add(NorthwestTerritory);
		territoiresList.add(Alberta);
		territoiresList.add(Ontario);
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
>>>>>>> 6b6a295c73bf2b23e9bb8602e50f1d0b89ce00fa

	
}