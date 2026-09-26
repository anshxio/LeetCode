class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for(List<String> pair: knowledge){
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder res = new StringBuilder("");
        StringBuilder key = new StringBuilder("");

        boolean inside = false;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                inside = true;
                key.setLength(0);
            }else if(ch == ')'){
                inside = false;
                String val = map.get(key.toString());
                
                if(val != null){
                    res.append(val);
                }else{
                    res.append('?');
                }
            }else if(inside){
                key.append(ch);
            }else{
                res.append(ch);
            }
        }
        return res.toString();
    }
}