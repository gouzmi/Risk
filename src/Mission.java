import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Mission {
	String A = "Détruire le joueur";
	String B = "Conquérir tous les territoires";
	String C = "Contôler 3 régions et au moins 18 territoires";
	String D = "Contrôler 18 territoires avec au moins 2 armées";
	String E = "Contrôler 30 territoires";
	String F = "Contrôler 24 territoires";
	String G = "contrôler 21 territoires";
	String H = "Contrôler la plus grosse région + 1 autre région";
	List<String> list = new ArrayList<String>();
	

	
	public Mission (List<Joueur> j) {
		list.add(C);
		list.add(H);
		
		switch (j.size()) {
		
		case 2:
			list.add(B);
			list.add(E);
			choixmission(list, j);
			break;
			
		case 3:
			list.add(A);
			list.add(B);
			list.add(E);
			list.add(D);
			choixmission(list, j);
			break;
			
		case 4:
			list.add(A);
			list.add(D);
			list.add(F);
			choixmission(list, j);
			break;
			
		case 5:
			list.add(A);
			list.add(D);
			list.add(F);
			choixmission(list, j);
			break;
			
		case 6 : 
			list.add(A);
			list.add(D);
			list.add(G);
			choixmission(list, j);
			break;
			
		
		}
	}
	
	public void choixmission (List<String> list, List<Joueur> j) {
		int l = list.size();
		for (int i=0; i<j.size(); i++) {
			Random r = new Random();
			int valeur = 1 + r.nextInt(l - 1);
			String mission = list.get(valeur);;
			if (mission == A) {
				Random p = new Random();
				int k = 2 + p.nextInt(j.size() - 2);
				while (k==i) {
					p = new Random();
					k = 2 + p.nextInt(j.size() - 2);
				}
				mission = "Détruire le joueur "+k;
			}
			j.get(i).setMission(mission);
			//System.out.println("La mission du joueur "+i+" est "+mission); // il faudra faire un pause d'affichage 
		}
	}
	
		public boolean Victoire(Joueur j, List<Joueur> Jlist) {
		boolean v = false;
		if (j.territoireListJoueur.size()==42) {
			v = true;
		}
		else if (j.getMission().equals(B)) {
			if (j.territoireListJoueur.size()==42) {
				v = true;
			}
		}
		else if (j.getMission().equals(C)) {
			int comptr=0;
			if (j.territoireListJoueur.size()>=18) {
				for (Region region : Plateau.regionsList) {
					int comptt=0;
					for (Territoire t : j.territoireListJoueur) {
						for (Territoire r : region.territoires) {
							if (t==r) {
								comptt++;
						}
					}
				}
					if (comptt==region.territoires.length) {
						comptr++;
					}
			}
				if (comptr >=3) {
				v = true;
				}
			}
		}
		else if (j.getMission().equals(D)) {
			int compt = 0;
			if (j.territoireListJoueur.size()>=18) {
				int nbarmee = 0;
				for (Territoire t : j.territoireListJoueur) {
					nbarmee = t.canonListTerritoire.size()+t.soldatListTerritoire.size()+t.cavalierListTerritoire.size();
					if (nbarmee>=2) {
						compt++;
					}
				}
				if (compt>=18) {
					v=true;
				}
			}
		}
		else if (j.getMission().equals(E)) {
			if (j.territoireListJoueur.size()==30) {
				v = true;
			}
		}
		else if (j.getMission().equals(F)) {
			if (j.territoireListJoueur.size()==24) {
				v = true;
			}
		}
		else if (j.getMission().equals(G)) {
			if (j.territoireListJoueur.size()==21) {
				v = true;
			}
		}
		else if (j.getMission().equals(H)) {
			int compt=0;
			for (Territoire r : Plateau.regionsList.get(4).getTerritoires()) {
				for (Territoire t : j.territoireListJoueur) {
					if (r==t) {
						compt++;
					}
				}
			}
			
			if (compt==Plateau.regionsList.get(4).territoires.length) {
				int comptr=0;
				if (j.territoireListJoueur.size()>=18) {
					ArrayList<Region> copie = new ArrayList<Region>();
					copie = Plateau.regionsList;
					copie.remove(4);
					for (Region region : copie) {
						int comptt=0;
						for (Territoire t : j.territoireListJoueur) {
							for (Territoire r : region.territoires) {
								if (t==r) {
									comptt++;
							}
						}
					}
						if (comptt==region.territoires.length) {
							comptr++;
						}
				}
					if (comptr >=1) {
					v = true;
					}
				}		
			}
		}
		/*else if(j.getMission().substring(0, 19) == "Détruire le joueur"){
			System.out.println("LAAAAAAAAAAA");
			for(Joueur cible : Jlist) {
				if(j.getMission().equals("Détruire le joueur "+cible.getNom())) {
					System.out.print("Détruire le joueur " + cible.getNom() + " C'est la mission de " + j.getNom());
					if(cible.getTerritoireListJoueur().size() == 0) {
						v = true;
					}
				}
			}
		}*/
		return v;
	}

}
