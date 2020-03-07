import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

class RunLengthEncoding {

	public static void main(String[] args) throws IOException 
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s = br.readLine();
			GFG g = new GFG();
			System.out.println(g.encode(s));
		}
	}
}

class GFG
{
	String encode(String str)
	{
		char ch[] = str.toCharArray();
		ArrayList<Character> ar = new ArrayList<>();
		
		char c = ch[0];
		ar.add(ch[0]);
		int freq = 1;
		for (int i = 1; i < ch.length; i++) {

			if(ch[i]== c) {
				freq++;
			}
			else{
				
				ar.add( (char)(freq+ '0') );  //converting the integer into character 
				freq = 0;
				
				c = ch[i];
				ar.add(ch[i]);
				freq++;
			}
		}
		ar.add( (char)(freq+'0') );
		
		
		StringBuilder sb = new StringBuilder();
		for (char op : ar) {
			sb.append(op);
		}
		return sb.toString(); 
	}
}
