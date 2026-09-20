class Solution {
    public int reverseDegree(String s) {
        int product = 1;
        int sum = 0;
        for(int i = 1; i <= s.length(); i++){
            char ch = s.charAt(i-1);
            product = i * (revDegree(ch));
            System.out.println("product " + product);
            sum += product;
            System.out.println("sum " + sum);
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