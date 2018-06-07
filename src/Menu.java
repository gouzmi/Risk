import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javazoom.jl.decoder.*;
import javazoom.jl.player.Player;
import java.awt.Toolkit;


public class Menu extends JFrame implements MouseListener{
	
	Dimension p= Toolkit.getDefaultToolkit().getScreenSize();
	int l = p.width;
	int h = p.height;
	int x = l/2;
	int y = h/2;
	
	private JPanel menu;
	private JLabel background;
	private JLabel jouer;
	private JLabel quitter;
	private JLabel select;
	private JLabel retour;
	private JLabel lancer;
	private JLabel j2;
	private JLabel j3;
	private JLabel j4;
	private JLabel j5;
	private JLabel j6;
	JTextField t1 = new JTextField("joueur 1");
	JTextField t2 = new JTextField("joueur 2");
	JTextField t3 = new JTextField("joueur 3");
	JTextField t4 = new JTextField("joueur 4");
	JTextField t5 = new JTextField("joueur 5");
	JTextField t6 = new JTextField("joueur 6");
	int nbjoueur;

	
       
  public Menu(){
	
	
	this.setSize(l,h);
	this.setTitle("RiskIsep");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null); 
    this.add(panneau());
    
    
    select.setVisible(false);
    j2.setVisible(false);
    j3.setVisible(false);
    j4.setVisible(false);
    j5.setVisible(false);
    j6.setVisible(false);
    retour.setVisible(false);
    lancer.setVisible(false);
    t1.setVisible(false);
    t2.setVisible(false);
    t3.setVisible(false);
    t4.setVisible(false);
    t5.setVisible(false);
    t6.setVisible(false);
  
    this.setUndecorated(true);
    this.setVisible(true);
    playMusic("Faraway.mp3");
    
  }      

  	public class fond extends JPanel{
  		public void paintComponent(Graphics g) {
  			super.paintComponent(g);
  			ImageIcon y = new ImageIcon("images/risk.jpg");
			g.drawImage(y.getImage(), 0, 0,l,h,this);
  		}
  	}
  
	private JPanel panneau() {
		

		fond fond = new fond();
	    this.add(fond);
	    fond.setLayout(null);
		
		jouer = new JLabel();
    	jouer.setIcon(new ImageIcon("Images/jouer.png"));
    	jouer.setBounds(x-350, y-77, 300, 144);
    	jouer.addMouseListener(this);
    	fond.add(jouer);
    	
    	quitter = new JLabel();
    	quitter.setIcon(new ImageIcon("Images/quitter.png"));
    	quitter.setBounds(x+50, y-77, 300, 144);
    	quitter.addMouseListener(this);
    	fond.add(quitter);
    	
    	select = new JLabel();
    	select.setIcon(new ImageIcon("Images/select.png"));
    	select.setBounds(x-411, y-250-140, 823, 140);
    	select.addMouseListener(this);
    	fond.add(select);
    	
    	retour = new JLabel();
    	retour.setIcon(new ImageIcon("Images/retour.png"));
    	retour.setBounds(x+300, y+300, 300, 144);
    	retour.addMouseListener(this);
    	fond.add(retour);
    	
    	lancer = new JLabel();
    	lancer.setIcon(new ImageIcon("Images/lancer.png"));
    	lancer.setBounds(x-600, y+300, 300, 144);
    	lancer.addMouseListener(this);
    	fond.add(lancer);
    	
    	j2 = new JLabel();
    	j2.setIcon(new ImageIcon("Images/2.png"));
    	j2.setBounds(x-163-81-81, y-144-10, 163, 144);
    	j2.addMouseListener(this);
    	fond.add(j2);
    	j3 = new JLabel();
    	j3.setIcon(new ImageIcon("Images/3.png"));
    	j3.setBounds(x-81, y-144-10, 163, 144);
    	j3.addMouseListener(this);
    	fond.add(j3);
    	j4 = new JLabel();
    	j4.setIcon(new ImageIcon("Images/4.png"));
    	j4.setBounds(x+82+81, y-144-10, 163, 144);
    	j4.addMouseListener(this);
    	fond.add(j4);
    	j5 = new JLabel();
    	j5.setIcon(new ImageIcon("Images/5.png"));
    	j5.setBounds(x-163-42, y+10, 163, 144);
    	j5.addMouseListener(this);
    	fond.add(j5);
    	j6 = new JLabel();
    	j6.setIcon(new ImageIcon("Images/6.png"));
    	j6.setBounds(x+41, y+10, 163, 144);
    	j6.addMouseListener(this);
    	fond.add(j6);
    	
    	
    	t1.setBounds(x-140, y-17, 280, 34);
        t2.setBounds(x-140, y+17+5, 280, 34);
        t3.setBounds(x-140, y+17+2*5+34, 280, 34);
        t4.setBounds(x-140, y+17+3*5+2*34, 280, 34);
        t5.setBounds(x-140, y+17+4*5+3*34, 280, 34);
        t6.setBounds(x-140, y+17+5*5+4*34, 280, 34);
        fond.add(t1);
        fond.add(t2);
        fond.add(t3);
        fond.add(t4);
        fond.add(t5);
        fond.add(t6);
    	
    	
    	return fond;
		
	}
 

