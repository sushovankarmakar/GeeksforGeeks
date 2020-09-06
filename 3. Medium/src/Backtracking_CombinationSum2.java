import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 06.09.2020
// https://practice.geeksforgeeks.org/problems/combination-sum-part-2/0/
// https://leetcode.com/problems/combination-sum-ii/
// https://leetcode.com/problems/combination-sum-ii/discuss/16861/Java-solution-using-dfs-easy-understand
// https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning) (BEST)
// https://leetcode.com/problems/combination-sum-ii/discuss/16861/Java-solution-using-dfs-easy-understand/507875 (Important to understand the if continue condition)
// https://leetcode.com/problems/combination-sum-ii/discuss/16878/Combination-Sum-I-II-and-III-Java-solution-(see-the-similarities-yourself)
// https://practice.geeksforgeeks.org/problems/combination-sum/0  (Similar question)
// https://leetcode.com/problems/combination-sum/ (Similar question)

/* Input :
* 7
* 10 1 2 7 6 1 5
* 8
*
* after sorting it will be
* 1 1 2 5 6 7 10
*
* if we don't use the "If continue" condition inside for loop then output will be
* (1 1 6)(1 2 5)(1 7)(1 2 5)(1 7)(2 6)
*
* but actual output should be
* (1 1 6)(1 2 5)(1 7)(2 6)
* */

public class Backtracking_CombinationSum2 {

    private static List<List<Integer>> combinationSum(int[] numbers, int sum) {
        Arrays.sort(numbers);
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

            if (index > startingIndex && numbers[index] == numbers[index - 1]) continue;   // Very important to understand this condition

            currentCombination.add(numbers[index]);
            combinationSumUtil(numbers, sum - numbers[index], currentCombination, combinations, index + 1);
            currentCombination.remove(currentCombination.size() - 1);
        }
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
