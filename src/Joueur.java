import java.util.ArrayList;

public class Joueur {
	public String nom;
	public int id;
	public static ArrayList<Joueur> joueurList;
	protected ArrayList<Territoire> territoireList;
	
	public Joueur(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	public static void initListJoueurs(int nbJoueur) {
		for (int i = 1; i <= nbJoueur; i++) {
			
			joueurList.add(new Joueur(i, "joueur"+i));
			
			System.out.println(joueurList.get(i));
		}
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static ArrayList<Joueur> getJoueurList() {
		return joueurList;
	}

	public static void setJoueurList(ArrayList<Joueur> joueurList) {
		Joueur.joueurList = joueurList;
	}

	public ArrayList<Territoire> getTerritoireList() {
		return territoireList;
	}

	public void setTerritoireList(ArrayList<Territoire> territoireList) {
		this.territoireList = territoireList;
	}

	public void addTerritoire (Territoire territoire){
		this.territoireList.add(territoire);
	}
}
