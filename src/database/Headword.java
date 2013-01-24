package database;

// Generated 25 janv. 2013 00:04:50 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Headword generated by hbm2java
 */
@Entity
@Table(name = "headword", catalog = "bddictionnairique")
public class Headword implements java.io.Serializable {

	private Integer idHeadword;
	private Dictionnaires dictionnaires;
	private LiensDict liensDict;
	private String mot;
	private String var1;
	private String var2;
	private String var3;
	private String var4;
	private String var5;
	private String note;
	private Set syllabeses = new HashSet(0);
	private Set noteses = new HashSet(0);
	private Set avoirPourCategorieHeadwords = new HashSet(0);
	private Set senses = new HashSet(0);
	private Set flexionses = new HashSet(0);
	private Set etymoMcqs = new HashSet(0);
	private Set composeses = new HashSet(0);

	public Headword() {
	}

	public Headword(Dictionnaires dictionnaires) {
		this.dictionnaires = dictionnaires;
	}

	public Headword(Dictionnaires dictionnaires, LiensDict liensDict,
			String mot, String var1, String var2, String var3, String var4,
			String var5, String note, Set syllabeses, Set noteses,
			Set avoirPourCategorieHeadwords, Set senses, Set flexionses,
			Set etymoMcqs, Set composeses) {
		this.dictionnaires = dictionnaires;
		this.liensDict = liensDict;
		this.mot = mot;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
		this.var4 = var4;
		this.var5 = var5;
		this.note = note;
		this.syllabeses = syllabeses;
		this.noteses = noteses;
		this.avoirPourCategorieHeadwords = avoirPourCategorieHeadwords;
		this.senses = senses;
		this.flexionses = flexionses;
		this.etymoMcqs = etymoMcqs;
		this.composeses = composeses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_headword", unique = true, nullable = false)
	public Integer getIdHeadword() {
		return this.idHeadword;
	}

	public void setIdHeadword(Integer idHeadword) {
		this.idHeadword = idHeadword;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dictionnaire", nullable = false)
	public Dictionnaires getDictionnaires() {
		return this.dictionnaires;
	}

	public void setDictionnaires(Dictionnaires dictionnaires) {
		this.dictionnaires = dictionnaires;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lien_dict")
	public LiensDict getLiensDict() {
		return this.liensDict;
	}

	public void setLiensDict(LiensDict liensDict) {
		this.liensDict = liensDict;
	}

	@Column(name = "mot", length = 100)
	public String getMot() {
		return this.mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	@Column(name = "var1", length = 100)
	public String getVar1() {
		return this.var1;
	}

	public void setVar1(String var1) {
		this.var1 = var1;
	}

	@Column(name = "var2", length = 100)
	public String getVar2() {
		return this.var2;
	}

	public void setVar2(String var2) {
		this.var2 = var2;
	}

	@Column(name = "var3", length = 100)
	public String getVar3() {
		return this.var3;
	}

	public void setVar3(String var3) {
		this.var3 = var3;
	}

	@Column(name = "var4", length = 100)
	public String getVar4() {
		return this.var4;
	}

	public void setVar4(String var4) {
		this.var4 = var4;
	}

	@Column(name = "var5", length = 100)
	public String getVar5() {
		return this.var5;
	}

	public void setVar5(String var5) {
		this.var5 = var5;
	}

	@Column(name = "note", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword")
	public Set getSyllabeses() {
		return this.syllabeses;
	}

	public void setSyllabeses(Set syllabeses) {
		this.syllabeses = syllabeses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword")
	public Set getNoteses() {
		return this.noteses;
	}

	public void setNoteses(Set noteses) {
		this.noteses = noteses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword")
	public Set getAvoirPourCategorieHeadwords() {
		return this.avoirPourCategorieHeadwords;
	}

	public void setAvoirPourCategorieHeadwords(Set avoirPourCategorieHeadwords) {
		this.avoirPourCategorieHeadwords = avoirPourCategorieHeadwords;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword")
	public Set getSenses() {
		return this.senses;
	}

	public void setSenses(Set senses) {
		this.senses = senses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword")
	public Set getFlexionses() {
		return this.flexionses;
	}

	public void setFlexionses(Set flexionses) {
		this.flexionses = flexionses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword")
	public Set getEtymoMcqs() {
		return this.etymoMcqs;
	}

	public void setEtymoMcqs(Set etymoMcqs) {
		this.etymoMcqs = etymoMcqs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword")
	public Set getComposeses() {
		return this.composeses;
	}

	public void setComposeses(Set composeses) {
		this.composeses = composeses;
	}

}
