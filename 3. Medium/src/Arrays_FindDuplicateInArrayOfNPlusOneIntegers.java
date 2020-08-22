import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/find-the-duplicate-number/
// https://www.youtube.com/watch?v=32Ll35mhWg0 (BEST VIDEO EXPLANATION)

public class Arrays_FindDuplicateInArrayOfNPlusOneIntegers {

    // this method takes similar approach to linked list cycle detection hare tortoise algorithm
    private static int findDuplicate(int[] values) {
        int slow = values[0];
        int fast = values[0];

        do {
            slow = values[slow];
            fast = values[values[fast]];
        } while (slow != fast);

        fast = values[0];
        while (slow != fast) {
            slow = values[slow];
            fast = values[fast];
        }

        return slow;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t -- > 0) {
            String[] input = br.readLine().trim().split("\\s+");
            int[] values = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                values[i] = Integer.parseInt(input[i]);
            }
            System.out.println(findDuplicate(values));
        }
    }
}
