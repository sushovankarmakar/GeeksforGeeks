import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// https://www.geeksforgeeks.org/count-pairs-with-given-sum/


class CountPairsWithGivenSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+"), s2[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(s1[0]) ,k = Integer.parseInt(s1[1]);
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s2[i]);
			}
			
			// approach: 1  ,  0(n^2) complexity 
			/*
			 * int count=0;
			 * for (int i = 0; i < n-1; i++) {
				for (int j = i+1; j < n; j++) {
					int pairSum = ip[i]+ip[j];
					if(k==pairSum) {
						count++;
					}
				}
			}
			System.out.println(count);
			*/
			
			int countTwice = 0;
			HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
			for (int i = 0; i < n; i++) {
				Integer freq = map.get(ip[i]);
				if(freq !=null) {
					map.put(ip[i], freq+1);
				}
				else {
					map.put(ip[i], 1);
				}
			}
			
			for (int i = 0; i < ip.length; i++) {
				int temp = k-ip[i];
				if(map.containsKey(temp)) {
					countTwice += map.get(temp);
				}
				
				if(temp==ip[i]) countTwice--;
			}
			
			System.out.println(countTwice);
		}
	}
}
