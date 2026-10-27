class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        Queue<int[]> q = new PriorityQueue<>((d,e)->e[0]-d[0]);
        if(a>0) q.offer(new int[]{a,0});
        if(b>0) q.offer(new int[]{b,1});
        if(c>0) q.offer(new int[]{c,2});

        while(!q.isEmpty()){
            int [] f = q.poll();
            if(res.length()>1 && res.charAt(res.length()-1)==(f[1]+'a') && res.charAt(res.length()-2)==(f[1]+'a')){
                if(q.isEmpty()) break;
                int [] s = q.poll();
                q.offer(f);
                res.append((char)(s[1]+'a'));
                s[0]--;
                if(s[0]>0) q.offer(s);
            }
            else{
                res.append((char)(f[1]+'a'));
                f[0]--;
                if(f[0]>0) q.offer(f);
            }
        }
        return res.toString();
        
    }
}