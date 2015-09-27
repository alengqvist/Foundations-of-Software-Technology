package exercise2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/** 
 * This class works like an ferry.
 * Implements the Ferry interface which tells it how to work.
 *
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:25, September 20, 2015.
 */
public class FerryOfAllFerries implements Ferry {

	private static final int MAX_NUMBER_OF_PASSENGERS = 200;
	private static final int MAX_NUMBER_OF_VEHICLES = 200;
 	private List<Passenger> passengers = new ArrayList<Passenger>();
 	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
 	private int earnedMoney;

	/**
	 * Number of passengers on board.
	 * 
	 * @return passengersCount
	 */
	@Override
	public int countPassengers() {
		return passengers.size();
	}

	/**
	 * Used vehicle space:
	 *   One Bicycle = 1
	 *   One Car = 5
	 *   One Bus = 20
	 *   One Lorry = 40
	 * 
	 * @return vehicleCount
	 */
	@Override
	public int countVehicleSpace() {
		int count = 0;
		for (Vehicle v : vehicles) {
			count += v.getVehicleSize();
		}
		return count;
	}

	/**
	 * Earned money.
	 * 
	 * @return earnedMoney
	 */
	@Override
	public int countMoney() {
		return earnedMoney;
	}

	/**
	 * Vehicle iterator. (However, not needed when using approach with ArrayList)
	 * 
	 * @return VehicleIterator
	 */
	@Override
	public Iterator<Vehicle> iterator() {
		return new Iterator<Vehicle>() {
			private int count = 0;
			public Vehicle next() {return vehicles.get(count++);}
			
			public boolean hasNext() {return count < vehicles.size();}
			
			public void remove() {
				throw new RuntimeException("remove() is not implemented");
			}
		};
	}

	/**
	 * Embark vehicle, warning if not enough space.
	 * 
	 * @param v
	 */
	@Override
	public void embark(Vehicle v) {
		
		// If vehicle already embarked. (Nothing will happen) 
		// Can also use a hasEmbarked boolean which is set depending on if it has embarked or not.
		// Or should we use a registration number? The instruction is again too vague, but this time I
		// will just go with the easiest possible solution. 
		// Which is -> If the Vehicles-object has already been embarked, don't let it embark again.
		if (!vehicles.contains(v)) {
			
			// If not space for.
			if (!hasSpaceFor(v)) {
				throw new IndexOutOfBoundsException("The maximum number of vehicles on the ferry is reached.");
			}
			
			// Embark the passenger of the vehicle.
			for (Passenger passenger : v.getPassengers()) {
				embark(passenger);
			}
			
			// Pay vehicle fee.
			payFee(v.getVehicleFee());
			
			vehicles.add(v);
		}
	}

	/**
	 * Embark passenger, warning if not enough room
	 * 
	 * @param p
	 */
	@Override
	public void embark(Passenger p) {
		
		// If not has room for.
		if (!hasRoomFor(p)) {
			throw new IndexOutOfBoundsException("The maximum number of passenger on the ferry is reached.");
		}
		
		// Pay passenger fee.
		payFee(p.getFee());
		
		passengers.add(p);
	}

	/**
	 * Clear (empty) ferry. 
	 */
	@Override
	public void disembark() {
		
		//vehicles.clear();	// Is this enough? 
		
		// Otherwise remove the first vehicle all the time until its empty.
		while (!vehicles.isEmpty()) {
			vehicles.remove(0);
		}
		passengers.clear();
	}

	/**
	 * Checks if we can embark Vehicle.
	 * 
	 * @param v
	 * 
	 * @return if has space for
	 */
	@Override
	public boolean hasSpaceFor(Vehicle v) {
		return (v.getVehicleSize() + countVehicleSpace()) <= MAX_NUMBER_OF_VEHICLES;
	}
	
	/**
	 * Checks if we can embark Passenger.
	 * 
	 * @param p
	 * 
	 * @return if has room for
	 */
	@Override
	public boolean hasRoomFor(Passenger p) {
		return passengers.size() < MAX_NUMBER_OF_PASSENGERS;
	}
	
	/**
	 * Pays the fee for Passenger or Vehicle.
	 * 
	 * @param fee
	 */
	public void payFee(int fee) {
		earnedMoney += fee;
	}
	
	/**
	 * Returns a pretty string of the ferry content as a list.
	 * 
	 * @return pretty string
	 */
	@Override
	public String toString() {
		
        StringBuilder sb = new StringBuilder();
		
        String prefix = "\n";
        
        if (vehicles.isEmpty()) {
        	return "Ferry is empty, disembarked or what ever you want it to be.";
        }
        
		for (Vehicle v : vehicles) {
			sb.append(prefix);
            sb.append(v.toString());
		}
		return sb.toString();
	}
}