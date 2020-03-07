import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/merge-sort/
// https://www.geeksforgeeks.org/counting-inversions/

class MergeSort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] =  br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			divide(ip,0,n-1);
			for (int i = 0; i < n; i++) {
				System.out.print(ip[i]+" ");
			}
			System.out.println();
		}
	}
	
	// merge sort algorithm : first divide and then merge
	
	static void divide (int ip[],int l,int r) {
		if(l<r) {
			int m = l + (r-l)/2;
			//System.out.println(l +" " + m);
			divide (ip,l,m);
			//System.out.println(m+1 +" " + r);
			divide (ip,m+1,r);
			merge(ip,l,m,r);
		}
	}
	
	static void merge(int ip[],int l,int m,int r) {
		int range1 = m-l+1, range2 = r-m ;
		//System.out.println(l+" "+m+" "+r);
		
		int leftPart[] = new int[range1+1], rightPart[] = new int[range2+1];
		
		for (int i = 0; i < range1; i++) {
			leftPart[i] = ip[l+i];
		}
		leftPart[range1] = Integer.MAX_VALUE;
		
		for (int i = 0; i < range2; i++) {
			rightPart[i] = ip[m +1 +i];
		}
		rightPart[range2] = Integer.MAX_VALUE;
		
		int i= 0,j=0;
		for (int k = l; k <= r; k++) {
			if( leftPart[i] <= rightPart[j]) {
				ip[k] = leftPart[i];
				i++;
			}
			else {
				ip[k] = rightPart[j];
				j++;
			}
		}	
	}
}
