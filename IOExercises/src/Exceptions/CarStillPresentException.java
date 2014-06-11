package Exceptions;

public class CarStillPresentException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarStillPresentException() {
		System.err.println("The Car still exists in showroom");
	}
}
