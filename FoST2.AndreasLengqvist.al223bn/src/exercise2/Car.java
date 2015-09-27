package exercise2;


/** 
 * This class handles the creation of a Car.
 * It inherits from the abstract class Vehicle and basically 
 * just contains the cars unique properties to be embark the ferry.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:25, September 20, 2015.
 */
public class Car extends Vehicle {
	
	private static final int VEHICLE_SIZE = 5;
	private static final int MAX_NUMBER_OF_PASSENGERS = 4;
	private static final int VEHICLE_FEE = 100;
	private static final int PASSENGERS_FEE = 15;
		
	/**
	 * Constructor which calls the super class (Vehicle) with 
	 * the Cars unique properties.
	 * 
	 * @param passengers
	 */
	public Car(int passengers) {
		super(VEHICLE_SIZE, VEHICLE_FEE, MAX_NUMBER_OF_PASSENGERS, passengers, PASSENGERS_FEE);
	}
}