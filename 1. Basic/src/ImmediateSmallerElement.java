import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class ImmediateSmallerElement {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		/*Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();*/
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			StringBuffer sb = new StringBuffer(); //;
			
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			
			for (int i = 0; i < s.length-1; i++) {
				ip[i] = Integer.parseInt(s[i]);
				ip[i+1] = Integer.parseInt(s[i+1]);
				
				if(ip[i] > ip[i+1]) sb.append(ip[i+1]+" ");/*System.out.print(ip[i+1]+" ");*/
				else 				sb.append("-1 ");/*System.out.print("-1 ");*/
			}
			
			/*for (int i = 0; i < ip.length; i++) {
				ip[i] = sc.nextInt();
			}
			for (int i = 0; i < ip.length-1; i++) {
				if(ip[i] > ip[i+1]) System.out.print(ip[i+1]+" ");
				else 				System.out.print("-1 ");
			}*/
			
			//System.out.println("-1");
			sb.append("-1");
			System.out.println(sb);
		}
		//sc.close();
	}
}
