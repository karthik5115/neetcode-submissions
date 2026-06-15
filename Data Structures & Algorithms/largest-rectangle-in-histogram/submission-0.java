class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int max_area =0;
        stk.push(-1);
        for(int i=0;i<heights.length;i++){
            if(stk.peek()==-1){
                stk.push(i);
            }
            else if(heights[stk.peek()]<heights[i]){
                stk.push(i);
            }
            else{
                while(stk.peek()!=-1 && heights[stk.peek()]>=heights[i]){
                        int high = heights[stk.pop()];
                        int pse = stk.peek();
                        int area = (i-pse-1)*high;
                        max_area = Math.max(area,max_area);
                }
                stk.push(i);
            }
        }
        while(stk.peek()!=-1){
            int high = heights[stk.pop()];
            int nse = heights.length;
            int area = (nse-stk.peek()-1)*high;
            max_area = Math.max(area,max_area);
        }
        return max_area;
    }
}
