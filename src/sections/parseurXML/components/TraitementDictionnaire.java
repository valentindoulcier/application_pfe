/**
 * 
 */
package sections.parseurXML.components;

/**
 * @author Simon Kesteloot
 * 
 */
public class TraitementDictionnaire {

	private AbstractDictionnaire dico;

	public TraitementDictionnaire(String nomXML, String nomJSON) {
		dico = new DictMacquarie(nomXML);

		traiter();
	}

	public void traiter() {
		System.out.println(dico.getNombreNoeud());
		dico.traiter();
	}
}
