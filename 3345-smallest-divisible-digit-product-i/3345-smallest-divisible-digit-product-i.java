class Solution {
    public int smallestNumber(int n, int t) {
        while(product_of_digits(n) % t != 0 ){
            n++;
        }
        return n;
    }
    public int product_of_digits(int n){

        int product = 1;
        while(n > 0){

            int digit = n % 10;
            product *= digit;
            n = n/10;
        }
        return product;
    }
}