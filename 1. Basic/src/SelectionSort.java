

// https://practice.geeksforgeeks.org/problems/selection-sort/1
class SelectionSort {
	void selectionSort(int arr[])
	{
		int n = arr.length;
		for(int i=n-1; i>=0; i--)
		{
			int j = select(arr, i);
			
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}	
	}
	
	static int select(int arr[], int i)
    {
	    int max_index = i;
	    for(int j=i; j>=0; j--) {
	        if(arr[j] > arr[max_index]) {
	            max_index = j;
	        }
	    }
	    return max_index;
    }
}
