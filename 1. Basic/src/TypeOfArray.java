import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/type-array-maximum-element/

class TypeOfArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i=0; i < n; i++ ) {
				ip[i] = Integer.parseInt(s[i]);
			}
			int maxElement = Integer.MIN_VALUE, maxElementPos = -1,
					minElement = Integer.MAX_VALUE, minElementPos = -1;
			
			for (int i = 0; i < n; i++) {
				if( ip[i] > maxElement) {
					maxElement = ip[i];		maxElementPos = i;
				}
				if( ip[i] < minElement) {
					minElement = ip[i];		minElementPos = i;
				}
			}
		
			System.out.print(maxElement+" ");
			
			if( Math.abs(maxElementPos-minElementPos) == n-1 ) {
				if( maxElementPos == n-1 ) System.out.println("1"); // ascending
				else System.out.println("2"); // descending
			}
			else {
				if( (maxElementPos-minElementPos) > 0) System.out.println("3");   // descending rotated
				else System.out.println("4");   // ascending rotated
			}
		}
	}
}
