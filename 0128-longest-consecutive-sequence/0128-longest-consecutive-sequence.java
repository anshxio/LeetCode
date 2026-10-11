class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> map = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            map.add(nums[i]);
        }

        int longest = 0;
        for(int i: map){
            if(!map.contains(i - 1)){
                int curr = i;
                int count = 1;

                while(map.contains(curr+1)){
                    curr++;
                    count++;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;
    }
}