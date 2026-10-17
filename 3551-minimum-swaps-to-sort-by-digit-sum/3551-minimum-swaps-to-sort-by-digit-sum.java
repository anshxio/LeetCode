class Solution {

    public int getSum(int num){
        int sum =0;
        while(num > 0){
            sum += num % 10;
            num = num/10;
        }
        return sum;
    }
    
    public int minSwaps(int[] nums) {
        int n = nums.length;

        Integer[] sorted = new Integer[n];

        for(int i = 0; i< n; i++){
            sorted[i] = nums[i]; 
        }

        Arrays.sort(sorted, (a,b) -> {
            int sum1 = getSum(a);
            int sum2 = getSum(b);

            if(sum1 != sum2){
                return Integer.compare(sum1,sum2);
            }

            return Integer.compare(a,b);
        });

        Map<Integer, Integer> map  = new HashMap<>();

        for(int i =0; i< n; i++){
            map.put(nums[i], i);
        }

        int swap =0;

        for(int i = 0; i< n; i++){
            int currVal = nums[i];
            int expectedVal = sorted[i];

            if(currVal == expectedVal){
                continue;
            }

            int index = map.get(expectedVal);

            nums[i] = expectedVal;
            nums[index] = currVal;

            map.put(expectedVal,i);
            map.put(currVal,index);

            swap++;
        }
        return swap;
    }
}