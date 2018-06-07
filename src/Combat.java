import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import javax.swing.JOptionPane;

	

public class Combat {
	
	public ArrayList<Unite> listSurvivant;
	public ArrayList<Soldat> soldatSurvivant;
	public ArrayList<Cavalier> cavalierSurvivant;
	public ArrayList<Canon> canonSurvivant;
	
	
	public Combat() {
		ArrayList<Unite> sur = new ArrayList<Unite>();
		this.listSurvivant = sur;
	}
	
	public static int attribuerPui (int a, int b) {
		Random r = new Random();
		int puissance = a + r.nextInt(b - a);
		return puissance;
	}
	
	public void lancerDe(ArrayList<Unite> list) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getCout()==1) {
				list.get(i).setPuissance(attribuerPui(1,6));
			}
			else if(list.get(i).getCout()==3) {
				list.get(i).setPuissance(attribuerPui(2,7));
			}
			else {
				list.get(i).setPuissance(attribuerPui(4,9));
			}
		}
	}
	
	public void choisirDEF(Territoire t) {
		t.getUniteDef().clear();
		t.getUniteDef().addAll(t.getSoldatListTerritoire());
		t.getUniteDef().addAll(t.getCanonListTerritoire());
		t.getUniteDef().addAll(t.getCavalierListTerritoire());	
		Collections.sort(t.getUniteDef(), Comparator.comparing(Unite::getDefence));
		
		if(t.getUniteDef().size()>2) {
			for(int i=t.getUniteDef().size()-1;i>1;i--) {
				t.getUniteDef().remove(i);
			}
		}
		
	}
	
	public void trierDEF(ArrayList<Unite> liste) {
		if(liste.size()>1) {
			if (liste.get(0).getPuissance() < liste.get(1).getPuissance()) {
				Collections.swap(liste, 0, 1);
			}
		}
	}
	
	public void trierATT(Territoire t) {
		
		// TRI A BULLES DANS LA LISTE ATTAQUANTE
		
		Collections.sort(t.getUniteAtt(), Comparator.comparing(Unite::getPuissance));
		Collections.reverse(t.getUniteAtt());
		for (int i = t.getUniteAtt().size()-1; i > 0 ; i--) {
			for(int j =0;j<	i;j++) {
				if(t.getUniteAtt().get(j+1).getPuissance()==t.getUniteAtt().get(j).getPuissance()
						&& t.getUniteAtt().get(j+1).getAttaque()<t.getUniteAtt().get(j).getAttaque()) {
					Collections.swap(t.getUniteAtt(), j+1, j);
				}
			}
		}
	}
	
	public void affrontement(Territoire att, Territoire def) {
		int r;
		if(att.getUniteAtt().size()<def.getUniteDef().size()) {
			r = att.getUniteAtt().size();
		}
		else {
			r = def.getUniteDef().size();
		}
		// NETTOYAGE DE LA LISTE SURVIVANT AVANT LE COMBAT
		this.listSurvivant.clear();
		//
		ArrayList<String>victoires = new ArrayList<String>();
		for(int i=0;i<r;i++) {
			int a = i+1;

			// VICTOIRE
			if(att.getUniteAtt().get(i).getPuissance()>def.getUniteDef().get(i).getPuissance()) {
				victoires.add("Victoire au tour "+a);
				this.listSurvivant.add(att.getUniteAtt().get(i));   // AJOUT A LA LISTE SURVIVANT 
				if(def.getUniteDef().get(i).getCout()==1) {
					def.getSoldatListTerritoire().remove(def.getUniteDef().get(i));
				}
				else if(def.getUniteDef().get(i).getCout()==3) {
					def.getCavalierListTerritoire().remove(def.getUniteDef().get(i));
				}
				else {
					def.getCanonListTerritoire().remove(def.getUniteDef().get(i));
				}
				
				//remove tdef
				
			// DEFAITE
			}
			else {
				victoires.add("Défaite au tour "+a);
				if(att.getUniteAtt().get(i).getCout()==1) {
					att.getSoldatListTerritoire().remove(att.getUniteAtt().get(i));
				}
				else if(att.getUniteAtt().get(i).getCout()==3) {
					att.getCavalierListTerritoire().remove(att.getUniteAtt().get(i));
				}
				else {
					att.getCanonListTerritoire().remove(att.getUniteAtt().get(i));
				}
				//remove tatt
			}
			
		}
		if(def.getCanonListTerritoire().size()+def.getCavalierListTerritoire().size()+def.getSoldatListTerritoire().size()==0) {
			victoires.add(def.getNom()+" conquis par "+att.getOccupant().getNom());
			//System.out.println(def.getNom()+" conquis par "+att.getOccupant().getNom() );
			att.getOccupant().getTerritoireListJoueur().add(def);
			def.getOccupant().getTerritoireListJoueur().remove(def);
			def.setOccupant(att.getOccupant());
			// CHANGEMENT D OCCUPANT
			
			// PLACEMENT DES UNITES SURVIVANTES SELON LE TYPE
			
			for(int i=0;i<this.listSurvivant.size();i++) {
				if(this.listSurvivant.get(i).getCout()==1) {
					Soldat soldat = new Soldat();
					soldat.setNbmouv(listSurvivant.get(i).getNbmouv()-1);
					def.getSoldatListTerritoire().add(soldat);
				}
				else if(this.listSurvivant.get(i).getCout()==3) {
					Cavalier cavalier = new Cavalier();
					cavalier.setNbmouv(listSurvivant.get(i).getNbmouv()-1);
					def.getCavalierListTerritoire().add(cavalier);
				}
				else {
					Canon canon = new Canon();
					canon.setNbmouv(listSurvivant.get(i).getNbmouv()-1);
					def.getCanonListTerritoire().add(canon);
				}
			}
	
		}
		JOptionPane jop3;
		//Boîte du message d'information
		jop3 = new JOptionPane();
		jop3.showMessageDialog(null, ""+victoires, "Résultats de l'attaque", JOptionPane.INFORMATION_MESSAGE);

	}
	
	public void combattre(Territoire tATT,Territoire tDEF) {
		choisirDEF(tDEF);
		System.out.println("choisirDEF");
		lancerDe(tDEF.getUniteDef());
		System.out.println("lancerDe");
		trierDEF(tDEF.uniteDef);
		System.out.println("trierDEF");
		lancerDe(tATT.getUniteAtt());
		System.out.println("lancerDe");
		trierATT(tATT);
		System.out.println("trierATT");
		affrontement(tATT,tDEF);
	}
}
