import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Reverse_words_of_string 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			char s[] = br.readLine().toCharArray();
			
			ArrayList<String> al = new ArrayList<>();
			String op = ""+s[0];
			
			for (int i = 1; i < s.length; i++) {
			
				if(s[i]=='.')
				{
					al.add(op);
					al.add(".");
					op = "";
				}
				else
				{
					op += s[i];
				}
			}
			al.add(op);
			for (int i = al.size()-1; i >=0; i--) {
				System.out.print(al.get(i));
			}
			System.out.println();
		}
	}
}
