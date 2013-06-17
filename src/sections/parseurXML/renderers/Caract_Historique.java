/**
 * 
 */
package sections.parseurXML.renderers;

/**
 * @author Valentin DOULCIER
 *
 */
public class Caract_Historique {
	public int numRecherche;
	public String fichier;
	public String date;

    public Caract_Historique(int numRecherche, String fichier, String date) {
    	this.numRecherche = numRecherche;
        this.fichier = fichier;
        this.date = date;
    }
}
