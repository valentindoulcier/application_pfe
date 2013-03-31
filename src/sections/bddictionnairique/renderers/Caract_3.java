/**
 * 
 */
package sections.bddictionnairique.renderers;

/**
 * @author Valentin
 *
 */
public class Caract_3 {
	
	public int idHeadword;
	public String mot;
	public String categorie;
	public String region;
	public String schema;
	public String type;
	public String syllabes;

    public Caract_3(int idHeadword, String mot, String categorie, String region, String schema, String type, String syllabes) {
    	this.idHeadword = idHeadword;
        this.mot = mot;
        this.categorie = categorie;
        this.region = region;
        this.schema = schema;
        this.type = type;
        this.syllabes = syllabes;
    }

}
