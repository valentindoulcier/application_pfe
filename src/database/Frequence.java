package database;

// Generated 29 mars 2013 17:34:42 by Hibernate Tools 3.4.0.CR1

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
 * Frequence generated by hbm2java
 */
@Entity
@Table(name = "frequence", catalog = "bddictionnairique")
public class Frequence implements java.io.Serializable {

	private static final long serialVersionUID = -8489033299676188871L;

	private Integer idFreq;
	private Headword headword;
	private Double frequence;
	private String source;
	private String note;

	public Frequence() {
	}

	public Frequence(Headword headword) {
		this.headword = headword;
	}

	public Frequence(Headword headword, Double frequence, String source,
			String note) {
		this.headword = headword;
		this.frequence = frequence;
		this.source = source;
		this.note = note;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_freq", unique = true, nullable = false)
	public Integer getIdFreq() {
		return this.idFreq;
	}

	public void setIdFreq(Integer idFreq) {
		this.idFreq = idFreq;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "headword_id_headword", nullable = false)
	public Headword getHeadword() {
		return this.headword;
	}

	public void setHeadword(Headword headword) {
		this.headword = headword;
	}

	@Column(name = "frequence", precision = 22, scale = 0)
	public Double getFrequence() {
		return this.frequence;
	}

	public void setFrequence(Double frequence) {
		this.frequence = frequence;
	}

	@Column(name = "source", length = 50)
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "note", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
