package exercise2;

import java.util.ArrayList;
import java.util.List;


/** 
 * This abstract base class of all types of Vehicles on a ferry.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:25, September 20, 2015.
 */
public abstract class Vehicle {
	
	private static final int MIN_NUMBER_OF_PASSENGERS = 1;
	
	protected List<Passenger> passengers = new ArrayList<Passenger>();
	protected int vehicleSize;
	protected int vehicleFee;
	
	/**
	 * Constructor which is called by all subclasses.
	 * Handles the creation of a Vehicle and also adds its passengers to it.
	 * 
	 * @param vehicleSize
	 * @param vehicleFee
	 * @param MAX_NUMBER_OF_PASSENGERS
	 * @param numberOfPassengers
	 * @param passengerFee
	 */
	public Vehicle(int vehicleSize, int vehicleFee, int MAX_NUMBER_OF_PASSENGERS, int numberOfPassengers, int passengerFee) {
		
		// If the passengers cannot fit in the Vehicle.
		if (numberOfPassengers < MIN_NUMBER_OF_PASSENGERS || numberOfPassengers > MAX_NUMBER_OF_PASSENGERS) {
			throw new IndexOutOfBoundsException("This vehicle can only take " + MIN_NUMBER_OF_PASSENGERS + " - " + MAX_NUMBER_OF_PASSENGERS + " passenger.");
		}
		
		this.vehicleSize = vehicleSize;
		this.vehicleFee = vehicleFee;
		
		// Add the number of passengers to the car.
		for (int i = 0; i < numberOfPassengers; i++) {
			this.passengers.add(new Passenger(passengerFee));
		}
	}
	
	/**
	 * Get the size of the Vehicle.
	 * 
	 * @return vehicleSize
	 */
	public int getVehicleSize() {
		return this.vehicleSize;
	}
	
	/**
	 * Get the fee of the Vehicle.
	 * 
	 * @return vehicleFee
	 */
	public int getVehicleFee() {
		return this.vehicleFee;
	}
	
	/**
	 * Get the list of passengers.
	 * 
	 * @return passengers
	 */
	public List<Passenger> getPassengers() {
		return this.passengers;
	}
	
	/**
	 * Returns a pretty string of the Vehicle content in this case the subclass name.
	 * 
	 * @return pretty string
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}