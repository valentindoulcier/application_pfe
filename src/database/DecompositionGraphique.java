package database;

// Generated 25 janv. 2013 00:04:50 by Hibernate Tools 3.4.0.CR1

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
 * DecompositionGraphique generated by hbm2java
 */
@Entity
@Table(name = "decomposition_graphique", catalog = "bddictionnairique")
public class DecompositionGraphique implements java.io.Serializable {

	private Integer idDecompGraph;
	private LiensDict liensDict;
	private String syllabe1;
	private String syllabe2;
	private String syllabe3;
	private String syllabe4;
	private String syllabe5;
	private String syllabe6;
	private String syllabe7;
	private String syllabe8;
	private String syllabe9;
	private String syllabe10;
	private Integer nbSyllabes;
	private String note;

	public DecompositionGraphique() {
	}

	public DecompositionGraphique(LiensDict liensDict) {
		this.liensDict = liensDict;
	}

	public DecompositionGraphique(LiensDict liensDict, String syllabe1,
			String syllabe2, String syllabe3, String syllabe4, String syllabe5,
			String syllabe6, String syllabe7, String syllabe8, String syllabe9,
			String syllabe10, Integer nbSyllabes, String note) {
		this.liensDict = liensDict;
		this.syllabe1 = syllabe1;
		this.syllabe2 = syllabe2;
		this.syllabe3 = syllabe3;
		this.syllabe4 = syllabe4;
		this.syllabe5 = syllabe5;
		this.syllabe6 = syllabe6;
		this.syllabe7 = syllabe7;
		this.syllabe8 = syllabe8;
		this.syllabe9 = syllabe9;
		this.syllabe10 = syllabe10;
		this.nbSyllabes = nbSyllabes;
		this.note = note;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_decomp_graph", unique = true, nullable = false)
	public Integer getIdDecompGraph() {
		return this.idDecompGraph;
	}

	public void setIdDecompGraph(Integer idDecompGraph) {
		this.idDecompGraph = idDecompGraph;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lien_dict", nullable = false)
	public LiensDict getLiensDict() {
		return this.liensDict;
	}

	public void setLiensDict(LiensDict liensDict) {
		this.liensDict = liensDict;
	}

	@Column(name = "syllabe1", length = 20)
	public String getSyllabe1() {
		return this.syllabe1;
	}

	public void setSyllabe1(String syllabe1) {
		this.syllabe1 = syllabe1;
	}

	@Column(name = "syllabe2", length = 20)
	public String getSyllabe2() {
		return this.syllabe2;
	}

	public void setSyllabe2(String syllabe2) {
		this.syllabe2 = syllabe2;
	}

	@Column(name = "syllabe3", length = 20)
	public String getSyllabe3() {
		return this.syllabe3;
	}

	public void setSyllabe3(String syllabe3) {
		this.syllabe3 = syllabe3;
	}

	@Column(name = "syllabe4", length = 20)
	public String getSyllabe4() {
		return this.syllabe4;
	}

	public void setSyllabe4(String syllabe4) {
		this.syllabe4 = syllabe4;
	}

	@Column(name = "syllabe5", length = 20)
	public String getSyllabe5() {
		return this.syllabe5;
	}

	public void setSyllabe5(String syllabe5) {
		this.syllabe5 = syllabe5;
	}

	@Column(name = "syllabe6", length = 20)
	public String getSyllabe6() {
		return this.syllabe6;
	}

	public void setSyllabe6(String syllabe6) {
		this.syllabe6 = syllabe6;
	}

	@Column(name = "syllabe7", length = 20)
	public String getSyllabe7() {
		return this.syllabe7;
	}

	public void setSyllabe7(String syllabe7) {
		this.syllabe7 = syllabe7;
	}

	@Column(name = "syllabe8", length = 20)
	public String getSyllabe8() {
		return this.syllabe8;
	}

	public void setSyllabe8(String syllabe8) {
		this.syllabe8 = syllabe8;
	}

	@Column(name = "syllabe9", length = 20)
	public String getSyllabe9() {
		return this.syllabe9;
	}

	public void setSyllabe9(String syllabe9) {
		this.syllabe9 = syllabe9;
	}

	@Column(name = "syllabe10", length = 20)
	public String getSyllabe10() {
		return this.syllabe10;
	}

	public void setSyllabe10(String syllabe10) {
		this.syllabe10 = syllabe10;
	}

	@Column(name = "nb_syllabes")
	public Integer getNbSyllabes() {
		return this.nbSyllabes;
	}

	public void setNbSyllabes(Integer nbSyllabes) {
		this.nbSyllabes = nbSyllabes;
	}

	@Column(name = "note", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}