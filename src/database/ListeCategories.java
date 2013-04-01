package database;

// Generated 1 avr. 2013 22:44:41 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ListeCategories generated by hbm2java
 */
@Entity
@Table(name = "liste_categories", catalog = "bddictionnairique")
public class ListeCategories implements java.io.Serializable {

	private static final long serialVersionUID = 4128585333586017236L;

	private Integer idCategorie;
	private String nom;
	private Set<AvoirPourSuffixes> avoirPourSuffixesesForIdCategorieArrivee = new HashSet<AvoirPourSuffixes>(0);
	private Set<AvoirPourCategorieHeadword> avoirPourCategorieHeadwords = new HashSet<AvoirPourCategorieHeadword>(0);
	private Set<AvoirPourPrefixeBase> avoirPourPrefixeBases = new HashSet<AvoirPourPrefixeBase>(0);
	private Set<AvoirPourSuffixes> avoirPourSuffixesesForIdCategorieDepart = new HashSet<AvoirPourSuffixes>(0);

	public ListeCategories() {
	}

	public ListeCategories(String nom,
			Set<AvoirPourSuffixes> avoirPourSuffixesesForIdCategorieArrivee,
			Set<AvoirPourCategorieHeadword> avoirPourCategorieHeadwords,
			Set<AvoirPourPrefixeBase> avoirPourPrefixeBases,
			Set<AvoirPourSuffixes> avoirPourSuffixesesForIdCategorieDepart) {
		this.nom = nom;
		this.avoirPourSuffixesesForIdCategorieArrivee = avoirPourSuffixesesForIdCategorieArrivee;
		this.avoirPourCategorieHeadwords = avoirPourCategorieHeadwords;
		this.avoirPourPrefixeBases = avoirPourPrefixeBases;
		this.avoirPourSuffixesesForIdCategorieDepart = avoirPourSuffixesesForIdCategorieDepart;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_categorie", unique = true, nullable = false)
	public Integer getIdCategorie() {
		return this.idCategorie;
	}

	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}

	@Column(name = "nom", length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listeCategoriesByIdCategorieArrivee")
	public Set<AvoirPourSuffixes> getAvoirPourSuffixesesForIdCategorieArrivee() {
		return this.avoirPourSuffixesesForIdCategorieArrivee;
	}

	public void setAvoirPourSuffixesesForIdCategorieArrivee(
			Set<AvoirPourSuffixes> avoirPourSuffixesesForIdCategorieArrivee) {
		this.avoirPourSuffixesesForIdCategorieArrivee = avoirPourSuffixesesForIdCategorieArrivee;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listeCategories")
	public Set<AvoirPourCategorieHeadword> getAvoirPourCategorieHeadwords() {
		return this.avoirPourCategorieHeadwords;
	}

	public void setAvoirPourCategorieHeadwords(
			Set<AvoirPourCategorieHeadword> avoirPourCategorieHeadwords) {
		this.avoirPourCategorieHeadwords = avoirPourCategorieHeadwords;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listeCategories")
	public Set<AvoirPourPrefixeBase> getAvoirPourPrefixeBases() {
		return this.avoirPourPrefixeBases;
	}

	public void setAvoirPourPrefixeBases(
			Set<AvoirPourPrefixeBase> avoirPourPrefixeBases) {
		this.avoirPourPrefixeBases = avoirPourPrefixeBases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listeCategoriesByIdCategorieDepart")
	public Set<AvoirPourSuffixes> getAvoirPourSuffixesesForIdCategorieDepart() {
		return this.avoirPourSuffixesesForIdCategorieDepart;
	}

	public void setAvoirPourSuffixesesForIdCategorieDepart(
			Set<AvoirPourSuffixes> avoirPourSuffixesesForIdCategorieDepart) {
		this.avoirPourSuffixesesForIdCategorieDepart = avoirPourSuffixesesForIdCategorieDepart;
	}

}
