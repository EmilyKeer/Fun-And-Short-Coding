/*
Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

Find the number of islands.

Example
Given graph:

[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3.

*/

/*
Hints:
1. seperate each node, and go through each
2. for each node: 
    if 1: mark 0, queue.offer, 4 directions check(inbound, 1) -> next mark 0, queue.offer
*/
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public class Coordinate {
    int x;
    int y;
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        }
    }
    
    public int numIslands(boolean[][] grid) {
        // Write your code here
        int islands = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return islands;
        }
        int row = grid.length; //how many rows
        int col = grid[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j]) {
                    markBFS(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    private void markBFS(boolean[][] grid, int i, int j) {
        int[] directX = {0, 1, 0, -1};
        int[] directY = {1, 0, -1, 0};
        
        Queue<Coordinate> queue = new LinkedList<>();
        grid[i][j] = false;
        queue.offer(new Coordinate(i, j));
        
        while(!queue.isEmpty()) {
            Coordinate adj = queue.poll();
            int x = adj.x;
            int y = adj.y;
            for (int t=0; t<4; t++) {
                Coordinate coor = new Coordinate(x+directX[t], y+directY[t]);
                if (!inBound(coor, grid)) {
                    continue;
                }
                if (grid[x+directX[t]][y+directY[t]]) {
                    grid[x+directX[t]][y+directY[t]] = false;
                    queue.offer(coor);
                }
            }
        }
    }
    
    private boolean inBound(Coordinate coor, boolean[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        return coor.x>=0 && coor.x<row && coor.y>=0 && coor.y<col;
    }
    
}