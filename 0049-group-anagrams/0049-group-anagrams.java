class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();

        for(int i = 0; i<strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);

            String s = new String(arr);
            if(!mp.containsKey(s)){
                mp.put(s, new ArrayList<>());
            }
            mp.get(s).add(strs[i]);
        }
        return new ArrayList<>(mp.values());
    }
}