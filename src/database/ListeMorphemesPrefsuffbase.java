package database;

// Generated 29 mars 2013 17:34:42 by Hibernate Tools 3.4.0.CR1

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
 * ListeMorphemesPrefsuffbase generated by hbm2java
 */
@Entity
@Table(name = "liste_morphemes_prefsuffbase", catalog = "bddictionnairique")
public class ListeMorphemesPrefsuffbase implements java.io.Serializable {

	private static final long serialVersionUID = -8844945747281717240L;

	private Integer idMorphPrefsuffbase;
	private String type;
	private String origine;
	private String contenu;
	private Set<AvoirPourSuffixes> avoirPourSuffixeses = new HashSet<AvoirPourSuffixes>(0);
	private Set<AvoirPourPrefixeBase> avoirPourPrefixeBases = new HashSet<AvoirPourPrefixeBase>(0);
	private Set<ListeAllomorphes> listeAllomorpheses = new HashSet<ListeAllomorphes>(0);

	public ListeMorphemesPrefsuffbase() {
	}

	public ListeMorphemesPrefsuffbase(String type, String origine,
			String contenu, Set<AvoirPourSuffixes> avoirPourSuffixeses,
			Set<AvoirPourPrefixeBase> avoirPourPrefixeBases,
			Set<ListeAllomorphes> listeAllomorpheses) {
		this.type = type;
		this.origine = origine;
		this.contenu = contenu;
		this.avoirPourSuffixeses = avoirPourSuffixeses;
		this.avoirPourPrefixeBases = avoirPourPrefixeBases;
		this.listeAllomorpheses = listeAllomorpheses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_morph_prefsuffbase", unique = true, nullable = false)
	public Integer getIdMorphPrefsuffbase() {
		return this.idMorphPrefsuffbase;
	}

	public void setIdMorphPrefsuffbase(Integer idMorphPrefsuffbase) {
		this.idMorphPrefsuffbase = idMorphPrefsuffbase;
	}

	@Column(name = "type", length = 15)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "origine", length = 25)
	public String getOrigine() {
		return this.origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	@Column(name = "contenu", length = 50)
	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listeMorphemesPrefsuffbase")
	public Set<AvoirPourSuffixes> getAvoirPourSuffixeses() {
		return this.avoirPourSuffixeses;
	}

	public void setAvoirPourSuffixeses(
			Set<AvoirPourSuffixes> avoirPourSuffixeses) {
		this.avoirPourSuffixeses = avoirPourSuffixeses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listeMorphemesPrefsuffbase")
	public Set<AvoirPourPrefixeBase> getAvoirPourPrefixeBases() {
		return this.avoirPourPrefixeBases;
	}

	public void setAvoirPourPrefixeBases(
			Set<AvoirPourPrefixeBase> avoirPourPrefixeBases) {
		this.avoirPourPrefixeBases = avoirPourPrefixeBases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listeMorphemesPrefsuffbase")
	public Set<ListeAllomorphes> getListeAllomorpheses() {
		return this.listeAllomorpheses;
	}

	public void setListeAllomorpheses(Set<ListeAllomorphes> listeAllomorpheses) {
		this.listeAllomorpheses = listeAllomorpheses;
	}

}
