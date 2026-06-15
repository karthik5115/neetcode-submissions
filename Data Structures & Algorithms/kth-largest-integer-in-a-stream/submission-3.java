class KthLargest {
    Queue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        heap = new PriorityQueue<>();
        for(int i:nums){
            if(heap.size()<k){
                heap.offer(i);
            }
            else if(heap.peek()<i){
                heap.poll();
                heap.offer(i);
            }
        } 
        System.out.println(heap);   
    }
    
    public int add(int i) {
        //System.out.println(heap.peek());
        if(!heap.isEmpty() && i<heap.peek()){
            return heap.peek();
        }
        if(heap.size()<k){
                heap.offer(i);
            }
            else{
                heap.poll();
                heap.offer(i);
            }
           return heap.peek();
        }
        
        
    }

