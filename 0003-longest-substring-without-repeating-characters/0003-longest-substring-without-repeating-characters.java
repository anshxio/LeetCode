class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLength =0;
        int n = s.length();
        int l=0, r =0;
        while(r < n){
            if(!map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),r);
                maxLength = Math.max(maxLength, r-l+1);
                r++;
            }else{
                int idx = map.get(s.charAt(r));
                map.clear();
                l=r=idx+1;
            }
        } 
        return maxLength;
    }
}