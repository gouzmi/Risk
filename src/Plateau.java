import java.util.ArrayList;
import java.util.Collections;

public class Plateau {

	public static ArrayList<Joueur> joueurList;
	public static ArrayList<Territoire> territoiresList;
	
		
		
	
	public Plateau() {

		ArrayList<Joueur> jList = new ArrayList<Joueur>();
		ArrayList<Territoire> tList = new ArrayList<Territoire>();
		this.joueurList = jList;
		this.territoiresList = tList;
	}
	
	public static void init() {
		Territoire Alaska = new Territoire("Alaska",null);
		Territoire NorthwestTerritory = new Territoire("Northwest Territory",null);
		Territoire Alberta = new Territoire("Alberta",null);
		Territoire Ontario = new Territoire("Ontario",null);
		Territoire Greenland = new Territoire("Greenland",null);
		Territoire WesternUS = new Territoire("Western US",null);
		Territoire Quebec = new Territoire("Quebec",null);
		Territoire EasternUS = new Territoire("Eastern US",null);
		Territoire CentralAmerica = new Territoire("Central America",null);
		Territoire Venezuela = new Territoire("Venezuela",null);
		Territoire Peru = new Territoire("Peru",null);
		Territoire Argentina = new Territoire("Argentina",null);
		Territoire Brazil = new Territoire("Brazil",null);
		Territoire NorthAfrica = new Territoire("North Africa",null);
		Territoire Congo = new Territoire("Congo",null);
		Territoire SouthAfrica = new Territoire("South Africa",null);
		Territoire Madagascar = new Territoire("Madagascar",null);
		Territoire EastAfrica = new Territoire("East Africa",null);
		Territoire Egypt = new Territoire("Egypt",null);
		Territoire SouthernEU = new Territoire("Southern EU",null);
		Territoire WesternEU = new Territoire("Western EU",null);
		Territoire GreatBritain = new Territoire("Great Britain",null);
		Territoire Iceland = new Territoire("Iceland",null);
		Territoire Scandinavia = new Territoire("Scandinavia",null);
		Territoire NorthernEU = new Territoire("Northern EU",null);
		Territoire Ukraine = new Territoire("Ukraine",null);
		Territoire MiddleEast = new Territoire("Middle East",null);
		Territoire Afganistan = new Territoire("Afganistan",null);
		Territoire Ural = new Territoire("Ural",null);
		Territoire Siberia = new Territoire("Siberia",null);
		Territoire China = new Territoire("China",null);
		Territoire India = new Territoire("India",null);
		Territoire Siam = new Territoire("Siam",null);
		Territoire Mongolia = new Territoire("Mongolia",null);
		Territoire Yakutsk = new Territoire("Yakutsk",null);
		Territoire Irkutsk = new Territoire("Irkutsk",null);
		Territoire Kamchatka = new Territoire("Kamchatka",null);
		Territoire Japan = new Territoire("Japan",null);
		Territoire Indonesia = new Territoire("Indonesia",null);
		Territoire WesternAustralia = new Territoire("Western Australia",null);
		Territoire EasternAustralia = new Territoire("Eastern Australia",null);
		Territoire NewGuinea = new Territoire("New Guinea",null);
		
		// définition des territoires voisins
		
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
	    Territoire voisinPeru [] = {NorthwestTerritory, Alberta, Kamchatka};
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
	    Territoire voisinEastAfrica [] = {NorthAfrica, Egypt, Congo, SouthAfrica};
	    EastAfrica.setVoisins(voisinEastAfrica);
	    Territoire voisinEgypt [] = {EastAfrica, NorthAfrica, SouthernEU, MiddleEast};
	    Egypt.setVoisins(voisinEgypt);
	    Territoire voisinSouthernEU [] = {WesternEU, NorthernEU, Ukraine, MiddleEast};
	    SouthernEU.setVoisins(voisinSouthernEU);
	    Territoire voisinWesternEU [] = {SouthernEU, NorthAfrica, NorthernEU, GreatBritain};
	    WesternEU.setVoisins(voisinWesternEU);
	    Territoire voisinGreatBritain  [] = {WesternEU, Iceland, Scandinavia};
	    GreatBritain.setVoisins(voisinGreatBritain);
	    Territoire voisinIceland [] = {Greenland, Scandinavia, GreatBritain};
	    Iceland.setVoisins(voisinIceland);
	    Territoire voisinScandinavia  [] = {Iceland, GreatBritain, NorthernEU, Ukraine};
	    Scandinavia.setVoisins(voisinScandinavia);
	    Territoire voisinNorthernEU  [] = {GreatBritain, Scandinavia, WesternEU, SouthernEU, Ukraine};
	    NorthernEU.setVoisins(voisinArgentina);
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
	    Territoire voisinKamchatka  [] = {Yakutsk, Irkutsk, Mongolia, Alaska};
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
	    NewGuinea.setVoisins(voisinArgentina);
	    
	
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
		
		Ural.getCavalierListTerritoire().add(new Cavalier());
	}
	

}
