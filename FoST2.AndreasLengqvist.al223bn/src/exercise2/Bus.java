package exercise2;


/** 
 * This class handles the creation of a Bus.
 * It inherits from the abstract class Vehicle and basically 
 * just contains the bus unique properties to be embark the ferry.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:25, September 20, 2015.
 */
public class Bus extends Vehicle {
	
	private static final int VEHICLE_SIZE = 20;
	private static final int MAX_NUMBER_OF_PASSENGERS = 20;
	private static final int PASSENGERS_FEE = 10;
	private static final int VEHICLE_FEE = 200;
		
	/**
	 * Constructor which calls the super class (Vehicle) with 
	 * the Bus unique properties.
	 * 
	 * @param passengers
	 */
	public Bus(int passengers) {
		super(VEHICLE_SIZE, VEHICLE_FEE, MAX_NUMBER_OF_PASSENGERS, passengers, PASSENGERS_FEE);
	}
}