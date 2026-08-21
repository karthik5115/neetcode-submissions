class WordDictionary {
    public class Trie{
        Trie[] chars;
        boolean isWord;
        Trie(){
            chars = new Trie[26];
            isWord=false;
        }
    }
    Trie head; 
    public WordDictionary() {
        head = new Trie();
    }

    public void addWord(String word) {
        Trie cur=head;
        for(int i=0;i<word.length();i++){
            int letter = word.charAt(i);
            if(cur.chars[letter-'a']==null){
                cur.chars[letter-'a']=new Trie();
            }
            cur=cur.chars[letter-'a'];
        }
        cur.isWord=true;
    }

    public boolean search(String word) {
        return search1(0,word,head);
    }
    public boolean search1(int i,String word,Trie cur){
        
        if(cur==null){
            return false;
        }
        if(i>=word.length()){
            System.out.println(i+" "+word+" "+cur.isWord);
            return cur.isWord;
        }
        char letter = word.charAt(i);
        if(letter=='.'){
            for(int j=0;j<26;j++){
                if(search1(i+1,word,cur.chars[j])){
                    return true;
                }
            }
            return false;
        }
        else if(cur.chars[letter-'a']!=null){
            return search1(i+1,word,cur.chars[letter-'a']);
        }
        return false;
    }
}
