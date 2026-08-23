class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] hash = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(hash, -1);

        int maxIndex =0;
        int maxLength =1;

        for(int i =0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[i] % nums[prev] == 0 && dp[prev] + 1 > dp[i]){
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }
            if(dp[i] > maxLength){
                maxLength = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(maxIndex != -1){
            ans.add(nums[maxIndex]);
            maxIndex = hash[maxIndex];
        }
        return ans;
    }
}