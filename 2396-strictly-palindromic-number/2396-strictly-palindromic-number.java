class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            int temp = n;
            StringBuilder base = new StringBuilder();

            while (temp != 0) {
                base.append(temp % i);
                temp /= i;
            }

            if (!palindrome(base)) {
                return false;
            }
        }
        return true;
    }

    public boolean palindrome(StringBuilder b) {
        int left = 0;
        int right = b.length() - 1;

        while (left < right) {
            if (b.charAt(left) != b.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}