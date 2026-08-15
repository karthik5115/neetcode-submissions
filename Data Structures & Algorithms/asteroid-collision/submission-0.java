class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(Integer i: asteroids){
            if(stk.isEmpty()){
                stk.push(i);
            }
            else if(i<0){
                boolean add=true;
                while(!stk.isEmpty() && stk.peek()>0){
                    if(Math.abs(i)>stk.peek()){
                        stk.pop();
                    }
                    else if(Math.abs(i)==stk.peek()){
                        stk.pop();
                        add=false;
                        break;
                    }
                    else{
                        add=false;
                        break;
                    }
                }
                if(add){
                    stk.push(i);
                }

            }
            else{
                stk.push(i);
            }
        }
        int [] ans = new int[stk.size()];
        for(int i=stk.size()-1;i>=0;i--){
            ans[i]=stk.pop();
        }
        return ans; 
    }
}