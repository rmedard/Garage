package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import Exceptions.CarStillPresentException;

public class Garage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2721727061763249939L;
	
	private transient Scanner sc;
	private transient static File myFile;
	private transient BufferedWriter bfWriter;
	private transient FileWriter fileWriter;
	private List<Car> showRoom;
	private transient Set<Vendor> vendors = new TreeSet<Vendor>();

	public Garage() {
		try {
			myFile = new File("src/resources/cars");
			fileWriter = new FileWriter(myFile, true);
			sc = new Scanner(myFile);
			loadCars();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Car> getShowRoom() {
		return showRoom;
	}

	public Set<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(Set<Vendor> vendors) {
		this.vendors = vendors;
	}

	public void setShowRoom(List<Car> showRoom) {
		this.showRoom = showRoom;
	}

	private void loadCars() {
		this.showRoom = new ArrayList<>();
		while (sc.hasNextLine()) {
			String carDetails = sc.nextLine();
			StringTokenizer st = new StringTokenizer(carDetails, ",");
			Car car = new Car();
			for (int i = 0; i < st.countTokens(); i++) {
				if (i == 0)
					car.setType(st.nextToken().trim());
				if (i == 1)
					car.setModel(st.nextToken().trim());
				if (i == 2) {
					car.setYearOfFabrication(Integer.parseInt(st.nextToken()
							.trim()));
				}
				if (i == 3) { 
					String km = st.nextToken().trim();
					car.setKilometrage(Integer.parseInt(km.substring(0,
							km.length() - 2)));
				}
				if (i == 4) {
					String price = st.nextToken().trim();
					car.setCost(Double.parseDouble(price.substring(0,
							price.length() - 6)));
				}

			}
			showRoom.add(car);
		}

	}

	public void addCar(Car car) throws CarStillPresentException {
		try {
			if (!this.checkIfExists(car)) {
				bfWriter = new BufferedWriter(fileWriter);
				bfWriter.newLine();
				bfWriter.append(car.getType() + ", ");
				bfWriter.append(car.getModel() + ", ");
				bfWriter.append(car.getYearOfFabrication() + ", ");
				bfWriter.append(car.getKilometrage() + "km, ");
				bfWriter.append(car.getCost() + " Euros");
			}else{
				throw new CarStillPresentException();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bfWriter != null) {
				try {
					bfWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void addVendor(Vendor v) {
		this.vendors.add(v);
	}

	private boolean checkIfExists(Car car) {
		for (Car c : this.getShowRoom()) {
			if (c.equals(car)) {
				return true;
			}
		}
		return false;
	}
	
	public void serialize() {
		File garageFile = new File("Garage.ser");
		try (FileOutputStream out = new FileOutputStream(garageFile)) {
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			objOut.writeObject(this);
			objOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

}
