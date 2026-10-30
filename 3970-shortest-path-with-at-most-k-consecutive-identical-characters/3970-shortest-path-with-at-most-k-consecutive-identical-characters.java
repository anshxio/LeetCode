class Solution {

    class State {
        int node;
        long cost;
        int count;

        State(int node, long cost, int count) {
            this.node = node;
            this.cost = cost;
            this.count = count;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<State>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new State(v, wt, 0));
        }

        long[][] dis = new long[n][k + 1];

        for (long[] row : dis) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.cost, b.cost)
        );

        dis[0][1] = 0;
        pq.offer(new State(0, 0, 1));

        while (!pq.isEmpty()) {

            State curr = pq.poll();

            int node = curr.node;
            long cost = curr.cost;
            int count = curr.count;

            if (cost > dis[node][count]) {
                continue;
            }

            for (State nbr : adj.get(node)) {

                int adjNode = nbr.node;
                int adjCost = (int) nbr.cost;
                int newCount;
                if (labels.charAt(node) == labels.charAt(adjNode)) {
                    newCount = count + 1;
                } 
                else {
                    newCount = 1;
                }
                if (newCount > k) {
                    continue;
                }

                long newCost = cost + adjCost;
                if (newCost < dis[adjNode][newCount]) {

                    dis[adjNode][newCount] = newCost;

                    pq.offer(
                        new State(adjNode, newCost, newCount)
                    );
                }
            }
        }
        long ans = Long.MAX_VALUE;
        for (int count = 1; count <= k; count++) {
            ans = Math.min(ans, dis[n - 1][count]);
        }
        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
}
