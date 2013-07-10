/**
 * 
 */
package sections.parseurXML.components;

/**
 * @author Simon Kesteloot
 *
 */
public class Noeud {
	
	private String nom;
	private String valeur;
	private int numero;
	
	public Noeud(){
		nom = "";
		valeur = "";
		numero = 0;
	}

	/**
	 * @param nom
	 * @param valeur
	 * @param numero
	 */
	public Noeud(String nom, String valeur, int numero) {
		super();
		this.nom = nom;
		this.valeur = valeur;
		this.numero = numero;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the valeur
	 */
	public String getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
