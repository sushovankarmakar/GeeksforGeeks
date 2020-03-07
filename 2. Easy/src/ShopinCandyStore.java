import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class ShopinCandyStore {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String nk[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
			int ip[] = new int[n];
			String ip_arr[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < ip_arr.length; i++) {
				ip[i] = Integer.parseInt(ip_arr[i]);
			}
			Arrays.sort(ip);
			/*for (int i = 0; i < ip.length; i++) {
				System.out.print(ip[i]+" ");
			}
			System.out.println();*/
			int minCost = 0, maxCost = 0, startIndex = 0, endIndex = ip.length;
			
			for (int i = 0; i < endIndex ; i++) {
				minCost += ip[i];
				endIndex -= k;
			}
			System.out.print(minCost+" ");
			for (int i = ip.length-1; i >= startIndex; i--) {
				maxCost += ip[i];
				startIndex += k;
			}
			System.out.println(maxCost);
		}
	}
}
