public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] input = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        System.out.println(maxAreaOfIsland(input));
    }

    private static int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int area = maxArea(grid, visited, i, j);
                    if(maxArea < area)
                        maxArea = area;
                }
            }
        }
        return maxArea;
    }

    private static int maxArea(int[][] grid, boolean[][] visited, int i, int j){
        int maxArea = 1;
        visited[i][j] = true;
        if(grid[i][j] == 0) return 0;
        else{
            if(j < grid[0].length-1 && grid[i][j+1] == 1 && !visited[i][j+1])
                maxArea += maxArea(grid, visited, i, j+1);
            if(i < grid.length-1 && grid[i+1][j] == 1 && !visited[i+1][j])
                maxArea += maxArea(grid, visited, i+1, j);
            if(j > 0 && grid[i][j-1] == 1 && !visited[i][j-1])
                maxArea += maxArea(grid, visited, i, j-1);
            if(i > 0 && grid[i-1][j] == 1 && !visited[i-1][j])
                maxArea += maxArea(grid, visited, i-1, j);
        }
        return maxArea;
    }
}
