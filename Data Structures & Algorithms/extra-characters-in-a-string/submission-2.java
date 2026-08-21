class Solution {

    class Trie {
        Trie[] chars = new Trie[26];
        boolean isWord;
    }

    Trie head;
    int[] dp;

    public int minExtraChar(String s, String[] dictionary) {

        head = new Trie();

        for (String word : dictionary) {
            addWord(word);
        }

        dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return dfs(0, s);
    }

    private void addWord(String word) {

        Trie cur = head;

        for (char c : word.toCharArray()) {

            int idx = c - 'a';

            if (cur.chars[idx] == null) {
                cur.chars[idx] = new Trie();
            }

            cur = cur.chars[idx];
        }

        cur.isWord = true;
    }

    private int dfs(int i, String s) {

        if (i == s.length()) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // Consider s[i] as an extra character
        int ans = 1 + dfs(i + 1, s);

        Trie cur = head;

        // Try dictionary words starting from i
        for (int j = i; j < s.length(); j++) {

            int idx = s.charAt(j) - 'a';

            if (cur.chars[idx] == null) {
                break;
            }

            cur = cur.chars[idx];

            if (cur.isWord) {
                ans = Math.min(ans, dfs(j + 1, s));
            }
        }

        return dp[i] = ans;
    }
}