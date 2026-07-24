class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int m = n / 2;

        int[] left = Arrays.copyOfRange(nums, 0, m);
        int[] right = Arrays.copyOfRange(nums, m, n);

        int totalSum = 0;
        for (int x : nums)
            totalSum += x;

        List<Integer>[] leftSum = new ArrayList[m + 1];
        List<Integer>[] rightSum = new ArrayList[m + 1];

        for (int i = 0; i <= m; i++) {
            leftSum[i] = new ArrayList<>();
            rightSum[i] = new ArrayList<>();
        }
        for (int mask = 0; mask < (1 << m); mask++) {

            int cnt = 0;
            int lsum = 0;
            int rsum = 0;

            for (int j = 0; j < m; j++) {
                if ((mask & (1 << j)) != 0) {
                    cnt++;
                    lsum += left[j];
                    rsum += right[j];
                }
            }

            leftSum[cnt].add(lsum);
            rightSum[cnt].add(rsum);
        }

        for (int i = 0; i <= m; i++) {
            Collections.sort(rightSum[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int leftCount = 0; leftCount <= m; leftCount++) {

            int rightCount = m - leftCount;

            List<Integer> L = leftSum[leftCount];
            List<Integer> R = rightSum[rightCount];

            for (int s1 : L) {

                int target = totalSum / 2 - s1;

                int idx = Collections.binarySearch(R, target);

                if (idx < 0)
                    idx = -idx - 1;

                if (idx < R.size()) {
                    int selected = s1 + R.get(idx);
                    ans = Math.min(ans,
                            Math.abs(totalSum - 2 * selected));
                }

                if (idx > 0) {
                    int selected = s1 + R.get(idx - 1);
                    ans = Math.min(ans,
                            Math.abs(totalSum - 2 * selected));
                }
            }
        }

        return ans;
    }
}