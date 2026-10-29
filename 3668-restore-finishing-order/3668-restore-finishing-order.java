class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0; i< friends.length; i++){
            map.add(friends[i]);
        }
        int k = 0;
        for(int i = 0; i<order.length; i++){
            if(map.contains(order[i])){
                friends[k++] = order[i];
            }
        }
        return friends;
    }
}