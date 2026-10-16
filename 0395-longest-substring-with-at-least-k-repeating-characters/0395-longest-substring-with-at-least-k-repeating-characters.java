class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int ans = 0;
        for (int target = 1; target <= 26; target++) {

            int[] freq = new int[26];
            int left = 0;
            int unique = 0;
            int countAtLeastK = 0;

            for (int right = 0; right < n; right++) {
                int idx = s.charAt(right) - 'a';
                if (freq[idx] == 0) {
                    unique++;
                }

                freq[idx]++;

                if (freq[idx] == k) {
                    countAtLeastK++;
                }

                while (unique > target) {
                    int leftIdx = s.charAt(left) - 'a';
                    if (freq[leftIdx] == k) {
                        countAtLeastK--;
                    }
                    freq[leftIdx]--;
                    if (freq[leftIdx] == 0) {
                        unique--;
                    }
                    left++;
                }
                if (unique == target && countAtLeastK == target) {
                    ans = Math.max(ans, right - left + 1);
                }
            }
        }

        return ans;
    }
}