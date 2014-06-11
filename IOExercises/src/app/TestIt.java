package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		garage.addVendor(new Vendor("Julian", "Assange", "jassange@gmail.com",
				23));

		Garage deserialized;
		try {
			garage.addCar(new Car("Indi modoka", "955 Tunga", 2001, 123,
					122220.0));
		} catch (CarStillPresentException e) {
			e.printStackTrace();
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
			case "serial":
				new TestIt().serializeGarage(garage);
				System.out.println("Garage has been serialised");
				break;
			case "deserial":
				deserialized = new TestIt().deserializeGarage();
				if(deserialized != null){
					System.out.println(deserialized.getShowRoom().size());
					for(Car car : deserialized.getShowRoom()){
						System.out.println("Car model: " + car.getType() +" "+car.getModel());
					}
				}else{
					System.out.println("Null garage");
				}
				break;
			default:
				System.out.println("Uknown command");
			}
		}

	}

	private void serializeGarage(Garage garage) {
		File garageFile = new File("Garage.ser");
		try (FileOutputStream out = new FileOutputStream(garageFile)) {
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			objOut.writeObject(garage);
			objOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	private Garage deserializeGarage(){
		File garageFile = new File("Garage.ser");
		Garage gar = null;
		try(FileInputStream in = new FileInputStream(garageFile)) {
			gar = (Garage)new ObjectInputStream(in).readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return gar;
	}
}
