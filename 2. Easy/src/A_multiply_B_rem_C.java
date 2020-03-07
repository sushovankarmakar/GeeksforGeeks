import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/compute-abc-such-that-ac-bc-can-be-beyond-range/

class A_multiply_B_rem_C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			long a = Long.parseLong(ip[0]), b = Long.parseLong(ip[1]), c = Long.parseLong(ip[2]);
			a = a % c; 
			b = b % c;
			System.out.println((a*b)%c);
		}
	}
}

/*  Use the Property Of Modulo
	(a*b)%c =((a%c)*(b%c))%c
*/
