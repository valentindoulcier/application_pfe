package administration;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Date;

import javax.swing.JFileChooser;

public class Fichier {
	
	/**
     * Constante taille
     */
    private static final long[] CST_SIZE = {1024, 1024 * 1024, 1024 * 1024 * 1024};
    /**
     * Constante unité
     */
    private static final String[] CST_UNITS = {"Ko", "Mo", "Go"};
	
	private int numero;
		
	private Date dateParsing;
	
	private String nom;
	
	private String path;
	
	private String extension;
	
	private String type;
	
	private String taille;
	
	private String auteur;
	
	private String canRead;
	
	private Date dateModification;
	
	
	public Fichier() {		
		dateParsing = new Date();
		
		auteur = "N/A";
	}
	
	
	public Fichier(File fic) {
		
		dateParsing = new Date();
		
		nom = fic.getName();
		
		path = fic.getAbsolutePath();
		
		extension = fic.getName().substring(fic.getName().lastIndexOf("."));
				
		type = new JFileChooser().getTypeDescription(fic);
		
		taille = format(fic.length());
		
		auteur = "N/A";
		
		if(fic.canRead()) {
			canRead = "Oui";
		}
		else {
			canRead = "Non";
		}
		
		dateModification = new Date(fic.lastModified());
	}
	
	
	 /**
     * Afficher la taille du fichier formatée
     * @param long taille en octet
     * @return string
     */
    public static String format(final long value) {
        String result = null;
        long size;
        for (int i = 0; i < 3; i++) {
            size=value/CST_SIZE[i];
            if (size <= 1024) {
                result = mergeUnit(size, CST_UNITS[i]);
                break;
            }
        }
        return result;
    }

    /**
     * Arrondir et ajouter l'unité
     * @param size
     * @param unit
     * @return
     */
    public static String mergeUnit(long size, String unit) {
        return new DecimalFormat("#,##0.#").format(size) + " " + unit;
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
	 * @return the dateParsing
	 */
	public Date getDateParsing() {
		return dateParsing;
	}


	/**
	 * @param dateParsing the dateParsing to set
	 */
	public void setDateParsing(Date dateParsing) {
		this.dateParsing = dateParsing;
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
	 * @return the path
	 */
	public String getPath() {
		return path;
	}


	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}


	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}


	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * @return the taille
	 */
	public String getTaille() {
		return taille;
	}


	/**
	 * @param taille the taille to set
	 */
	public void setTaille(String taille) {
		this.taille = taille;
	}


	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}


	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	/**
	 * @return the dateModification
	 */
	public Date getDateModification() {
		return dateModification;
	}


	/**
	 * @param dateModification the dateModification to set
	 */
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}


	/**
	 * @return the canRead
	 */
	public String getCanRead() {
		return canRead;
	}


	/**
	 * @param canRead the canRead to set
	 */
	public void setCanRead(String canRead) {
		this.canRead = canRead;
	}
}
