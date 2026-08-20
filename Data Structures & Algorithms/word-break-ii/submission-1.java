public class Solution {
class Node{
    Node [] arr;
    boolean flag;
    public Node(){
        this.arr = new Node[26];
        this.flag=false;
    }
}
class Trie {
    Node root;
    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
           if(curr.arr[index]==null){
                curr.arr[index]=new Node();
           }
           curr=curr.arr[index];
        }
        curr.flag=true;
    }
    
    public boolean search(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(curr.arr[index]==null){
                return false;
            }
            curr = curr.arr[index];
        }
        return curr.flag;
    }
}
    private Trie trie;
    private Map<Integer, List<String>> cache;

    public List<String> wordBreak(String s, List<String> wordDict) {
        trie = new Trie();
    for(String word:wordDict){
        trie.insert(word);
    }
        cache = new HashMap<>();
        return backtrack(s, 0);
    }

    private List<String> backtrack(String s, int i) {
        if (i == s.length())
            return Arrays.asList("");
        if (cache.containsKey(i))
            return cache.get(i);

        List<String> res = new ArrayList<>();
        for (int j = i; j < s.length(); j++) {
            String w = s.substring(i, j + 1);
            if (!trie.search(w))
                continue;
            List<String> strings = backtrack(s, j + 1);
            for (String substr : strings) {
                String sentence = w;
                if (!substr.isEmpty())
                    sentence += " " + substr;
                res.add(sentence);
            }
        }
        cache.put(i, res);
        return res;
    }
}