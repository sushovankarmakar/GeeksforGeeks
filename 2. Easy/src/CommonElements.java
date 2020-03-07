import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Iterator;*/

// https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/

// two types of algo, both are working fine but second one didn't work cause GFG didn't provide non-decreasing input

class CommonElements {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String n1n2n3[] = br.readLine().trim().split("\\s+");
			int n1 = Integer.parseInt(n1n2n3[0]), n2 = Integer.parseInt(n1n2n3[1]), n3 = Integer.parseInt(n1n2n3[2]);
			
			String 	A[] = br.readLine().trim().split("\\s+"), 
					B[] = br.readLine().trim().split("\\s+"), 
					C[] = br.readLine().trim().split("\\s+");
			
			// 1. Using Set Intersection
			/*Set<Long> set1 = new LinkedHashSet<>(), set2 = new LinkedHashSet<>(), set3 = new LinkedHashSet<>();
			
			for (int i = 0; i < n1; i++)	set1.add(Long.parseLong(A[i]));
			for (int i = 0; i < n2; i++)	set2.add(Long.parseLong(B[i]));
			for (int i = 0; i < n3; i++)	set3.add(Long.parseLong(C[i]));
			
			set1.retainAll(set2);
			set1.retainAll(set3);
			
			if(set1.isEmpty()) System.out.println("-1");
			else {
				Iterator <Long> itr = set1.iterator();
				while(itr.hasNext()) {
					System.out.print(itr.next()+" ");
				}
				System.out.println();
			}*/
			
			// 2. using no extra space
			
			Long a[] = new Long[n1], b[] = new Long[n2], c[] = new Long[n3]; 
			
			for (int i = 0; i < n1; i++) 	a[i] = Long.parseLong(A[i]);
			for (int i = 0; i < n2; i++)	b[i] = Long.parseLong(B[i]);
			for (int i = 0; i < n3; i++)	c[i] = Long.parseLong(C[i]);
			
			int i = 0, j = 0, k = 0;
			StringBuilder sb = new StringBuilder();
			
			while( (i < n1) && (j < n2) && (k < n3) ) {
				
				if( a[i]==b[j] && b[j]==c[k]) {
					sb.append(a[i]+" ");
					i++; j++; k++;
				}
				else if(a[i] <b[j]) i++;
				else if(b[j] < c[k]) j++;
				else k++;
			}
			System.out.println( sb.length() > 0 ? sb : "-1");
			sb.setLength(0);
		}
	}
}
