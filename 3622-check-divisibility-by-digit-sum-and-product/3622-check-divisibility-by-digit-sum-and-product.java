class Solution {
    public boolean checkDivisibility(int n) {
        int digitSum = digit(n);
        if(n%digitSum == 0){
            return true;
        }
        return false;
    }
    public int digit(int n){
        int sum =0;
        int product =1;
        while(n != 0){
            sum += n%10;
            product *= n%10;
            n = n/10;
        }
        return (sum + product);
    }
}