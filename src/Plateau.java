import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;


public class Plateau {

	public static ArrayList<Joueur> joueurList = new ArrayList<Joueur>();
	public static ArrayList<Territoire> territoiresList;
	public static ArrayList<Region> regionsList;
	public static Mission m;

			
	
	public Plateau(ArrayList<Joueur> jList) {
		this.joueurList = jList;
		this.territoiresList = new ArrayList<>();
		this.regionsList = new ArrayList<>();
	}
	
	public void init() {
		Territoire Alaska = new Territoire("Alaska",null,104,108);
		Territoire NorthwestTerritory = new Territoire("Northwest Territory",null,215,119);
		Territoire Alberta = new Territoire("Alberta",null,203,185);
		Territoire Ontario = new Territoire("Ontario",null,287,193);
		Territoire Greenland = new Territoire("Greenland",null,465,59);
		Territoire WesternUS = new Territoire("Western US",null,218,271);
		Territoire Quebec = new Territoire("Quebec",null,384,204);
		Territoire EasternUS = new Territoire("Eastern US",null,317,283);
		Territoire CentralAmerica = new Territoire("Central America",null,235,426);
		Territoire Venezuela = new Territoire("Venezuela",null,322,473);
		Territoire Peru = new Territoire("Peru",null,286,566);
		Territoire Argentina = new Territoire("Argentina",null,342,663);
		Territoire Brazil = new Territoire("Brazil",null,412,537);
		Territoire NorthAfrica = new Territoire("North Africa",null,609,556);
		Territoire Congo = new Territoire("Congo",null,725,614);
		Territoire SouthAfrica = new Territoire("South Africa",null,715,720);
		Territoire Madagascar = new Territoire("Madagascar",null,870,790);
		Territoire EastAfrica = new Territoire("East Africa",null,757,560);
		Territoire Egypt = new Territoire("Egypt",null,705,481);
		Territoire SouthernEU = new Territoire("Southern EU",null,673,404);
		Territoire WesternEU = new Territoire("Western EU",null,591,360);
		Territoire GreatBritain = new Territoire("Great Britain",null,525,300);
		Territoire Iceland = new Territoire("Iceland",null,584,208);
		Territoire Scandinavia = new Territoire("Scandinavia",null,650,187);
		Territoire NorthernEU = new Territoire("Northern EU",null,638,308);
		Territoire Ukraine = new Territoire("Ukraine",null,800,175);
		Territoire MiddleEast = new Territoire("Middle East",null,806,488);
		Territoire Afganistan = new Territoire("Afganistan",null,883,350);
		Territoire Ural = new Territoire("Ural",null,911,235);
		Territoire Siberia = new Territoire("Siberia",null,971,180);
		Territoire China = new Territoire("China",null,985,344);
		Territoire India = new Territoire("India",null,930,400);
		Territoire Siam = new Territoire("Siam",null,1061,472);
		Territoire Mongolia = new Territoire("Mongolia",null,1060,330);
		Territoire Yakutsk = new Territoire("Yakutsk",null,1082,78);
		Territoire Irkutsk = new Territoire("Irkutsk",null,1036,242);
		Territoire Kamchatka = new Territoire("Kamchatka",null,1133,167);
		Territoire Japan = new Territoire("Japan",null,1205,276);
		Territoire Indonesia = new Territoire("Indonesia",null,1040,625);
		Territoire WesternAustralia = new Territoire("Western Australia",null,1140,720);
		Territoire EasternAustralia = new Territoire("Eastern Australia",null,1220,700);
		Territoire NewGuinea = new Territoire("New Guinea",null,1165,571);
		

		
		Territoire voisinAlaska [] = {NorthwestTerritory, Alberta, Kamchatka};
	    Alaska.setVoisins(voisinAlaska);
	    Territoire voisinNorthwestTerritory [] = { Alberta, Alaska , Ontario, Greenland};
	    NorthwestTerritory.setVoisins(voisinNorthwestTerritory);
	    Territoire voisinAlberta  [] = {Alaska, NorthwestTerritory, Ontario, WesternUS};
	    Alberta.setVoisins(voisinAlberta);
	    Territoire voisinOntario  [] = {NorthwestTerritory, Alberta, WesternUS, EasternUS, Greenland, Quebec};
	    Ontario.setVoisins(voisinOntario);
	    Territoire voisinGreenland  [] = {NorthwestTerritory, Ontario, Quebec, Iceland};
	    Greenland.setVoisins(voisinGreenland);
	    Territoire voisinQuebec  [] = {Ontario, EasternUS, Greenland};
	    Quebec.setVoisins(voisinQuebec);
	    Territoire voisinWesternUS [] = {Alberta, Ontario, EasternUS, CentralAmerica};
	    WesternUS.setVoisins(voisinWesternUS);
	    Territoire voisinEasternUS [] = {WesternUS, Ontario, Quebec, CentralAmerica};
	    EasternUS.setVoisins(voisinEasternUS);
	    Territoire voisinCentralAmerica [] = {WesternUS, EasternUS, Venezuela};
	    CentralAmerica.setVoisins(voisinCentralAmerica);
	    Territoire voisinVenezuela  [] = {CentralAmerica, Brazil, Peru};
	    Venezuela.setVoisins(voisinVenezuela);
	    Territoire voisinPeru [] = {Brazil, Argentina, Venezuela};
	    Peru.setVoisins(voisinPeru);
	    Territoire voisinArgentina  [] = {Peru, Brazil};
	    Argentina.setVoisins(voisinArgentina);
	    Territoire voisinBrazil [] = {Peru, Venezuela, Argentina, NorthAfrica};
	    Brazil.setVoisins(voisinBrazil);
	    Territoire voisinNorthAfrica [] = {Brazil, Egypt, EastAfrica, Congo, WesternEU, SouthernEU};
	    NorthAfrica.setVoisins(voisinNorthAfrica);
	    Territoire voisinCongo  [] = {NorthAfrica, EastAfrica, SouthAfrica};
	    Congo.setVoisins(voisinCongo);
	    Territoire voisinSouthAfrica [] = {Congo, EastAfrica, Madagascar};
	    SouthAfrica.setVoisins(voisinSouthAfrica);
	    Territoire voisinMadagascar [] = {SouthAfrica, EastAfrica};
	    Madagascar.setVoisins(voisinMadagascar);
	    Territoire voisinEastAfrica [] = {NorthAfrica, Egypt, Congo, SouthAfrica,MiddleEast};
	    EastAfrica.setVoisins(voisinEastAfrica);
	    Territoire voisinEgypt [] = {EastAfrica, NorthAfrica, SouthernEU, MiddleEast};
	    Egypt.setVoisins(voisinEgypt);
	    Territoire voisinSouthernEU [] = {WesternEU, NorthernEU, Ukraine, MiddleEast, Egypt};
	    SouthernEU.setVoisins(voisinSouthernEU);
	    Territoire voisinWesternEU [] = {SouthernEU, NorthAfrica, NorthernEU, GreatBritain};
	    WesternEU.setVoisins(voisinWesternEU);
	    Territoire voisinGreatBritain  [] = {WesternEU, Iceland, Scandinavia,NorthernEU};
	    GreatBritain.setVoisins(voisinGreatBritain);
	    Territoire voisinIceland [] = {Greenland, Scandinavia, GreatBritain};
	    Iceland.setVoisins(voisinIceland);
	    Territoire voisinScandinavia  [] = {Iceland, GreatBritain, NorthernEU, Ukraine};
	    Scandinavia.setVoisins(voisinScandinavia);
	    Territoire voisinNorthernEU  [] = {GreatBritain, Scandinavia, WesternEU, SouthernEU, Ukraine};
	    NorthernEU.setVoisins(voisinNorthernEU);
	    Territoire voisinUkraine  [] = {Scandinavia, NorthernEU, SouthernEU, MiddleEast, Afganistan, Ural};
	    Ukraine.setVoisins(voisinUkraine);
	    Territoire voisinMiddleEast  [] = {Egypt, EastAfrica, SouthernEU, Ukraine, Afganistan, India};
	    MiddleEast.setVoisins(voisinMiddleEast);
	    Territoire voisinAfganistan  [] = {MiddleEast, India, China, Ural, Ukraine};
	    Afganistan.setVoisins(voisinAfganistan);
	    Territoire voisinUral [] = {Ukraine, Siberia, Afganistan, China};
	    Ural.setVoisins(voisinUral);
	    Territoire voisinSiberia  [] = {Ural, Yakutsk, Irkutsk, Mongolia, China};
	    Siberia.setVoisins(voisinSiberia);
	    Territoire voisinChina [] = {Ural, Afganistan, India, Siam, Mongolia, Siberia};
	    China.setVoisins(voisinChina);
	    Territoire voisinIndia  [] = {MiddleEast, Afganistan, Siam, China};
	    India.setVoisins(voisinIndia);
	    Territoire voisinSiam  [] = {India, China, Indonesia};
	    Siam.setVoisins(voisinSiam);
	    Territoire voisinMongolia  [] = {China, Siberia, Irkutsk, Kamchatka, Japan};
	    Mongolia.setVoisins(voisinMongolia);
	    Territoire voisinYakutsk [] = {Siberia, Irkutsk, Kamchatka};
	    Yakutsk.setVoisins(voisinYakutsk);
	    Territoire voisinIrkutsk [] = {Siberia, Yakutsk, Kamchatka, Mongolia};
	    Irkutsk.setVoisins(voisinIrkutsk);
	    Territoire voisinKamchatka  [] = {Yakutsk, Irkutsk, Mongolia, Alaska,Japan};
	    Kamchatka.setVoisins(voisinKamchatka);
	    Territoire voisinJapan  [] = {Mongolia, Kamchatka};
	    Japan.setVoisins(voisinJapan);
	    Territoire voisinIndonesia  [] = {Siam, NewGuinea, WesternAustralia};
	    Indonesia.setVoisins(voisinIndonesia);	
	    Territoire voisinWesternAustralia  [] = {Indonesia, NewGuinea, EasternAustralia};
	    WesternAustralia.setVoisins(voisinWesternAustralia);
	    Territoire voisinEasternAustralia [] = {WesternAustralia, NewGuinea};
	    EasternAustralia.setVoisins(voisinEasternAustralia);
	    Territoire voisinNewGuinea  [] = {Indonesia, EasternAustralia, WesternAustralia};
	    NewGuinea.setVoisins(voisinNewGuinea);
	    
	   
		territoiresList.add(Alaska);
		territoiresList.add(NorthwestTerritory);
		territoiresList.add(Alberta);
		territoiresList.add(Ontario);
		territoiresList.add(WesternUS);
		territoiresList.add(Quebec);
		territoiresList.add(EasternUS);
		territoiresList.add(CentralAmerica);
		territoiresList.add(Venezuela);
		territoiresList.add(Peru);
		territoiresList.add(Argentina);
		territoiresList.add(Brazil);
		territoiresList.add(NorthAfrica);
		territoiresList.add(Congo);
		territoiresList.add(SouthAfrica);
		territoiresList.add(Madagascar);
		territoiresList.add(EastAfrica);
		territoiresList.add(Egypt);
		territoiresList.add(SouthernEU);
		territoiresList.add(WesternEU);
		territoiresList.add(GreatBritain);
		territoiresList.add(Iceland);
		territoiresList.add(Scandinavia);
		territoiresList.add(NorthernEU);
		territoiresList.add(Ukraine);
		territoiresList.add(MiddleEast);
		territoiresList.add(Afganistan);
		territoiresList.add(Ural);
		territoiresList.add(Siberia);
		territoiresList.add(China);
		territoiresList.add(India);
		territoiresList.add(Siam);
		territoiresList.add(Mongolia);
		territoiresList.add(Yakutsk);
		territoiresList.add(Irkutsk);
		territoiresList.add(Kamchatka);
		territoiresList.add(Japan);
		territoiresList.add(Indonesia);
		territoiresList.add(WesternAustralia);
		territoiresList.add(EasternAustralia);
		territoiresList.add(NewGuinea);
		territoiresList.add(Greenland);
		

		//Initialisation des régions

		Territoire TNorthUS [] = {Alaska, NorthwestTerritory, Alberta, Ontario, WesternUS, CentralAmerica, EasternUS, Quebec, Greenland};
		Region NorthUS = new Region ("NorthUS", TNorthUS);
		Territoire TSouthUS [] = {Venezuela, Peru, Argentina, Brazil};
		Region SouthUS = new Region ("SouthUS", TSouthUS);
		Territoire TEurope [] = {Iceland, GreatBritain, WesternEU, SouthernEU, NorthernEU, Scandinavia, Ukraine};
		Region Europe = new Region ("Europe", TEurope);
		Territoire TAfrica [] = {NorthAfrica, Egypt, EastAfrica, Congo, SouthAfrica, Madagascar};
		Region Africa = new Region ("Africa", TAfrica);
		Territoire TAsia [] = {MiddleEast, India, Afganistan, Ural, Siberia, China, Siam, Mongolia, Irkutsk, Yakutsk, Kamchatka, Japan};
		Region Asia = new Region ("Asia", TAsia);
		Territoire TAustralia [] = {Indonesia, NewGuinea, WesternAustralia, EasternAustralia};
		Region Australia = new Region ("Australia", TAustralia);
		
		// Ajout des régions dans une liste
		
		regionsList.add(NorthUS);
		regionsList.add(SouthUS);
		regionsList.add(Europe);
		regionsList.add(Africa);
		regionsList.add(Asia);
		regionsList.add(Australia);
		
		//initialisation des missions
		
		m = new Mission(joueurList);
		
	}

	public static Mission getMission() {
		return m;
	}
	
	public static ArrayList<Joueur> getJoueurList() {
		return joueurList;
	}

	public static void setJoueurList(ArrayList<Joueur> joueurList) {
		Plateau.joueurList = joueurList;
	}

	public static ArrayList<Territoire> getTerritoiresList() {
		return territoiresList;
	}

	public static void setTerritoiresList(ArrayList<Territoire> territoiresList) {
		Plateau.territoiresList = territoiresList;
	}

	public static ArrayList<Region> getRegionsList() {
		return regionsList;
	}

	public static void setRegionsList(ArrayList<Region> regionsList) {
		Plateau.regionsList = regionsList;
	}

	
	
	//Tour à tour 
	
/*	public static boolean fintour () {
		if (//vérif bouton) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public void Tour () {
		int compt = 0;
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
			if (fintour() == true) {
				//passe au joueur suivant
				if (compt>=Plateau.joueurList.size()) {
					compt = 0;
				}
				j = Plateau.joueurList.get(compt++);
			}
		}
	} */
	
	

}
