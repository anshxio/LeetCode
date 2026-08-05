class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        Boolean[][] dp = new Boolean[n][m];
        
        return patternMatch(n-1, m-1, s, p, dp);
    }
    public boolean patternMatch(int i, int j, String s, String p, Boolean[][]dp){
        if(i < 0 && j< 0){
            return true;
        }
        if(j < 0){
            return false;
        }
        if( i < 0){
            for(int pt = 0; pt <= j; pt++){
                if(p.charAt(pt) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j] = patternMatch(i-1,j-1,s,p, dp);
        }
        if(p.charAt(j) == '*'){
            return dp[i][j] = patternMatch(i-1, j, s, p, dp) || patternMatch(i, j-1, s, p, dp);  
        }
        return dp[i][j] = false;
    }
}