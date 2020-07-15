import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 15.07.2020 (Solved completely by myself)
// https://www.geeksforgeeks.org/minimum-distance-to-the-corner-of-a-grid-from-source/ (Almost similar problem)
// (In this problem, only right and down movement is possible)

/*
Problem Description:
        Imagine a robot sitting in the upper left corner of a grid with R rows and C columns.
        The robot can only move in two directions, right and down.
        Certain cells are 'off limits' such that the robot cannot step on them.
        Find a path for the robot from the top left to the bottom right.
Sample Input :
3 3
0 0 1
0 1 0
0 0 0
Sample output :
1 1
2 1
3 1
3 2
3 3

*/

/* below is a edge test case
INPUT :
3 3
0 0 0
0 0 0
0 0 1
OUTPUT :
Not possible
*/

public class Graph_PathBetweenTwoCornersGrid {

    private static List<String> robotInAGrid(int[][] grid, int n, int m) {
        List<String> path = new ArrayList<>();
        robotInAGridUtil(grid, 0, 0, n, m, path);
        return path;
    }

    // below method is just a variation of DFS
    private static boolean robotInAGridUtil(int[][] grid, int i, int j, int n, int m, List<String> path) {
        if(!isValidGrid(i, j, n, m)) {  // if the grid is out of the matrix limit, then return false
            return false;
        }
        if(grid[i][j] == 1) {   // if the grid have value 1, then we can proceed further, return false
            return false;
        }

        if(i == (n-1) && j == (m-1)) {  // BASE CONDITION, if we reach the destination grid, then add that and return true
            path.add(n + " " + m);
            return true;
        }

        if(grid[i][j] == 0) {
            path.add((i+1) + " " + (j+1));                             // add this grid to path
            if(!robotInAGridUtil(grid, i, j+1, n, m, path) &&       // then go to right grid
                    !robotInAGridUtil(grid, i+1, j, n, m, path)) {  // if right grid gives false then check below grid
                path.remove(path.size()-1);                     // here we are doing BACKTRACKING, so if right and below both grid return false,
                // then remove that grid from path and return false
                return false;
            }
        }
        return true;    // if right grid or below grid, any of them return true, then return true
    }

    private static boolean isValidGrid(int i, int j, int n, int m) {   // checks the boundary
        return (0 <= i && i < n) && (0 <= j && j < m);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        List<String> result = robotInAGrid(grid, n, m);
        if(result.isEmpty()) System.out.println("Not Possible");
        else {
            for(String elem : result) {
                System.out.println(elem);
            }
        }
    }
}
