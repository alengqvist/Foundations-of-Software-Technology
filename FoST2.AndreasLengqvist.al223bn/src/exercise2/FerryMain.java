package exercise2;

/** 
 * This class tests the Ferry.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 14:25, September 20, 2015.
 */
public class FerryMain {

	public static void main(String[] args) {

		FerryOfAllFerries ferry = new FerryOfAllFerries();
		
	// SESSION 1.
		
		// Embark 15 cars with 1 Passenger each.
		for (int i = 0; i < 15; i++) {
			try {
				ferry.embark(new Car(1));
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}
		
		// Embark 1 lorry with 2 Passenger.
		try {
			ferry.embark(new Lorry(2));
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		// Embark 4 buses with 10 Passenger each.
		for (int i = 0; i < 4; i++) {
			try {
				ferry.embark(new Bus(10));
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}
		
		// Embark 100 passenger.
		for (int i = 0; i < 100; i++) {
			try {
				ferry.embark(new Passenger());				
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}
		
		// Embark 6 bicycles (but as for the limit of 40 vehicles only 5 will get embarked.
		for (int i = 0; i < 6; i++) {
			try {
				ferry.embark(new Bicycle());
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Vehicles onboard: (listed)" + ferry.toString());
		System.out.println("There are " + ferry.countPassengers() + " passengers onboard the ferry.");
		System.out.println("Money earned (total since Session 1): " + ferry.countMoney());
		
	// FERRY ARRIVED THE DESTINATION.
		
		ferry.disembark();
		System.out.println("Disembarking...");
		System.out.println("Vehicles onboard: (listed) " + ferry.toString());
		System.out.println("There are now " + ferry.countPassengers() + " passengers onboard the ferry.");
		

	// SESSION 2...
		
		
	}
}