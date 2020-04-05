// https://practice.geeksforgeeks.org/problems/maximum-in-struct-array/1


public class MaxInStructArray {
	
	
	
	class Height {
		int feet;
		int inches;
		public Height(int ft, int inc)
		{
		    feet = ft;
		    inches = inc;
		}
	}
	
	private static int findMaximumHeight(Height arr[], int n){
		
		int maxHeight = 0;
		
		for(int i=0; i < n; i++){
			int currentHeight = arr[i].feet*12 + arr[i].inches;
			if(maxHeight <= currentHeight ){
				maxHeight = currentHeight;
			}
		}
		
		return maxHeight; 
	}
}
