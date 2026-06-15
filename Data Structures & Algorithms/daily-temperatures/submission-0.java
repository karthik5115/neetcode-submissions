class Solution {
    public int[] dailyTemperatures(int[] temparatures) {
        Stack<Integer> stk = new Stack<>();
        int [] res = new int[temparatures.length];
        for(int i=temparatures.length-1;i>=0;i--){
            if(stk.isEmpty()){
                stk.push(i);
                res[i]=0;
            }
            else if(temparatures[stk.peek()]>temparatures[i]){
                res[i] = stk.peek()-i;
                    stk.push(i);
                    
            }
            else{
                while(!stk.isEmpty() && temparatures[stk.peek()]<=temparatures[i]){
                    stk.pop();
                }
                if(stk.isEmpty()){
                    res[i]=0;
                }
                else{
                    res[i] = stk.peek()-i;
                }
                stk.push(i);
                
            }
        }
        return res;
    }
}
