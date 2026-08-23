class Solution {
    
    public int calPoints(String[] operations) {
        Stack<Integer> stk = new Stack<>();
        for(String i:operations){
            if(i.equals("+")){
                int peek1 = stk.pop();
                int peek2 = stk.peek();
                stk.push(peek1);
                stk.push(peek1+peek2);
            }
            else if(i.equals("C")){
                stk.pop();
            }
            else if(i.equals("D")){
                int peek1 = stk.pop();
                stk.push(peek1);
                stk.push(peek1*2);
            }
            else{
                stk.push(Integer.parseInt(i));
            }

        }
        int ans=0;
        while(!stk.isEmpty()){
            ans+=stk.pop();
        }
        return ans;
        
    }
}