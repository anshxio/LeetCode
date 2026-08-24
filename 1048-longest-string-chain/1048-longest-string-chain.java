class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b) -> a.length() - b.length());
        int n = words.length;

        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        int maxLength = 1;
        for(int i =0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(compare(words[i], words[prev]) && dp[prev] + 1 > dp[i]){
                    dp[i] = dp[prev] + 1;
                }
            }
            if(dp[i] > maxLength){
                maxLength = dp[i];
            }
        }
        return maxLength;
    }
    public boolean compare(String s1, String s2){
        if(s1.length() != s2.length() + 1){
            return false;
        }
        int first = 0;
        int second = 0;

        while(first < s1.length() && second < s2.length()){
            if(s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }
        return second == s2.length();
    }
}