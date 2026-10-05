class Solution {
    public int scoreOfParentheses(String s) {
        int depth = 0;
        int score = 0;
        Stack<Character> st = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(ch);
                depth++;
                System.out.println(depth);
            }
            if(ch == ')'){
                st.pop();

                if(s.charAt(i - 1) == '('){
                    score += (int)Math.pow(2, depth - 1);
                }
                
                depth--;
            }
        }
        return score;
    }
}