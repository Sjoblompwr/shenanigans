package spike;

public class Primes {

	 public static void main(String []args){
		 
	 System.out.println(primes(9));
		 
	 }
	
	public static boolean primes(int num) {
		
		/**
		 * prime representation in2^x ssystem. Is there something that can be used from this?
		 */
		
		if(num == 2)
			return true;
		if(num % 2 != 0)
			for(int i = 3;i <= Math.sqrt(num);i = i + 2) {
				if(num % i == 0) {
					return false;
				}
			}
		else
			return false;
		
		return true;
	}
}
