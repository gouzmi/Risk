import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Toolkit;



public class Map extends JFrame{
	
	Dimension p= Toolkit.getDefaultToolkit().getScreenSize();
	int l = p.width;
	int h = p.height;
	int joueurAct = 0;
	//int l = 1366;
	//int h = 915;
			
	//float cl = 1f;
	//float ch= 1f;
	float cl = 0.8f;
	float ch= 0.8f;
	float pl = (l*cl)/1366;
	float ph = (h*ch)/915;
	private JLabel exit;
	JLabel territoireAct;
	JLabel soldatAct;
	JLabel cavalierAct;
	JLabel canonAct;
	JLabel vterritoireAct;
	JLabel vsoldatAct;
	JLabel vcavalierAct;
	JLabel vcanonAct;
	JLabel j1;
	JLabel j2;
	JLabel j3;
	JLabel j4;
	JLabel j5;
	JLabel j6;
	JLabel suivant;
	JLabel renfort;
	JLabel refresh;
	JLabel nbTer;
	JLabel renfortAct;
	JLabel nbTerAct;
	JLabel soldat;
	JLabel cavalier;
	JLabel canon;
	
	JLabel plus1;
	JLabel plus2;
	JLabel plus3;
	JLabel moins1;
	JLabel moins2;
	JLabel moins3;
	
	JLabel nbSoldat;
	JLabel nbCavalier;
	JLabel nbCanon;
	int nbS = 0;
	int nbCav=0;
	int nbCan=0;
	JLabel placer;
	JLabel move;
	JLabel mission;
	JLabel instruction;
	
