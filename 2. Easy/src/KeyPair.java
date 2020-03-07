import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

class KeyPair {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(s[0]);
			int input[] = new int[n];
			int x = Integer.parseInt(s[1]);
			String in[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < in.length; i++) {
				input[i] = Integer.parseInt(in[i]);
			}
			boolean b = false;
			/*can't use hashmap, because 4-2 = 2
			 * hashmap won't work in case of below test cases.
			 * 5 4
			   1 2 5 6 7
			 * */
			
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				int temp = x - input[i];
				if(set.contains(temp)) {
					//System.out.println(input[i]);
					b = true;
					break;
				}
				set.add(input[i]);
			}
			
			
			
			/*for (int i = 0; i < n; i++) {
				//System.out.print(map.get(input[i])+" ");
			}*/
			
			if(b) System.out.println("Yes");
			else  System.out.println("No");
		}
	}
}


//solution link: https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/


// simple approach
/*outerloop:
for (int i = 0; i < n; i++) {
	int a = input[i];
	for (int j = i; j < n; j++) {
		if(a+input[j]==x) {
			b = true;
			break outerloop;
		}
	}
}*/
