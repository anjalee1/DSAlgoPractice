
//ide : https://leetcode.com/problems/copy-list-with-random-pointer/
//sol.vid: https://www.youtube.com/watch?v=VNf6VynfpdM
//https://takeuforward.org/data-structure/clone-linked-list-with-random-and-next-pointer/

//Method ---1//
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        HashMap<Node,Node> hashMap=new HashMap<>();
        Node temp = head;
        
        while(temp != null) {
            Node newNode = new Node(temp.val);
            hashMap.put(temp,newNode);
            temp = temp.next;
        }
          
        Node t = head;
        
        while(t != null) {
            Node node =hashMap.get(t);
            node.next=t.next!= null ?hashMap.get(t.next):null;
            node.random=t.random!= null ?hashMap.get(t.random):null;
            t = t.next;
        }
        
        return hashMap.get(head);   
           
    }
}


//Time Complexity: O(N)+O(N)
//Reason: Two iterations over the entire list. Once for inserting in the map and other for linking nodes with next and random pointer.
//Space Complexity: O(N)
//Reason: Use of hashmap for storing entire data.

//Method ---2//

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Node temp = head;
        
        //step 1
        while(temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        
        //step 2
        Node itr = head;
        while(itr != null) {
            if(itr.random != null)
                itr.next.random = itr.random.next;
            itr = itr.next.next;
        }
        
        //step 3
        Node dummy = new Node(0);
        itr = head;
        temp = dummy;
        Node fast;
        while(itr != null) {
            fast = itr.next.next;
            temp.next = itr.next;
            itr.next = fast;
            temp = temp.next;
            itr = fast;
        }
        return dummy.next;
  }
}

//Time Complexity: O(N)+O(N)+O(N)
//Reason: Each step takes O(N) of time complexity.
//Space Complexity: O(1)
//Reason: No extra data structure was used for computation.
