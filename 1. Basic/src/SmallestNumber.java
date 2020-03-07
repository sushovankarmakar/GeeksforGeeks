import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class SmallestNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String sd[] = br.readLine().trim().split("\\s+");
			int s = Integer.parseInt(sd[0]) , d = Integer.parseInt(sd[1]);
			int l_lim= 0, r_lim=0;
			
			if(d==1)      { l_lim= 1; r_lim=9;}
			else if(d==2) { l_lim= 10; r_lim=99;}
			else if(d==3) { l_lim= 100; r_lim=999;}
			else if(d==4) { l_lim= 1000; r_lim=9999;}
			else if(d==5) { l_lim= 10000; r_lim=99999;}
			else if(d==6) { l_lim= 100000; r_lim=999999;}
			
			System.out.println(findSmallestNo(s, l_lim, r_lim));
		}
	}
	static int findSmallestNo(int s, int l_lim , int r_lim) {
		int op=-1;
		for (int i = l_lim; i <= r_lim; i++) {
			if(s == findSumDigits(i)) {
				op = i;
				break;
			}
		}
		return op;
	}
	
	static int findSumDigits(int n) {
		int sum=0;
		while(n!=0) {
			sum += (n % 10);
			n /= 10;
		}
		return sum;
	}
}
