class Solution {
     class unionFind{
            int[] parent;
            int[] rank;
            unionFind(int n){
                this.parent = new int[n];
                this.rank = new int[n];
                for(int i=0;i<n;i++){
                    parent[i]=i;
                    rank[i]=1;
                }
            }
            int find(int x){
                if(parent[x]!=x){
                    parent[x]=find(parent[x]);
                }
                return parent[x];
            }
            void union(int x,int y){
                int p1=parent[x];
                int p2=parent[y];
                if(p1==p2){
                    return;
                }
                if(rank[p1]>rank[p2]){
                    parent[p2]=p1;
                    rank[p1]+=rank[p2];
                }
                else{
                    parent[p1]=p2;
                    rank[p2]+=rank[p1];
                }
            }
        }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
       Map<String,Integer> emailtoId = new HashMap<>();
       int n = accounts.size();
       unionFind unionf = new unionFind(n);
       for(int i=0;i<n;i++){
        List<String> emails = accounts.get(i);
        for(int j=1;j<emails.size();j++){
            if(emailtoId.containsKey(emails.get(j))){
                unionf.union(i,emailtoId.get(emails.get(j)));
            }
            else{
                emailtoId.put(emails.get(j),i);
            }
        }
       }
        Map<Integer,List<String>> emailsGroup = new HashMap<>();
        for(Map.Entry<String,Integer> ent :emailtoId.entrySet()){
            int root = unionf.find(ent.getValue());
            List<String> temp = emailsGroup.getOrDefault(root,new ArrayList<>());
            temp.add(ent.getKey());
            emailsGroup.put(root,temp);
            
        }

        List<List<String>> ans= new ArrayList<>();
        for(Map.Entry<Integer,List<String>> ent :emailsGroup.entrySet()){
            int id = ent.getKey();
            List<String> temp1 = ent.getValue();
            Collections.sort(temp1);
            String name = accounts.get(id).get(0);
            List<String> temp = new ArrayList<>();
            temp.add(name);
            temp.addAll(temp1);
            ans.add(temp);
        }
        return ans;

       }  
       
        
    }
