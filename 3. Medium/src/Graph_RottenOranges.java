import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.youtube.com/watch?v=CxrnOTUlNJE (THE BEST VIDEO EXPLANATION)
// https://practice.geeksforgeeks.org/problems/rotten-oranges/0
// https://leetcode.com/problems/rotting-oranges/
// https://leetcode.com/problems/rotting-oranges/discuss/238681/Java-Clean-BFS-Solution-with-comments

// It is nothing but count no. of connected components in a graph,
// we should apply BFS from every cell value=2, if its not visited how many times we apply BFS is the answer

public class Graph_RottenOranges {

    private static class OrangeNode {
        private int timeFrame = 0;
        private int row = 0;
        private int col = 0;
        OrangeNode(int timeFrame, int row, int col) {
            this.timeFrame = timeFrame;
            this.row = row;
            this.col = col;
        }
    }

    private static int getMinMinutesTakenForOrangesRotting(int[][] grid) {
        Queue<OrangeNode> queue = getAllInitialRottenTomatoes(grid);
        int currTime = 0;

        int[][] directions = { {0,-1}, {0,1}, {-1,0}, {1,0} };   // left, right, up, down

        while (!queue.isEmpty()) {
            OrangeNode currOrange = queue.poll();
            currTime = currOrange.timeFrame;

            for (int[] direction : directions) {    // traversing through all four directions
                int newRow = currOrange.row + direction[0];
                int newCol = currOrange.col + direction[1];

                if(isAdjacentFreshOrange(newRow, newCol, grid)) {
                    grid[newRow][newCol] = 2;   // make adjacent fresh orange as rotten
                    queue.add(new OrangeNode(currTime+1, newRow, newCol));    // add the newly rotten tomato
                }
            }
        }
        return (checkFreshTomatoRemain(grid)) ? -1 : currTime;  // after traversing is there any fresh tomato left, then return -1
    }

    private static boolean isAdjacentFreshOrange(int row, int col, int[][] grid) {
        return  (0 <= row && row < grid.length) &&
                (0 <= col && col < grid[0].length) &&
                (grid[row][col] == 1);
    }

    private static Queue<OrangeNode> getAllInitialRottenTomatoes(int[][] grid) {
        Queue<OrangeNode> queue = new LinkedList<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] == 2) {
                    queue.add(new OrangeNode(0, row, col));
                }
            }
        }
        return queue;
    }

    private static boolean checkFreshTomatoRemain(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0) {
            String[] rc = br.readLine().trim().split("\\s+");
            int row = Integer.parseInt(rc[0]);
            int col = Integer.parseInt(rc[1]);
            String[] str  = br.readLine().trim().split("\\s+");
            int[][] grid = new int[row][col];
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    grid[r][c] = Integer.parseInt(str[r*col + c]);
                }
            }
            System.out.println(getMinMinutesTakenForOrangesRotting(grid));
        }
    }
}
