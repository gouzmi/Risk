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
	//Map map = new Map();

	
	  
	  Plateau p = new Plateau();
	  Joueur.initListJoueurs(3);
	  

	 Territoire voisin[] = new Territoire[2];	
	 Territoire France = new Territoire("France",voisin);
	 Territoire Italie = new Territoire("Italie",voisin);
	 Territoire Espagne = new Territoire("Espagne",voisin);
	  Plateau.territoiresList.add(France);
	  Plateau.territoiresList.add(Italie);
	  Plateau.territoiresList.add(Espagne);
	  //Plateau.joueurList.get(0).territoireListJoueur.add(France);
	  //Plateau.territoiresList.remove(France);
	 Plateau.attribuerTer();
	  
	  
	  
	  
	
  }
}
