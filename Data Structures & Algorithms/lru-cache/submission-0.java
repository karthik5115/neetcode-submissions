class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    HashMap<Integer,Node> mp;
    Node head;
    Node tail;
    int capacity;
    int length;
    public LRUCache(int capacity) {
        mp = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        this.length=0;
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)){
            Node x = mp.get(key);
            remove(x);
            add(x);
            return x.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {

        if(mp.containsKey(key)){
            Node x = mp.get(key);
            remove(x);
            x.value=value;
            add(x);
        }
        else{
            if(length>=capacity){
               // System.out.println(length+" "+capacity);
                mp.remove(tail.prev.key);
                remove(tail.prev);
                length--;
            }

            Node x = new Node(key,value);
            length++;
            mp.put(key,x);
            add(x);
        }
        
    }
    public void add(Node x){
        x.next=head.next;
        x.prev=head;
        head.next=x;
        x.next.prev=x;
    }
    public void remove(Node x){
        Node pre = x.prev;
        pre.next=x.next;
        x.next.prev=pre;
    }
}
