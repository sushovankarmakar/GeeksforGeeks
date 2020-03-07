import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class JavaOperatorsArithmetic {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			int a = Integer.parseInt(ip[0]),b = Integer.parseInt(ip[1]),c = Integer.parseInt(ip[2]);
			if( ((b*b)-(4*a*c)) < 0 ) {
				System.out.println("COMPLEX");
			}
			else {
				double root1 = ( -b - Math.sqrt((b*b)-(4*a*c)) ) / (2*a);
				double root2 = ( -b + Math.sqrt((b*b)-(4*a*c)) ) / (2*a);
				
				//arranging the output in ascending order
				if((float)root1 <= (float)root2) {
					System.out.println((float)root1+" "+(float)root2);
				}
				else {
					System.out.println((float)root2+" "+(float)root1);
				}
			}
		}
	}
}
