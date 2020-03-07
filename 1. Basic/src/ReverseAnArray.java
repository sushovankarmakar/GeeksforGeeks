import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class ReverseAnArray {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int no = Integer.parseInt(br.readLine());
		ArrayList<Integer> op = new ArrayList<>();
		while(no-->0)
		{
			int t = Integer.parseInt(br.readLine());
			String[] str = br.readLine().trim().split("\\s+");
			for(int i = 0; i<str.length; i++)
			{
				op.add(Integer.parseInt(str[i]));
			}
			
			for(int i = op.size()-1; i>=0; i--)
			{
				System.out.print(op.get(i)+" ");
			}
			System.out.print("\n");
			op.clear();
		}
	}

}
