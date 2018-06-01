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
				j.addSoldatJoueur();
			}
		System.out.println(j.getNom()+ " Ã  une armÃ©e de ");
		System.out.println(j.soldatListJoueur.size());
		}
	}
	
		public static void renfort(Joueur j) {
		int r = (int) Math.floor((j.territoireListJoueur.size()/3));
		if (r<=2) {
			r = 2;
		}
		int compt = 0;
		for (Region region : Plateau.regionsList) {
			for (Territoire t : region.territoires) {
				for(Territoire tj : j.territoireListJoueur) {
					if (tj == t) {
						compt++;
					}
				}
			}
			if (compt == region.territoires.length) {
				r = r+(int)Math.floor(compt/2);
			}
		}
		for (int i=0; i<r; i++) {
			j.addSoldatJoueur();
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
	
	public void move(Territoire dep, Territoire arr) {
		if(dep.getOccupant()==arr.getOccupant()) {
			if(this.nbmouv>0) {
				if(this.cout==1) {
					Soldat soldat = new Soldat();
					soldat.setNbmouv(this.getNbmouv()-1);
					arr.getSoldatListTerritoire().add(soldat);
					dep.getSoldatListTerritoire().remove(this);
				}
				else if(this.cout==3) {
					Cavalier cavalier = new Cavalier();
					cavalier.setNbmouv(this.getNbmouv()-1);
					arr.getCavalierListTerritoire().add(cavalier);
					dep.getCavalierListTerritoire().remove(this);
				}
				else {
					Canon canon = new Canon();
					canon.setNbmouv(this.getNbmouv()-1);
					arr.getCanonListTerritoire().add(canon);
					dep.getCanonListTerritoire().remove(this);
				}
			}
			else {
				System.out.println("Plus assez de déplacement");
			}
		}
		else {
			System.out.println("Les 2 territoires ne sont pas au même occupant");
		}
	}
	
}
