import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

	

public class Combat {
	
	public ArrayList<Unite> uniteDef;
	
	
	public Combat() {
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
		uniteDef.clear();
		uniteDef.addAll(t.getSoldatListTerritoire());
		uniteDef.addAll(t.getCanonListTerritoire());
		uniteDef.addAll(t.getCavalierListTerritoire());	
		Collections.sort(uniteDef, Comparator.comparing(Unite::getDefence));
		
		if(uniteDef.size()>2) {
			for(int i=uniteDef.size()-1;i>1;i--) {
				uniteDef.remove(i);
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
			for(int j =0;j<	i;i++) {
				if(t.getUniteAtt().get(j+1).getPuissance()==t.getUniteAtt().get(j).getPuissance()
						&& t.getUniteAtt().get(j+1).getAttaque()<t.getUniteAtt().get(j).getAttaque()) {
					Collections.swap(t.getUniteAtt(), j+1, j);
				}
			}
		}
	}
	
	public void combattre(Territoire tATT,Territoire tDEF) {
		choisirDEF(tDEF);
		lancerDe(uniteDef);
		trierDEF(uniteDef);
		
		lancerDe(tATT.getUniteAtt());
		trierATT(tATT);
		
		
	}
}
