import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;

class PairSumExistence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int sum = Integer.parseInt(br.readLine().trim());
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			System.out.println(sumExists(ip, n, sum));
		}
	}
	
	static int sumExists(int arr[], int n, int sum)
    {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i< n; i++ ){
            if(set.contains(arr[i])) {
                return 1;
            }
            else {
                set.add(sum-arr[i]);
            }
        }
        return 0 ;
    }
	
	/*public static int sumExists(int arr[], int n, int sum)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: arr){
            Integer val = map.get(a);
            if(val!=null) return 1;
            else {
                map.put(sum-a, a);
            }
        }
        return 0;
    }*/
	
}
