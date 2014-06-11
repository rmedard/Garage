package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class Multilanguage {

	private static Multilanguage multi = new Multilanguage();
	private Properties props;
	private Properties props_fr;

	private Locale[] locales = { Locale.ENGLISH, Locale.FRENCH };

	private ResourceBundle defaultBundle;
	private ResourceBundle frenchBundle;

	private Multilanguage() {
		generateProps();
	}

	public static Multilanguage getInstance() {
		return multi;
	}

	private void generateProps() {
		this.props = new Properties();
		this.props_fr = new Properties();

		OutputStream out_en = null;
		OutputStream out_fr = null;

		try {
			out_en = new FileOutputStream(new File(
					"src/resources/props.properties"));
			out_fr = new FileOutputStream(new File(
					"src/resources/props_fr.properties"));

			props.setProperty("save car", "Save Car");
			props.setProperty("add car", "Add Car");
			props.setProperty("remove car", "Remove Car");
			props.setProperty("Type", "Type");
			props.setProperty("Model", "Model");
			props.setProperty("YOF", "Year of fab.");
			props.setProperty("Km", "Kilometer");
			props.setProperty("cost", "Cost");

			props_fr.setProperty("save", "Sauvegarder");
			props_fr.setProperty("add car", "Ajouter");
			props_fr.setProperty("remove car", "Supprimer voiture");
			props_fr.setProperty("Type", "Type");
			props_fr.setProperty("Model", "Modèle");
			props_fr.setProperty("YOF", "Année de fab.");
			props_fr.setProperty("Km", "Kilometrage");
			props_fr.setProperty("cost", "Prix");

			defaultBundle = ResourceBundle.getBundle("props", locales[0]);
			frenchBundle = ResourceBundle.getBundle("props_fr", locales[1]);

			try {
				props.store(out_en, null);
				props_fr.store(out_fr, null);
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

	public ResourceBundle getDefaultBundle() {
		return defaultBundle;
	}

	public ResourceBundle getFrenchBundle() {
		return frenchBundle;
	}

}
