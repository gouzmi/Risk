import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
	JLabel joueur = new JLabel("Sélectionnez le nombre de joueur",SwingConstants.CENTER);
	JButton retour = new JButton("Retour");
	JButton j2 = new JButton("2 Joueurs");
	JButton j3 = new JButton("3 Joueurs");
	JButton j4 = new JButton("4 Joueurs");
	JButton j5 = new JButton("5 Joueurs");
	JButton j6 = new JButton("6 Joueurs");
	JTextField t1 = new JTextField("joueur 1");
	JTextField t2 = new JTextField("joueur 2");
	JTextField t3 = new JTextField("joueur 3");
	JTextField t4 = new JTextField("joueur 4");
	JTextField t5 = new JTextField("joueur 5");
	JTextField t6 = new JTextField("joueur 6");
	
       
  public Menu(){
	
	
	this.setSize(l,h);
	this.setTitle("RiskIsep");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    this.setContentPane(panneau());
    
    /*quitter.addActionListener(this);
    jouer.addActionListener(this);
    retour.addActionListener(this);
    j2.addActionListener(this);
    j3.addActionListener(this);
    j4.addActionListener(this);
    j5.addActionListener(this);
    j6.addActionListener(this);
    joueur.setVisible(false);
    j2.setVisible(false);
    j3.setVisible(false);
    j4.setVisible(false);
    j5.setVisible(false);
    j6.setVisible(false);
    retour.setVisible(false);
    t1.setVisible(false);
    t2.setVisible(false);
    t3.setVisible(false);
    t4.setVisible(false);
    t5.setVisible(false);
    t6.setVisible(false);*/
  
    this.setUndecorated(true);
    
    

    this.setVisible(true);
    
    playMusic("Faraway.mp3");
    
  }      
  


/*public class Panneau extends JPanel { 
	

	
	  public void paintComponent(Graphics g){
		  
		  super.paintComponent(g);
		  ImageIcon m = new ImageIcon("images/risk.jpg");
          g.drawImage(m.getImage(), 0, 0,this.getWidth(),this.getHeight(),this);
	      int x = this.getWidth()/2;
	      int y = this.getHeight()/2;	      
         
          this.add(quitter);
          this.add(retour);
          this.add(joueur);
          this.add(j2);
          this.add(j3);
          this.add(j4);
          this.add(j5);
          this.add(j6);
          this.add(t1);
          this.add(t2);
          this.add(t3);
          this.add(t4);
          this.add(t5);
          this.add(t6);
          
          
      	  
          
          jouer.setBounds(x-160, y-35, 150, 70);
          joueur.setBounds(x-175, y-180, 350, 60);
          quitter.setBounds(x+10, y-35, 150, 70);
          retour.setBounds(x+460, y+300, 110, 50);
          j2.setBounds(x-175, y-55, 110, 50);
          j3.setBounds(x-55, y-55, 110, 50);
          j4.setBounds(x+65, y-55, 110, 50);
          j5.setBounds(x-115, y+5, 110, 50);
          j6.setBounds(x+5, y+5, 110, 50);
          t1.setBounds(x-140, y-17, 280, 34);
          t2.setBounds(x-140, y+17+5, 280, 34);
          t3.setBounds(x-140, y+17+2*5+34, 280, 34);
          t4.setBounds(x-140, y+17+3*5+2*34, 280, 34);
          t5.setBounds(x-140, y+17+4*5+3*34, 280, 34);
          t6.setBounds(x-140, y+17+5*5+4*34, 280, 34);
          
          Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
          joueur.setBorder(border);
          joueur.setForeground(Color.WHITE);
          
	  }     
	  
	}*/
	private JPanel panneau() {
		
		menu = new JPanel();
		menu.setLayout(null);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("images/risk.jpg"));
		background.setBounds(0, 0, l, h);
		
		JLabel jouer = new JLabel();
    	jouer.setIcon(new ImageIcon("Images/jouer.png"));
    	jouer.setBounds(x-350, y-77, 300, 144);
    	jouer.addMouseListener(this);
    	background.add(jouer);
    	
    	JLabel quitter = new JLabel();
    	quitter.setIcon(new ImageIcon("Images/quitter.png"));
    	quitter.setBounds(x+50, y-77, 300, 144);
    	quitter.addMouseListener(this);
    	background.add(quitter);
    	
    	menu.add(background);
    	return menu;
		
	}
 

  /*public void actionPerformed(ActionEvent arg0) {
	  if(arg0.getSource() == jouer) {
		  jouer.setVisible(false);
		  quitter.setVisible(false);
		  retour.setVisible(true);
		  j2.setVisible(true);
		  j3.setVisible(true);
		  j4.setVisible(true);
		  j5.setVisible(true);
		  j6.setVisible(true);
		  joueur.setVisible(true);
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
		  joueur.setVisible(false);
		  String J = joueur.getText();
		  if(J=="Inscrivez vos noms") {
			  joueur.setText("Sélectionnez le nombre de joueur");
		  }
	  }
	  
	  if(arg0.getSource() == j2) {
		  j2.setVisible(false);
		  j3.setVisible(false);
		  j4.setVisible(false);
		  j5.setVisible(false);
		  j6.setVisible(false);
		  t1.setVisible(true);
		  t2.setVisible(true);
		  joueur.setText("Inscrivez vos noms");
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
		  joueur.setText("Inscrivez vos noms");
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
		  joueur.setText("Inscrivez vos noms");
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
		  joueur.setText("Inscrivez vos noms");
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
		  joueur.setText("Inscrivez vos noms");
	  }
	  
	  
	}*/
  


public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getSource() == jouer) {
		  jouer.setVisible(false);
		  quitter.setVisible(false);
		  retour.setVisible(true);
		  j2.setVisible(true);
		  j3.setVisible(true);
		  j4.setVisible(true);
		  j5.setVisible(true);
		  j6.setVisible(true);
		  joueur.setVisible(true);
	  }

	if(arg0.getSource() == quitter) {
		  System.exit(0); 
	  }
}



@Override
public void mouseClicked(MouseEvent arg0) {
	if(arg0.getSource() == jouer) {
		  jouer.setVisible(false);
		  quitter.setVisible(false);
		  retour.setVisible(true);
		  j2.setVisible(true);
		  j3.setVisible(true);
		  j4.setVisible(true);
		  j5.setVisible(true);
		  j6.setVisible(true);
		  joueur.setVisible(true);
	  }

	if(arg0.getSource() == quitter) {
		  System.exit(0); 
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
public void mousePressed(MouseEvent arg0) {
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