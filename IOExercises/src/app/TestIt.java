package app;

import java.util.Scanner;

import Exceptions.CarStillPresentException;

public class TestIt {
	private static Scanner sc;

	public static void main(String[] args) {
		System.out
				.println("Choose option(Type): \n\t 1. Showroom \n\t 2. Show vendors \n\t 3. Exit");
		Garage garage = new Garage();
		garage.addVendor(new Vendor("Jeannot", "Ghost", "jghost@gmail.com", 5));
		garage.addVendor(new Vendor("Jimmy", "Ghana", "jghana@gmail.com", 12));
		garage.addVendor(new Vendor("Julian", "Assange", "jassange@gmail.com", 23));
		try {
			garage.addCarToGarage(new Car("OtherCar", "955 Tunga", 2001, 123, 122220.0));
		} catch (CarStillPresentException e) {
			System.out.println("The car still exists in the showroom");
		}
		sc = new Scanner(System.in);
		while (true) {
			String command = sc.nextLine();
			switch (command) {
			case "showroom":
				for (Car car : garage.getShowRoom()) {
					System.out.println(car.getType() + " " + car.getModel()
							+ " " + car.getYearOfFabrication() + " "
							+ car.getKilometrage() + " " + car.getCost());
				}
				break;
			case "show vendors":
				for (Vendor vendor : garage.getVendors()) {
					System.out.println(vendor.getNom() + " "
							+ vendor.getPrenom() + " " + vendor.getEmail()
							+ " " + vendor.getSoldCars());
				}
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				System.out.println("Uknown command");	
			}
		}

	}
}
