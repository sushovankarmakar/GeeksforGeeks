import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/check-door-open-closed/

/*
A gate will be open in the end if and only if it has an odd number of factors.

This is so because each gate is visited by its factors only. 
For example 100 will be visited by 1,2,4,5,10,20,25,50,100 in that order.  

Only perfect squares have an odd number of factors. 

Hence the answer for N will be the number of perfect squares less than or equal to N.
*/


public class NoOfOpenDoors {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			long n = Long.parseLong(br.readLine().trim());
			System.out.println((long)Math.sqrt(n));
		}
	}
}
