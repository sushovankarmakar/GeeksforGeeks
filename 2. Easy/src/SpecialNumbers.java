import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpecialNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			
			// below logic is giving time limit exceed 
			/*int no = 0;
			while(n > 1) {
				String s = String.valueOf(no);
				boolean b = true;
				for (int i = 0; i < s.length(); i++) {
					if(s.charAt(i)=='0' || s.charAt(i)=='1' || s.charAt(i)=='2' || 
					   s.charAt(i)=='3' || s.charAt(i)=='4' || s.charAt(i)=='5'  ) {
					}
					else {
						b = false;
						break;
					}
				}
				if(b) n--;
				
				no++;
			}
			System.out.println(no);*/
			
			if(n==1) {
				System.out.println("0");
			}
			else {
				n--;
				String s = "";
				while(n > 0) {
					s = n%6 + s;
					n = n/6;
				}
				System.out.println(s);
			}
		}
	}
}
