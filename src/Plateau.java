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
	}
	

}
