import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import javax.swing.JOptionPane;

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

	
	public static void attribuerArmees () {
	
		int nb = Plateau.joueurList.size();
		int nbarmee;
		
		switch (nb) {
		
		case 2 :
			nbarmee = 40;
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
		System.out.println(j.getNom()+ " a une armée de");
		System.out.println(j.soldatListJoueur.size());
		}
	}
	
		public static void renfort(Joueur j) {
		int r = (int) Math.floor((j.territoireListJoueur.size()/3));
		System.out.print(r);
		
		int compt = 0;
		for (Region region : Plateau.regionsList) {
			for (Territoire t : region.territoires) {
				for(Territoire tj : j.territoireListJoueur) {
					System.out.print("je suis ici");
					if (tj == t) {
						compt++;
					}
				}
			}
			if (compt == region.territoires.length) {
				r = r+(int) Math.floor((compt/2));
				System.out.print(r);
			}
		}
		System.out.print("r final "+r);
		if (r<=2) {
			r = 2;
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
	
	public static boolean sontVoisin(Territoire dep, Territoire arr) {
		for (int i=0;i<arr.voisins.length;i++) {
			if(dep == arr.voisins[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static void beforeMove(Territoire dep, int nbS,int nbCav, int nbCan) {
		dep.getUniteMove().clear();
		if(dep.getCanonListTerritoire().size()+dep.getSoldatListTerritoire().size()+dep.getCavalierListTerritoire().size()>nbS+nbCan+nbCav) {
			// IL DOIT RESTER AU MOINS UNE UNITE SUR DEP
			if(dep.getCanonListTerritoire().size()>=nbCan && dep.getSoldatListTerritoire().size()>=nbS && dep.getCavalierListTerritoire().size()>=nbCav  ) {
			// VERIFICATION SUR LE NOMBRE DE CHAQUE TYPE
				Collections.sort(dep.soldatListTerritoire, Comparator.comparing(Soldat::getNbmouv));
				Collections.reverse(dep.getSoldatListTerritoire());
				for(int i=0;i<nbS;i++) {
					if(dep.getSoldatListTerritoire().get(i).getNbmouv()>0) {
						dep.uniteMove.add(dep.getSoldatListTerritoire().get(i));
					}
					else {
						JOptionPane jop2;
						jop2 = new JOptionPane();
						jop2.showMessageDialog(null, "Plus assez de déplacement pour votre "+dep.getSoldatListTerritoire().get(i).getType(), "Attention", JOptionPane.INFORMATION_MESSAGE);	
					}
					
				}
				Collections.sort(dep.cavalierListTerritoire, Comparator.comparing(Cavalier::getNbmouv));
				Collections.reverse(dep.getCavalierListTerritoire());
				for(int i=0;i<nbCav;i++) {
					if(dep.getCavalierListTerritoire().get(i).getNbmouv()>0) {
						dep.getUniteMove().add(dep.getCavalierListTerritoire().get(i));
					}
					else {
						JOptionPane jop2;
						jop2 = new JOptionPane();
						jop2.showMessageDialog(null, "Plus assez de déplacement pour votre "+dep.getCavalierListTerritoire().get(i).getType(), "Attention", JOptionPane.INFORMATION_MESSAGE);	
					}
					
				}
				Collections.sort(dep.canonListTerritoire, Comparator.comparing(Canon::getNbmouv));
				Collections.reverse(dep.getCanonListTerritoire());
				for(int i=0;i<nbCan;i++) {
					if(dep.getCanonListTerritoire().get(i).getNbmouv()>0) {
						dep.getUniteMove().add(dep.getCanonListTerritoire().get(i));
					}
					else {
						JOptionPane jop2;
						jop2 = new JOptionPane();
						jop2.showMessageDialog(null,"Plus assez de déplacement pour votre "+dep.getCanonListTerritoire().get(i).getType(), "Attention", JOptionPane.INFORMATION_MESSAGE);	
					}
					
				}
			}
			else {
				JOptionPane jop2;
				jop2 = new JOptionPane();
				jop2.showMessageDialog(null,"Un de vos types d'unités n'est pas suffisant", "Attention", JOptionPane.INFORMATION_MESSAGE);				
			}
		}
		else {
			JOptionPane jop2;
			jop2 = new JOptionPane();
			jop2.showMessageDialog(null,"Il doit rester au moins une unité sur le territoire de départ", "Attention", JOptionPane.INFORMATION_MESSAGE);				
		}
		
	}
	
	public static void move(Territoire dep, Territoire arr) {
		
		if(sontVoisin(dep,arr)==true) {
			if(dep.getOccupant()==arr.getOccupant()) {
				for(Unite each : dep.getUniteMove()) {
						if(each.cout==1) {
							Soldat soldat = new Soldat();
							soldat.setNbmouv(each.getNbmouv()-1);
							arr.getSoldatListTerritoire().add(soldat);
							dep.getSoldatListTerritoire().remove(each);
						}
						else if(each.cout==3) {
							Cavalier cavalier = new Cavalier();
							cavalier.setNbmouv(each.getNbmouv()-1);
							arr.getCavalierListTerritoire().add(cavalier);
							dep.getCavalierListTerritoire().remove(each);
						}
						else {
							Canon canon = new Canon();
							canon.setNbmouv(each.getNbmouv()-1);
							arr.getCanonListTerritoire().add(canon);
							dep.getCanonListTerritoire().remove(each);
						}
				}
				dep.getUniteMove().clear();
	
			}
			else {
				if(dep.uniteMove.size()<4) {
					System.out.println("A l'attaque !");
					dep.getUniteAtt().clear();
					dep.getUniteAtt().addAll(dep.getUniteMove());
					dep.getUniteMove().clear();
					Combat c = new Combat();
					c.combattre(dep, arr);	
				}
				else {
					JOptionPane jop2;
					jop2 = new JOptionPane();
					jop2.showMessageDialog(null,"Trop d'unités pour attaquer !", "Attention", JOptionPane.INFORMATION_MESSAGE);				
				}
			}
		}
		else {
			JOptionPane jop2;
			jop2 = new JOptionPane();
			jop2.showMessageDialog(null,"Les territoires ne sont pas voisins !", "Attention", JOptionPane.INFORMATION_MESSAGE);				
		}
	}
	
}
