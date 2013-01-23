package database;

// Generated 23 janv. 2013 18:39:10 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Notes generated by hbm2java
 */
@Entity
@Table(name = "notes", catalog = "bddictionnairique")
public class Notes implements java.io.Serializable {

	private Integer idNotes;
	private Headword headword;
	private String texte;

	public Notes() {
	}

	public Notes(Headword headword) {
		this.headword = headword;
	}

	public Notes(Headword headword, String texte) {
		this.headword = headword;
		this.texte = texte;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_notes", unique = true, nullable = false)
	public Integer getIdNotes() {
		return this.idNotes;
	}

	public void setIdNotes(Integer idNotes) {
		this.idNotes = idNotes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_headword", nullable = false)
	public Headword getHeadword() {
		return this.headword;
	}

	public void setHeadword(Headword headword) {
		this.headword = headword;
	}

	@Column(name = "texte", length = 65535)
	public String getTexte() {
		return this.texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

}
