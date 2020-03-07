import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class MinimizeStringValue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			char ip[] = br.readLine().trim().toCharArray();
			int k = Integer.parseInt(br.readLine().trim());
			int freq[] = new int[26];
			for (int i = 0; i < ip.length; i++) {
				char ch = ip[i];
				freq[ch-'a']++;
			}
			
			for (int i = 0; i < freq.length; i++) {
				System.out.print(freq[i]+" ");
			}
			System.out.println();
			
			if(k >= ip.length) {
				System.out.println("0");
			}
			else {
				
				/*	We can use an array to store frequency of each character.
					
					Then do following k times
					1) Find a maximum frequency character and decrements its frequency by 1. 

					After k iterations print the value function you get by remaining characters.
				*/

								
				while(k-->0) {
					Arrays.sort(freq);
					freq[25]--;
				}
				
				int minStringValue = 0; 
				
				for (int i = 0; i < freq.length; i++) {
					
					minStringValue += (freq[i]*freq[i]) ; 
				}
				System.out.println(minStringValue);
			}
		}
	}
}
