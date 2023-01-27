
class LRUCache {
    class Node{
        int key,val;
        Node prev,next;
    }
    
     public void addNode(Node node){
        Node nbr=head.next;
         
        node.next=nbr;
        node.prev=head;
         
        nbr.prev=node;
        head.next=node;

    }
    
    public void removeNode(Node node){
            Node prev=node.prev;
            Node forw = node.next;
            
           prev.next=forw;
           forw.prev=prev;
           node.prev=node.next=null;
                
     }
    
    public void moveToFront(Node node){
        removeNode(node);
        addNode(node);

    }

    HashMap<Integer, Node> cache;
    Node head,tail;
    int cap;
   
    public LRUCache(int capacity) {
        cache=new HashMap<>();
        cap=capacity;
        head=new Node();
        tail=new Node();
        
        head.next=tail;
        tail.prev=head;
        
    }
    
    public int get(int key) {
        Node node=cache.get(key);
        if(node==null){
            return -1;
        }
        else{
            int vl=node.val;
            moveToFront(node);
            return vl;
            
        }
    }
    
    public void put(int key, int value) {
        Node node=cache.get(key);
        if(node==null){
            Node newNode=new Node();
            newNode.key=key;
            newNode.val=value;
            if(cache.size()==cap){
                Node LRU_Node=tail.prev;
                cache.remove(LRU_Node.key);
                removeNode(LRU_Node);
                
            }
            
            cache.put(key,newNode);
            addNode(newNode);      
            
        }
        else{
            node.val=value;
            moveToFront(node);
        }
        
    }
}

/**
 * tc of put and get in hashmap is o(1)
 * tc of add and remove in double ll is o(1)
 *https://www.youtube.com/watch?v=JxtmaAFfVBo&t=3678s
 https://leetcode.com/problems/lru-cache/
 */
