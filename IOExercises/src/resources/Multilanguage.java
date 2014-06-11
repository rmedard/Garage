package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Multilanguage {

	private static Multilanguage multi = new Multilanguage();
	private Properties myBundle;
	private Properties myBundle_en;
	private Properties myBundle_fr;

	private Multilanguage() {
		generateProps();
	}

	public static Multilanguage getInstance() {
		return multi;
	}

	private void generateProps() {
		this.myBundle = new Properties();
		this.myBundle_en = new Properties();
		this.myBundle_fr = new Properties();

		OutputStream out_en = null;
		OutputStream out_fr = null;

		try {
			out_en = new FileOutputStream(new File(
					"src/resources/messages_en.properties"));
			out_fr = new FileOutputStream(new File(
					"src/resources/messages_fr.properties"));

			myBundle_en.setProperty("save", "Save");
			myBundle_en.setProperty("add", "Add");

			myBundle_fr.setProperty("save", "Sauvegarder");
			myBundle_fr.setProperty("add", "Ajouter");

			try {
				myBundle_en.store(out_en, null);
				myBundle_fr.store(out_fr, null);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (out_en != null) {
				try {
					out_en.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out_fr != null) {
				try {
					out_fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
