package app;

//import java.util.Comparator;

public class Vendor implements Comparable<Vendor> {
	private String nom;
	private String prenom;
	private String email;
	private int soldCars;

	public Vendor(String nom, String prenom, String email, int soldCars) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.soldCars = soldCars;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSoldCars() {
		return soldCars;
	}

	public void setSoldCars(int soldCars) {
		this.soldCars = soldCars;
	}

	@Override
	public int compareTo(Vendor vendor) {
		if (this.nom.compareTo(vendor.getNom()) == 0) {
			return this.prenom.compareTo(vendor.getPrenom());
		} else {
			return this.nom.compareTo(vendor.getNom());
		}
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return true;
		if (o.getClass() != this.getClass()) {
			return false;
		} else {
			Vendor v = (Vendor) o;
			if (!this.nom.equals(v.nom) || !this.prenom.equals(v.prenom)
					|| this.email.equals(v.email)) {
				return false;
			}
		}
		return true;

	}

}
