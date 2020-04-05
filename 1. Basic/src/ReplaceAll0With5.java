import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/replace-all-0s-with-5/1/

public class ReplaceAll0With5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(convertfive(n));
		}
	}
	
	private static int convertfive(int num) {
        if(num == 0) return 5;
        else return convert0To5Rec(num);
    }
    
    private static int convert0To5Rec(int num){
        
        if(num == 0) return 0;
        
        int digit = num % 10;
        if(digit == 0) digit = 5;
        
        return convert0To5Rec(num / 10)* 10 + digit;
    }
}
