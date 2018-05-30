import java.util.ArrayList;
import java.util.Collections;

public class Plateau {

	public static ArrayList<Joueur> joueurList;
	public static ArrayList<Territoire> territoiresList;
	
	/*static Territoire voisin[] = new Territoire[2];
	static Territoire Alaska = new Territoire("Alaska",voisin);
	static Territoire NorthwestTerritory = new Territoire("NorthwestTerritory",voisin);
	static Territoire Alberta = new Territoire("Alberta",voisin);
	static Territoire Ontario = new Territoire("Ontario",voisin);
	static Territoire Greenland = new Territoire("Greenland",voisin);
	territoiresList.add(Alaska);
		territoiresList.add(NorthwestTerritory);
		territoiresList.add(Alberta);
		territoiresList.add(Ontario);*/
	
	public Plateau() {

		ArrayList<Joueur> jList = new ArrayList<Joueur>();
		ArrayList<Territoire> tList = new ArrayList<Territoire>();
		this.joueurList = jList;
		this.territoiresList = tList;
	}
	
public static void attribuerTer() {
		
		
		int j = 0; 
		Collections.shuffle(territoiresList); // mélange liste Territoires
		for (Territoire t : territoiresList){
			if (j==joueurList.size()-1){
				j=0;
			}
			joueurList.get(j).territoireListJoueur.add(t);
			territoiresList.remove(t);
			j++;
		}
		
	}
}
