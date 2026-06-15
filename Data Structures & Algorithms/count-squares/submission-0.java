class CountSquares {
    HashMap<Integer,HashMap<Integer,Integer>> mp;
    public CountSquares() {
      mp  = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x=point[0],y=point[1];
        HashMap<Integer,Integer> innermap = mp.getOrDefault(x,new HashMap<>());
        innermap.put(y,innermap.getOrDefault(y,0)+1);
        mp.put(x,innermap);
        
    }
    
    public int count(int[] point) {
        int x=point[0],y=point[1],res=0;
        if(!mp.containsKey(x)){return res;}
        for(int y1:mp.get(x).keySet()){
             int side=Math.abs(y-y1);
             if(side==0){continue;}
             int x3=x-side,x4=x+side;
             res += mp.getOrDefault(x,new HashMap<>()).getOrDefault(y1,0)*mp.getOrDefault(x3,new HashMap<>()).getOrDefault(y1,0)*mp.getOrDefault(x3,new HashMap<>()).getOrDefault(y,0);
             res += mp.getOrDefault(x,new HashMap<>()).getOrDefault(y1,0)*mp.getOrDefault(x4,new HashMap<>()).getOrDefault(y1,0)*mp.getOrDefault(x4,new HashMap<>()).getOrDefault(y,0);

        }
        return res;
        
    }
}
