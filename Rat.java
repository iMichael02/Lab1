package Lab1;
/**
 * @overview rational number typr
 *  
 * @author Group5

 */
public class Rat {
	 private int numerator, denominator;


	   //  Constructor: Sets up the rational number by ensuring a nonzero
	   //  denominator and making only the numerator signed.

	   public Rat(int numer, int denom)
	   {
	      if (denom == 0)
	         denom = 1;

	      // Make the numerator "store" the sign
	      if (denom < 0)
	      {
	         numer = numer * -1;
	         denom = denom * -1;
	      }

	      numerator = numer;
	      denominator = denom;

	      reduce();
	   }

	   //-----------------------------------------------------------------
	   //  Returns the numerator of this rational number.
	   //-----------------------------------------------------------------
	   public int getNumerator ()
	   {
	      return numerator;
	   }

	   //-----------------------------------------------------------------
	   //  Returns the denominator of this rational number.
	   //-----------------------------------------------------------------
	   public int getDenominator ()
	   {
	      return denominator;
	   }

	   //-----------------------------------------------------------------
	   //  Returns the reciprocal of this rational number.
	   //-----------------------------------------------------------------
	   public Rat reciprocal ()
	   {
	      return new Rat (denominator, numerator);
	   }

	   //  Determines if this rational number is equal to the one passed
	   //  as a parameter.  Assumes they are both reduced.
	   //-----------------------------------------------------------------
	   public boolean equals (Rat r)
	   {
	      return ( numerator == r.getNumerator() &&
	               denominator == r.getDenominator() );
	   }

	   //  Returns this rational number as a string.
	   public String toString ()
	   {
	      String result;

	      if (numerator == 0)
	         result = "0";
	      else
	         if (denominator == 1)
	            result = numerator + "";
	         else
	            result = numerator + "/" + denominator;
	    
	      return result;
	   }


	   //  Reduces this rational number by dividing both the numerator
	   //  and the denominator by their greatest common divisor.

	   private void reduce ()
	   {
	      if (numerator != 0)
	      {
	         int common = gcd (Math.abs(numerator), denominator);

	         numerator = numerator / common;
	         denominator = denominator / common;
	      }
	   }

	   //  Computes and returns the greatest common divisor of the two
	   //  positive parameters. Uses Euclid's algorithm.

	   private int gcd (int num1, int num2)
	   {
	      while (num1 != num2)
	         if (num1 > num2)
	            num1 = num1 - num2;
	         else
	            num2 = num2 - num1;

	      return num1;
	   }
}
