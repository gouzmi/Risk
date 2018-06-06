import java.awt.Color;
import java.util.ArrayList;

public class Joueur {
	public String nom;
	public int id;
	protected ArrayList<Territoire> territoireListJoueur;
	protected ArrayList<Soldat> soldatListJoueur;
	public static boolean Victoire = false;
	Color color;
	private String mission = new String();
	
	


	public Joueur(int id, String nom, Color color) {
		this.id = id;
		this.nom = nom;
		this.color = color;
		ArrayList<Territoire> territoireListJoueur = new ArrayList<Territoire>();
		this.territoireListJoueur = territoireListJoueur;
		ArrayList<Soldat> soldatListJoueur = new ArrayList<Soldat>();
		this.soldatListJoueur = soldatListJoueur;
		this.Victoire = Victoire;
		
	}
	


	public static void initListJoueurs(int nbJoueur) {
		for (int i =1; i <=nbJoueur; i++) {
			
			Color tabColor[] = {Color.yellow,Color.red,Color.green,Color.blue,Color.black,Color.white};
			Joueur j=new Joueur(i, "joueur"+i, tabColor[i]);	
			Plateau.joueurList.add(j);	
			Color color = tabColor[i-1];
			j.setColor(color);
			System.out.println(Plateau.joueurList.get(i-1).getNom());
			System.out.println(Plateau.joueurList.get(i-1).getColor());
		}
	}
	
	public ArrayList<Territoire> getTerritoireListJoueur() {
		return territoireListJoueur;
	}

	public void setTerritoireListJoueur(ArrayList<Territoire> territoireListJoueur) {
		this.territoireListJoueur = territoireListJoueur;
	}

	public ArrayList<Soldat> getSoldatListJoueur() {
		return soldatListJoueur;
	}

	public void setSoldatListJoueur(ArrayList<Soldat> soldatListJoueur) {
		this.soldatListJoueur = soldatListJoueur;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isVictoire() {
		return Victoire;
	}

	public void setVictoire(boolean victoire) {
		Victoire = victoire;
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
	
	public String getMission() {
		return mission;
	}


	public void setMission(String mission) {
		this.mission = mission;
	}


	public void addTerritoire (Territoire territoire){
		this.territoireListJoueur.add(territoire);	
	}
	
	public void addSoldatJoueur (){
		Soldat soldat = new Soldat(); 
		this.soldatListJoueur.add(soldat);	
	}
	
	public boolean Victoire (Joueur j) {
		if (territoireListJoueur.size()==42) {
			Victoire = true; 
			System.out.println("Victoire de "+j);
			return Victoire;
		}
		return Victoire;
	}
		
	public void defaite (Joueur j) {
		if (territoireListJoueur.size()==0) {
			System.out.println("Défaite de "+j);
		}
	}

	
}
