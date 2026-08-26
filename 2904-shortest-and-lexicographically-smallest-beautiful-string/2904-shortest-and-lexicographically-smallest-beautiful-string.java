class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        String ans = "";
        for(int right = 0; right < s.length(); right++){
            if(s.charAt(right) == '1'){
                count++;
            }
            while(count == k){
                int len = right - left + 1;
                String curr = s.substring(left, right+1);
                if(len < minLength || len == minLength && (ans.equals("") || curr.compareTo(ans) < 0)){
                    minLength = len;
                    ans = curr;
                }
                if(s.charAt(left) == '1'){
                    count--;
                }
                left++;
            }
        }
        return ans;
    }
}