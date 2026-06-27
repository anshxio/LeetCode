class Disjoint {
	int[] parent;
	int[] rank;
	
	Disjoint(int n) {
		parent = new int[n];
		rank = new int[n];
		
		for (int i = 0; i<n; i++) {
			parent[i] = i;
		}
	}
	
	int find(int node) {
		if (parent[node] == node) {
			return node;
		}
		return parent[node] = find(parent[node]);
	}
	void union (int u, int v) {
		int pu = find(u);
		int pv = find(v);
		
		if (pu == pv) {
			return;
		}
		if (rank[pu] < rank[pv]) {
			parent[pu] = pv;
		}
		else if (rank[pv] < rank[pu]) {
			parent[pv] = pu;
		}
		else {
			parent[pv] = pu;
			rank[pu]++;
		}
	}
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        HashMap<String,Integer> map = new HashMap<>();
        Disjoint ds = new Disjoint(n);

        for(int i=0; i<n; i++){
            List<String> account = accounts.get(i);

            for(int j=1; j<account.size(); j++){
                String email = account.get(j);
                if(!map.containsKey(email)){
                    map.put(email,i);
                }else{
                    ds.union(i,map.get(email));
                }
            }
        }
        HashMap<Integer, List<String>> merged = new HashMap<>();

        for(String email: map.keySet()){
            int leader = ds.find(map.get(email));
            merged.putIfAbsent(leader, new ArrayList<>());
            merged.get(leader).add(email);
        }
        List<List<String>> ans = new ArrayList<>();

        for(int leader: merged.keySet()){
            List<String> emails = merged.get(leader);

            Collections.sort(emails);

            List<String> temp = new ArrayList<>();

            temp.add(accounts.get(leader).get(0));
            temp.addAll(emails);
            ans.add(temp);
        }
        return ans;
    }
}