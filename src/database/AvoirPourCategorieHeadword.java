package database;

// Generated 29 mars 2013 17:34:42 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AvoirPourCategorieHeadword generated by hbm2java
 */
@Entity
@Table(name = "avoir_pour_categorie_headword", catalog = "bddictionnairique")
public class AvoirPourCategorieHeadword implements java.io.Serializable {

	private static final long serialVersionUID = -7727863060311010859L;

	private AvoirPourCategorieHeadwordId id;
	private ListeCategories listeCategories;
	private Headword headword;
	private Integer ordre;

	public AvoirPourCategorieHeadword() {
	}

	public AvoirPourCategorieHeadword(AvoirPourCategorieHeadwordId id,
			ListeCategories listeCategories, Headword headword) {
		this.id = id;
		this.listeCategories = listeCategories;
		this.headword = headword;
	}

	public AvoirPourCategorieHeadword(AvoirPourCategorieHeadwordId id,
			ListeCategories listeCategories, Headword headword, Integer ordre) {
		this.id = id;
		this.listeCategories = listeCategories;
		this.headword = headword;
		this.ordre = ordre;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idHeadword", column = @Column(name = "id_headword", nullable = false)),
			@AttributeOverride(name = "idListeCategories", column = @Column(name = "id_liste_categories", nullable = false)) })
	public AvoirPourCategorieHeadwordId getId() {
		return this.id;
	}

	public void setId(AvoirPourCategorieHeadwordId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_liste_categories", nullable = false, insertable = false, updatable = false)
	public ListeCategories getListeCategories() {
		return this.listeCategories;
	}

	public void setListeCategories(ListeCategories listeCategories) {
		this.listeCategories = listeCategories;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_headword", nullable = false, insertable = false, updatable = false)
	public Headword getHeadword() {
		return this.headword;
	}

	public void setHeadword(Headword headword) {
		this.headword = headword;
	}

	@Column(name = "ordre")
	public Integer getOrdre() {
		return this.ordre;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}

}
