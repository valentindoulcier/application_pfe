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
		System.out.println(dico.getNombreNoeud());
		/*
		n = dico.prochainNoeud();
//		System.out.println("   nom : "+n.getNom());
//		System.out.println("valeur : "+n.getValeur());
//		System.out.println("numero : "+n.getNumero());
		
		while(!n.isDernier()){
			n = dico.prochainNoeud();
//			System.out.println("   nom : "+n.getNom());
//			System.out.println("valeur : "+n.getValeur());
//			System.out.println("numero : "+n.getNumero());
		}
		System.out.println("numero : "+n.getNumero());
		*/
	}
}
