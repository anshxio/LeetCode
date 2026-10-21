class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        int[] next = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int element = nums2[i];

            if (st.isEmpty()) {
                st.push(element);
                next[i] = -1;
                continue;
            }
            if (element < st.peek()) {
                next[i] = st.peek();
                st.push(element);
                continue;
            }

            while (!st.isEmpty() && element >= st.peek()) {
                st.pop();
            }

            if (st.isEmpty()) {
                next[i] = -1;
            } else {
                next[i] = st.peek();
            }

            st.push(element);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], next[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}