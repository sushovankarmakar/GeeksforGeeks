import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// this question was based on "Inclusion–exclusion principle".

//helpful links
// https://math.stackexchange.com/questions/688019/what-is-the-inclusion-exclusion-principle-for-4-sets
// https://www.hackerearth.com/practice/math/combinatorics/inclusion-exclusion/tutorial/
// https://www.geeksforgeeks.org/inclusion-exclusion-principle-and-programming-applications/
// https://practice.geeksforgeeks.org/editorial.php?pid=1016

class NumThatAreNotDivisible {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			long n = Long.parseLong(br.readLine().trim());
			//approach - 1, time limit exceed
			/* int count = 0;
			 * while(n>10) {
				if( (n%2!=0) && (n%3!=0) && (n%5!=0) && (n%7!=0) ) {
					System.out.println("n = "+n);
					count++;
				}
				n--;
			}
			System.out.println(count+1);*/
			
			// approach-2
			
			long ans = n - ( (n/2)+(n/3)+(n/5)+(n/7)
							-(n/6)-(n/10)-(n/14)-(n/15)-(n/21)-(n/35)
							+(n/30)+(n/42)+(n/70)+(n/105)
							-(n/210)
							);
			System.out.println(ans);
		}
	}
}
