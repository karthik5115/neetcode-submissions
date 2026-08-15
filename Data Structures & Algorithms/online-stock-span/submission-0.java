class StockSpanner {
    int index;
    Stack<Integer> stk;
    Map<Integer,Integer> map;
    public StockSpanner() {

        this.index=0;
        this.stk = new Stack<>();
        this.map = new HashMap<>();
    }
    
    public int next(int price) {
        while(!stk.isEmpty() && map.get(stk.peek())<=price){
            stk.pop();
        }
        int low = stk.isEmpty()?-1:stk.peek();
        int ans = index - low ;
        stk.push(index);
        map.put(index,price);
        index++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */