class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for(int i=0;i<s.length();i++){
            char paran = s.charAt(i);
            if(map.containsKey(paran)){
                stk.push(paran);
            }
            else{
                if(stk.isEmpty()){
                    return false;
                }
                char open = stk.pop();
                if(paran!=map.get(open)){
                    return false;
                }
            }
        } 
        if(!stk.isEmpty()){
            return false;
        }
        return true;
        
    }
}