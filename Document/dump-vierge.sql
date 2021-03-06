SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `bddictionnairique` ;
CREATE SCHEMA IF NOT EXISTS `bddictionnairique` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `bddictionnairique` ;

-- -----------------------------------------------------
-- Table `bddictionnairique`.`dictionnaires`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`dictionnaires` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`dictionnaires` (
  `id_dictionnaire` INT(11) NOT NULL AUTO_INCREMENT,
  `nom_dictionnaire` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id_dictionnaire`),
  INDEX `id_dictionnaire` (`id_dictionnaire` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`note`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`note` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`note` (
  `id_note` INT(11) NOT NULL AUTO_INCREMENT,
  `texte` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id_note`),
  INDEX `id_notes` (`id_note` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`headword`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`headword` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`headword` (
  `id_headword` INT(11) NOT NULL AUTO_INCREMENT,
  `mot` VARCHAR(200) NULL DEFAULT NULL,
  `var1` VARCHAR(200) NULL DEFAULT NULL,
  `var2` VARCHAR(200) NULL DEFAULT NULL,
  `var3` VARCHAR(200) NULL DEFAULT NULL,
  `var4` VARCHAR(200) NULL DEFAULT NULL,
  `var5` VARCHAR(200) NULL DEFAULT NULL,
  `flag_lien` INT NULL,
  `flag_autre` INT NULL,
  `id_note` INT(11) NULL,
  `id_dictionnaire` INT(11) NOT NULL,
  `id_meta_headword` INT(11) NULL DEFAULT -1,
  PRIMARY KEY (`id_headword`),
  INDEX `id_headword` (`id_headword` ASC),
  INDEX `id_dictionnaire` (`id_dictionnaire` ASC),
  INDEX `fk_headword_notes1_idx` (`id_note` ASC),
  CONSTRAINT `headword_ibfk_2`
    FOREIGN KEY (`id_dictionnaire`)
    REFERENCES `bddictionnairique`.`dictionnaires` (`id_dictionnaire`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_headword_notes1`
    FOREIGN KEY (`id_note`)
    REFERENCES `bddictionnairique`.`note` (`id_note`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 303732
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`liste_categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`liste_categories` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`liste_categories` (
  `id_categorie` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id_categorie`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`avoir_pour_categorie_headword`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`avoir_pour_categorie_headword` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`avoir_pour_categorie_headword` (
  `id_headword` INT(11) NOT NULL,
  `id_liste_categories` INT(11) NOT NULL,
  `ordre` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_headword`, `id_liste_categories`),
  INDEX `id_liste_categories` (`id_liste_categories` ASC),
  CONSTRAINT `avoir_pour_categorie_headword_ibfk_1`
    FOREIGN KEY (`id_headword`)
    REFERENCES `bddictionnairique`.`headword` (`id_headword`),
  CONSTRAINT `avoir_pour_categorie_headword_ibfk_2`
    FOREIGN KEY (`id_liste_categories`)
    REFERENCES `bddictionnairique`.`liste_categories` (`id_categorie`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`liste_morphemes_prefsuffbase`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`liste_morphemes_prefsuffbase` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`liste_morphemes_prefsuffbase` (
  `id_morph_prefsuffbase` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(15) NULL DEFAULT NULL,
  `origine` VARCHAR(25) NULL DEFAULT NULL,
  `contenu` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id_morph_prefsuffbase`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`avoir_pour_prefixe_base`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`avoir_pour_prefixe_base` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`avoir_pour_prefixe_base` (
  `id_categorie` INT(11) NOT NULL,
  `id_morph_prefsuffbase` INT(11) NOT NULL,
  `type` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`id_categorie`, `id_morph_prefsuffbase`),
  INDEX `id_categorie` (`id_categorie` ASC),
  INDEX `id_morph_prefsuffbase` (`id_morph_prefsuffbase` ASC),
  CONSTRAINT `avoir_pour_prefixe@002fbase_ibfk_1`
    FOREIGN KEY (`id_categorie`)
    REFERENCES `bddictionnairique`.`liste_categories` (`id_categorie`),
  CONSTRAINT `avoir_pour_prefixe@002fbase_ibfk_2`
    FOREIGN KEY (`id_morph_prefsuffbase`)
    REFERENCES `bddictionnairique`.`liste_morphemes_prefsuffbase` (`id_morph_prefsuffbase`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`avoir_pour_suffixes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`avoir_pour_suffixes` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`avoir_pour_suffixes` (
  `id_categorie_depart` INT(11) NOT NULL DEFAULT '0',
  `id_categorie_arrivee` INT(11) NOT NULL DEFAULT '0',
  `id_morph_prefsuffbase` INT(11) NOT NULL,
  PRIMARY KEY (`id_categorie_depart`, `id_categorie_arrivee`, `id_morph_prefsuffbase`),
  INDEX `id_categorie_depart` (`id_categorie_depart` ASC),
  INDEX `id_categorie_arrivee` (`id_categorie_arrivee` ASC),
  INDEX `id_morph_prefsuffbase` (`id_morph_prefsuffbase` ASC),
  CONSTRAINT `avoir_pour_suffixes_ibfk_1`
    FOREIGN KEY (`id_categorie_depart`)
    REFERENCES `bddictionnairique`.`liste_categories` (`id_categorie`),
  CONSTRAINT `avoir_pour_suffixes_ibfk_2`
    FOREIGN KEY (`id_categorie_arrivee`)
    REFERENCES `bddictionnairique`.`liste_categories` (`id_categorie`),
  CONSTRAINT `avoir_pour_suffixes_ibfk_3`
    FOREIGN KEY (`id_morph_prefsuffbase`)
    REFERENCES `bddictionnairique`.`liste_morphemes_prefsuffbase` (`id_morph_prefsuffbase`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`composes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`composes` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`composes` (
  `id_compose` INT(11) NOT NULL AUTO_INCREMENT,
  `texte` TEXT NULL DEFAULT NULL,
  `id_headword` INT(11) NOT NULL,
  PRIMARY KEY (`id_compose`),
  INDEX `id_compose` (`id_compose` ASC),
  INDEX `id_headword` (`id_headword` ASC),
  CONSTRAINT `composes_ibfk_1`
    FOREIGN KEY (`id_headword`)
    REFERENCES `bddictionnairique`.`headword` (`id_headword`))
ENGINE = InnoDB
AUTO_INCREMENT = 113639
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`decomposition_graphique`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`decomposition_graphique` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`decomposition_graphique` (
  `id_decomp_graph` INT(11) NOT NULL AUTO_INCREMENT,
  `syllabe1` VARCHAR(20) NULL DEFAULT NULL,
  `syllabe2` VARCHAR(20) NULL DEFAULT NULL,
  `syllabe3` VARCHAR(20) NULL DEFAULT NULL,
  `syllabe4` VARCHAR(20) NULL DEFAULT NULL,
  `syllabe5` VARCHAR(20) NULL DEFAULT NULL,
  `syllabe6` VARCHAR(20) NULL DEFAULT NULL,
  `syllabe7` VARCHAR(20) NULL DEFAULT NULL,
  `syllabe8` VARCHAR(20) NULL DEFAULT NULL,
  `syllabe9` VARCHAR(20) NULL DEFAULT NULL,
  `syllabe10` VARCHAR(20) NULL DEFAULT NULL,
  `nb_syllabes` INT(11) NULL DEFAULT NULL,
  `note` TEXT NULL DEFAULT NULL,
  `headword_id_headword` INT(11) NOT NULL,
  PRIMARY KEY (`id_decomp_graph`),
  INDEX `id_decomp_graph` (`id_decomp_graph` ASC),
  INDEX `fk_decomposition_graphique_headword1_idx` (`headword_id_headword` ASC),
  CONSTRAINT `fk_decomposition_graphique_headword1`
    FOREIGN KEY (`headword_id_headword`)
    REFERENCES `bddictionnairique`.`headword` (`id_headword`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 82976
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`types_morphologie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`types_morphologie` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`types_morphologie` (
  `id_type_morph` INT(11) NOT NULL AUTO_INCREMENT,
  `type_morph` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id_type_morph`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`decomposition_morphologique`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`decomposition_morphologique` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`decomposition_morphologique` (
  `id_morph` INT(11) NOT NULL AUTO_INCREMENT,
  `m1` VARCHAR(15) NULL DEFAULT NULL,
  `m2` VARCHAR(15) NULL DEFAULT NULL,
  `m3` VARCHAR(15) NULL DEFAULT NULL,
  `m4` VARCHAR(15) NULL DEFAULT NULL,
  `m5` VARCHAR(15) NULL DEFAULT NULL,
  `m6` VARCHAR(15) NULL DEFAULT NULL,
  `m7` VARCHAR(15) NULL DEFAULT NULL,
  `m8` VARCHAR(15) NULL DEFAULT NULL,
  `m9` VARCHAR(15) NULL DEFAULT NULL,
  `m10` VARCHAR(15) NULL DEFAULT NULL,
  `note` TEXT NULL DEFAULT NULL,
  `headword_id_headword` INT(11) NOT NULL,
  `types_morphologie_id_type_morph1` INT(11) NOT NULL,
  `types_morphologie_id_type_morph2` INT(11) NOT NULL,
  `types_morphologie_id_type_morph3` INT(11) NOT NULL,
  `types_morphologie_id_type_morph4` INT(11) NOT NULL,
  `types_morphologie_id_type_morph5` INT(11) NOT NULL,
  `types_morphologie_id_type_morph6` INT(11) NOT NULL,
  `types_morphologie_id_type_morph7` INT(11) NOT NULL,
  `types_morphologie_id_type_morph8` INT(11) NOT NULL,
  `types_morphologie_id_type_morph9` INT(11) NOT NULL,
  `types_morphologie_id_type_morph10` INT(11) NOT NULL,
  PRIMARY KEY (`id_morph`),
  INDEX `id_morph` (`id_morph` ASC),
  INDEX `fk_decomposition_morphologique_headword1_idx` (`headword_id_headword` ASC),
  INDEX `fk_decomposition_morphologique_types_morphologie2_idx` (`types_morphologie_id_type_morph1` ASC),
  INDEX `fk_decomposition_morphologique_types_morphologie3_idx` (`types_morphologie_id_type_morph2` ASC),
  INDEX `fk_decomposition_morphologique_types_morphologie4_idx` (`types_morphologie_id_type_morph3` ASC),
  INDEX `fk_decomposition_morphologique_types_morphologie5_idx` (`types_morphologie_id_type_morph4` ASC),
  INDEX `fk_decomposition_morphologique_types_morphologie6_idx` (`types_morphologie_id_type_morph5` ASC),
  INDEX `fk_decomposition_morphologique_types_morphologie7_idx` (`types_morphologie_id_type_morph6` ASC),
  INDEX `fk_decomposition_morphologique_types_morphologie8_idx` (`types_morphologie_id_type_morph7` ASC),
  INDEX `fk_decomposition_morphologique_types_morphologie9_idx` (`types_morphologie_id_type_morph8` ASC),
  INDEX `fk_decomposition_morphologique_types_morphologie10_idx` (`types_morphologie_id_type_morph9` ASC),
  INDEX `fk_decomposition_morphologique_types_morphologie11_idx` (`types_morphologie_id_type_morph10` ASC),
  CONSTRAINT `fk_decomposition_morphologique_headword1`
    FOREIGN KEY (`headword_id_headword`)
    REFERENCES `bddictionnairique`.`headword` (`id_headword`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_decomposition_morphologique_types_morphologie2`
    FOREIGN KEY (`types_morphologie_id_type_morph1`)
    REFERENCES `bddictionnairique`.`types_morphologie` (`id_type_morph`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_decomposition_morphologique_types_morphologie3`
    FOREIGN KEY (`types_morphologie_id_type_morph2`)
    REFERENCES `bddictionnairique`.`types_morphologie` (`id_type_morph`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_decomposition_morphologique_types_morphologie4`
    FOREIGN KEY (`types_morphologie_id_type_morph3`)
    REFERENCES `bddictionnairique`.`types_morphologie` (`id_type_morph`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_decomposition_morphologique_types_morphologie5`
    FOREIGN KEY (`types_morphologie_id_type_morph4`)
    REFERENCES `bddictionnairique`.`types_morphologie` (`id_type_morph`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_decomposition_morphologique_types_morphologie6`
    FOREIGN KEY (`types_morphologie_id_type_morph5`)
    REFERENCES `bddictionnairique`.`types_morphologie` (`id_type_morph`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_decomposition_morphologique_types_morphologie7`
    FOREIGN KEY (`types_morphologie_id_type_morph6`)
    REFERENCES `bddictionnairique`.`types_morphologie` (`id_type_morph`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_decomposition_morphologique_types_morphologie8`
    FOREIGN KEY (`types_morphologie_id_type_morph7`)
    REFERENCES `bddictionnairique`.`types_morphologie` (`id_type_morph`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_decomposition_morphologique_types_morphologie9`
    FOREIGN KEY (`types_morphologie_id_type_morph8`)
    REFERENCES `bddictionnairique`.`types_morphologie` (`id_type_morph`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_decomposition_morphologique_types_morphologie10`
    FOREIGN KEY (`types_morphologie_id_type_morph9`)
    REFERENCES `bddictionnairique`.`types_morphologie` (`id_type_morph`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_decomposition_morphologique_types_morphologie11`
    FOREIGN KEY (`types_morphologie_id_type_morph10`)
    REFERENCES `bddictionnairique`.`types_morphologie` (`id_type_morph`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`etymo_mcq`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`etymo_mcq` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`etymo_mcq` (
  `id_etymo` INT(11) NOT NULL AUTO_INCREMENT,
  `date` VARCHAR(15) NULL DEFAULT NULL,
  `langue` VARCHAR(25) NULL DEFAULT NULL,
  `contenu` TEXT NULL DEFAULT NULL,
  `flag` INT(11) NULL DEFAULT NULL,
  `id_headword` INT(11) NOT NULL,
  PRIMARY KEY (`id_etymo`),
  INDEX `id_etymo` (`id_etymo` ASC),
  INDEX `id_headword` (`id_headword` ASC),
  CONSTRAINT `etymo_mcq_ibfk_1`
    FOREIGN KEY (`id_headword`)
    REFERENCES `bddictionnairique`.`headword` (`id_headword`))
ENGINE = InnoDB
AUTO_INCREMENT = 39815
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`flexions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`flexions` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`flexions` (
  `id_flexion` INT(11) NOT NULL AUTO_INCREMENT,
  `mot` VARCHAR(100) NULL DEFAULT NULL,
  `id_headword` INT(11) NOT NULL,
  PRIMARY KEY (`id_flexion`),
  INDEX `id_flexion` (`id_flexion` ASC),
  INDEX `id_headword` (`id_headword` ASC),
  CONSTRAINT `flexions_ibfk_1`
    FOREIGN KEY (`id_headword`)
    REFERENCES `bddictionnairique`.`headword` (`id_headword`))
ENGINE = InnoDB
AUTO_INCREMENT = 109888
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`frequence`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`frequence` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`frequence` (
  `id_freq` INT(11) NOT NULL AUTO_INCREMENT,
  `frequence` DOUBLE NULL DEFAULT NULL,
  `source` VARCHAR(50) NULL DEFAULT NULL,
  `note` TEXT NULL DEFAULT NULL,
  `headword_id_headword` INT(11) NOT NULL,
  PRIMARY KEY (`id_freq`),
  INDEX `id_freq` (`id_freq` ASC),
  INDEX `fk_frequence_headword1_idx` (`headword_id_headword` ASC),
  CONSTRAINT `fk_frequence_headword1`
    FOREIGN KEY (`headword_id_headword`)
    REFERENCES `bddictionnairique`.`headword` (`id_headword`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`liste_types_lexicaux`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`liste_types_lexicaux` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`liste_types_lexicaux` (
  `id_type_lexical` INT(11) NOT NULL AUTO_INCREMENT,
  `type_lexical` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`id_type_lexical`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`liste_statuts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`liste_statuts` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`liste_statuts` (
  `id_statut` INT(11) NOT NULL AUTO_INCREMENT,
  `statut` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`id_statut`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`types_construction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`types_construction` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`types_construction` (
  `id_construction` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id_construction`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`lexique`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`lexique` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`lexique` (
  `id_lien_lex` INT(11) NOT NULL AUTO_INCREMENT,
  `id_type_lexical` INT(11) NOT NULL,
  `note` TEXT NULL DEFAULT NULL,
  `id_statut` INT(11) NOT NULL,
  `id_construction` INT(11) NOT NULL,
  `headword_id_mot_etudie` INT(11) NOT NULL,
  `headword_id_mot_referent_1` INT(11) NOT NULL,
  `headword_id_mot_referent_2` INT(11) NOT NULL,
  PRIMARY KEY (`id_lien_lex`),
  INDEX `id_lien_lex` (`id_lien_lex` ASC),
  INDEX `id_type_lexical` (`id_type_lexical` ASC),
  INDEX `id_statut` (`id_statut` ASC),
  INDEX `id_construction` (`id_construction` ASC),
  INDEX `fk_lexique_headword1_idx` (`headword_id_mot_etudie` ASC),
  INDEX `fk_lexique_headword2_idx` (`headword_id_mot_referent_1` ASC),
  INDEX `fk_lexique_headword3_idx` (`headword_id_mot_referent_2` ASC),
  CONSTRAINT `lexique_ibfk_4`
    FOREIGN KEY (`id_type_lexical`)
    REFERENCES `bddictionnairique`.`liste_types_lexicaux` (`id_type_lexical`),
  CONSTRAINT `lexique_ibfk_5`
    FOREIGN KEY (`id_statut`)
    REFERENCES `bddictionnairique`.`liste_statuts` (`id_statut`),
  CONSTRAINT `lexique_ibfk_6`
    FOREIGN KEY (`id_construction`)
    REFERENCES `bddictionnairique`.`types_construction` (`id_construction`),
  CONSTRAINT `fk_lexique_headword1`
    FOREIGN KEY (`headword_id_mot_etudie`)
    REFERENCES `bddictionnairique`.`headword` (`id_headword`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lexique_headword2`
    FOREIGN KEY (`headword_id_mot_referent_1`)
    REFERENCES `bddictionnairique`.`headword` (`id_headword`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lexique_headword3`
    FOREIGN KEY (`headword_id_mot_referent_2`)
    REFERENCES `bddictionnairique`.`headword` (`id_headword`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`liste_allomorphes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`liste_allomorphes` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`liste_allomorphes` (
  `id_allo` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(25) NULL DEFAULT NULL,
  `contenu` VARCHAR(50) NULL DEFAULT NULL,
  `actif` DOUBLE NULL DEFAULT NULL,
  `id_morph_prefsuffbase` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_allo`),
  INDEX `id_allo` (`id_allo` ASC),
  INDEX `id_morph_prefsuffbase` (`id_morph_prefsuffbase` ASC),
  CONSTRAINT `liste_allomorphes_ibfk_1`
    FOREIGN KEY (`id_morph_prefsuffbase`)
    REFERENCES `bddictionnairique`.`liste_morphemes_prefsuffbase` (`id_morph_prefsuffbase`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`liste_usages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`liste_usages` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`liste_usages` (
  `id_usage` INT(11) NOT NULL AUTO_INCREMENT,
  `usage` VARCHAR(15) NULL DEFAULT NULL,
  `note` TEXT NULL,
  `headword_id_headword` INT(11) NOT NULL,
  PRIMARY KEY (`id_usage`),
  INDEX `fk_liste_usages_headword1_idx` (`headword_id_headword` ASC),
  CONSTRAINT `fk_liste_usages_headword1`
    FOREIGN KEY (`headword_id_headword`)
    REFERENCES `bddictionnairique`.`headword` (`id_headword`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`sens`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`sens` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`sens` (
  `id_headword` INT(11) NOT NULL,
  `texte` TEXT NULL DEFAULT NULL,
  `origine` VARCHAR(10) NULL DEFAULT NULL,
  `id_sens` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_sens`),
  INDEX `id_sens` (`id_sens` ASC),
  INDEX `id_headword` (`id_headword` ASC),
  CONSTRAINT `sens_ibfk_1`
    FOREIGN KEY (`id_headword`)
    REFERENCES `bddictionnairique`.`headword` (`id_headword`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`syllabes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`syllabes` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`syllabes` (
  `id_syllabe` INT(11) NOT NULL AUTO_INCREMENT,
  `ordre` INT(11) NULL DEFAULT NULL,
  `region` VARCHAR(50) NULL DEFAULT NULL,
  `scheme` VARCHAR(20) NULL DEFAULT NULL,
  `nb_syllabes` INT(11) NULL DEFAULT NULL,
  `type_prononciation` VARCHAR(15) NULL DEFAULT NULL,
  `syllabe1` VARCHAR(25) NULL DEFAULT NULL,
  `syllabe2` VARCHAR(25) NULL DEFAULT NULL,
  `syllabe3` VARCHAR(25) NULL DEFAULT NULL,
  `syllabe4` VARCHAR(25) NULL DEFAULT NULL,
  `syllabe5` VARCHAR(25) NULL DEFAULT NULL,
  `syllabe6` VARCHAR(25) NULL DEFAULT NULL,
  `syllabe7` VARCHAR(25) NULL DEFAULT NULL,
  `syllabe8` VARCHAR(25) NULL DEFAULT NULL,
  `syllabe9` VARCHAR(25) NULL DEFAULT NULL,
  `syllabe10` VARCHAR(25) NULL DEFAULT NULL,
  `note` TEXT NULL DEFAULT NULL,
  `schema_phonologique` VARCHAR(20) NULL DEFAULT NULL,
  `catdef_mot` VARCHAR(50) NULL DEFAULT NULL,
  `id_headword` INT(11) NOT NULL,
  `id_flexion` INT(11) NULL,
  PRIMARY KEY (`id_syllabe`),
  INDEX `id_syllabe` (`id_syllabe` ASC),
  INDEX `id_headword` (`id_headword` ASC),
  INDEX `id_flexion` (`id_flexion` ASC),
  CONSTRAINT `syllabes_ibfk_1`
    FOREIGN KEY (`id_headword`)
    REFERENCES `bddictionnairique`.`headword` (`id_headword`),
  CONSTRAINT `syllabes_ibfk_3`
    FOREIGN KEY (`id_flexion`)
    REFERENCES `bddictionnairique`.`flexions` (`id_flexion`))
ENGINE = InnoDB
AUTO_INCREMENT = 739083
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bddictionnairique`.`Utilisateur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bddictionnairique`.`Utilisateur` ;

CREATE TABLE IF NOT EXISTS `bddictionnairique`.`Utilisateur` (
  `id_utilisateur` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` TEXT NOT NULL,
  `admin` TINYINT(1) NOT NULL DEFAULT FALSE,
  PRIMARY KEY (`id_utilisateur`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
