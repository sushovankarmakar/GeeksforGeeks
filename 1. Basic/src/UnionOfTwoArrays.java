import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;*/

// https://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/

class UnionOfTwoArrays {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+"),
					s2[] = br.readLine().trim().split("\\s+"),
					s3[] = br.readLine().trim().split("\\s+");
			int n1 = Integer.parseInt(s1[0]), n2 = Integer.parseInt(s1[1]);
			// Approach-1 : Using HashSet
			/*HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < n1; i++) {
				set.add(Integer.parseInt(s2[i]));
			}
			for (int i = 0; i < n2; i++) {
				set.add(Integer.parseInt(s3[i]));
			}
			List<Integer> list = new ArrayList<Integer>();
			list.addAll(set);
			Collections.sort(list);
			System.out.println(String.valueOf(list).replace("[", "").replace("]", "").replaceAll(",", ""));*/
			
			// Approach-2 
			StringBuffer sb = new StringBuffer();
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
			
			boolean b = true;
			for (int i = 0; i < arr.length-1; i++) {
				if(arr[i]==arr[i+1] && b) {
					sb.append(arr[i]+" ");
					b = false;
				}
				else if(arr[i]!=arr[i+1]) {
					b = false;
				}
			}
			System.out.println(sb);
			
			// Approach-3
			// https://docs.oracle.com/javase/tutorial/collections/interfaces/set.html
			/*HashSet<Integer> set1 = new HashSet<>(),set2 = new HashSet<>();
			for (int i = 0; i < n1; i++) {
				set1.add(Integer.parseInt(s2[i]));
			}
			for (int i = 0; i < n2; i++) {
				set2.add(Integer.parseInt(s3[i]));
			}
			set1.addAll(set2);
			ArrayList<Integer> list = new ArrayList<>();
			list.addAll(set1);
			Collections.sort(list);
			System.out.println(String.valueOf(list).replace("[", "").replace("]", "").replaceAll(",", ""));*/
		}
	}
}
