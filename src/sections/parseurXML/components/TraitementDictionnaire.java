/**
 * 
 */
package sections.parseurXML.components;

import javax.swing.JProgressBar;

/**
 * @author Simon Kesteloot
 * 
 */
public class TraitementDictionnaire implements Runnable{

	private AbstractDictionnaire dico;
	String nomXml;
	JProgressBar barreDeChargement;

	public TraitementDictionnaire(String nomXml, JProgressBar barreDeChargement) {
		this.nomXml = nomXml;
		this.barreDeChargement = barreDeChargement;
	}

	public void traiter() {
//		System.out.println(dico.getNombreNoeud());
		dico.traiter();
	}
	
	public void run(){
		dico = new DictMacquarie(nomXml, barreDeChargement);
		traiter();
	}
}
