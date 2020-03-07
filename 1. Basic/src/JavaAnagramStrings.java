import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.HashMap;

class JavaAnagramStrings {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			char s1[] = br.readLine().trim().toCharArray() , s2[] = br.readLine().trim().toCharArray();
			/*
			Approach-1 : Sort the arrays 
			Arrays.sort(s1);
			Arrays.sort(s2);
			System.out.println((String.valueOf(s1).equals(String.valueOf(s2)))?"1":"0");
			*/
			
			// Approach-2 Use HashMap
			if(s1.length!=s2.length) {
				System.out.println("0");
			}
			else {
				HashMap<Character, Integer> map = new HashMap<Character, Integer>();
				for (int i = 0; i < s1.length; i++) {
					Integer val = map.get(s1[i]);
					if(val!=null) {
						map.put(s1[i], new Integer(val+1));
					}
					else {
						map.put(s1[i], 1);
					}
				}
				
				for (int i = 0; i < s2.length; i++) {
					Integer val = map.get(s2[i]);
					if(val!=null) {
						map.put(s2[i], new Integer(val-1));
					}
				}
				
				boolean isAnagram = false;
				for (int i = 0; i < s1.length; i++) {
					if(map.get(s1[i])==0) {
						isAnagram = true;
					}
					else {
						isAnagram = false;
						break;
					}			
				}
				System.out.println( (isAnagram) ?"1":"0");
			}
		}
	}
}
