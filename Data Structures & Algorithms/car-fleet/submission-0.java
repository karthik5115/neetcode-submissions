class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int [][] ps = new int[position.length][2];
        for(int i=0;i<position.length;i++){
            ps[i][0]=position[i];
            ps[i][1]=speed[i];
        }
        Arrays.sort(ps, (a,b)->Integer.compare(b[0],a[0]));
        Stack<Double> stk = new Stack<>();
        for(int i=0;i<position.length;i++){
            double time = (double)(target-ps[i][0])/ps[i][1];
            if(stk.isEmpty()){
                stk.push(time);
            }
            else{
                if(time>stk.peek()){
                    stk.push(time);
                }
            }
        }
        return stk.size();
    }
}
