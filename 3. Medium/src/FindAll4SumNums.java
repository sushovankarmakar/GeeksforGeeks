import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.LinkedHashSet;

class FindAll4SumNums {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String nk[] = br.readLine().trim().split("\\s+"), arr[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(arr[i]);
			}
			Arrays.sort(ip);
			
			allFourSumNumbers(ip,k);
		}
	}
	
	static void allFourSumNumbers(int ip[], int k) {
		int n = ip.length;
		
		Set<String> set = new LinkedHashSet<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n-3; i++) {
			for (int j = i+1; j < n-2; j++) {
				
				int l = j+1, r = n-1;
				while(l < r) {
					if(ip[i]+ip[j]+ip[l]+ip[r]== k) {
						String tempString = (ip[i]+" "+ip[j]+" "+ip[l]+" "+ip[r]+" $");
						if(!set.contains(tempString)) {
							set.add(tempString);
							sb.append(tempString);
						}
						l++; r--;
					}
					else if ( ip[i]+ip[j]+ip[l]+ip[r] > k ) r--;
					else l++;
				}
			}
		}
		System.out.println(sb.length() > 0 ? sb : "-1");
		sb.setLength(0);
	}
}
