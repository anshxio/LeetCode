class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n]; 
        for(int i =0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return lcs(0,n-1,s,dp);
    }
    private int lcs(int index1, int index2, String s, int[][] dp){
        if(index1 > index2){
            return 0;
        }
        if(index1 == index2){
            return 1;
        }
        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }

        if(s.charAt(index1) == s.charAt(index2)){
            return dp[index1][index2] = 2 + lcs(index1+1,index2-1,s,dp);
        }
        return dp[index1][index2] = Math.max(lcs(index1+1, index2, s, dp), lcs(index1, index2-1,s,dp));
    }
}