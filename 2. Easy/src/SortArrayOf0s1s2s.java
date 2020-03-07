import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/sort-array-0s-1s-2s-simple-counting/
// https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/



class SortArrayOf0s1s2s {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String ip[] = br.readLine().trim().split("\\s+");
			StringBuffer sb0 = new StringBuffer(), sb1 = new StringBuffer(), sb2 = new StringBuffer();
			
			//int count0 = 0, count1 = 0, count2 = 0;
			
			for (int i = 0; i < n; i++) {
				int no = Integer.parseInt(ip[i]);
				if(no == 0) sb0.append(0+" ");
				else if(no == 1) sb1.append(1+" ");
				else if(no == 2) sb2.append(2+" ");
			}
			
			System.out.println(sb0.append(sb1).append(sb2));
			sb0.setLength(0);
			sb1.setLength(0);
			sb2.setLength(0);
		}
	}
}
