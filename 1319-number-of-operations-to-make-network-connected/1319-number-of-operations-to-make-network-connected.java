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
    public int makeConnected(int n, int[][] connections) {
        Disjoint ds = new Disjoint(n);
        int extra =0;
        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];

            if(ds.find(u) == ds.find(v)){
                extra++;
            }
            else{
                ds.union(u,v);
            }
        }
        int countComp = 0;
        for(int i=0; i<n; i++){
            if(ds.parent[i] == i){
                countComp++;
            }
        }
        int ans = countComp -1;
        if(extra >= ans){
            return ans;
        }
        return -1;
    }
}