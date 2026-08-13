class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int best;
        int len;

        Node(char c) {
            leftChar = c;
            rightChar = c;
            prefix = 1;
            suffix = 1;
            best = 1;
            len = 1;
        }

        Node() {
        }
    }

    Node[] tree;
    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        int n = s.length();
        tree = new Node[4 * n];
        build(1, 0, n - 1, s);
        int q = queryIndices.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            update(1, 0, n - 1, index, ch);

            ans[i] = tree[1].best;
        }

        return ans;
    }
    void build(int node, int l, int r, String s) {
        if (l == r) {
            tree[node] = new Node(s.charAt(l));
            return;
        }
        int mid = l + (r - l) / 2;
        build(node * 2, l, mid, s);
        build(node * 2 + 1, mid + 1, r, s);
        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]);
    }
    void update(
            int node,
            int l,
            int r,
            int index,
            char ch) {

        if (l == r) {
            tree[node] = new Node(ch);
            return;
        }
        int mid = l + (r - l) / 2;
        if (index <= mid) {

            update(
                    node * 2,
                    l,
                    mid,
                    index,
                    ch);
        } else {

            update(
                    node * 2 + 1,
                    mid + 1,
                    r,
                    index,
                    ch);
        }

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]);
    }

    Node merge(Node a, Node b) {
        Node res = new Node();
        res.len = a.len + b.len;

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;
        res.best = Math.max(a.best, b.best);
        res.prefix = a.prefix;

        if (a.prefix == a.len &&
                a.rightChar == b.leftChar) {

            res.prefix = a.len + b.prefix;
        }
        res.suffix = b.suffix;

        if (b.suffix == b.len &&
                a.rightChar == b.leftChar) {

            res.suffix = b.len + a.suffix;
        }
        if (a.rightChar == b.leftChar) {

            res.best = Math.max(
                    res.best,
                    a.suffix + b.prefix);
        }
        return res;
    }
}