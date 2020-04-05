import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/find-transition-point/1

public class FindTransitionPoint {
	
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
			
			System.out.println(getTransitionPoint(ip, ip.length));
		}
	}
	
    private static int getTransitionPoint(int arr[], int n) {
        if(arr == null || arr.length ==0) return -1;
             int start = 0;
             int end = n-1;
            while(start < end){
                 int mid = start+(end-start)/2;
                 if(arr[mid]==1){
                     end = mid;
                 }else{
                     start=mid+1;
                 }
             }
             return arr[start] == 1 ? start : -1;
    }
}
