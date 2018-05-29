import java.util.ArrayList;
import java.util.List;

public class Territoire {
	String nom;
	Territoire voisins[];
	
	public Territoire(String nom, Territoire voisins[]) {
		this.nom = nom;
		this.voisins = voisins;
	}
}