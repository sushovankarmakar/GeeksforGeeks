import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Save_Ironman {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s = br.readLine()/*.trim().replaceAll("\\s+", "")*/;
			//System.out.println(s);
			boolean b = isPalindrome(s.toCharArray());
			System.out.println( b ? "YES" :"NO" );  
		}
	}
	
	static boolean isPalindrome(char c[]) {
		int i=0, j=c.length-1;
		while(i<=j) {
			boolean a = isAlphanum(c[i]);
			boolean b = isAlphanum(c[j]);
			
			if(a && b) {
				
				//if both the character is equal or not
				if(Character.toLowerCase(c[i])!=Character.toLowerCase(c[j])){
					return false;
				}
				i++;
				j--;
			}
			else {
				if(!a) {  //the character is not alphanumeric then skip it
					i++;
				}
				if(!b) { //the character is not alphanumeric then skip it
					j--;  
				}
			}
		}
		return true;
	}
	
	//checking if the character is alphabet/numeric or not 
	static boolean isAlphanum(char c) {
		if( (c>=48 && c<=57) || (c>=65 && c<=90) || (c>=97 && c<=122)){
			return true;
		}
		return false;
	}
}



//converting the character array into String and also removing "[", "]" , "," , "\\s+"
/*String s1 = Arrays.toString(c).replace("[", "").replace("]", "").replace(",", "").replaceAll("\\s+", "");
String s2 = new String(s1);*/			

/*// Expected Time Limit < 1.368sec
 * 
 * boolean b = true;
char[] op = s2.toCharArray();
for (int i = 0, j=op.length-1 ; i < op.length/2; i++,j--) {
	if(  op[i]==op[j] || (op[i] == ((int)op[j]-32)) || (((int)op[i]-32)== op[j]) ) {
	}
	else {
		b = false;
		break;
	}
}
System.out.println((b)?"YES":"NO");
*/

/*  // Expected Time Limit < 1.368sec

StringBuffer sb = new StringBuffer(s2);   //converting the string into StringBuffer
sb.reverse();                             //reversing the array
String op = new String(sb);               //converting the StringBuffer into string  
System.out.println((op.equalsIgnoreCase(s2))?"YES":"NO");    //checking if both the string is equal or not

*/


