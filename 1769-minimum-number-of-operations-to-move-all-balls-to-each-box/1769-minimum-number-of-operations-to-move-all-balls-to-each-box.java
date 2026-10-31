class Solution {
    public int[] minOperations(String boxes) {

        int n = boxes.length();
        int[] ans = new int[n];

        int count = 0;
        int operations = 0;
        for (int i = 0; i < n; i++) {

            ans[i] += operations;

            if (boxes.charAt(i) == '1') {
                count++;
            }

            operations += count;
        }

        count = 0;
        operations = 0;
        for (int i = n - 1; i >= 0; i--) {

            ans[i] += operations;

            if (boxes.charAt(i) == '1') {
                count++;
            }

            operations += count;
        }

        return ans;
    }
}