class PrefixTree {
   class Node{
        Node [] alph = new Node [26];
        boolean word;
    }
    Node head;
    public PrefixTree() {
        head = new Node();
         
    }

    public void insert(String word) {
        Node cur=head;
        for(int i=0;i<word.length();i++){
        char let = word.charAt(i);
        if(cur.alph[let-'a']==null){
            cur.alph[let-'a']=new Node();
        }
        cur=cur.alph[let-'a'];
        }
        cur.word=true;
    }

    public boolean search(String word) {
        Node cur=head;
        for(int i=0;i<word.length();i++){
        char let = word.charAt(i);
        if(cur.alph[let-'a']==null){
            return false;
        }
        cur=cur.alph[let-'a'];
        }
        
        return cur.word;
    }

    public boolean startsWith(String word) {
         Node cur=head;
        for(int i=0;i<word.length();i++){
        char let = word.charAt(i);
        if(cur.alph[let-'a']==null){
            return false;
        }
        cur=cur.alph[let-'a'];
        }
        
        return true;
    }
}
