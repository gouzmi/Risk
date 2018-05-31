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
	Joueur.initListJoueurs(2);
	Plateau.init();
	Territoire.attribuerTer(Plateau.territoiresList);

	Map map = new Map();
	

	  
	  
	  
	
  }
}
