
class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int insertions = 0;

        char[] arr = s.toCharArray();  

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (c == '(') {
                stack.push('(');
            } else { 
                if (i + 1 < arr.length && arr[i + 1] == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();     
                    } else {
                        insertions++;      
                    }
                    i++; 
                } else {
                   
                    if (!stack.isEmpty()) {
                        stack.pop();       
                        insertions++; 
                    } else {
                        insertions += 2;   
                    }
                }
            }
        }
        insertions += stack.size() * 2;
        return insertions;
    }
}