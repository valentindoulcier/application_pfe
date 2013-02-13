/**
 * 
 */
package principal;

import database.Headword;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Valentin
 *
 */
public class Recherche {
	
	
	String motRecherche;
	
	List<Headword> maListe;
	
	public Recherche() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(dateFormat.format(new Date()));
	}
	
	

}