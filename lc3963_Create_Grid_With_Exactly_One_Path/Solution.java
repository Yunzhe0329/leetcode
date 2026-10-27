package lc3963_Create_Grid_With_Exactly_One_Path;

class Solution {
    public String[] createGrid(int m, int n) {
        // in 1-step, you can go right or go down
        // create an L for valid grid
        // from grid[0][0...n - 1] => "."
        // from grid[i][n - 1] => "."
        String[] grid = new String[m];
        char[] row = new char[n];
        for(int i = 0; i < n; i++){
            row[i] = '#';
        }
        // initialize as all '#' in grid
        for(int i = 0; i < m; i++){
            grid[i] = new String(row);
        }

        char[] firstRow = grid[0].toCharArray();
        for(int i = 0; i < n; i++){
            firstRow[i] = '.';
        }
        grid[0] = new String(firstRow);

        for(int i = 1; i < m; i++){
            char[] str = grid[i].toCharArray();
            str[n-1] = '.';
            grid[i] = new String(str);
        }

        return grid;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.createGrid(2, 3));
    }
}