class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i =0; i<reservedSeats.length; i++){
            int row = reservedSeats[i][0];
            int col = reservedSeats[i][1];

            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(col);
        }
        int ans = (n - map.size())*2;
        for(HashSet<Integer> seats: map.values()){
            boolean left = true;
            boolean right = true;
            boolean middle = true;

            for(int i = 2; i<=5; i++){
                if(seats.contains(i)){
                    left = false;
                    break;
                }
            }
            for(int i = 6; i<=9; i++){
                if(seats.contains(i)){
                    right = false;
                    break;
                }
            }
            for(int i=4; i<=7; i++){
                if(seats.contains(i)){
                    middle = false;
                    break;
                }
            }

            if(left && right){
                 ans += 2;
            }
            else if(left || right || middle){
                ans += 1;
            }
        }
        return ans;
    }
}