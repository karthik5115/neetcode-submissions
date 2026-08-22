class Solution {
    class pair{
        String loc;
        int noturns;
        pair(String loc,int noturns){
            this.loc=loc;
            this.noturns=noturns;
        }
    }
    public List<pair> children(pair p){
        String lock = p.loc;
        List<pair> res = new ArrayList<>();
        for(int i=0;i<4;i++){
            String up = Integer.toString((Character.getNumericValue(lock.charAt(i))+1)%10);
            String down = Integer.toString((Character.getNumericValue(lock.charAt(i))-1+10)%10);
            if(i==0){
                up = up + lock.substring(i+1,4);
                down = down + lock.substring(i+1,4);
            }
            else if(i==3){
                up = lock.substring(0,i)+ up ;
                down = lock.substring(0,i)+ down;
            }
            else{
                up = lock.substring(0,i)+ up + lock.substring(i+1,4);
                down = lock.substring(0,i)+ down + lock.substring(i+1,4);
            }
            res.add(new pair(up,p.noturns+1));
            res.add(new pair(down,p.noturns+1));
        }
        return res;
    }
    public int openLock(String[] deadends, String target) {
        Queue<pair> q= new LinkedList<>();
        q.offer(new pair("0000",0));
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if(visited.contains("0000")){
            return -1;
        }
        while(!q.isEmpty()){
            pair p = q.poll();
            for(pair pc :children(p)){
                if(target.equals(pc.loc)){
                    return pc.noturns;
                }
                else if(!visited.contains(pc.loc)){
                    visited.add(pc.loc);
                    q.offer(pc);
                }
            }

        }
        return -1;
        

        
    }
}