import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class EqualSumAndProduct {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()) , count = 0;
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = i; j <= n; j++) {
					if(true == checkEqualSumAndProduct(ip,i,j)) {
						count++;
					}
					//System.out.println();
				}
				
			}
			System.out.println(count);
		}
	}

	static boolean checkEqualSumAndProduct(int[] ip, int i, int j) {
		
		int sum = 0, product = 1;
		for (int k = i; k < j; k++) {
			sum += ip[k];
			product *= ip[k];
		}
		
		if(sum==product)  return true;
		return false;
	}
}
