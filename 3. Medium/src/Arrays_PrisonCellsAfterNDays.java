import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 21.08.2020
// https://leetcode.com/problems/prison-cells-after-n-days/
// https://leetcode.com/problems/prison-cells-after-n-days/discuss/266854/Java%3A-easy-to-understand (BEST Resource)
// https://leetcode.com/problems/prison-cells-after-n-days/discuss/266854/Java:-easy-to-understand/414202 (Time complexity)
// https://www.youtube.com/watch?v=KcEtcBDX76w (BEST Video explanation)
// https://www.youtube.com/watch?v=qBxsNCsFj4w (Details but not so understandable)

public class Arrays_PrisonCellsAfterNDays {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t -- > 0) {
            String[] input = br.readLine().trim().split("\\s+");
            int[] cells = new int[input.length];
            int days = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < input.length; i++) {
                cells[i] = Integer.parseInt(input[i]);
            }

            int[] result = prisonAfterNDays(cells, days);
            StringBuilder sb = new StringBuilder();
            for (int j : result) {
                sb.append(j).append(" ");
            }
            System.out.println(sb);
        }
    }

    /*
    * https://leetcode.com/problems/prison-cells-after-n-days/discuss/266854/Java:-easy-to-understand/414202
    * time complexity : O(1) // i.e num of times we ran the loop to find a cycle.
    * space complexity : O(1)
    * */

    private static int[] prisonAfterNDays(int[] cells, int days) {
        if(cells == null || cells.length == 0 || days <= 0) return cells;

        boolean hasCycle = false;
        int cycleSize = 0;
        Set<String> set = new HashSet<>();

        for(int i = 0; i < days; i++) {
            int[] nextDay = getNextDay(cells);
            String key = Arrays.toString(nextDay);
            if(!set.contains(key)) {    //store cell state
                set.add(key);
                cycleSize++;
            }
            else {   //hit a cycle
                hasCycle = true;
                break;
            }
            cells = nextDay;
        }

        if(hasCycle) {
            days %= cycleSize;

            for (int i = 0; i < days; i++) {
                cells = getNextDay(cells);
            }
        }

        return cells;
    }

    private static int[] getNextDay(int[] cells) {
        int[] nextDay = new int[cells.length];  /* java initialize array values with 0 */
        for(int i = 1; i < cells.length - 1; i++) {    /* starting from 1 and going upto length-1, cause 0th index value and last index value will always be 0 */
            nextDay[i] = (cells[i - 1] == cells[i + 1]) ? 1: 0;
        }
        return nextDay;
    }
}
