class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        helper(0,s, partition, res);
        return res;
    }
    public void helper(int index, String s, List<String> partition, List<List<String>> res ){
        if(index == s.length()){
            res.add(new ArrayList<>(partition));
            return;
        }
        for(int i= index; i< s.length(); i++){
            if(isPalindrome(s,index,i)){
                partition.add(s.substring(index, i+1));
                helper(i+1,s,partition,res);
                partition.remove(partition.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}