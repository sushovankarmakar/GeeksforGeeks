import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://practice.geeksforgeeks.org/problems/subsets/0
// https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
// https://www.geeksforgeeks.org/recursive-program-to-generate-power-set/

public class Subsets {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t--> 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String ip[] = br.readLine().trim().split("\\s+");
			Arrays.sort(ip);
			printNonDuplicateSubsets(ip, n);
		}
	}
	
	private static void printNonDuplicateSubsets(String ip[], int n) {
		Set<String> subsets = new HashSet<String>();
		StringBuilder subset = new StringBuilder();
		for (int i = 0; i < (1 << n); i++) {
			for(int j = 0; j < n; j++) {
				if((i & (1 << j)) > 0) {
					subset.append((ip[j] + " "));
				}
			}
			subsets.add(subset.toString().trim());
			subset.setLength(0);
		}
		List<String> listOfSubsets = new ArrayList<String>();
		listOfSubsets.addAll(subsets);
		listOfSubsets.sort(Comparator.naturalOrder());
		listOfSubsets.forEach(e -> System.out.print("(" + e + ")"));
		System.out.println();
	}
}
