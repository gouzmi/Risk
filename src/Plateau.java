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
	
	public static void init() {
		Territoire voisin[] = new Territoire[2];
		Territoire Alaska = new Territoire("Alaska",voisin);
		Territoire NorthwestTerritory = new Territoire("NorthwestTerritory",voisin);
		 Territoire Alberta = new Territoire("Alberta",voisin);
		 Territoire Ontario = new Territoire("Ontario",voisin);
		 Territoire Greenland = new Territoire("Greenland",voisin);
		//territoiresList.add(Alaska);
		territoiresList.add(NorthwestTerritory);
		territoiresList.add(Alberta);
		territoiresList.add(Ontario);
	}
	

}
