import java.util.ArrayList;
import java.util.Collections;

public class Plateau {

	public static ArrayList<Joueur> joueurList;
	public static ArrayList<Territoire> territoiresList;
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
