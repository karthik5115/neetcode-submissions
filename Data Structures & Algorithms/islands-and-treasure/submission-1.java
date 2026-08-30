class Solution {

    public void islandsAndTreasure(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int i = cur[0];
            int j = cur[1];

            for (int[] dir : dirs) {

                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni < 0 || ni >= m ||
                    nj < 0 || nj >= n ||
                    grid[ni][nj] == -1 ||
                    grid[ni][nj] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[ni][nj] = grid[i][j] + 1;

                q.offer(new int[]{ni, nj});
            }
        }
    }
}