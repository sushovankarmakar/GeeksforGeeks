import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class FrequencyGame {

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
			System.out.println(largButMinFreq(ip, n));
		}
	}
	
	public static int largButMinFreq(int arr[], int n)
    {
        Map<Integer,Integer> map = new HashMap<>();
        int highest = Integer.MIN_VALUE, minFreq = Integer.MAX_VALUE;
        
        for(int a: arr){
            Integer val = map.get(a);
            if(val!=null){
                map.put(a, val+1);
                
                if( minFreq > val+1 ) {
                	minFreq = val+1;
                	
                	if(highest < a) {
                        highest = a;
                    }
                }
                
            }
            else{
                minFreq = 1;
                
                if(highest < a) {
                    highest = a;
                }
                
                map.put(a,1);
            }
        }
        
        return highest;
    }
}
