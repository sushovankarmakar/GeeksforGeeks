import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/trapping-rain-water/

class AmountOfWater {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			
			// approach-1
			/*int leftMax=0, rightMax=0, amount=0;
			for (int i = 0; i < n; i++) {
				leftMax = findMax(ip,0,i);
				rightMax = findMax(ip,i,n-1);
				amount += ((leftMax<=rightMax)?leftMax:rightMax) - ip[i];
			}
			System.out.println(amount);*/
			
			// approach-2
			int maxArr[] = new int[n];
			
			//finding left side highest bar of all nodes 
			int maxVal = ip[0];
			for (int i = 0; i < n; i++) {
				if(maxVal < ip[i]) {
					maxVal = ip[i];
				}
				maxArr[i] = maxVal;
			}
			/*for (int i = 0; i < n; i++) {
				System.out.print(leftMaxArr[i]+" ");
			}
			System.out.println();*/
			
			/* finding right side highest bar of all nodes and if right side highest bar is smaller than left side highest bar
			   then store the value in maxArr[]
			*/
			maxVal = ip[n-1];
			for (int i = n-1; i >=0 ; i--) {
				if(maxVal < ip[i]) {
					maxVal = ip[i];
				}
				if(maxVal<maxArr[i]) maxArr[i] = maxVal;
			}
			/*for (int i = 0; i < n; i++) {
				System.out.print(rightMaxArr[i]+" ");
			}*/
			
			int amount = 0;
			for (int i = 0; i < n; i++) {
				amount += (maxArr[i] - ip[i]);
			}
			System.out.println(amount);
		}
	}

	/*static int findMax(int[] ip, int i, int j) {
		int max = ip[i];
		for (int k = i; k <= j; k++) {
			if(max < ip[k]) {
				max = ip[k];
				//System.out.println("Max "+ max);
			}
		}
		return max;
	}*/
}
