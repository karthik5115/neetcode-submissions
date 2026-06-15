class Solution {
    int[] dp;
    Set<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        dp = new int[s.length()];
        return rec(0, s);
    }

    private boolean rec(int i, String s) {
        if (i == s.length()) return true;
        if (dp[i] != 0) return dp[i] == 1;

        for (int j = i + 1; j <= s.length(); j++) {
            if (set.contains(s.substring(i, j)) && rec(j, s)) {
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = -1;
        return false;
    }
}