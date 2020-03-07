import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

class CommonElementsJava {

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
			commonEle(ip1,ip2);
		}
	}
	
	static void commonEle(int arr1[],int arr2[])
    {
        Set<Integer> s1 = new LinkedHashSet<>(), 
        s2 = new LinkedHashSet<>();
        for(int a: arr1){
            s1.add(a);
        }
        for(int a: arr2){
            s2.add(a);
        }
        
        s2.retainAll(s1);
        if(s2.size()==0){
            System.out.print("-1");
        }
        else {
            for(int i=0; i< arr2.length; i++ ){
                if(s2.contains(arr2[i])) System.out.print(arr2[i]+" ");
            }
        }
    }
}
