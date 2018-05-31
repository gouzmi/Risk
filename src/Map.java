import java.awt.Color;
import java.awt.Dimension;
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
	//int l = p.width;
	//int h = p.height;
	int l = 1366;
	int h = 915;
			
	float cl = 1f;
	float ch= 1f;
	//float cl = 0.75f;
	//float ch= 0.7f;
	
	public Map() {
		
		this.setSize(l,h);
		
		//this.setSize(l,h);
		this.setTitle("RiskIsep");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setUndecorated(false);	    
	    //this.setResizable(false);
	    Background map = new Background();
	    this.add(map);
	    this.setVisible(true);
	    
	    
	}
	

	
	
	
	public class Background extends JPanel implements MouseMotionListener{ 
		
		
		ArrayList<BufferedImage> imageList = new ArrayList<BufferedImage>(); // 
		ArrayList<ImageIcon> imageNom = new ArrayList<ImageIcon>(); // 
		ArrayList<BufferedImage> imageList_highlight = new ArrayList<BufferedImage>(); // 
		ArrayList<BufferedImage> imageToDraw = new ArrayList<BufferedImage>(); // 
		int currentHighLight; //
		
		
		  public void paintComponent(Graphics g){ 
			  
			  Color fond = Color.decode("#d6c2aa");
			  this.setBackground( fond );
			  super.paintComponent(g);
				for (BufferedImage each : imageToDraw) 
				{
					g.drawImage(each, 0, 0,(int) (cl*l),(int) (ch*h), this);}
				ImageIcon y = new ImageIcon("images/map1.png");
				g.drawImage(y.getImage(), 0, 0,(int) (cl*l),(int) (ch*h),this);
				g.fillOval(20, 20, 75, 75);
		  	}

		  	public Background() {
		  		this.setLayout(null);
				this.addMouseMotionListener(this);
				
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

			int ix = (int)((1366/(l*cl))*e.getX());
			int iy = (int)((915/(h*ch))*e.getY());
			System.out.println(ix);
			System.out.println(iy);
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
					System.out.println(nom);
					for(Joueur j: Plateau.joueurList) {
						for(Territoire t : j.territoireListJoueur) {		
							if(t.getNom().equals(nom)) {
								System.out.println("-------");
								System.out.println(t.getNom()+" appartient à "+j.getNom());
								//System.out.println("Soldat");
								//System.out.println(t.getSoldatListJoueur().size());
								System.out.println("Cavalier");
								System.out.println(t.getCavalierListJoueur().size());
								System.out.println("Canon");
								System.out.println(t.getCanonListJoueur().size());
							}
						}
					}
					
				}
				
			}
			
		}

	}
	
}
