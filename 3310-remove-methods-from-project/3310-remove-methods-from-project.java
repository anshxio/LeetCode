class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edges: invocations){
            int u = edges[0];
            int v = edges[1];

            adj.get(u).add(v);
        }

        boolean[] sus = new boolean[n];
        dfs(k, adj, sus);

        for(int u =0; u < n; u++){
            for(int v: adj.get(u)){
                if(!sus[u] && sus[v]){
                    List<Integer> ans = new ArrayList<>();
                    for(int i=0; i<n; i++){
                        ans.add(i);
                    }
                    return ans;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i =0; i<n; i++){
            if(!sus[i]){
                res.add(i);
            }
        }
        return res;
    }
    public void dfs(int node, List<List<Integer>> adj, boolean[] sus){
        sus[node] = true;
        for(int edges: adj.get(node)){
            if(!sus[edges]){
                dfs(edges, adj,sus);
            }
        }
    }
}