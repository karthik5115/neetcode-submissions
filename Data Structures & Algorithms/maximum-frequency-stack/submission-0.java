class FreqStack {
    Stack<int[]> stk1,stk2;
    HashMap<Integer,Integer> mp;
    public FreqStack() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
        mp = new HashMap<>();
    }
    
    public void push(int val) {
        mp.put(val,mp.getOrDefault(val,0)+1);
        int [] freq = {val,mp.get(val)};
        if(stk1.isEmpty()){
            stk1.push(freq);
        }
        else{
            while(stk1.peek()[1]>freq[1]){
                stk2.push(stk1.pop());
            }
            stk1.push(freq);
            while(!stk2.isEmpty()){
                stk1.push(stk2.pop());
            }
        }

    }
    
    public int pop() {
        mp.put(stk1.peek()[0],stk1.peek()[1]-1);
        return stk1.pop()[0];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */