class Solution {
    public String simplifyPath(String path) {
        path+="/";
        int x = 0,n=path.length();
        Stack<String> stk = new Stack<>();
        String fn = "";
        while(x<n){
            if(path.charAt(x)=='/'){
                System.out.println(fn+" "+stk);
                if(fn!=""){
                    if(fn.equals("..")){
                        if(!stk.isEmpty()){
                            stk.pop();
                        }
                    }
                    else if(!fn.equals(".")){
                        stk.push(fn);
                    }
                        fn="";
                }
                
            }
            else{
                    fn+=path.charAt(x);
                }
            
                x++;
        }
        String ans = "";
        if(stk.isEmpty()){
            return "/";
        }
        while(!stk.isEmpty()){
            ans = "/"+stk.pop()+ans; 
        }
        return ans;
    }
}