	JLabel terdep;
	JLabel terarr;
	Territoire TerritoireA;
	Territoire TerritoireD;
	
	
	boolean premierTour = true;
	
	
	public Map() {
		
		this.setSize(l,h);
		this.setLayout(null);
		//this.setSize(l,h);
		this.setTitle("RiskIsep");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setUndecorated(true);	 
	    
	    // PANEL CARTE
	    
	    Background map = new Background();
	    this.add(map);
	    map.setSize((int) (cl*l),(int) (ch*h));
		map.add(exit);
		
		//PANEL DE DROITE
		
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(null);
		Color fondr = Color.decode("#e5b886");
		rightPanel.setBackground( fondr );
		territoireAct = new JLabel("Territoire",SwingConstants.CENTER);
		soldatAct = new JLabel("Soldat",SwingConstants.CENTER);
		cavalierAct = new JLabel("Cavalier",SwingConstants.CENTER);
		canonAct = new JLabel("Canon",SwingConstants.CENTER);
		vterritoireAct = new JLabel("Territoire",SwingConstants.CENTER);
		vsoldatAct = new JLabel("Soldat",SwingConstants.CENTER);
		vcavalierAct = new JLabel("Cavalier",SwingConstants.CENTER);
		vcanonAct = new JLabel("Canon",SwingConstants.CENTER);
		Font font = new Font("Arial",Font.BOLD,25);
		territoireAct.setFont(font);
		soldatAct.setFont(font);
		cavalierAct.setFont(font);
		canonAct.setFont(font);
		vterritoireAct.setFont(font);
		vsoldatAct.setFont(font);
		vcavalierAct.setFont(font);
		vcanonAct.setFont(font);
		territoireAct.setBounds(0, 0, (int)(0.5*(l-(cl*l))), 80);
		soldatAct.setBounds(0, 80, (int)(0.5*(l-(cl*l))), 80);
		cavalierAct.setBounds(0, 160, (int)(0.5*(l-(cl*l))), 80);
		canonAct.setBounds(0, 240, (int)(0.5*(l-(cl*l))), 80);
		vterritoireAct.setFont(font);
		vsoldatAct.setFont(font);
		vcavalierAct.setFont(font);
		vcanonAct.setFont(font);
		vterritoireAct.setBounds((int)(0.5*(l-(cl*l))), 0, (int)(0.5*(l-(cl*l))), 80);
		vsoldatAct.setBounds((int)(0.5*(l-(cl*l))), 80, (int)(0.5*(l-(cl*l))), 80);
		vcavalierAct.setBounds((int)(0.5*(l-(cl*l))), 160, (int)(0.5*(l-(cl*l))), 80);
		vcanonAct.setBounds((int)(0.5*(l-(cl*l))), 240, (int)(0.5*(l-(cl*l))), 80);
		rightPanel.add(territoireAct);
		rightPanel.add(soldatAct);
		rightPanel.add(cavalierAct);
		rightPanel.add(canonAct);
		rightPanel.add(vterritoireAct);
		rightPanel.add(vsoldatAct);
		rightPanel.add(vcavalierAct);
		rightPanel.add(vcanonAct);
		suivant = new JLabel();
		suivant.setIcon(new ImageIcon("images/suivant.png"));
		suivant.setBounds((int)(0.95*(l-cl*l)-149), (int) (ch*h+40), 149, 117);
		suivant.addMouseListener(m);
		refresh = new JLabel();
		refresh.setIcon(new ImageIcon("images/refresh.png"));
		refresh.setBounds((int)(0.05*(l-cl*l)), (int) (ch*h+40), 150, 113);
		refresh.addMouseListener(m);
		rightPanel.add(suivant);
		rightPanel.add(refresh);
		
		
		soldat = new JLabel();
    	soldat.setIcon(new ImageIcon("Images/soldat.png"));
    	soldat.setBounds(10, 320, 100, 80);
    	rightPanel.add(soldat);
    	cavalier = new JLabel();
    	cavalier.setIcon(new ImageIcon("Images/cavalier.png"));
    	cavalier.setBounds(10, 400, 100, 80);
    	rightPanel.add(cavalier);
    	canon = new JLabel(); 
    	canon.setIcon(new ImageIcon("Images/canon.png"));
    	canon.setBounds(10, 480, 100, 80);
    	rightPanel.add(canon);
    	
    	plus1 = new JLabel(); 
    	plus1.setIcon(new ImageIcon("Images/plus.png"));
    	plus1.setBounds(100+40, 320+35, 35, 35);
    	rightPanel.add(plus1);
    	plus2 = new JLabel(); 
    	plus2.setIcon(new ImageIcon("Images/plus.png"));
    	plus2.setBounds(100+40, 400+35, 35, 35);
    	rightPanel.add(plus2);
    	plus3 = new JLabel(); 
    	plus3.setIcon(new ImageIcon("Images/plus.png"));
    	plus3.setBounds(100+40, 480+35, 35, 35);
    	rightPanel.add(plus3);
    	
    	moins1 = new JLabel(); 
    	moins1.setIcon(new ImageIcon("Images/moins.png"));
    	moins1.setBounds(200+40, 320+35, 35, 35);
    	rightPanel.add(moins1);
    	moins2 = new JLabel(); 
    	moins2.setIcon(new ImageIcon("Images/moins.png"));
    	moins2.setBounds(200+40, 400+35, 35, 35);
    	rightPanel.add(moins2);
    	moins3 = new JLabel(); 
    	moins3.setIcon(new ImageIcon("Images/moins.png"));
    	moins3.setBounds(200+40, 480+35, 35, 35);
    	rightPanel.add(moins3);
    	plus1.addMouseListener(m);
    	plus2.addMouseListener(m);
    	plus3.addMouseListener(m);
    	moins1.addMouseListener(m);
    	moins2.addMouseListener(m);
    	moins3.addMouseListener(m);
    	
    	
    	nbSoldat = new JLabel(Integer.toString(0),SwingConstants.CENTER);
    	nbSoldat.setFont(font);
    	nbSoldat.setBounds(208-25, 320+35, 50, 35);
		rightPanel.add(nbSoldat);
		nbCavalier = new JLabel(Integer.toString(0),SwingConstants.CENTER);
		nbCavalier.setFont(font);
		nbCavalier.setBounds(208-25, 400+35, 50, 35);
		rightPanel.add(nbCavalier);
		nbCanon = new JLabel(Integer.toString(0),SwingConstants.CENTER);
		nbCanon.setFont(font);
		nbCanon.setBounds(208-25, 480+35, 50, 35);
		rightPanel.add(nbCanon);
		
    	placer = new JLabel();
    	placer.setIcon(new ImageIcon("images/renfort.png"));
    	placer.setBounds(15, 670, 150, 72);
    	placer.addMouseListener(m);
		rightPanel.add(placer);
		
		move = new JLabel();
    	move.setIcon(new ImageIcon("images/move.png"));
    	move.setBounds((int)((((l-cl*l))/2)+15), 670, 150, 72);
    	move.addMouseListener(m);
		rightPanel.add(move);
		
		terdep = new JLabel("Territoires dÃ©part",SwingConstants.CENTER);
		terdep.setFont(font);
		terdep.setBounds((int)(0.1*(l-cl*l)), 570, (int)(0.8*(l-(cl*l))), 80);
		rightPanel.add(terdep);
		
		terarr = new JLabel("Territoires d'arrivÃ©e",SwingConstants.CENTER);
		terarr.setFont(font);
		terarr.setBounds((int)(0.1*(l-cl*l)),762,(int)(0.8*(l-(cl*l))), 80);
		rightPanel.add(terarr);
		
		

		this.add(rightPanel);
		
		// PANEL DU BAS
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(null);
		Color fondl = Color.decode("#e5b886");
		downPanel.setBackground( fondl );
		
		Font fontjoueur = new Font("Arial",Font.BOLD,25);
		j1 = new JLabel("" + Plateau.joueurList.get(0).getNom(),SwingConstants.CENTER);
		j1.setFont(fontjoueur);	
		j1.setBounds(0, 0, (int) (0.17*cl*l), (int)(0.33*(h-ch*h)));
		j1.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5)); 
		j2 = new JLabel("" + Plateau.joueurList.get(1).getNom(),SwingConstants.CENTER);
		j2.setFont(fontjoueur);
		j2.setBounds(0, (int)(0.33*(h-ch*h)), (int) (0.17*cl*l), (int)(0.33*(h-ch*h)));
		downPanel.add(j1);
		downPanel.add(j2);
		
		for(int i = 2; i<=Plateau.joueurList.size(); i++) {
			if(i == 3) {
				j3 = new JLabel("" + Plateau.joueurList.get(i-1).getNom(),SwingConstants.CENTER);
				j3.setFont(fontjoueur);
				j3.setBounds(0, (int)(2*0.33*(h-ch*h)), (int) (0.17*cl*l), (int)(0.33*(h-ch*h)));
				downPanel.add(j3);
			} else if(i == 4) {
				j4 = new JLabel("" + Plateau.joueurList.get(i-1).getNom(),SwingConstants.CENTER);
				j4.setFont(fontjoueur);
				j4.setBounds((int) (0.17*cl*l), 0, (int) (0.17*cl*l), (int)(0.33*(h-ch*h)));
				downPanel.add(j4);
			} else if(i == 5){
				j5 = new JLabel("" + Plateau.joueurList.get(i-1).getNom(),SwingConstants.CENTER);
				j5.setFont(fontjoueur);
				j5.setBounds((int) (0.17*cl*l), (int)(0.33*(h-ch*h)), (int) (0.17*cl*l), (int)(0.33*(h-ch*h)));
				downPanel.add(j5);
			} else if(i == 6) {
				j6 = new JLabel("" + Plateau.joueurList.get(i-1).getNom(),SwingConstants.CENTER);
				j6.setFont(fontjoueur);
				j6.setBounds((int) (0.17*cl*l), (int)(2*0.33*(h-ch*h)), (int) (0.17*cl*l), (int)(0.33*(h-ch*h)));
				downPanel.add(j6);
			}
		}		
		
		renfort = new JLabel("Renforts :");
		nbTer = new JLabel("Territoires :");
		renfortAct = new JLabel(Integer.toString(Plateau.joueurList.get(0).getSoldatListJoueur().size()));
		nbTerAct = new JLabel(Integer.toString(Plateau.joueurList.get(0).getTerritoireListJoueur().size()));
		Font fontclass = new Font("Arial",Font.BOLD,30);
		renfort.setFont(fontclass);
		nbTer.setFont(fontclass);
		renfortAct.setFont(fontclass);
		nbTerAct.setFont(fontclass);
		renfort.setBounds((int) (2.3*0.17*cl*l), 30, (int) (0.17*cl*l), (int)(0.33*(h-ch*h)));
		nbTer.setBounds((int) (2.3*0.17*cl*l), (int)(0.33*(h-ch*h)+30), (int) (0.17*cl*l), (int)(0.33*(h-ch*h)));
		renfortAct.setBounds((int) (3.1*0.17*cl*l), 30, 50, (int)(0.33*(h-ch*h)));
		nbTerAct.setBounds((int) (3.1*0.17*cl*l), (int)(0.33*(h-ch*h)+30), 50, (int)(0.33*(h-ch*h)));
		downPanel.add(renfort);
		downPanel.add(nbTer);
		downPanel.add(renfortAct);
		downPanel.add(nbTerAct);
		
		Font fonj = new Font("Arial",Font.BOLD,30);
		mission = new JLabel();
		mission.setIcon(new ImageIcon("images/petitbouton.png"));
		mission.setBounds((int) (4*0.17*cl*l), (int)(0.2*(h-ch*h)), 150, 72);
		mission.addMouseListener(m);
		
		downPanel.add(mission);
		instruction = new JLabel();
		instruction.setText("Placer les renforts");
		instruction.setBounds((int) (3.8*0.17*cl*l), (int)(0.6*(h-ch*h)), 300, (int)(0.33*(h-ch*h)));
		instruction.addMouseListener(m);
		instruction.setFont(fonj);
		downPanel.add(instruction);
		
	
		this.add(downPanel);
		rightPanel.setBounds((int) (cl*l), 0, l-(int) (cl*l), h);
		downPanel.setBounds(0, (int) (ch*h),(int) (cl*l), h-(int) (ch*h));
		
		
			//voir actualiserRA
			move.setVisible(false);
			placer.setVisible(true);
			suivant.setVisible(false);
		
	    this.setVisible(true);
	}
	
	
	
	MouseListener m = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
			
			if (e.getSource() == suivant && Plateau.joueurList.get(joueurAct).getSoldatListJoueur().size()==0) {

				
				
				Unite.renfort(Plateau.joueurList.get(joueurAct));

				/*if (Plateau.getMission().Victoire(Plateau.joueurList.get(joueurAct), Plateau.joueurList) ==true) {
					JOptionPane jop2;
					//Boîte du message de victoire
					jop2 = new JOptionPane();
					ImageIcon img = new ImageIcon("images/pistolet.png");
					jop2.showMessageDialog(null, ""+Plateau.joueurList.get(joueurAct)+", tu as Gagné !!!", "Fin du jeu", JOptionPane.INFORMATION_MESSAGE, img);
				}*/

				joueurAct++;
				nbS=0;
				nbSoldat.setText(Integer.toString(nbS));
				nbCav=0;
				nbCan=0;
				nbCanon.setText(Integer.toString(nbCan));
				nbCavalier.setText(Integer.toString(nbCav));
				
				
				if (joueurAct >= Plateau.joueurList.size()) {
					joueurAct = 0;
					premierTour = false;
				}
				renfortAct.setText(Integer.toString(Plateau.joueurList.get(joueurAct).getSoldatListJoueur().size()));
				nbTerAct.setText(Integer.toString(Plateau.joueurList.get(joueurAct).getTerritoireListJoueur() .size()));
				actualiserRA();
				if (joueurAct == 0) {
					j1.setBorder(BorderFactory.createLineBorder( Plateau.joueurList.get(joueurAct).getColor(), 5));
					if (Plateau.joueurList.size()==2) {
						j2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
					}
					else if (Plateau.joueurList.size()==3) {
						j3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
					}
					else if (Plateau.joueurList.size()==4) {
						j4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
					}
					else if (Plateau.joueurList.size()==5) {
						j5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
					}
					else if (Plateau.joueurList.size()==6) {
						j6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
					}
				}
				if (joueurAct == 1) {
					j2.setBorder(BorderFactory.createLineBorder( Plateau.joueurList.get(joueurAct).getColor(), 5));
					j1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
					
				}

				if (joueurAct == 2) {
					j3.setBorder(BorderFactory.createLineBorder( Plateau.joueurList.get(joueurAct).getColor(), 5));
					j2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
				}

				if (joueurAct == 3) {
					j4.setBorder(BorderFactory.createLineBorder( Plateau.joueurList.get(joueurAct).getColor(), 5));
					j3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
				}

				if (joueurAct == 4) {
					j5.setBorder(BorderFactory.createLineBorder( Plateau.joueurList.get(joueurAct).getColor(), 5));
					j4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
				}
				if (joueurAct == 5) {
					j6.setBorder(BorderFactory.createLineBorder( Plateau.joueurList.get(joueurAct).getColor(), 5));
					j5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
				}
			}
			
			
			if(e.getSource()==refresh) {
				TerritoireD = null;
				TerritoireA = null;
				terdep.setText("Territoires dÃ©part");
				terarr.setText("Territoires d'arrivÃ©e");
			}
			
			if (e.getSource()==mission) {
				JOptionPane jop1;
				 
				//BoÃ®te du message d'information
				jop1 = new JOptionPane();
				jop1.showMessageDialog(null, ""+Plateau.joueurList.get(joueurAct).getMission(), "Mission", JOptionPane.INFORMATION_MESSAGE);

			}
			
			if(e.getSource()==plus1) {
				nbS++;
				nbSoldat.setText(Integer.toString(nbS));
			}
			if(e.getSource()==moins1) {
				nbS--;
				nbSoldat.setText(Integer.toString(nbS));
			}
			if(e.getSource()==plus2) {
				nbCav++;
				nbCavalier.setText(Integer.toString(nbCav));
			}
			if(e.getSource()==moins2) {
				nbCav--;
				nbCavalier.setText(Integer.toString(nbCav));
			}
			if(e.getSource()==plus3) {
				nbCan++;
				nbCanon.setText(Integer.toString(nbCan));
			}
			if(e.getSource()==moins3) {
				nbCan--;
				nbCanon.setText(Integer.toString(nbCan));
			}
			
			if(e.getSource()==placer) {
				if(TerritoireD.getOccupant() == Plateau.joueurList.get(joueurAct)) {
					if(TerritoireD.getOccupant().getSoldatListJoueur().size()>=(nbS+nbCav+nbCan)) {
						TerritoireD.addSoldat(nbS);
						nbS=0;
						TerritoireD.addCavalier(nbCav);
						nbCav=0;
						TerritoireD.addCanon(nbCan);
						nbCan=0;
						actualiserNb();
						actualiserRA();
						actualiserTerRen();	
						System.out.println("joueur ="+joueurAct);
						System.out.println(Plateau.joueurList.get(joueurAct).getSoldatListJoueur().size());
					}
					else {
						JOptionPane jop2;
						jop2 = new JOptionPane();
						jop2.showMessageDialog(null, "Vous n'avez pas assez de renforts !", "Attention", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
				else {
					JOptionPane jop2;
					jop2 = new JOptionPane();
					jop2.showMessageDialog(null, "Ce territoire n'est pas à vous !", "Attention", JOptionPane.INFORMATION_MESSAGE);
					System.out.println();
				}
				
			}
			if(e.getSource()==move) {
				Unite.beforeMove(TerritoireD, nbS,nbCav, nbCan);
				Unite.move(TerritoireD, TerritoireA);
				nbS=0;
				nbCav=0;
				nbCan=0;
				actualiserNb();
				actualiserRA();
				actualiserTerRen();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

	};
	
	public void actualiserRA() {
		if(Plateau.joueurList.get(joueurAct).getSoldatListJoueur().size()!=0) {
			instruction.setText("Placer les renforts");
			move.setVisible(false);
			placer.setVisible(true);
			suivant.setVisible(false);
		}
		else {
			
			if(premierTour==false) {
				move.setVisible(true);
				instruction.setText("Attaquez/ d�placez");
			}
			placer.setVisible(false);
			suivant.setVisible(true);
		}
	}
	
	public void actualiserNb() {
		nbSoldat.setText(Integer.toString(nbS));
		nbCavalier.setText(Integer.toString(nbCav));
		nbCanon.setText(Integer.toString(nbCan));
	}
	
	public void actualiserTerRen(){
		renfortAct.setText(Integer.toString(Plateau.joueurList.get(joueurAct).getSoldatListJoueur().size()));
		nbTerAct.setText(Integer.toString(Plateau.joueurList.get(joueurAct).getTerritoireListJoueur().size()));
	}
	
	public class Background extends JPanel implements MouseListener, MouseMotionListener{ 
		
		
		ArrayList<BufferedImage> imageList = new ArrayList<BufferedImage>(); // 
		ArrayList<ImageIcon> imageNom = new ArrayList<ImageIcon>(); // 
		ArrayList<BufferedImage> imageList_highlight = new ArrayList<BufferedImage>(); // 
		ArrayList<BufferedImage> imageToDraw = new ArrayList<BufferedImage>(); // 
		int currentHighLight; //
		
		
		
		  public void paintComponent(Graphics g){ 
			  
			  Color fond = Color.decode("#e5b886");
			  this.setBackground( fond );
			  super.paintComponent(g);
				for (BufferedImage each : imageToDraw) 
				{
					g.drawImage(each, 0, 0,(int) (cl*l),(int) (ch*h), this);}
				ImageIcon y = new ImageIcon("images/map1.png");
				g.drawImage(y.getImage(), 0, 0,(int) (cl*l),(int) (ch*h),this);
				
				for(Territoire each:Plateau.territoiresList) {
					g.setColor(each.getOccupant().getColor());
					g.fillOval((int)(pl*each.getX()), (int)(ph*each.getY()), 25, 25);
					g.setColor(Color.BLACK);
					g.drawOval((int)(pl*each.getX())-1, (int)(ph*each.getY())-1, 25+2, 25+2);
					this.repaint();
				}
		  	}

		  	public Background() {
		  		this.setLayout(null);
				this.addMouseListener(this);
				
				this.addMouseMotionListener(this);
				exit = new JLabel();
			    exit.setIcon(new ImageIcon("images/exit.png"));
				exit.setBounds(0, 0, 80, 70);
				exit.addMouseListener(this);
				try 
				{
						String [] listenormal; 
						String [] listehighlight; 
	
						int i;
						String normalpath = "images/normal";
						listenormal = new File(normalpath).list(); 
						for(i=0;i<listenormal.length;i++){
							imageList.add(ImageIO.read(new File(normalpath+"/"+listenormal[i])));
							imageNom.add(new ImageIcon(normalpath+"/"+listenormal[i]));
							imageToDraw.add(ImageIO.read(new File(normalpath+"/"+listenormal[i])));
							
						}
						String highpath = "images/highlight";
						listehighlight = new File(highpath).list();
						for(i=0;i<listenormal.length;i++){
							imageList_highlight.add(ImageIO.read(new File(highpath+"/"+listehighlight[i])));
						}
						
					
					
					
				} 
				catch (IOException e) 
				{
					
					e.printStackTrace();
				}
		  	}
		  	
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {

			int ix = (int)((1/pl)*e.getX());
			int iy = (int)((1/ph)*e.getY());
			/*System.out.println(ix);
			System.out.println(iy);
			System.out.println("-----");
			System.out.println(e.getX());
			System.out.println(e.getY());*/
			int index = 0; 
			for (BufferedImage each : imageList) 
			{
				index++;
				int alpha = (each.getRGB(ix, iy) >> 24) & 0xff;
				if (alpha != 0) 
				{
					
					if (currentHighLight != 0) 
					{
						imageToDraw.set(currentHighLight - 1,
								imageList.get(currentHighLight - 1));
					}
					
					currentHighLight = index;
					imageToDraw.set(index - 1, imageList_highlight.get(index - 1));
					
					repaint();
					ImageIcon img = imageNom.get(index-1);
					String source = img.getDescription();
					String nom = source.substring(14, source.length()-6);
					for(Joueur j: Plateau.joueurList) {
						for(Territoire t : j.territoireListJoueur) {		
							if(t.getNom().equals(nom)) {
								vterritoireAct.setText(nom);
								vsoldatAct.setText(Integer.toString(t.getSoldatListTerritoire().size()));
								vcavalierAct.setText(Integer.toString(t.getCavalierListTerritoire().size()));
								vcanonAct.setText(Integer.toString(t.getCanonListTerritoire().size()));
								
							}
						}
					}
					
				}
				
			}
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			int ix = (int)((1/pl)*e.getX());
			int iy = (int)((1/ph)*e.getY());
			int index = 0; 
			for (BufferedImage each : imageList) 
			{
				index++;
				int alpha = (each.getRGB(ix, iy) >> 24) & 0xff;
				if (alpha != 0) 
				{
					
					ImageIcon img = imageNom.get(index-1);
					String source = img.getDescription();
					String nom = source.substring(14, source.length()-6);
					for(Joueur j: Plateau.joueurList) {
						for(Territoire t : j.territoireListJoueur) {		
							if(t.getNom().equals(nom)) {
								if(TerritoireD==null) {
									TerritoireD=t;
									terdep.setText(TerritoireD.getNom());
								}
								else if(TerritoireA==null) {
									TerritoireA=t;
									terarr.setText(TerritoireA.getNom());
								}
							}
						}
					}
					
				}
				
			}
			
			if(e.getSource() == exit) {
				System.exit(0);
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	}

	public JLabel getVterritoireAct() {
		return vterritoireAct;
	}



	public void setVterritoireAct(JLabel vterritoireAct) {
		this.vterritoireAct = vterritoireAct;
	}



	public JLabel getVsoldatAct() {
		return vsoldatAct;
	}



	public void setVsoldatAct(JLabel vsoldatAct) {
		this.vsoldatAct = vsoldatAct;
	}



	public JLabel getVcavalierAct() {
		return vcavalierAct;
	}



	public void setVcavalierAct(JLabel vcavalierAct) {
		this.vcavalierAct = vcavalierAct;
	}



	public JLabel getVcanonAct() {
		return vcanonAct;
	}



	public void setVcanonAct(JLabel vcanonAct) {
		this.vcanonAct = vcanonAct;
	}



	public int getJoueurAct() {
		return joueurAct;
	}



	public void setJoueurAct(int joueurAct) {
		this.joueurAct = joueurAct;
	}

	


	
}
