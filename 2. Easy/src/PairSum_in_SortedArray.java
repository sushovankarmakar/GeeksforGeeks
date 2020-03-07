import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class PairSum_in_SortedArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int s = Integer.parseInt(br.readLine());
			int a[] = new int[s];
			String[] ip = br.readLine().trim().split("\\s+");
			for (int i = 0; i < s; i++) {
				a[i] = Integer.parseInt(ip[i]);
			}
			int sum = Integer.parseInt(br.readLine());
			
			int l = 0;
			int r = a.length-1;
			boolean b = false;
			
			while(l<r) {
				if(a[l]+a[r]<sum) {
					//System.out.println(l+" "+r+" sum is greater");
					l++; 
				}
				else if(a[l]+a[r]>sum) {
					//System.out.println(l+" "+r+" sum is smaller");
					r--;
				}
				else if(a[l]+a[r]==sum) {
					b = true;
					System.out.println(a[l]+" "+a[r]+" "+sum);
					//System.out.println(l+" "+r);
					l++;
					r--;
				}
			}
			if(!b) System.out.println("-1");
		}
	}
}


/*int n1=0,n2=0;
boolean b = false;
for (int i = 0; i < a.length; i++) {
	n1= a[i];
	n2= sum-a[i];
	if(n1==n2) continue;
	
	for (int j = i; j < a.length; j++) {
		if(n2==a[j]) {
			b = true;
			System.out.println(n1+" "+n2+" "+sum);
		}
	}
}

if(!b) System.out.println("-1");*/
