class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum=0, rSum =0, maxSum=0;
        for(int i=0; i <= k-1; i++){
            lSum += cardPoints[i];
            maxSum = lSum;
        }
        int rightIdx = cardPoints.length-1;
        for(int i=k-1; i >=0; i--){
            lSum -= cardPoints[i];
            rSum += cardPoints[rightIdx];
            rightIdx =rightIdx- 1;
            maxSum = Math.max(maxSum, lSum+ rSum);
        }
        return maxSum;
    }
}