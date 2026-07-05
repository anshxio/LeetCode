class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, r = 0;
        int maxFreq = 0;
        int maxLength = 0;
        int [] freq = new int[26];
        while (r < n) {
            int idx = s.charAt(r) - 'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq,freq[idx]);
            if((r - l + 1) - maxFreq > k) {
                freq[s.charAt(l) -'A']--;
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}