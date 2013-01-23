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
 * DecompositionMorphologique generated by hbm2java
 */
@Entity
@Table(name = "decomposition_morphologique", catalog = "bddictionnairique")
public class DecompositionMorphologique implements java.io.Serializable {

	private Integer idMorph;
	private LiensDict liensDict;
	private String m1;
	private String m2;
	private String m3;
	private String m4;
	private String m5;
	private String m6;
	private String m7;
	private String m8;
	private String m9;
	private String m10;
	private String note;

	public DecompositionMorphologique() {
	}

	public DecompositionMorphologique(LiensDict liensDict) {
		this.liensDict = liensDict;
	}

	public DecompositionMorphologique(LiensDict liensDict, String m1,
			String m2, String m3, String m4, String m5, String m6, String m7,
			String m8, String m9, String m10, String note) {
		this.liensDict = liensDict;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		this.m4 = m4;
		this.m5 = m5;
		this.m6 = m6;
		this.m7 = m7;
		this.m8 = m8;
		this.m9 = m9;
		this.m10 = m10;
		this.note = note;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_morph", unique = true, nullable = false)
	public Integer getIdMorph() {
		return this.idMorph;
	}

	public void setIdMorph(Integer idMorph) {
		this.idMorph = idMorph;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lien_dict", nullable = false)
	public LiensDict getLiensDict() {
		return this.liensDict;
	}

	public void setLiensDict(LiensDict liensDict) {
		this.liensDict = liensDict;
	}

	@Column(name = "m1", length = 15)
	public String getM1() {
		return this.m1;
	}

	public void setM1(String m1) {
		this.m1 = m1;
	}

	@Column(name = "m2", length = 15)
	public String getM2() {
		return this.m2;
	}

	public void setM2(String m2) {
		this.m2 = m2;
	}

	@Column(name = "m3", length = 15)
	public String getM3() {
		return this.m3;
	}

	public void setM3(String m3) {
		this.m3 = m3;
	}

	@Column(name = "m4", length = 15)
	public String getM4() {
		return this.m4;
	}

	public void setM4(String m4) {
		this.m4 = m4;
	}

	@Column(name = "m5", length = 15)
	public String getM5() {
		return this.m5;
	}

	public void setM5(String m5) {
		this.m5 = m5;
	}

	@Column(name = "m6", length = 15)
	public String getM6() {
		return this.m6;
	}

	public void setM6(String m6) {
		this.m6 = m6;
	}

	@Column(name = "m7", length = 15)
	public String getM7() {
		return this.m7;
	}

	public void setM7(String m7) {
		this.m7 = m7;
	}

	@Column(name = "m8", length = 15)
	public String getM8() {
		return this.m8;
	}

	public void setM8(String m8) {
		this.m8 = m8;
	}

	@Column(name = "m9", length = 15)
	public String getM9() {
		return this.m9;
	}

	public void setM9(String m9) {
		this.m9 = m9;
	}

	@Column(name = "m10", length = 15)
	public String getM10() {
		return this.m10;
	}

	public void setM10(String m10) {
		this.m10 = m10;
	}

	@Column(name = "note", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
