class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, r = 0;
        int maxFreq = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < n) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));
            while ((r - l + 1) - maxFreq > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                maxFreq = 0;
                for (int freq : map.values()) {
                    maxFreq = Math.max(maxFreq, freq);
                }
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}