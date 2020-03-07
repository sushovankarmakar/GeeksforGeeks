import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Smallest_and_second_smallest_element {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int size = Integer.parseInt(br.readLine());
			String[] ip = br.readLine().trim().split("\\s+");
			
			int ss = Integer.MAX_VALUE;
			int s = Integer.parseInt(ip[0]);
			for (int i = 1; i < size; i++) {
				if(s > Integer.parseInt(ip[i]) ) {
					ss = s;
					s = Integer.parseInt(ip[i]);
				}
				else if(s==Integer.parseInt(ip[i])) {
					
				}
				else if(ss > Integer.parseInt(ip[i])) {
					ss = Integer.parseInt(ip[i]);
				}
			}
			System.out.println((ss == Integer.MAX_VALUE)?"-1":(s+" "+ss));
		}	
	}
}
