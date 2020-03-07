import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.ArrayList;

// https://www.geeksforgeeks.org/lucky-numbers/


class LuckyNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			//approach-2 , took the help of editorial to get to know the logic but wrote the whole code by myself. 
			int pos = n, step =2;
			boolean isLucky = true;
			/* 	here in every iteration, we're try to find the position of given input number
			 * 	and increase the step in each iteration
			 * 	if in any iteration the given number's position is divided by the step
			 * 	then we stop the loop because in that number will be deleted at the end of this loop
			 * 	so this number is not a lucky number. 
			*/
			while(step<=pos) {
				if(pos%step==0) {
					isLucky = false;
					break;
				}
				pos = pos - (pos/step);
				step++;
			}
			System.out.println(isLucky?"1":"0");
			
			
			//approach-1, this approach gives time limit exceed.
			/*ArrayList<Integer> ip = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				ip.add(i+1);
			}
			System.out.println(ip);
			
			int step = 1; 
			while(step<ip.size()) {
				for (int i = 0; i < ip.size(); i+=step) {
					if(i!=0) { // first element i.e 0th index number shouldn't be removed.
						ip.remove(i);
					}
					System.out.println(ip);
				}
				step++;
			}
			System.out.println(ip.contains(n)?"1":"0");*/
		}
	}
}
