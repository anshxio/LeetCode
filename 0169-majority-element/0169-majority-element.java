class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i =0; i< nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(int it: map.keySet()){
            if(map.get(it) > n/2){
                return it;
            }
        }
        return -1;
    }
}