class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> Rq = new LinkedList<>();
         Queue<Integer> Dq = new LinkedList<>();
         for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){
                Rq.offer(i);
            }
            else{
                Dq.offer(i);
            }
         }
         while(Rq.size()!=0 && Dq.size()!=0){
            int ind1 = Rq.poll();
            int ind2 = Dq.poll();
            if(ind1<ind2){
                Rq.offer(ind1+senate.length());
            }
            else{
                Dq.offer(ind2+senate.length());
            }
         }
         if(Rq.size()!=0){
            return "Radiant";
         }
         return "Dire";
        
    }
}