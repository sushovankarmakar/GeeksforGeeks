import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Array_to_BST {

	static void arraytoBST(int a[], int l, int h)
	{
		if( l>h )
		{
			return;
		}
		int root = (l + ((h-l)/2) );
		
		System.out.print(a[root]+" ");
		arraytoBST(a, l, root-1);
		arraytoBST(a, root+1, h);
	}
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int size = Integer.parseInt(br.readLine());
			int a[] = new int[size];
			String s[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < s.length; i++) {
				a[i] = Integer.parseInt(s[i]);
			}
			
			arraytoBST(a, 0, size-1);
			System.out.println();
		}
	}
}
