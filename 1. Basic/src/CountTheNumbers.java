import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/count-numbers-from-1-to-n-that-have-4-as-a-a-digit/


class CountTheNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()),count = 0, num = 1;
			
			while(num <= n) {
				
				boolean b = true;
				int temp = num;
				
				while( temp > 0 ) {
					int d = temp % 10;
					if(d==1 || d==2 ||d==3 || d==4 || d==5 ) {
						temp = temp / 10;
					}
					else {
						b = false;
						break;
					}
				}
				if(b)count++;
				num++;
			}
			System.out.println(count);
		}
	}
}
