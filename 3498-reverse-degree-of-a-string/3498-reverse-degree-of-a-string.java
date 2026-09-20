class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i = 1; i <= s.length(); i++){
            int product = i * (revDegree(s.charAt(i-1)));
            sum += product;
        }
        return sum;
    }
    public int revDegree(char ch){
        if(ch >= 'a' && ch <= 'z'){
            return  1+('z' - ch);
        }
        return 0;
    }
}