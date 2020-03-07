import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

class DuplicateElementJava {

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
			sortedDuplicates(ip, n);
		}
	}

	static void sortedDuplicates(int arr[], int n)
    {
        Map<Integer, Integer> map = new TreeMap<>();
        boolean b = false;
        for(int a : arr){
            Integer val = map.get(a);
            if(val!=null){
                b = true;
                map.put(a, val+1);
            }
            else {
                map.put(a, 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> e: map.entrySet() ){
            int val = (int) e.getValue(); 
            if(val > 1) {
                System.out.print(e.getKey()+" ");
            }
        }
        if(!b) System.out.print("-1");
     }
}
