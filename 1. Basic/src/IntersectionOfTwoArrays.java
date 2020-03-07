import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
//import java.util.Arrays;
/*import java.util.HashMap;*/
import java.util.ArrayList;
import java.util.HashSet;

// https://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/

class IntersectionOfTwoArrays {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+"),
				   s2[] = br.readLine().trim().split("\\s+"),
				   s3[] = br.readLine().trim().split("\\s+");
			int n1 = Integer.parseInt(s1[0]),n2 = Integer.parseInt(s1[1]);
			
			// Approach-1 : Hashing
			/*HashMap<Integer, Integer> map = new HashMap<>();
			ArrayList<Integer> list = new ArrayList<>();
			
			for (int i = 0; i < n1; i++) {
				Integer val = map.get(Integer.parseInt(s2[i]));
				if(val!=null) {
					map.put(Integer.parseInt(s2[i]), val+1);
				}
				else {
					map.put(Integer.parseInt(s2[i]), 1);
				}
			}
			
			for (int i = 0; i < n2; i++) {
				Integer val = map.get(Integer.parseInt(s3[i]));
				if(val!=null) {
					map.put(Integer.parseInt(s3[i]), val+1);
					list.add(Integer.parseInt(s3[i]));
				}
				else {
					map.put(Integer.parseInt(s3[i]), 1);
				}
			}
			Collections.sort(list);
			System.out.println((list.size()==0)?"Zero":String.valueOf(list).replace("[", "").replace("]", "").replaceAll(",",""));*/
			
			
			// Approach-2
			/*StringBuffer sb = new StringBuffer();
			int arr[] = new int[n1+n2];
			for (int i = 0; i < n1; i++) {
				arr[i] = Integer.parseInt(s2[i]);
			}
			for (int i = 0; i < n2; i++) {
				arr[i+n1] = Integer.parseInt(s3[i]);
			}			
			Arrays.sort(arr);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			
			for (int i = 0; i < arr.length-1; i++) {
				if(arr[i]==arr[i+1])
					sb.append(arr[i]+" ");
			}
			System.out.println(sb.length()==0?"Zero":sb);
			sb.setLength(0);*/
			
			// Aprroach-3 
			// https://docs.oracle.com/javase/tutorial/collections/interfaces/set.html
			HashSet<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();;
			for (int i = 0; i < n1; i++) {
				set1.add(Integer.parseInt(s2[i]));
			}
			for (int i = 0; i < n2; i++) {
				set2.add(Integer.parseInt(s3[i]));
			}
			/* s1.retainAll(s2) — transforms s1 into the intersection of s1 and s2. 
			(The intersection of two sets is the set containing only the elements common to both sets.)*/
			set1.retainAll(set2);
			
			ArrayList<Integer> list = new ArrayList<>();
			list.addAll(set1);
			Collections.sort(list);  // sorting before printing
			System.out.println(set1.size()==0?"Zero":String.valueOf(list).replace("[", "").replace("]", "").replaceAll(",",""));
		}
	}
}
