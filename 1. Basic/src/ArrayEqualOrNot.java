import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class ArrayEqualOrNot {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int flag = -1;
		while(t-->0)
		{
			int size = Integer.parseInt(br.readLine());
			String a1[] = br.readLine().trim().split("\\s+");
			String b1[] = br.readLine().trim().split("\\s+");
			int a[] = new int[size];
			int b[] = new int[size];
			for (int i = 0; i < a.length; i++) {
				a[i] = Integer.parseInt(a1[i]);
				b[i] = Integer.parseInt(b1[i]);
			}
			Arrays.sort(a);
			Arrays.sort(b);
			for (int i = 0; i < a.length; i++) {
				if(a[i]==b[i]) {
					flag=1;
				}
				else {
					flag=0;
					break;
				}
			}
			if(flag==1) {
				System.out.println("1");
			}
			else {
				System.out.println("0");
			}
		}
	}
}
