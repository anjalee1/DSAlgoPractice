
//ide: https://www.codingninjas.com/codestudio/problems/complete-string_2687860?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTab=0
//sol:https://www.youtube.com/watch?v=AWnBa91lThI&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=5


//tc:o(N)* o(len) where len is avaerage length of all the string
//sc: in trie we cant predict time complexity



import java.util.* ;
import java.io.*; 

class Node {
    Node links[] = new Node[26]; 
    boolean flag = false; 
    public Node() {
        
    }
    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null); 
    }
    Node get(char ch) {
        return links[ch-'a']; 
    }
    void put(char ch, Node node) {
        links[ch-'a'] = node; 
    }
    void setEnd() {
        flag = true; 
    }
    boolean isEnd() {
        return flag; 
    }
}
class Trie {
    private static Node root; 
    public Trie() {
        root = new Node(); 
    }
    
    void insert(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node()); 
            }
            node = node.get(word.charAt(i)); 
        }
        node.setEnd(); 
    }
    boolean checkIfAllPrefixExists(String word) {
        Node node = root;
        boolean flag = true; 
        for(int i = 0;i<word.length() && flag;i++) {
            if(node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i)); 
                flag = flag & node.isEnd(); 
            }
            else {
                return false; 
            } 
        }
        return flag; 
    }
}

class Solution {
  public static String completeString(int n, String[] a) {
    Trie obj = new Trie();
    for(String word : a) obj.insert(word); 
    String longest = ""; 
    for(String word: a) {
        if(obj.checkIfAllPrefixExists(word)) {
            if(word.length() > longest.length()) {
                longest = word; 
            }
            else if(word.length() == longest.length() && word.compareTo(longest) < 0) {
                longest = word; 
            }
        }
    }
    if(longest == "") return "None"; 
    return longest; 

  }
}
