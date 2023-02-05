package nyu.edu;
import java.util.Scanner; // Import Scanner

public class PrimeCalc {

	public static void main(String[] args){
		
		Scanner scn = new Scanner(System.in); 
		System.out.println("Please enter upper bound: ");
		String user_upper = scn.nextLine();
		int upper;
		
		try {upper = Integer.parseInt(user_upper);
			Sieve s = new Sieve(); // Construct Sieve object
			s.primesTo(upper); // Call method to print out primes to upper bound value upper
		}
		
		catch(NumberFormatException e) {
			System.out.println("Please enter an integer.");
		}

	
	}
}
