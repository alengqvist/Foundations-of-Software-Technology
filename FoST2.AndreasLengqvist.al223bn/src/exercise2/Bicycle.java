package exercise2;

/** 
 * This class handles the creation of a Bicycle.
 * It inherits from the abstract class Vehicle and basically 
 * just contains the bicycles unique properties to be embark the ferry.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:25, September 20, 2015.
 */
public class Bicycle extends Vehicle {

	private static final int VEHICLE_SIZE = 1;
	private static final int MAX_NUMBER_OF_PASSENGERS = 1;
	private static final int PASSENGERS_FEE = 0;
	private static final int VEHICLE_FEE = 40;
		
	/**
	 * Constructor which calls the super class (Vehicle) with 
	 * the Bicycles unique properties.
	 */
	public Bicycle() {
		super(VEHICLE_SIZE, VEHICLE_FEE, MAX_NUMBER_OF_PASSENGERS, 1, PASSENGERS_FEE);
	}
}