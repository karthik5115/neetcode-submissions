class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        rec(0,0,n,0,"",ans);
        return ans;

    }
    public void rec(int open,int close,int n,int stk,String temp,List<String> ans){
        if(open==n && close==n){
            if(stk==0){
                ans.add(temp);
            }
            return;
        }
        if(close==n){
            return;
        }
        if(stk==0){
            
            rec(open+1,close,n,stk+1,temp+"(",ans);
        }
        else{
            if(open!=n){
            rec(open+1,close,n,stk+1,temp+"(",ans);
            }
            rec(open,close+1,n,stk-1,temp+")",ans);
        }

    }
}
