import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/discuss/93703/Share-my-explained-Greedy-solution (BEST Resource and explanation)
// https://www.youtube.com/watch?v=FEM7uVzSbYI&t=342s&ab_channel=HappyCoding (A good video to understand)
// https://www.youtube.com/watch?v=y_n1rALjKzI&ab_channel=bitwisebytes (A good video for visualization)

public class Arrays_MinNumOfArrowsToBurstBalloons {

    /*LOGIC :
    * We sort all the balloons position on the basis of ending position.
    * And then run over the loop to find out how many balloons I can take down with one shot by aiming at the ending position of the current balloon.
    * whenever we get to see a balloon, we check the range of it and
    * if the current balloon's start time is in the range, then
    * we don't increase the arrow count
    * as this balloon can be burst down by current arrow.*/

    private static int calculateMinNumberOfArrowsToBurstBalloons(int[][] balloons) {
        if (balloons.length == 0) return 0;

        Arrays.sort(balloons, (a, b) -> (a[1] - b[1])); /* sorted by the end coordinate */

        int numOfArrows = 1;
        int currentEnding = balloons[0][1];

        for (int i = 1; i < balloons.length; i++) {

            int currentStart = balloons[i][0];
            if (currentStart <= currentEnding) {
                continue;
            }
            else {
                numOfArrows++;
                currentEnding = balloons[i][1];
            }
        }
        return numOfArrows;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t -- > 0) {
            int numOfBalloons = Integer.parseInt(br.readLine().trim());
            int[][] balloons = new int[numOfBalloons][2];
            for (int i = 0; i < numOfBalloons; i++) {
                String[] coordinates = br.readLine().trim().split("\\s+");
                int startCoordinate = Integer.parseInt(coordinates[0]);
                int endCoordinate = Integer.parseInt(coordinates[1]);
                balloons[i][0] = startCoordinate;
                balloons[i][1] = endCoordinate;
            }
            System.out.println(calculateMinNumberOfArrowsToBurstBalloons(balloons));
        }
    }
}