public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub

}



@Override
public void mousePressed(MouseEvent arg0) {
	if(arg0.getSource() == jouer) {
		  jouer.setVisible(false);
		  quitter.setVisible(false);
		  retour.setVisible(true);
		  j2.setVisible(true);
		  j3.setVisible(true);
		  j4.setVisible(true);
		  j5.setVisible(true);
		  j6.setVisible(true);
		  select.setVisible(true);
	  }

	if(arg0.getSource() == quitter) {
		  System.exit(0); 
	  }
	
	if(arg0.getSource() == retour) {
		  jouer.setVisible(true);
		  quitter.setVisible(true);
		  retour.setVisible(false);
		  j2.setVisible(false);
		  j3.setVisible(false);
		  j4.setVisible(false);
		  j5.setVisible(false);
		  j6.setVisible(false);
		  t1.setVisible(false);
		  t2.setVisible(false);
		  t3.setVisible(false);
		  t4.setVisible(false);
		  t5.setVisible(false);
		  t6.setVisible(false);
		  lancer.setVisible(false);
		  select.setVisible(false);
		  select.setIcon(new ImageIcon("images/select.png"));
	  }
	
	if(arg0.getSource() == j2) {
		  j2.setVisible(false);
		  j3.setVisible(false);
		  j4.setVisible(false);
		  j5.setVisible(false);
		  j6.setVisible(false);
		  t1.setVisible(true);
		  t2.setVisible(true);
		  lancer.setVisible(true);
		  select.setIcon(new ImageIcon("images/noms.png"));
		  nbjoueur=2;
	  }
	  
	  if(arg0.getSource() == j3) {
		  j2.setVisible(false);
		  j3.setVisible(false);
		  j4.setVisible(false);
		  j5.setVisible(false);
		  j6.setVisible(false);
		  t1.setVisible(true);
		  t2.setVisible(true);
		  t3.setVisible(true);
		  lancer.setVisible(true);
		  select.setIcon(new ImageIcon("images/noms.png"));
		  nbjoueur=3;
	  }
	  
	  if(arg0.getSource() == j4) {
		  j2.setVisible(false);
		  j3.setVisible(false);
		  j4.setVisible(false);
		  j5.setVisible(false);
		  j6.setVisible(false);
		  t1.setVisible(true);
		  t2.setVisible(true);
		  t3.setVisible(true);
		  t4.setVisible(true);
		  lancer.setVisible(true);
		  select.setIcon(new ImageIcon("images/noms.png"));
		  nbjoueur=4;
	  }
	  
	  if(arg0.getSource() == j5) {
		  j2.setVisible(false);
		  j3.setVisible(false);
		  j4.setVisible(false);
		  j5.setVisible(false);
		  j6.setVisible(false);
		  t1.setVisible(true);
		  t2.setVisible(true);
		  t3.setVisible(true);
		  t4.setVisible(true);
		  t5.setVisible(true);
		  lancer.setVisible(true);
		  select.setIcon(new ImageIcon("images/noms.png"));
		  nbjoueur=5;
	  }
	  
	  if(arg0.getSource() == j6) {
		  j2.setVisible(false);
		  j3.setVisible(false);
		  j4.setVisible(false);
		  j5.setVisible(false);
		  j6.setVisible(false);
		  t1.setVisible(true);
		  t2.setVisible(true);
		  t3.setVisible(true);
		  t4.setVisible(true);
		  t5.setVisible(true);
		  t6.setVisible(true);
		  lancer.setVisible(true);
		  select.setIcon(new ImageIcon("images/noms.png"));
		  nbjoueur=6;
		 
	  }
	  
	  if(arg0.getSource() == lancer) {
		  
		  	ArrayList<Joueur> JJ = new ArrayList<Joueur>();
			Color tabColor[] = {Color.yellow,Color.red,Color.green,Color.blue,Color.black,Color.white};
			String listNom[] = {t1.getText(),t2.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText()};
		    for (int i=0; i<nbjoueur; i++) {
		    	Joueur j = new Joueur(i, listNom[i], tabColor[i]);
		    	JJ.add(j);
		    }
		
		    Plateau p = new Plateau(JJ);
			//Joueur.initListJoueurs(nbjoueur);
			Unite.attribuerArmees();
			p.init();
			Territoire.attribuerTer(p.territoiresList);
			//Plateau.territoiresList.get(0).addCanon(10);
			Map map = new Map();
			this.dispose();
			
	  }
}

	


@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}



@Override
public void mouseExited(MouseEvent arg0) {
	
}



@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}



@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

public static void playMusic(String filepath) {
	  
	  try {
		  FileInputStream fileInputStream = new FileInputStream(filepath);
		  Player player = new Player(fileInputStream);
		  player.play();
	  }
	  catch(FileNotFoundException e){
	  }
	  catch(JavaLayerException e) {
		  
	  }
}
 
}
