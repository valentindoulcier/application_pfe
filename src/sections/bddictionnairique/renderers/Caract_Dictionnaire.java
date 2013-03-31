/**
 * 
 */
package sections.bddictionnairique.renderers;

/**
 * @author Valentin
 *
 */
public class Caract_Dictionnaire {
	public int num;
	public String dictionnaire;
	public boolean selected;

    public Caract_Dictionnaire(int num, String dictionnaire, boolean selected) {
    	this.num = num;
        this.dictionnaire = dictionnaire;
        this.selected = selected;
    }

}
