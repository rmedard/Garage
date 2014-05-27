package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.output.FileWriterWithEncoding;

import Exceptions.CarStillPresentException;

public class Garage {
	private Scanner sc;
	private static File myFile;
	private BufferedWriter bfWriter;
	private FileWriter fileWriter;
	private List<Car> showRoom = new ArrayList<>();
	private Set<Vendor> vendors = new TreeSet<Vendor>();

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
		while (sc.hasNextLine()) {
			String carDetails = sc.nextLine();
			StringTokenizer st = new StringTokenizer(carDetails, ",");
			Car car = new Car();
			for (int i = 0; i < st.countTokens(); i++) {
				if (i == 0)
					car.setType(st.nextToken());
				if (i == 1)
					car.setModel(st.nextToken());
				if (i == 2) {
					String km = st.nextToken().trim();
					car.setKilometrage(Integer.parseInt(km.substring(0,
							km.length() - 2)));
				}
				if (i == 3) {
					String price = st.nextToken().trim();
					car.setCost(Double.parseDouble(price.substring(0,
							price.length() - 6)));
				}

			}
			showRoom.add(car);
		}

	}

	public void addCarToGarage(Car car) throws CarStillPresentException {
		bfWriter = new BufferedWriter(fileWriter);
		try {
			for(Car c : getShowRoom()){
				if(c.equals(car)){
					throw new CarStillPresentException();
				}else{
					bfWriter.newLine();
					bfWriter.append(car.getType() + ", ");
					bfWriter.append(car.getModel() + ", ");
					bfWriter.append(car.getYearOfFabrication() + ", ");
					bfWriter.append(car.getKilometrage() + "km, ");
					bfWriter.append(car.getCost() + " Euros");
				}
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

}
