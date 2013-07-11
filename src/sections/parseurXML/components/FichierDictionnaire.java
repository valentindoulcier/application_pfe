/**
 * 
 */
package sections.parseurXML.components;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 * @author Simon Kesteloot
 *
 */
public class FichierDictionnaire {
	
	private String nomDuFichier;
	
	private DocumentBuilderFactory docBuilderFactory;
	private DocumentBuilder docBuilder;
	private Document doc; 
	
	private File fichier;
	
	private int numeroNoeudCourant;
	private int nombreNoeud;
	
	private Node noeudCourant;
	private Stack<Node> pile;

	public FichierDictionnaire(String nomFichier){
		
		nomDuFichier = nomFichier;
		numeroNoeudCourant = -1;
		pile = new Stack<Node>();
		
		
		docBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
        try {
        	fichier = new File(nomDuFichier);
//        	System.out.println(nomDuFichier);
			doc = docBuilder.parse(fichier);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
        noeudCourant = doc;
        pile.push(noeudCourant);
//        System.out.println(doc.toString());
	}
	/*
	public int getNombreNoeud(){
		if(nombreNoeud = -1){
			
		}
		return nombreNoeud;
	}
	*/
	public Noeud prochainNoeud(){
		Noeud noeud;
		String nom;
		String valeur;
		boolean dernier;
	
		//avance d'un noeud
		dernier = chercherProchainNoeud();
		
		nom = noeudCourant.toString();
		valeur = noeudCourant.getNodeName();
		
		
		noeud = new Noeud(nom, valeur, numeroNoeudCourant, dernier);
		return noeud;
	}
	
	// version avec pile
	private boolean chercherProchainNoeud(){
		NodeList liste;
		int tailleListe;
		boolean dernier;
		if(!pile.empty()){
			noeudCourant = pile.pop();
			numeroNoeudCourant++;
			
			if(noeudCourant.getChildNodes() != null){
				liste = noeudCourant.getChildNodes();
				tailleListe = liste.getLength();
//				System.out.println("tailleListe : "+tailleListe);
				for(int i=tailleListe; i>=0; i--){
					if(liste.item(i) != null){
						pile.push(liste.item(i));
					}
				}
			}
			dernier = false;
		}
		else{
			dernier = true;
		}
		return dernier;
	}
	
	/*//version foireuse pour le moment
	private void chercherProchainNoeud(){
		// marque le noeud courant comme lu
		noeudCourant.setUserData("visite", true, null);
		
		// si enfant, passe au premier
		if(noeudCourant.getFirstChild() != null){
			noeudCourant = noeudCourant.getFirstChild();
		}// si frere, passe au suivant
		else if(noeudCourant.getNextSibling() != null){
			noeudCourant = noeudCourant.getNextSibling();
		}// sinon remonte au parent
		else{
			if(noeudCourant.getParentNode() != null){
				boolean visite = noeudCourant.getUserData("visite")!=null;
				System.out.println(visite);
				while (visite && !noeudCourant.isSameNode(doc)){
					if(noeudCourant.getParentNode().getNextSibling() != null){
						noeudCourant = noeudCourant.getParentNode().getNextSibling();
					}else{
						noeudCourant = noeudCourant.getParentNode();
					}
				}
			}
		}
		numeroNoeudCourant ++;
	}
	*/
}
