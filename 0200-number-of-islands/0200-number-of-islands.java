class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second= second;
    }

}

class Solution {
    public void bfs(int i, int j, int[][] vis, char[][] grid) {
        vis[i][j] = 1;
        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(i, j));
        int n = grid.length;
        int m = grid[0].length;
        int[] delRow = { 0, -1, 0, 1 };
        int[] delCol = { -1, 0, 1, 0 };
        while (!qu.isEmpty()) {
            int row = qu.peek().first;
            int col = qu.peek().second;
            qu.poll();

            for (int nei = 0; nei < 4; nei++) {
                int nRow = row + delRow[nei];
                int nCol = col + delCol[nei];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0 &&
                        grid[nRow][nCol] == '1') {
                    vis[nRow][nCol] = 1;
                    qu.offer(new Pair(nRow, nCol));
                }
            }

        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return count;
    }
}