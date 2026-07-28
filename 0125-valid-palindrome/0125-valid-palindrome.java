class Solution {
    public boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        while (l <= r) {
            char ch1 = s.charAt(l);
            char ch2 = s.charAt(r);

            if(!isAlphanumeric(ch1)){
                l++;
                continue;
            }

            if(!isAlphanumeric(ch2)){
                r--;
                continue;
            }


            if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public boolean isAlphanumeric(char c){
        if(c >= 'a' &&  c <= 'z' || c >= 'A' &&  c <= 'Z' || c >= '0' &&  c <= '9'){
            return true;
        }
        return false;
    }
}