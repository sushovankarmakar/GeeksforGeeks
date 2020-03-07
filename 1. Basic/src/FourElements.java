import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//INCOMPLETE UNSOLVED

class FourElements {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			int x = Integer.parseInt(br.readLine().trim());
			Arrays.sort(ip);
			for (int i = 0; i < ip.length; i++) {
				System.out.print(ip[i]+" ");
			}
			System.out.println();
			int sum = 0;
			boolean b = false;
			for (int i = 0; i < ip.length-3; i++) {
				sum = ip[i] + ip[i+1] + ip[i+2];
				for (int j = ip.length-1; j > (i+2); j--) {
					System.out.println("sum: "+ip[i] + ip[i+1] + ip[i+2]+ ip[j]+"="+(sum+ip[j]));
					if(x == sum+ ip[j]) {
						b = true;
						break;
					}
				}
			}
			System.out.println((b)?"1":"0");
		}
	}
}
