package exercise2;


/** 
 * This class handles the creation of a Lorry.
 * It inherits from the abstract class Vehicle and basically 
 * just contains the lorries unique properties to be embark the ferry.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:25, September 20, 2015.
 */
public class Lorry extends Vehicle {
	
	private static final int VEHICLE_SIZE = 40;
	private static final int MAX_NUMBER_OF_PASSENGERS = 2;
	private static final int PASSENGERS_FEE = 15;
	private static final int VEHICLE_FEE = 300;

	/**
	 * Constructor which calls the super class (Vehicle) with 
	 * the Lorries unique properties.
	 * 
	 * @param passengers
	 */
	public Lorry(int passengers) {
		super(VEHICLE_SIZE, VEHICLE_FEE, MAX_NUMBER_OF_PASSENGERS, passengers, PASSENGERS_FEE);
	}
}