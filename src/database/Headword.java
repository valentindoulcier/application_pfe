package database;

// Generated 1 avr. 2013 22:44:41 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
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

	private static final long serialVersionUID = 8305910393200751305L;

	private Integer idHeadword;
	private Note note;
	private Dictionnaires dictionnaires;
	private String mot;
	private String var1;
	private String var2;
	private String var3;
	private String var4;
	private String var5;
	private Integer flagLien;
	private Integer flagAutre;
	private Integer idMetaHeadword;
	private Set<Syllabes> syllabeses = new HashSet<Syllabes>(0);
	private Set<DecompositionMorphologique> decompositionMorphologiques = new HashSet<DecompositionMorphologique>(0);
	private Set<Lexique> lexiquesForHeadwordIdMotReferent1 = new HashSet<Lexique>(0);
	private Set<Lexique> lexiquesForHeadwordIdMotReferent2 = new HashSet<Lexique>(0);
	private Set<Lexique> lexiquesForHeadwordIdMotEtudie = new HashSet<Lexique>(0);
	private Set<Flexions> flexionses = new HashSet<Flexions>(0);
	private Set<DecompositionGraphique> decompositionGraphiques = new HashSet<DecompositionGraphique>(0);
	private Set<ListeUsages> listeUsageses = new HashSet<ListeUsages>(0);
	private Set<AvoirPourCategorieHeadword> avoirPourCategorieHeadwords = new HashSet<AvoirPourCategorieHeadword>(0);
	private Set<Frequence> frequences = new HashSet<Frequence>(0);
	private Set<Sens> senses = new HashSet<Sens>(0);
	private Set<Composes> composeses = new HashSet<Composes>(0);
	private Set<EtymoMcq> etymoMcqs = new HashSet<EtymoMcq>(0);

	public Headword() {
	}

	public Headword(Dictionnaires dictionnaires) {
		this.dictionnaires = dictionnaires;
	}

	public Headword(Note note, Dictionnaires dictionnaires, String mot,
			String var1, String var2, String var3, String var4, String var5,
			Integer flagLien, Integer flagAutre, Integer idMetaHeadword,
			Set<Syllabes> syllabeses,
			Set<DecompositionMorphologique> decompositionMorphologiques,
			Set<Lexique> lexiquesForHeadwordIdMotReferent1,
			Set<Lexique> lexiquesForHeadwordIdMotReferent2,
			Set<Lexique> lexiquesForHeadwordIdMotEtudie,
			Set<Flexions> flexionses,
			Set<DecompositionGraphique> decompositionGraphiques,
			Set<ListeUsages> listeUsageses,
			Set<AvoirPourCategorieHeadword> avoirPourCategorieHeadwords,
			Set<Frequence> frequences, Set<Sens> senses,
			Set<Composes> composeses, Set<EtymoMcq> etymoMcqs) {
		this.note = note;
		this.dictionnaires = dictionnaires;
		this.mot = mot;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
		this.var4 = var4;
		this.var5 = var5;
		this.flagLien = flagLien;
		this.flagAutre = flagAutre;
		this.idMetaHeadword = idMetaHeadword;
		this.syllabeses = syllabeses;
		this.decompositionMorphologiques = decompositionMorphologiques;
		this.lexiquesForHeadwordIdMotReferent1 = lexiquesForHeadwordIdMotReferent1;
		this.lexiquesForHeadwordIdMotReferent2 = lexiquesForHeadwordIdMotReferent2;
		this.lexiquesForHeadwordIdMotEtudie = lexiquesForHeadwordIdMotEtudie;
		this.flexionses = flexionses;
		this.decompositionGraphiques = decompositionGraphiques;
		this.listeUsageses = listeUsageses;
		this.avoirPourCategorieHeadwords = avoirPourCategorieHeadwords;
		this.frequences = frequences;
		this.senses = senses;
		this.composeses = composeses;
		this.etymoMcqs = etymoMcqs;
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

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_note")
	public Note getNote() {
		return this.note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_dictionnaire", nullable = false)
	public Dictionnaires getDictionnaires() {
		return this.dictionnaires;
	}

	public void setDictionnaires(Dictionnaires dictionnaires) {
		this.dictionnaires = dictionnaires;
	}

	@Column(name = "mot", length = 200)
	public String getMot() {
		return this.mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	@Column(name = "var1", length = 200)
	public String getVar1() {
		return this.var1;
	}

	public void setVar1(String var1) {
		this.var1 = var1;
	}

	@Column(name = "var2", length = 200)
	public String getVar2() {
		return this.var2;
	}

	public void setVar2(String var2) {
		this.var2 = var2;
	}

	@Column(name = "var3", length = 200)
	public String getVar3() {
		return this.var3;
	}

	public void setVar3(String var3) {
		this.var3 = var3;
	}

	@Column(name = "var4", length = 200)
	public String getVar4() {
		return this.var4;
	}

	public void setVar4(String var4) {
		this.var4 = var4;
	}

	@Column(name = "var5", length = 200)
	public String getVar5() {
		return this.var5;
	}

	public void setVar5(String var5) {
		this.var5 = var5;
	}

	@Column(name = "flag_lien")
	public Integer getFlagLien() {
		return this.flagLien;
	}

	public void setFlagLien(Integer flagLien) {
		this.flagLien = flagLien;
	}

	@Column(name = "flag_autre")
	public Integer getFlagAutre() {
		return this.flagAutre;
	}

	public void setFlagAutre(Integer flagAutre) {
		this.flagAutre = flagAutre;
	}

	@Column(name = "id_meta_headword")
	public Integer getIdMetaHeadword() {
		return this.idMetaHeadword;
	}

	public void setIdMetaHeadword(Integer idMetaHeadword) {
		this.idMetaHeadword = idMetaHeadword;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword", cascade = {CascadeType.ALL})
	public Set<Syllabes> getSyllabeses() {
		return this.syllabeses;
	}

	public void setSyllabeses(Set<Syllabes> syllabeses) {
		this.syllabeses = syllabeses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword", cascade = {CascadeType.ALL})
	public Set<DecompositionMorphologique> getDecompositionMorphologiques() {
		return this.decompositionMorphologiques;
	}

	public void setDecompositionMorphologiques(
			Set<DecompositionMorphologique> decompositionMorphologiques) {
		this.decompositionMorphologiques = decompositionMorphologiques;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headwordByHeadwordIdMotReferent1", cascade = {CascadeType.ALL})
	public Set<Lexique> getLexiquesForHeadwordIdMotReferent1() {
		return this.lexiquesForHeadwordIdMotReferent1;
	}

	public void setLexiquesForHeadwordIdMotReferent1(
			Set<Lexique> lexiquesForHeadwordIdMotReferent1) {
		this.lexiquesForHeadwordIdMotReferent1 = lexiquesForHeadwordIdMotReferent1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headwordByHeadwordIdMotReferent2", cascade = {CascadeType.ALL})
	public Set<Lexique> getLexiquesForHeadwordIdMotReferent2() {
		return this.lexiquesForHeadwordIdMotReferent2;
	}

	public void setLexiquesForHeadwordIdMotReferent2(
			Set<Lexique> lexiquesForHeadwordIdMotReferent2) {
		this.lexiquesForHeadwordIdMotReferent2 = lexiquesForHeadwordIdMotReferent2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headwordByHeadwordIdMotEtudie", cascade = {CascadeType.ALL})
	public Set<Lexique> getLexiquesForHeadwordIdMotEtudie() {
		return this.lexiquesForHeadwordIdMotEtudie;
	}

	public void setLexiquesForHeadwordIdMotEtudie(
			Set<Lexique> lexiquesForHeadwordIdMotEtudie) {
		this.lexiquesForHeadwordIdMotEtudie = lexiquesForHeadwordIdMotEtudie;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword", cascade = {CascadeType.ALL})
	public Set<Flexions> getFlexionses() {
		return this.flexionses;
	}

	public void setFlexionses(Set<Flexions> flexionses) {
		this.flexionses = flexionses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword", cascade = {CascadeType.ALL})
	public Set<DecompositionGraphique> getDecompositionGraphiques() {
		return this.decompositionGraphiques;
	}

	public void setDecompositionGraphiques(
			Set<DecompositionGraphique> decompositionGraphiques) {
		this.decompositionGraphiques = decompositionGraphiques;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword", cascade = {CascadeType.ALL})
	public Set<ListeUsages> getListeUsageses() {
		return this.listeUsageses;
	}

	public void setListeUsageses(Set<ListeUsages> listeUsageses) {
		this.listeUsageses = listeUsageses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword", cascade = {CascadeType.ALL})
	public Set<AvoirPourCategorieHeadword> getAvoirPourCategorieHeadwords() {
		return this.avoirPourCategorieHeadwords;
	}

	public void setAvoirPourCategorieHeadwords(
			Set<AvoirPourCategorieHeadword> avoirPourCategorieHeadwords) {
		this.avoirPourCategorieHeadwords = avoirPourCategorieHeadwords;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword", cascade = {CascadeType.ALL})
	public Set<Frequence> getFrequences() {
		return this.frequences;
	}

	public void setFrequences(Set<Frequence> frequences) {
		this.frequences = frequences;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword", cascade = {CascadeType.ALL})
	public Set<Sens> getSenses() {
		return this.senses;
	}

	public void setSenses(Set<Sens> senses) {
		this.senses = senses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword", cascade = {CascadeType.ALL})
	public Set<Composes> getComposeses() {
		return this.composeses;
	}

	public void setComposeses(Set<Composes> composeses) {
		this.composeses = composeses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "headword", cascade = {CascadeType.ALL})
	public Set<EtymoMcq> getEtymoMcqs() {
		return this.etymoMcqs;
	}

	public void setEtymoMcqs(Set<EtymoMcq> etymoMcqs) {
		this.etymoMcqs = etymoMcqs;
	}

}
