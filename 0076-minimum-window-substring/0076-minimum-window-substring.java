class Solution {
    public String minWindow(String s, String t) {
        int l = 0, r = 0;
        int count = 0, maxLength = Integer.MAX_VALUE;
        int sIndx = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        while (r < s.length()) {
            if (map.containsKey(s.charAt(r))) {
                if (map.get(s.charAt(r)) > 0) {
                    count++;
                }
                map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
            }
            while (count == t.length()) {
                if ((r - l + 1) < maxLength) {
                    maxLength = r - l + 1;
                    sIndx = l;
                }
                if (map.containsKey(s.charAt(l))) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                    if (map.get(s.charAt(l)) > 0) {
                        count--;
                    }
                }
                l++;
            }
            r++;
        }
        return sIndx == -1 ? "" : s.substring(sIndx,  sIndx + maxLength);
    }
}