class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot){
                l1.add(nums[i]);
            }else if(nums[i] == pivot){
                l2.add(nums[i]);
            }else{
                l3.add(nums[i]);
            }
        }

        int[] ans = new int[nums.length];
        int k = 0;
        for (int num : l1) {
            ans[k++] = num;
        }

        for (int num : l2) {
            ans[k++] = num;
        }

        for (int num : l3) {
            ans[k++] = num;
        }
        return ans;
    }
}