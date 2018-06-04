import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Risk{
  
  public static void main(String[] args) throws IOException{

	//Menu fenetre = new Menu();
	
	  
	Plateau p = new Plateau();
	Joueur.initListJoueurs(3);
	Unite.attribuerArmees();
	Plateau.init();
	Territoire.attribuerTer(Plateau.territoiresList);
	//Plateau.territoiresList.get(0).addCanon(10);
	Map map = new Map();
	
		//Tour à tour
/*	int compt = 0;
	Joueur j = Plateau.joueurList.get(compt);
	while (j.Victoire==false) {
		//actions de chaque joueur
		Unite.renfort(j);
		if (j.soldatListJoueur.size()==0) {//vérifie que le joueur à placer tous ses renforts
			System.out.println("Choississez le territoire de départ");
			System.out.println("Choississez le territoire de destination");
			Territoire.move(Territoire dep, Territoire arr);
			Combat combat = new Combat();
			Combat.combattre(dep, arr);
		}
		if (fintour == true) {
			//passe au joueur suivant
			if (compt>=Plateau.joueurList.size()) {
				compt = 0;
			}
			j = Plateau.joueurList.get(compt++);
		}
	}*/
	  
	  
	  
	
  }
}
