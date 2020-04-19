
// https://practice.geeksforgeeks.org/problems/bubble-sort/1/

class BubbleSort {
	
	void bubbleSort(int arr[], int n)
	{
	   for (int i = 0; i < n-1; i++)      
	        bubble(arr, i, n);
	}
	
	static void bubble(int arr[], int i, int n)
    {
        for(int j = 0; j < n-1-i; j++) {
            if(arr[j] > arr[j+1]) {
                swap(arr, j, j+1);
            }
        }       
    }
    
    static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
