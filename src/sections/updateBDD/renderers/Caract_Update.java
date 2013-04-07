/**
 * 
 */
package sections.updateBDD.renderers;

/**
 * @author Valentin DOULCIER
 *
 */
public class Caract_Update {
	public int numRecherche;
	public String fichier;
	public String date;

    public Caract_Update(int numRecherche, String fichier, String date) {
    	this.numRecherche = numRecherche;
        this.fichier = fichier;
        this.date = date;
    }
}
