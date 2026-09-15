class Solution {
    public int minEatingSpeed(int[] piles, int h) {        
        int low = 1;
        int high = maxLimit(piles);
        while(low <= high){
            int mid = low + (high - low)/2;
            if(totalHour(piles,mid) <= h){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public long totalHour(int[] piles, int hour){
        long totalTime = 0;
        for(int pile: piles){
            totalTime += Math.ceil((double)pile/hour);
        }
        return totalTime;
    }

    public int maxLimit(int[]piles){
        int max = piles[0];
        for(int i =0; i< piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        return max;
    }
}