class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return n + m- 2*lcs(n-1, m-1, word1, word2, dp);
    }

    private int lcs(int index1, int index2, String s1, String s2, int[][] dp) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (s1.charAt(index1) == s2.charAt(index2)) {
            return dp[index1][index2] = 1 + lcs(index1 - 1, index2 - 1, s1,s2, dp);
        }
        return dp[index1][index2] = Math.max(lcs(index1 - 1, index2, s1,s2, dp), lcs(index1, index2 - 1, s1, s2, dp));
    }
}