import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/triplet-family/1/
// https://www.geeksforgeeks.org/find-triplet-sum-two-equals-third-element/

class TripletFamily {
	 public static ArrayList<Integer> findTriplet(int arr[], int n)
	    {   
	        insertionSort(arr, n);
	        
	        ArrayList<Integer> op_list = new ArrayList<Integer>();
	        
	        outerloop:
	        for(int k = n-1; k >= 0; k--) {
	            int i = 0, j = k-1;
	            
	            while(i < j) {
	                
	                if(arr[i] + arr[j] == arr[k]) {
	                    op_list.add(arr[i]);
	                    op_list.add(arr[j]);
	                    op_list.add(arr[k]);
	                    break outerloop;
	                }
	                
	                if(arr[i] + arr[j] < arr[k])    i++;
	                
	                if(arr[i] + arr[j] > arr[k])    j--;
	            }
	        }
	        return op_list;
	    }
	    
	    static void insertionSort(int arr[], int n) {
	        for(int i = 1; i < n; i++) {
	            int curr_element = arr[i];
	            int j = i - 1;
	            while( j >= 0 && arr[j] > curr_element) {
	                arr[j+1] = arr[j];
	                j--;
	            }
	            arr[j+1] = curr_element;
	        }
	    }
}
