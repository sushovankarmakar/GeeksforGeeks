import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class IshaanCuriosity {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			long a = Long.parseLong(ip[0]),b = Long.parseLong(ip[1]),ans=0;
			
			String a1 = String.format("%64s", Long.toBinaryString(a)).replace(" ","0"), 
				   b1 = String.format("%64s", Long.toBinaryString(b)).replace(" ","0");
			
			ans = Long.parseLong(bitwiseOR(a1, b1), 2);
			/*for (long i = a+2; i < b; i++) {
				String a2 = String.format("%64s", Long.toBinaryString(ans)).replace(" ", "0");
				String b2 = String.format("%64s", Long.toBinaryString(i)).replace(" ", "0");
				ans = Long.parseLong(bitwiseOR(a2,b2), 2);
			}*/
			System.out.println(ans);
		}
	}
	
	static String bitwiseOR(String a, String b) {
		char ans[] = a.toCharArray();
		boolean bool = false;
		for (int i = 0; i < 64; i++) {
			char aCh = a.charAt(i), bCh = b.charAt(i);
			if(bool) {
				ans[i] = '1';
			}
			else if(aCh!=bCh) {
				ans[i] = '1';
				bool = true;
			}
		}
		return String.valueOf(ans);
	}
}
