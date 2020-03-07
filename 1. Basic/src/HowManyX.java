import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class HowManyX {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int x = Integer.parseInt(br.readLine());
			String s[] = br.readLine().trim().split("\\s+");
			int l = Integer.parseInt(s[0]);  // taking the lower bound
			int u = Integer.parseInt(s[1]);  // taking the upper bound
			
			int count = 0;
			for (int i = l+1; i < u; i++) {
				
				int no=i;
				int digit=0;   // checking if every digit of each numbers within the range is equal to x or not, if equal then count++ 
				while(no!=0) {
					digit = no%10;
					if(digit==x) {
						count++;
					}
					no = no/10;
				}
			}
			
			System.out.println(count);
 		}
	}
}
