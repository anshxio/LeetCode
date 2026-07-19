class RandomizedSet {
    List<Integer> ls;
    HashMap<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        ls = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        ls.add(val);
        map.put(val, ls.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        int lastVal = ls.get(ls.size()-1);

        ls.set(index,lastVal);
        map.put(lastVal, index);

        ls.remove(ls.size()-1);
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        int index = random.nextInt(ls.size());
        return ls.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */