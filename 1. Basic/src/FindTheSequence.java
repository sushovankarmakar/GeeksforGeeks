import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class FindTheSequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			long no1 = 1, no2 = 2, no3 = 5;
			int n = Integer.parseInt(br.readLine());
			if(n <= 3) {
				if(n==0) System.out.println();
				else if(n==1) System.out.println(no1);
				else if(n==2) System.out.println(no1+" "+no2);
				else if(n==3) System.out.println(no1+" "+no2+" "+no3);
			}
			else {
				System.out.print(no1+" "+no2+" "+no3);
				for (int i = 4; i <=n ; i++) {
					long no4 = (no1 + no2 + no3);
					System.out.print(" "+no4);
					no1 = no2;
					no2 = no3;
					no3 = no4;
				}
				System.out.println();
			}
		}
	}
}
