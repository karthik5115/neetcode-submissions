class Solution {
    public boolean isAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();i++){
            //System.out.println(map);
            if(map.containsKey(t.charAt(i))){
            map.put(t.charAt(i),map.get(t.charAt(i))-1);
            if(map.get(t.charAt(i))==0){
                map.remove(t.charAt(i));
            }
            }
            else{
                return false;
            }
        }
        return map.size()==0;

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        for(String x:strs){
            boolean ty=true;
            for(int i=0;i<ans.size();i++){
                if(isAnagram(x,ans.get(i).get(0))){
                    ty=false;
                    ans.get(i).add(x);
                }
            }
            if(ty){
                List<String> xx = new ArrayList<>();
                xx.add(x);
                ans.add(xx);
            }
        }
        return ans;
    }
}
