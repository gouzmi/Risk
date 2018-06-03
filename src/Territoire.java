import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

public class Territoire {
	String nom;
	Territoire voisins[];
	Joueur occupant;
	protected ArrayList<Soldat> soldatListTerritoire;
	protected ArrayList<Cavalier> cavalierListTerritoire;
	protected ArrayList<Canon> canonListTerritoire;
	public ArrayList<Territoire> territoiresList;
	public ArrayList<Unite> uniteAtt;
	public ArrayList<Unite> uniteDef;
	public ArrayList<Unite> uniteMove;
	int x;
	int y;
	
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
	
	
	
	   



	public Territoire(String nom, Territoire voisins[], int x,int y) {
		this.nom = nom;
		this.voisins = voisins;
		ArrayList<Cavalier> tCava = new ArrayList<Cavalier>();
		this.cavalierListTerritoire = tCava;
		ArrayList<Canon> tCan = new ArrayList<Canon>();
		this.canonListTerritoire = tCan;
		ArrayList<Soldat> tSol = new ArrayList<Soldat>();
		this.soldatListTerritoire = tSol;
		//this.occupant = occupant;
		this.x=x;
		this.y=y;
	}
	

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public static void attribuerTer(ArrayList<Territoire> territoiresList) {
		
		int j = 0; 
		Collections.shuffle(territoiresList); // mélange liste Territoires
		for (Territoire t : territoiresList){
			if (j==Plateau.joueurList.size()){
				j=0;
			}
			Plateau.joueurList.get(j).addTerritoire(t);
			t.setOccupant(Plateau.joueurList.get(j));
			t.addSoldat(1);
			j++;
		}
		
		for(Joueur l : Plateau.joueurList) {
			System.out.println(l.getNom());
			System.out.println(l.territoireListJoueur.size());
			
		}
		
		
	}

	public Joueur getOccupant() {
		return occupant;
	}


	public void setOccupant(Joueur occupant) {
		this.occupant = occupant;
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


	public ArrayList<Soldat> getSoldatListTerritoire() {
		return soldatListTerritoire;
	}


	public void setSoldatListTerritoire(ArrayList<Soldat> soldatListTerritoire) {
		this.soldatListTerritoire = soldatListTerritoire;
	}


	public ArrayList<Cavalier> getCavalierListTerritoire() {
		return cavalierListTerritoire;
	}


	public void setCavalierListTerritoire(ArrayList<Cavalier> cavalierListTerritoire) {
		this.cavalierListTerritoire = cavalierListTerritoire;
	}


	public ArrayList<Canon> getCanonListTerritoire() {
		return canonListTerritoire;
	}


	public void setCanonListTerritoire(ArrayList<Canon> canonListTerritoire) {
		this.canonListTerritoire = canonListTerritoire;
	}


	public void setVoisins(Territoire[] voisins) {
		this.voisins = voisins;
	}

	public ArrayList<Territoire> getTerritoiresList() {
		return territoiresList;
	}

	public void setTerritoiresList(ArrayList<Territoire> territoiresList) {
		this.territoiresList = territoiresList;
	}

	public void addSoldat(int nb) {
		if(this.occupant.soldatListJoueur.size()>=nb) {
			for(int i=0;i<nb;i++) {
				this.soldatListTerritoire.add(new Soldat());
				this.occupant.soldatListJoueur.remove(this.occupant.soldatListJoueur.size()-1);
			}
		}
		else {
			System.out.println("pas assez d'unités !");
		}
	}
	
	public void addCavalier(int nb) {
		if(this.occupant.soldatListJoueur.size()>=3*nb) {
			for(int i=0;i<nb;i++) {
				this.cavalierListTerritoire.add(new Cavalier());
			}
			for(int i=0;i<3*nb;i++) {
				this.occupant.soldatListJoueur.remove(this.occupant.soldatListJoueur.size()-1);
			}
		}
		else {
			System.out.println("pas assez d'unités !");
		}
	}
	
	public void addCanon(int nb) {
		if(this.occupant.soldatListJoueur.size()>=7*nb) {
			for(int i=0;i<nb;i++) {
				this.canonListTerritoire.add(new Canon());
			}
			for(int i=0;i<7*nb;i++) {
				this.occupant.soldatListJoueur.remove(this.occupant.soldatListJoueur.size()-1);
			}
		}
		else {
			System.out.println("pas assez d'unités !");
		}
	}
	
	public ArrayList<Unite> getUniteAtt() {
		return uniteAtt;
	}


	public void setUniteAtt(ArrayList<Unite> uniteAtt) {
		this.uniteAtt = uniteAtt;
	}


	public ArrayList<Unite> getUniteMove() {
		return uniteMove;
	}


	public void setUniteMove(ArrayList<Unite> uniteMove) {
		this.uniteMove = uniteMove;
	}
	public ArrayList<Unite> getUniteDef() {
		return uniteDef;
	}


	public void setUniteDef(ArrayList<Unite> uniteDef) {
		this.uniteDef = uniteDef;
	}


	
}