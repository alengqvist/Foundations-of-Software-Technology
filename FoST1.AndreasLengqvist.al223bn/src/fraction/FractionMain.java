package fraction;


/** 
 * This class contains a couple of tests for testing Fraction.java
 * 
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 12:14, September 10, 2015.
 */
public class FractionMain {

	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {

		// Testing Constructor.
		Fraction fraction = new Fraction(1, 3);
		
		// Testing getNumerator() and getDenominator().
		System.out.println("Testing fraction.getNumerator() -> " + fraction.getNumerator());
		System.out.println("Testing fraction.getDenominator() -> " + fraction.getDenominator());
		
		// Testing toString().
		System.out.println("Testing fraction.toString() -> " + fraction.toString());
		
		// Testing add().
		Fraction addF = new Fraction(1, 4);
		Fraction addedFraction = fraction.add(fraction, addF);
		System.out.println("Testing fraction.add() -> " + fraction.toString() + " + " + addF.toString() + " = " + addedFraction.toString());
		
		// Testing subtract().
		Fraction subF = new Fraction(1, 4);
		Fraction subtractedFraction = fraction.subtract(fraction, subF);
		System.out.println("Testing fraction.subtract() -> " + fraction.toString() + " - " + subF.toString() + " = " + subtractedFraction.toString());
	
		// Testing divide().
		Fraction divideF = new Fraction(1, 4);
		Fraction dividedFraction = fraction.divide(fraction, divideF);
		System.out.println("Testing fraction.divide() -> " + fraction.toString() + " / " + divideF.toString() + " = " + dividedFraction.toString());

		// Testing multiply().
		Fraction multiplyF = new Fraction(5, 1);
		Fraction multipliedFraction = fraction.multiply(fraction, multiplyF);
		System.out.println("Testing fraction.multiply() -> " + fraction.toString() + " * " + multiplyF.toString() + " = " + multipliedFraction.toString());
	
		// Testing isEqualTo().
		Fraction equalF = new Fraction(3, 9);
		System.out.println("Testing fraction.isEqualTo() -> " + fraction.toString() + " is equal to " + equalF.toString() + " = " + fraction.isEqualTo(equalF));
	
		// Testing isNegatice().
		Fraction negativeF = new Fraction(5, 10);
		System.out.println("Testing fraction.isNegative() -> " + negativeF.toString() + " is negative = " + negativeF.isNegative());
	}
}