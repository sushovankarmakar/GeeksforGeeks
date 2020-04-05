import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1/

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int ip[] = new int[n];
			String s[] = br.readLine().trim().split("\\s+");
			for(int i=0; i< n; i++){
			    ip[i] = Integer.parseInt(s[i]);
			}
			
			System.out.println(removeDuplicatesFromSortedArray(ip));
		}
	}
	
	
	private static int removeDuplicatesFromSortedArray(int a[]) {
		int i = 0, j = 1;
	    while(j < a.length) {
	
		    if( a[i] != a[j] ) {
			    a[++i] = a[j];
		    }
		    j++;
	    }
	    return i+1;
	}
}


