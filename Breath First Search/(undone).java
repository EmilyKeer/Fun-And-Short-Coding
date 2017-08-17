/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int[] directX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] directY = {2, -2, 2, -2, 1, -1, 1, -1};
        int step = 0;
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(source);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Point cur = queue.poll();
                if (cur.x == destination.x && cur.y == destination.y) {
                    return step;
                }
                grid[cur.x][cur.y] = true; //visited
                for (int t=0; t<8; t++) {
                    int nextX = cur.x+directX[t];
                    int nextY = cur.y+directY[t];
                    if (!inBoundAndNotVisited(nextX, nextY, grid)) {
                        continue;
                    }
                    Point next = new Point(nextX, nextY);
                    queue.offer(next);
                }
            }
            step++;
        }
        return -1;
    }
    private boolean inBoundAndNotVisited (int nextX, int nextY, boolean grid[][]) {
        if (nextX<0 || nextX>=grid.length) {
            return false;
        }
        if (nextY<0 || nextY>=grid[0].length) {
            return false;
        }
        return (!grid[nextX][nextY]); //not visited and not 1 initially
    }
}





/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
     int n, m; // size of the chessboard
     int[] directX = {1, 1, -1, -1, 2, 2, -2, -2};
     int[] directY = {2, -2, 2, -2, 1, -1, 1, -1};
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        n = grid.length;
        m = grid[0].length;

        
        int step = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Point cur = queue.poll();
                if (cur.x == destination.x && cur.y == destination.y) {
                    return step;
                }
                for (int t=0; t<8; t++) {
                    int nextX = cur.x+directX[t];
                    int nextY = cur.y+directY[t];
                    Point next = new Point(nextX, nextY);
                    if (!inBoundAndNotVisited(next, grid)) {
                        continue;
                    }
                    
                    queue.offer(next);
                    grid[cur.x][cur.y] = true; //visited
                }
            }
            step++;
        }
        return -1;
    }
    private boolean inBoundAndNotVisited (Point next, boolean grid[][]) {
        if (next.x<0 || next.x>=n) {
            return false;
        }
        if (next.y<0 || next.y>=m) {
            return false;
        }
        return (grid[next.x][next.y] == false); //not visited and not 1 initially
    }
}

