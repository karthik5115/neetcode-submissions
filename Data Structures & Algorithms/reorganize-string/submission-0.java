class Solution {
    public String reorganizeString(String s) {
       int [] freq = new int [26];
       for(char c:s.toCharArray()){
        freq[c-'a']++;
       }
       Queue<int []> q = new PriorityQueue<>((a,b)->b[0]-a[0]);
       for(int i=0;i<26;i++){
            if(freq[i]>0)
            q.offer(new int[]{freq[i],i});
       }
       StringBuilder res = new StringBuilder();
       int [] prev = null;
       while(!q.isEmpty() || prev!=null){
            if(prev!=null && q.isEmpty()){
                return "";
            }
            int [] cur = q.poll();
            res.append((char)(cur[1]+'a'));
            cur[0]--;
            if(prev!=null){
                q.offer(prev);
                prev=null;
            }
            if(cur[0]>0){
                prev=cur;
            }

       }
       return res.toString();
    }
}