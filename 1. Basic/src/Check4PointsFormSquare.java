import java.io.IOException;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/check-given-four-points-form-square/
// same problem    https://practice.geeksforgeeks.org/problems/is-square/0

// did it in c++, coz java solution in gfg platform was giving wrong answer although it was correct.

class Check4PointsFormSquare {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			Point p1 = new Point(Integer.parseInt(s[0]), Integer.parseInt(s[1])),
				p2 = new Point(Integer.parseInt(s[2]), Integer.parseInt(s[3])), 
				p3 = new Point(Integer.parseInt(s[4]), Integer.parseInt(s[5])),
				p4 = new Point(Integer.parseInt(s[6]), Integer.parseInt(s[7]));
			
			double a = Math.floor(p1.distance(p2)), b = Math.floor(p1.distance(p3)), c =  Math.floor(p1.distance(p4));
			
			if(a==0 || b==0 || c==0) {
				System.out.println("0");
			}
			else if( (a==b) && (Math.floor(Math.sqrt(2)*a) == c) ) {
				
				double temp1 = p4.distance(p2), temp2 = p4.distance(p3);
				if(temp1==a && temp2==a) System.out.println("1");
			}
			else if ( (b==c) && (Math.floor(Math.sqrt(2)*b) == a)) {
				
				double temp1 = p2.distance(p3), temp2 = p2.distance(p4);
				if(temp1==b && temp2==b) System.out.println("1");
			}
			else if ( (c==a) && (Math.floor(Math.sqrt(2)*c) == b) ) {
				
				double temp1 = p3.distance(p2), temp2 = p3.distance(p4);
				if(temp1==c && temp2==c) System.out.println("1");
			}
			else {
				System.out.println("0");
			}
		}
	}
}
