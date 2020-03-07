import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class LeadersInArray {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int no = Integer.parseInt(br.readLine());
		ArrayList<Integer> op = new ArrayList<>();
		for(int j=0; j<no; j++)
		{
			int t = Integer.parseInt(br.readLine());
			String str[] = br.readLine().trim().split("\\s+");
			
			int max = Integer.MIN_VALUE;
			int k = 0;
			for(int i=t-1; i>=0; i--)
			{
				int n = Integer.parseInt(str[i]);
				if(max < n)
				{
					max = n;
					op.add(k++, max);
					//System.out.print(max+" ");
				}
			}
			for (int i = op.size()-1; i >=0 ; i--) 
			{
				System.out.print(op.get(i)+" ");
			}
			op.clear();
			System.out.print("\n");
		}
	}
}
