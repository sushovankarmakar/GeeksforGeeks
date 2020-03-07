import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

class ExistingSubsequence {

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
			hasSubseq(ip1,ip2);
		}
	}
	
	static void hasSubseq(int arr1[],int arr2[])
    {
        Set<Integer> s1 = new LinkedHashSet<>(), 
        s2 = new LinkedHashSet<>();
        for(int a: arr1){
            s1.add(a);
        }
        for(int a: arr2){
            s2.add(a);
        }
        
        Set<Integer> s3 = new LinkedHashSet<>(s2);
        
        s3.retainAll(s1);
        
        s2.removeAll(s3);
        
        if(s2.size()==0) {
            System.out.print("1");
        }
        else {
            System.out.print("0");
        }
    }
}
