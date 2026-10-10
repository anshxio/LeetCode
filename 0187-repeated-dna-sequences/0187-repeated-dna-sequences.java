class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for(int i = 0 ; i<= s.length() - 10; i++){
            String st = s.substring(i, i+10);

            if(!seen.contains(st)){
                seen.add(st);
            }else{
                repeated.add(st);
            }
        }
        return new ArrayList<>(repeated);
    }
}