package database;

// Generated 1 avr. 2013 22:44:41 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AvoirPourCategorieHeadwordId generated by hbm2java
 */
@Embeddable
public class AvoirPourCategorieHeadwordId implements java.io.Serializable {

	private static final long serialVersionUID = -1704338477964294682L;

	private int idHeadword;
	private int idListeCategories;

	public AvoirPourCategorieHeadwordId() {
	}

	public AvoirPourCategorieHeadwordId(int idHeadword, int idListeCategories) {
		this.idHeadword = idHeadword;
		this.idListeCategories = idListeCategories;
	}

	@Column(name = "id_headword", nullable = false)
	public int getIdHeadword() {
		return this.idHeadword;
	}

	public void setIdHeadword(int idHeadword) {
		this.idHeadword = idHeadword;
	}

	@Column(name = "id_liste_categories", nullable = false)
	public int getIdListeCategories() {
		return this.idListeCategories;
	}

	public void setIdListeCategories(int idListeCategories) {
		this.idListeCategories = idListeCategories;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AvoirPourCategorieHeadwordId))
			return false;
		AvoirPourCategorieHeadwordId castOther = (AvoirPourCategorieHeadwordId) other;

		return (this.getIdHeadword() == castOther.getIdHeadword())
				&& (this.getIdListeCategories() == castOther
						.getIdListeCategories());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdHeadword();
		result = 37 * result + this.getIdListeCategories();
		return result;
	}

}
