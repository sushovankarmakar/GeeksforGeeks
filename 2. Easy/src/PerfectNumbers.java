import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class PerfectNumbers {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int no = Integer.parseInt(br.readLine());
		while(no-->0)
		{
			int sum = 0;
			int t = Integer.parseInt(br.readLine());
			//System.out.println(t);
			int i = 1;
			while( i <= (t/2) )
			{
				if((t%i)==0) {
					sum += i;
					//System.out.print(sum+" ");
				}
				i++;
			}
			//System.out.print(sum);
			int result = (sum==t)? 1 : 0;
			System.out.println(result);
		}
	}
}
