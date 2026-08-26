class Solution {
    class Pair{
        String var;
        double weight;
        Pair(String var,double weight){
            this.var=var;
            this.weight=weight;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,List<Pair>> map = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            map.putIfAbsent(a,new ArrayList<>());
            map.putIfAbsent(b,new ArrayList<>());
            List<Pair> temp1 = map.get(a);
            List<Pair> temp2 = map.get(b);
            temp1.add(new Pair(b,val));
            temp2.add(new Pair(a,1/val));
        }
        double[] ans = new double[queries.size()];
        int cnt=0;
        for(List<String> que:queries){
            String source = que.get(0),target=que.get(1);
            if(!map.containsKey(source) || !map.containsKey(target)){
                ans[cnt++]=-1.0;
                continue;
            }
            if(source.equals(target)){
                ans[cnt++]=1.0;
                continue;

            }
            Queue<Pair> q= new LinkedList<>();
            q.offer(new Pair(source,1.0));
            HashSet<String> visited = new HashSet<>();
            visited.add(source);
            boolean ty=true;
            while(!q.isEmpty()){
                Pair curp = q.poll();
                if(curp.var.equals(target)){
                        ans[cnt++]=curp.weight;
                        ty=false;
                        break;
                    }
                for(Pair adjs:map.get(curp.var)){
                    if(!visited.contains(adjs.var)){
                        visited.add(adjs.var);
                        q.offer(new Pair(adjs.var,curp.weight * adjs.weight));
                    }
                }
            }
            if(ty){
                ans[cnt++]=-1.0;
            }

        }
        return ans;
        
    }
}