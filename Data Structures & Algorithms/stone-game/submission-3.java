class Solution {
    int[][] dp;
    public boolean stoneGame(int[] piles) {
        dp = new int[piles.length][piles.length];
        for (int[] xx : dp) {
            Arrays.fill(xx, -1);
        }
        int total = 0;
        for (int su : piles) {
            total += su;
        }
        int score = rec(0, piles.length - 1, piles);
        return score > total - score;
    }
    public int rec(int l, int r, int[] piles) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        boolean even = (r - l + 1) % 2 == 0;
        int lef = even ? piles[l] : 0;
        int rig = even ? piles[r] : 0;

        int x = Math.max(lef + rec(l + 1, r, piles), rig + rec(l, r - 1, piles));

        return dp[l][r] = x;
    }
}