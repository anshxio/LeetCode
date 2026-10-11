class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int res = 0;
        int prefix_sm = 0;

        for(int i = 0; i< nums.length; i++){
            prefix_sm += nums[i];

            if(map.containsKey(prefix_sm - k)){
                res += map.get(prefix_sm-k);
            }

            map.put(prefix_sm, map.getOrDefault(prefix_sm, 0) + 1);
        }
        return res;
    }
}