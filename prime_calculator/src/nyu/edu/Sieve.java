package nyu.edu;

public class Sieve {
	// Private properties
	private LinkedQueue<Integer> numbers;
	private LinkedQueue<Integer> primes;
	private LinkedQueue<Integer> temp;
	
	public Sieve(){ // Constructor instantiates empty linked queues
		numbers = new LinkedQueue<Integer>(); 
		primes = new LinkedQueue<Integer>();
		temp = new LinkedQueue<Integer>();
	}
		
	/**
	   * Prints primes up to and including int upper.
	   * @param upper the upper bound of this list of primes
	   */
	public void primesTo(int upper)  {
		if(upper < 2) // If a number is smaller than 2 throw exception
			throw new IllegalArgumentException ("Error: Input must be a number greater than 2.");
			
		String output = "Primes up to " + upper + " are: "; // Initialize string to append output to
		int num = 2; // num will be the number we will be dividing by. We start at 2.
			
		for(int i = 2; i<=upper;i++) { numbers.enqueue(i);} // enqueue all numbers from 2 to the upper bound to the queue numbers
			
		while(num <= Math.sqrt(upper)) { // While divisor num is smaller than the square root of our upper bound int
			primes.enqueue(numbers.dequeue()); // Enqueue to primes
	
			while(!numbers.isEmpty()){ // Go through all the numbers in numbers
				if(numbers.first() % num == 0) {numbers.dequeue();} // dequeue the ones divisible by num since they clearly won't be prime
				else {temp.enqueue(numbers.dequeue());} // enqueue to temp the co-prime numbers and dequeue from numbers
			}
	
			while(!temp.isEmpty()) { // copy temp nodes to numbers
		        numbers.enqueue(temp.first());
		        temp.dequeue();
		       }
				
			num = numbers.first(); // set the next divisor to what's next in numbers
				
		}
		
		// By the time we have broken out of the loop, numbers will contain only primes
		// We copy these primes into primes
		while(numbers.size() != 0) {primes.enqueue(numbers.dequeue());}
			
		// We loop through primes and append each number to the output
		while(!primes.isEmpty()) { 
			if(primes.size() > 1) {output +=  primes.dequeue() + ", ";}
			else {output +=  primes.dequeue();}
			
		}
			
		System.out.println(output); // print out answer	
		}
			
	}
			
		
	
		
	


