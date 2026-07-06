class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int ans = subArrays(nums,k) - subArrays(nums, k-1);
        return ans;
    }
    public int subArrays(int[] nums, int k) {
        int n =nums.length;
        int l=0, r=0;
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r<n){
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);
            while(map.size() > k){
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }
            count = count+ (r-l+1);
            r++;
        }
        return count;
    }
}