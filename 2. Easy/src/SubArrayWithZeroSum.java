package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/subarray-with-0-sum/0

public class SubArrayWithZeroSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int ip[] = new int[n];
			String s[] = br.readLine().trim().split("\\s+");
			for(int i=0; i< n; i++){
			    ip[i] = Integer.parseInt(s[i]);
			}
			
			System.out.println(checkForSubArrayWithSumZero(ip)? "Yes" : "No");
		}
	}
	
	private static boolean checkForSubArrayWithSumZero(int[] ip){
	    
	   Map<Integer, Integer> map = new HashMap<>();
	   int prefix_sum = 0;
	   for(int i=0; i< ip.length; i++){
	       
	       prefix_sum += ip[i]; 
	       
	       if ( map.containsValue(prefix_sum) || prefix_sum == 0 ) return true; 
	       
	       map.put(i, prefix_sum);
	   }
	   return false;   
	}
}
