import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// https://practice.geeksforgeeks.org/problems/pair-in-java/1/?track=module-3-classes%20and-biginteger-java&batchId=114


class PairInJava {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			Pair pair[] = new Pair[n];
			int j = 0;
			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(s[j++]);
				int y = Integer.parseInt(s[j++]);
				pair[i] = new Pair(x,y);
			}
			
			/*for(int i = 0;i<n;i++){
	            System.out.print(pair[i].x + " " + pair[i].y + " ");
	        }
	        System.out.println();*/
			
			// The task is to sort the array on the basis of first element.
			// custom compare method.
			Arrays.sort(pair, new Comparator<Pair>(){
				
				@Override
				public int compare(Pair a,Pair b) {
					return a.x- b.x;
				}

			});
			
			
			for(int i = 0;i<n;i++){
	            System.out.print(pair[i].x + " " + pair[i].y + " ");
	        }
	        System.out.println();
			
			
		}
	}
}

class Pair {
	int x,y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}