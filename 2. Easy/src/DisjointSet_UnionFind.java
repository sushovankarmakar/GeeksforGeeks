import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class DisjointSet_UnionFind {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String nk[] = br.readLine().trim().split("\\s+"), ip[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
			int a[] = new int[n+1];
			for (int i = 1; i <=n; i++) {
				a[i] = i;
			}
			for (int i = 0; i < ip.length; ) {
				if(ip[i].equals("FIND")) {
					int x = Integer.parseInt(ip[i+1]);
					i += 2;
					int parent = find(a,x);
					System.out.println("parent "+parent+" ");
				}
				else if(ip[i].equals("UNION")) {
					int x = Integer.parseInt(ip[i+1]);
					int z = Integer.parseInt(ip[i+2]);
					i += 3;
					unionSet(a,x,z);
				}
			}
			System.out.println();
		}
	}
	
	static int find(int a[],int x) {
		return a[x];
	}
	
	static void unionSet(int a[],int x,int z) {
		
		for (int i = 1; i < a.length; i++) {
			if(a[i]==x) a[i] = a[z];
		}
		
		for (int i = 1; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
