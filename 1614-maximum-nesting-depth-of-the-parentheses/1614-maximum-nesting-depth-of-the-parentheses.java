class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int res = 0;

        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '('){
                st.push('(');
                res = Math.max(res,st.size());
            }else if(s.charAt(i) == ')'){
                st.pop();
            }
        }
        return res;
    }
}