import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Arrays;

public class ChocoDistributionProb {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().trim().split("\\s+");
			int m = Integer.parseInt(br.readLine());
			
			long ip[] = new long[n];
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Integer.parseInt(s[i]); 
			}
			//Arrays.sort(ip);
			/*for (int i = 0; i < ip.length; i++) {
				System.out.print(ip[i]+" "); 
			}
			System.out.println();*/
			quicksort(ip,0,n-1);
			long minDiff = Long.MAX_VALUE;
			for (int i = 0; i <= (ip.length-m); i++) {
				
				long d = ip[i+m-1]-ip[i];
				//System.out.println("d "+d);
				if(d < minDiff) {
					minDiff = d;
					//System.out.println("min "+ minDiff);
				}
			}
			
			System.out.println(minDiff);
		}
	}

	static void quicksort(long[] ip,int p,int r) {
		if(p<r) {
			int q = partition(ip, p, r);
			quicksort(ip, p, q-1);
			quicksort(ip, q+1, r);
		}
	}
	
	static int partition(long[] ip, int p,int r) {
		long x = ip[r];
		int i = p-1;
		for (int j = p; j <= (r-1); j++) {
			if(ip[j] <= x) {
				i++;
				exchange(ip,i,j);
			}
		}
		exchange(ip,i+1,r);
		return (i+1);
	}

	static void exchange(long[] ip, int i, int j) {
		long temp = ip[i];
		ip[i] = ip[j];
		ip[j] = temp;
	}
}
