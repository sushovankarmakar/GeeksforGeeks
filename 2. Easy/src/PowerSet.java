import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


// https://ide.geeksforgeeks.org/i8TJRLyL8H
// https://practice.geeksforgeeks.org/problems/power-set/0
// https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
// https://www.geeksforgeeks.org/recursive-program-to-generate-power-set/

public class PowerSet {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String ip = br.readLine().trim();
			printPowerSet(ip,n);
			
			//int index = -1; String curr = ""; printPowerSet(ip, index, curr);
			 
		}
	}

	
//	private static void printPowerSet(String inputString, int index, String currentString) { 
//		int n = inputString.length();
//
//		if (currentString != "") System.out.println(currentString);
//
//		for (int i = index + 1; i < n; i++) { 
//			currentString += inputString.charAt(i);
//			printPowerSet(inputString, i, currentString); 
//			currentString = currentString.substring(0, currentString.length() - 1); 
//		} 
//	}
	 

	private static void printPowerSet(String ip, int n) {
		List<String> listOfSubsets = new ArrayList<String>();
		StringBuilder set = new StringBuilder();
		for (int i = 0; i < (1 << n); i++) {
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0) {
					set.append(ip.charAt(j));
				}
			}
			if (set.length() > 0) listOfSubsets.add(set.toString());
			set.setLength(0);
		}
		listOfSubsets.sort(Comparator.naturalOrder()); 
		listOfSubsets.forEach(e -> System.out.print(e + " "));
		System.out.println();
	}
}
