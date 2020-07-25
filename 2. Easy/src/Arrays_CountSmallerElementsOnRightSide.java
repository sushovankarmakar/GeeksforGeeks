import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/count-smaller-elements/0
// https://leetcode.com/problems/count-of-smaller-numbers-after-self/
// https://practice.geeksforgeeks.org/problems/inversion-of-array/0 (A quite similar problem)

// https://www.youtube.com/watch?v=ffbwCfJ2Qjw (Best Video Explanation : I followed this)
// https://happygirlzt.com/code/315.html
// https://github.com/happygirlzt/algorithm-illustrations/blob/master/Count%20of%20Smaller%20Numbers%20After%20Self.png
// https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76584/Mergesort-solution

public class Arrays_CountSmallerElementsOnRightSide {

    private static class Item {
        private int value;
        private int index;  // we need to store the index of the original array, cause after sorting the index may get changed
        Item(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    private static List<Integer> countSmallerAfterSelf(int[] numbers) {
        int n = numbers.length;
        Item[] items = new Item[n];
        int[] counts = new int[n];
        for (int index = 0; index < n; index++) {
            items[index] = new Item(numbers[index], index);
        }

        mergeSort(items, 0, n-1, counts);

        List<Integer> output = new ArrayList<>();
        for (int count : counts) {
            output.add(count);
        }
        return output;
    }

    private static void mergeSort(Item[] items, int low, int high, int[] counts) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(items, low, mid, counts);
            mergeSort(items, mid + 1, high, counts);
            merge(items, low, mid, high, counts);
        }
    }

    private static void merge(Item[] originalItems, int low, int mid, int high, int[] counts) {
        int leftArrayLength  = mid - low + 1;
        int rightArrayLength = high - mid;

        // creating two temporary array, we'll compare these two array's values and store the min value in the original array
        Item[] leftArray  = new Item[leftArrayLength];
        Item[] rightArray = new Item[rightArrayLength];

        if (leftArrayLength >= 0) System.arraycopy(originalItems, low, leftArray, 0, leftArrayLength);
        if (rightArrayLength >= 0) System.arraycopy(originalItems, mid + 1, rightArray, 0, rightArrayLength);

        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int originalIndex = low;

        int rightCounter = 0;

        while (leftArrayIndex < leftArrayLength && rightArrayIndex < rightArrayLength) {
            /*
            Each time we choose a left to the merged array.
            We want to know how many numbers from array right are moved before this number.
            So for that we keep rightCounter.
            */
            if(leftArray[leftArrayIndex].value > rightArray[rightArrayIndex].value) {
                rightCounter++;     // most important line

                originalItems[originalIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            else {  // (leftArray[leftArrayIndex].value <= rightArray[rightArrayIndex].value)

                counts[leftArray[leftArrayIndex].index] += rightCounter; // most important line, storing the counter in the counts array.

                originalItems[originalIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            }
            originalIndex++;
        }

        while (leftArrayIndex < leftArrayLength) {
            counts[leftArray[leftArrayIndex].index] += rightCounter;    // most important line

            originalItems[originalIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            originalIndex++;
        }

        while (rightArrayIndex < rightArrayLength) {
            originalItems[originalIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            originalIndex++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split("\\s+");
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(input[i]);
            }
            List<Integer> output = countSmallerAfterSelf(numbers);
            StringBuilder sb = new StringBuilder();
            for (int count : output) {
                sb.append(count).append(" ");
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
