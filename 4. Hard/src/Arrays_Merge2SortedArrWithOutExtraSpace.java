import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays5135/1
// https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1/
// https://www.youtube.com/watch?v=hVl2b3bLzBw&ab_channel=takeUforward (BEST VIDEO)
// https://www.youtube.com/watch?v=Bcay1cEqrrA&ab_channel=PawanGupta (A good video)
// https://www.geeksforgeeks.org/efficiently-merging-two-sorted-arrays-with-o1-extra-space/ (BEST Post <- I followed this)
// https://www.youtube.com/watch?v=9crZRd8GPWM&ab_channel=Jenny%27slecturesCS%2FITNET%26JRF (Shell Sort)
// https://www.geeksforgeeks.org/shellsort/
// https://www.youtube.com/watch?v=OGzPmgsI-pQ&ab_channel=GeeksforGeeks (Insertion Sort)
/* Intuition behind the logic is Shell sort */

public class Arrays_Merge2SortedArrWithOutExtraSpace {

    /* time complexity : O((n + m) * log(n + m)) , space complexity : O(1) */
    private static void mergeTwoSortedArraysWithoutExtraSpace(int[] array1, int[] array2, int n, int m) {
        int i = 0;
        int j = 0;
        int totalSize = n + m;
        for (int gap = nextGap(totalSize) ; gap > 0; gap = nextGap(gap)) {

            /* comparing elements in the first array */
            for (i = 0; i + gap < n; i++) {
                if (array1[i] > array1[i + gap]) {
                    swap(array1, array1, i, i + gap);
                }
            }

            /* comparing elements in both the arrays */
            for (j = (gap > n ? gap - n : 0); (i < n && j < m); i++, j++) {
                if (array1[i] > array2[j]) {
                    swap(array1, array2, i, j);
                }
            }

            if (j < m) {
                /* comparing elements in the second array */
                for (j = 0; j + gap < m; j++) {
                    if (array2[j] > array2[j + gap]) {
                        swap(array2, array2, j, j + gap);
                    }
                }
            }
        }
    }

    private static void swap(int[] array1, int[] array2, int i, int j) {
        int temp = array1[i];
        array1[i] = array2[j];
        array2[j] = temp;
    }

    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);   /* We are taking the ceiling value */
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t -- > 0) {
            String[] nm = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            String[] input1 = br.readLine().trim().split("\\s+");
            String[] input2 = br.readLine().trim().split("\\s+");
            int[] array1 = new int[n];
            int[] array2 = new int[m];
            for (int i = 0; i < n; i++) {
                array1[i] = Integer.parseInt(input1[i]);
            }
            for (int i = 0; i < m; i++) {
                array2[i] = Integer.parseInt(input2[i]);
            }
            mergeTwoSortedArraysWithoutExtraSpace(array1, array2, n, m);
            print(array1, array2, n, m);
        }
    }

    private static void print(int[] array1, int[] array2, int n, int m) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(array1[i]).append(" ");
        }
        for (int j = 0; j < m; j++) {
            sb.append(array2[j]).append(" ");
        }
        System.out.println(sb);
        sb.setLength(0);
    }

    /*
    * 10 10
    * 7 9 9 10 11 11 13 14 17 19
    * 1 1 4 5 8 11 13 16 19 19
    *
    * Its Correct output is: 1 1 4 5 7 8 9 9 10 11 11 11 13 13 14 16 17 19 19 19
    * And Your Code's output is: 1 1 4 5 7 8 9 9 10 11 11 13 11 13 14 16 17 19 19 19
    *
    * 5 5
    * 1 3 5 7 10
    * 0 2 6 8 9
    *
    * */

    /* SHELL SORT ALGORITHM

    for (int gap = N / 2; gap >= 1; gap / 2) {
	    for (int j = gap; j < N; j++) {
		    for (int i = j - gap; i >= 0; i - gap) {
			    if (arr[i] < arr[i + gap]) {
				    break;
			    }
			    else {
				    swap(arr[i], arr[i + gap]);
			    }
		    }
	    }
    }

    time complexity depends upon the gap sequence.
    here we are taking the gap sequence as N / 2.
    so time complexity : O(N^2)
    space complexity : O(1)

    */
}
