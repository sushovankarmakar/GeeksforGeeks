import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class ParenthesisChecker {

	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			String s = br.readLine();
			if(areParenthesisBalanced(s))
			{
				System.out.println("balanced");
			}
			else
			{
				System.out.println("not balanced");
			}
		}
	}

	static boolean areParenthesisBalanced(String s)
	{
		Stack<Character> input = new Stack<>();
		for (int i = 0; i < s.length(); i++) 
		{
			if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') 
			{
				input.push(s.charAt(i));
			}
			else if(s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}') 
			{	
				if(input.isEmpty()) {
					return false;
				}
				else if ( !isMatchingPair((char)input.pop(), s.charAt(i)) )
	            {
					return false;
	            }
			}
		}
		if(input.isEmpty()) return true;
		else 				return false;
	}
	
	
	
	static boolean isMatchingPair(char character1, char character2) 
	{
			if (character1 == '(' && character2 == ')')
				return true;
			else if (character1 == '{' && character2 == '}')
				return true;
			else if (character1 == '[' && character2 == ']')
				return true;
			else
				return false;
	}
}
