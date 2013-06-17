/**
 * 
 */
package principal;

import database.Headword;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Valentin
 *
 */
public class Recherche {
	
	private int numRecherche;
	
	private Date dateRecherche;
	
	private String motRecherche;
	
	private String critereRecherche;
	
	private int dansRecherche;
	
	private ArrayList<String> listeDictionnaire;
	
	private HashMap<Integer, Headword> listeResultat;
	
	
	public Recherche() {
		setDansRecherche(-1);
		listeDictionnaire = new ArrayList<String>();
		listeResultat = new HashMap<Integer, Headword>();
	}
	

	/**
	 * @return the date
	 */
	public Date getDateRecherche() {
		return dateRecherche;
	}

	/**
	 * @param date the date to set
	 */
	public void setDateRecherche(Date date) {
		this.dateRecherche = date;
	}

	/**
	 * @return the motRecherche
	 */
	public String getMotRecherche() {
		return motRecherche;
	}

	/**
	 * @param motRecherche the motRecherche to set
	 */
	public void setMotRecherche(String motRecherche) {
		this.motRecherche = motRecherche;
	}

	/**
	 * @return the listeDictionnaire
	 */
	public ArrayList<String> getListeDictionnaire() {
		return listeDictionnaire;
	}

	/**
	 * @param listeDictionnaire the listeDictionnaire to set
	 */
	public void setListeDictionnaire(ArrayList<String> listeDictionnaire) {
		this.listeDictionnaire = listeDictionnaire;
	}

	/**
	 * @return the maListe
	 */
	public HashMap<Integer, Headword> getListeResultat() {
		return listeResultat;
	}

	public int getNumRecherche() {
		return numRecherche;
	}

	public String getCritereRecherche() {
		return critereRecherche;
	}


	public void setCritereRecherche(String critereRecherche) {
		this.critereRecherche = critereRecherche;
	}


	public void setNumRecherche(int numRecherche) {
		this.numRecherche = numRecherche;
	}

	/**
	 * @param maListe the maListe to set
	 */
	public void setListeResultat(HashMap<Integer, Headword> maListe) {
		this.listeResultat = maListe;
	}


	public int getDansRecherche() {
		return dansRecherche;
	}


	public void setDansRecherche(int dansRecherche) {
		this.dansRecherche = dansRecherche;
	}
	
	

}