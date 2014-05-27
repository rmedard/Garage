package app;

public class Car {
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
	
	public boolean equals(Car car){
		if(this.model.equalsIgnoreCase(car.getModel()) && this.type.equals(car.type) && this.yearOfFabrication == car.yearOfFabrication){
			return true;
		}return false;
	}

}
