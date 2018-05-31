import java.util.Collections;
import java.util.Random;

public class Unite {

	String type; 
	int cout;
	int puissance;
	int attaque;
	int defence;
	int nbmouv;
	
	public Unite (String type,int cout,int puissance,int attaque,int defence,int nbmouv) {
		this.type = type;
		this.cout = cout;
		this.puissance = puissance;
		this.attaque = attaque;
		this.defence = defence;
		this.nbmouv = nbmouv;
	}

	public static int attribuerpuissance (int mouvmin, int mouvmax) {
		Random r = new Random();
		int puissance = mouvmin + r.nextInt(mouvmax - mouvmin);
		return puissance;
	}
	
	public static void attribuerArmees () {
	
		int nb = Plateau.joueurList.size();
		int nbarmee;
		
		switch (nb) {
		
		case 2 :
			nbarmee = 45;
			ajoutsoldat(nbarmee);
			break;
			
		case 3 :
			nbarmee = 35;
			ajoutsoldat(nbarmee);
			break;
			
		case 4 :
			nbarmee = 30;
			ajoutsoldat(nbarmee);
			break;
			
		case 5 :
			nbarmee = 25;
			ajoutsoldat(nbarmee);
			break;
			
		case 6 :
			nbarmee = 20;
			ajoutsoldat(nbarmee);
			break;
		}
		
	}
	
	public static void ajoutsoldat(int nbarmee) {
		for (Joueur j : Plateau.joueurList) {
			for (int i=0; i<nbarmee; i++) {
				j.addSoldat();
			}
		}
	}
	
	// Getters et Setters 
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getNbmouv() {
		return nbmouv;
	}

	public void setNbmouv(int nbmouv) {
		this.nbmouv = nbmouv;
	}
	
}
