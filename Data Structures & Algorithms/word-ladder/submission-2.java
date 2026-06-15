class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean ty=false;
        for(String s:wordList){
            if(s.equals(endWord)){
                ty=true;
                break;
            }
        }
        if(!ty){
            return 0;
        }

        wordList.add(beginWord);
        HashMap<String,ArrayList<String>> adj = new HashMap<>();
        for(String word:wordList){
            for(int j=0;j<word.length();j++){
                String pattern = word.substring(0,j)+"*"+word.substring(j+1,word.length());
                ArrayList<String> x = adj.getOrDefault(pattern,new ArrayList<>());
                x.add(word);
                adj.put(pattern,x);
            }
        }
    HashSet<String> visited = new HashSet<>();
    Queue<String> q = new LinkedList<>();
    int res=1;
    q.offer(beginWord);
    while(!q.isEmpty()){
       int xxx = q.size();
        for(int kk=0;kk<xxx;kk++){
        String temp = q.poll();
        if(temp.equals(endWord)){
            return res;
        }
        if(!visited.contains(temp)){
            System.out.print(temp+ " ");
            visited.add(temp);
            for(int j=0;j<temp.length();j++){
                String pattern = temp.substring(0,j)+"*"+temp.substring(j+1,temp.length());
                ArrayList<String> x = adj.getOrDefault(pattern,new ArrayList<>());
                for(String neigh:x){
                    q.offer(neigh);
                }
            }
        }
        }
         System.out.println();
        res++;
    }
    return 0;
        
    }
}
