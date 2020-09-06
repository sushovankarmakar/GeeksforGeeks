import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 05.09.2020
// https://practice.geeksforgeeks.org/problems/combination-sum/0    (Solved it by myself with a bit of help in passing the startingIndex)
// https://leetcode.com/problems/combination-sum/
// https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning) (BEST)
// https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)/185237 (Why to pass startingIndex)
// https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)/16323  (Java passes variable by reference )
// https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)/323613 (Time and space complexity)
// https://assets.leetcode.com/users/danhuang/image_1587194198.png (Very much important to understand the why startingIndex is passing)
// https://leetcode.com/problems/combination-sum-ii/discuss/16878/Combination-Sum-I-II-and-III-Java-solution-(see-the-similarities-yourself)
// https://practice.geeksforgeeks.org/problems/combination-sum-part-2/0/ (Similar question)
// https://leetcode.com/problems/combination-sum-ii/ (Similar question)

public class Backtracking_CombinationSum1 {

    /* Time complexity : O(N ^ target) where N is a length of candidates array.
    *  Space complexity is O(target).*/

    private static List<List<Integer>> combinationSum(int[] numbers, int sum) {
        Arrays.sort(numbers);
        numbers = removeDuplicates(numbers);
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        combinationSumUtil(numbers, sum, currentCombination, combinations, 0);
        return combinations;
    }

    private static void combinationSumUtil(int[] numbers, int sum, List<Integer> currentCombination,
                                           List<List<Integer>> combinations, int startingIndex) {
        if (sum <= 0) {
            if (sum == 0) combinations.add(new ArrayList<>(currentCombination)); /* Java passes variable by reference so we are doing "new ArrayList<>(currentCombination)" */
            return;
        }

        for (int index = startingIndex; index < numbers.length; index++) {
            currentCombination.add(numbers[index]);
            combinationSumUtil(numbers, sum - numbers[index], currentCombination, combinations, index);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    private static int[] removeDuplicates (int[] numbers) {

        List<Integer> uniqueNumbers = new ArrayList<>();
        uniqueNumbers.add(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] != numbers[i]) uniqueNumbers.add(numbers[i]);
        }

        int[] uniqueNumbersArray = new int[uniqueNumbers.size()];
        for (int i = 0; i < uniqueNumbers.size(); i++) {
            uniqueNumbersArray[i] = uniqueNumbers.get(i);
        }
        return uniqueNumbersArray;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split("\\s+");
            int[] numbers = new int[size];
            for (int i = 0; i < size; i++) {
                numbers[i] = Integer.parseInt(input[i]);
            }
            int sum = Integer.parseInt(br.readLine().trim());
            List<List<Integer>> output = combinationSum(numbers, sum);
            print(output);
        }
    }

    private static void print(List<List<Integer>> output) {

        if(output.isEmpty()) {
            System.out.println("Empty");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (List<Integer> combinationSum : output) {
            sb.append("(");
            for (Integer num : combinationSum) {
                sb.append(num).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
        }
        System.out.println(sb);
        sb.setLength(0);
    }
}
