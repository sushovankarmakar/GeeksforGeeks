import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class ClosestNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(ip[0]), m = Integer.parseInt(ip[1]);
			int i = 0;
			boolean b = true;
			while(b) {
				if( ((n-i)%m==0) && ((n+i)%m==0)  ) {
					if( Math.abs(n+i) > Math.abs(n-i) ) {
						System.out.println(n+i);
					}
					else {
						System.out.println(n-i);
					}
					b = false;
				}
				else if( (n-i)%m==0 ){
					System.out.println(n-i);
					b = false;
				}
				else if( (n+i)%m==0 ){
					System.out.println(n+i);
					b = false;
				}
				
				i++;
			}
		}
	}
}
