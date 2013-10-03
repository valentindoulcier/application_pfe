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
	private boolean dernier;
	
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
	public Noeud(String nom, String valeur, int numero, boolean dernier) {
		super();
		this.nom = nom;
		this.valeur = valeur;
		this.numero = numero;
		this.dernier = dernier;
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

	/**
	 * @return the dernier
	 */
	public boolean isDernier() {
		return dernier;
	}

	/**
	 * @param dernier the dernier to set
	 */
	public void setDernier(boolean dernier) {
		this.dernier = dernier;
	}
}
