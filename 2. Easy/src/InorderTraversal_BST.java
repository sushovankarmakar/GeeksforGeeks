import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class InorderTraversal_BST {

	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int size = Integer.parseInt(br.readLine());
			int a[] = new int[size];
			boolean b = true;
			String in[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < in.length; i++) {
				a[i] = Integer.parseInt(in[i]);
			}
			
			for (int i = 0; i < size-1; i++) {
				if(a[i]>=a[i+1]) {
					b = false;
					break;
				}
			}
			
			System.out.println( (b)?"1":"0" );
		}
	}
}
