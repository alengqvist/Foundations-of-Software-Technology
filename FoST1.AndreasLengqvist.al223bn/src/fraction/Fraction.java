package fraction;


/** 
 * This class handles a Fractional number and all its functions like add, subtract, multiply, divide and more.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 12:14, September 10, 2015.
 */
public class Fraction {
	
	// Member fields.
	private int n;		// Numerator.
	private int d;		// Denominator.

	/**
	 * Constructor which sets the numerator and the denominator to specific values.
	 * 
	 * @param n  numerator
	 * @param d  denominator
	 */
	public Fraction(int n, int d) {
		if (d != 0) {
			this.n = n;
			this.d = d;
			reduce();
		} else {
			System.out.println("The denominator can't be 0!");
			System.exit(1);
		}
	}
	
	/**
	 * Getter.
	 * 
	 * @return	the numerator
	 */
	public int getNumerator() {
		return n;
	}
	
	
	/**
	 * Getter.
	 * 
	 * @return	the denominator
	 */
	public int getDenominator() {
		return d;
	}
	
	
	/**
	 * Reduces the Fraction to its most simplified form.
	 */
	public void reduce() {
		
        // Find the larger of the numerator and denominator.
        int n = this.n;
        int d = this.d;
        int largest;
        
        if (this.n < 0) {
            n = - this.n;
        }
        if (n > d) {
            largest = n;
        }
        else {
            largest = d;
        }

        // Find the largest number that divide the numerator and denominator evenly.
        int gcd = 0;
        for (int i = largest; i >= 2; i--) {
            if (this.n % i == 0 && this.d % i == 0) {
                gcd = i;
                break;
            }
        }

        // Divide the largest common denominator out of numerator and denominator.
        if (gcd != 0) {
            this.n /= gcd;
            this.d /= gcd;
        }
	}
	
	/**
	 * Adds two Fractions.
	 * 
	 * @param f1	the first Fraction
	 * @param f2	the second Fraction
	 * @return		the new added Fraction
	 */
	public Fraction add(Fraction f1, Fraction f2) {
		
		// Change the bottom using multiply or divide, but the same to the top must be applied.
        int n = (f1.getNumerator() * f2.getDenominator()) + (f2.getNumerator() * f1.getDenominator());
        int d = f1.getDenominator() * f2.getDenominator();
        Fraction addedF = new Fraction(n, d);
        addedF.reduce();
		return addedF;
	}
	
	/**
	 * Subtracts two Fractions.
	 * 
	 * @param f1	the first Fraction
	 * @param f2	the second Fraction
	 * @return		the new subtracted Fraction
	 */
	public Fraction subtract(Fraction f1, Fraction f2) {
		
		// Change the bottom using multiply or divide, but the same to the top must be applied.
        int n = (f1.getNumerator() * f2.getDenominator()) - (f2.getNumerator() * f1.getDenominator());
        int d = f1.getDenominator() * f2.getDenominator();
        Fraction subtractedF = new Fraction(n, d);
        subtractedF.reduce();
		return subtractedF;
	}
	
	/**
	 * Multiplies two Fractions.
	 * 
	 * @param f1	the first Fraction
	 * @param f2	the second Fraction
	 * @return		the new multiplied Fraction
	 */
	public Fraction multiply(Fraction f1, Fraction f2) {
		
		// Top times top over bottom times bottom. 
        int n = f1.getNumerator() * f2.getNumerator();
        int d = f1.getDenominator() * f2.getDenominator();
        Fraction multipliedF = new Fraction(n, d);
        multipliedF.reduce();
		return multipliedF;		
	}
	
	/**
	 * Divides two Fractions.
	 * 
	 * @param f1	the first Fraction
	 * @param f2	the second Fraction
	 * @return		the new divided Fraction
	 */
	public Fraction divide(Fraction f1, Fraction f2) {
		
		// Flip the second fraction, then multiply.
        int n = f1.getNumerator() * f2.getDenominator();
        int d = f1.getDenominator() * f2.getNumerator();
        Fraction devidedF = new Fraction(n, d);
        devidedF.reduce();
		return devidedF;
		
	}
	
	/**
	 * Checks if a Fraction is negative.
	 * 
	 * @return	if negative
	 */
	public boolean isNegative() {
		return this.n < 0 || this.d < 0;
	}
	
	/**
	 * Checks if a Fraction is equals to this Fraction.
	 * 
	 * @param f2	the Fraction to compare
	 * @return		if equals
	 */
	public boolean isEqualTo(Fraction f2) {
		return (this.n == f2.n) && (this.d == f2.d);
	}
	
	/**
	 * Returns a string which, if printed, provides a nice looking print out of the Fraction content.
	 * 
	 * @return	a pretty String
	 */
	public String toString() {
		return this.n + "/" + this.d;
	}
}