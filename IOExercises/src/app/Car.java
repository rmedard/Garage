package app;

import java.io.Serializable;

public class Car implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1323925552564656850L;
	private String type;
	private String model;
	private int yearOfFabrication;
	private int kilometrage;
	private Double cost;

	public String getType() {
		return type;
	}

	public Car() {

	}

	public Car(String type, String model, int yearOfFabrication,
			int kilometrage, Double cost) {
		super();
		this.type = type;
		this.model = model;
		this.yearOfFabrication = yearOfFabrication;
		this.kilometrage = kilometrage;
		this.cost = cost;
	}

	public void addCar(Car car) {

	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYearOfFabrication() {
		return yearOfFabrication;
	}

	public void setYearOfFabrication(int yearOfFabrication) {
		this.yearOfFabrication = yearOfFabrication;
	}

	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

//	public boolean equals(Car car) {
//		if (this.model.equalsIgnoreCase(car.getModel())
//				&& this.type.equalsIgnoreCase(car.getType())
//				&& this.yearOfFabrication == car.getYearOfFabrication()) {
//			return true;
//		}
//		return false;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + kilometrage;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + yearOfFabrication;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (kilometrage != other.kilometrage)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (yearOfFabrication != other.yearOfFabrication)
			return false;
		return true;
	}

}
