/**
 * 
 */
package sections.parseurXML.components;

/**
 * @author Simon Kesteloot
 *
 */
public class TraitementDictionnaire {

	private FichierDictionnaire dico;
//	private FichierDescripteur descripteur;
	
	public TraitementDictionnaire(String nomXML, String nomJSON) {
		dico = new FichierDictionnaire(nomXML);
//		descripteur = new FichierDescripteur(nomXML);
		
		traiter();
	}
	
	public void traiter(){
		Noeud n;
		for(int i=0; i< 1500; i++){
			n = dico.prochainNoeud();
			System.out.println("   nom : "+n.getNom());
			System.out.println("valeur : "+n.getValeur());
			System.out.println("numero : "+n.getNumero());
		}
	}
}
