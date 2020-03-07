import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SameFreqJava {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String n1n2[] = br.readLine().trim().split("\\s+"), 
					arr1[] = br.readLine().trim().split("\\s+"),
					arr2[] = br.readLine().trim().split("\\s+");
			int n1 = Integer.parseInt(n1n2[0]), n2 = Integer.parseInt(n1n2[1]); 
			int ip1[] = new int[n1], ip2[] = new int[n2];
			for (int i = 0; i < n1; i++) {
				ip1[i] = Integer.parseInt(arr1[i]);
			}
			for (int i = 0; i < n2; i++) {
				ip2[i] = Integer.parseInt(arr2[i]);
			}
			sameFreq(ip1,ip2);
		}
	}
	
	static void sameFreq(int arr1[],int arr2[])
    {
        Map<Integer, Integer> m1 = new LinkedHashMap<>(), 
        m2 = new LinkedHashMap<>();
        
        for(int a:arr1){
            Integer val = m1.get(a);
            if(val != null){
                m1.put(a, val+1);
            }
            else {
                m1.put(a, 1);
            }
        }
        
        for(int a:arr2){
            Integer val = m2.get(a);
            if(val != null){
                m2.put(a, val+1);
            }
            else {
                m2.put(a, 1);
            }
        }
        
        boolean b = false;
        for(Map.Entry<Integer,Integer> e: m2.entrySet()){
            if( m1.containsKey(e.getKey()) ){
                if(m1.get(e.getKey()) == m2.get(e.getKey()) ){
                    b = true;
                    System.out.print(e.getKey()+" ");
                }
            }
        }
        
        if(!b) System.out.print("-1");
        
    }

}
