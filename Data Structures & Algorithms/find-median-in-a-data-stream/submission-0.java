class MedianFinder {
    Queue<Integer> maxh ;
    Queue<Integer> minh ;
    public MedianFinder() {
        maxh = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        minh = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxh.isEmpty()){
            maxh.add(num);
        }
        else if(maxh.peek()<=num){
            minh.add(num);
        }
        else{
            maxh.add(num);
        }
        if(Math.abs(maxh.size()-minh.size())>1){
            if(maxh.size()>minh.size()){
                minh.add(maxh.poll());
            }
            else{
                maxh.add(minh.poll());
            }
        }

        
    }
    
    public double findMedian() {
       int x= Math.abs(maxh.size()-minh.size());
       if(x==1){
        if(maxh.size()>minh.size()){
            return (double)maxh.peek();
        }
        else{
            return (double)minh.peek();
        }
       }
       else{
        return ((double)(maxh.peek() + minh.peek()))/2;
       }
    }
}
