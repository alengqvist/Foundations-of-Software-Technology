package exercise2;


/** 
 * This class handes the creation of a Passenger.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 13:25, September 20, 2015.
 */
public class Passenger {
	
	private static final int FEE_WITHOUT_VEHICLE = 20;
	private int fee;
	
	/**
	 * Constructor 1.
	 */
	public Passenger() {
		this.fee = FEE_WITHOUT_VEHICLE;
	}
	
	/**
	 * Constructor 2.
	 * 
	 * @param fee
	 */
	public Passenger(int fee) {
		this.fee = fee;
	}
	
	/**
	 * Gets the passenger fee.
	 * 
	 * @param fee
	 */
	public int getFee() {
		return this.fee;
	}
}