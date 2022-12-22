//ide: https://leetcode.com/problems/longest-common-prefix/
//sol:https://www.youtube.com/watch?v=fhyIORFDD0k&t=3s

//tc:o(no of strings * length of string)



import java.io.* ;
import java.util.*;

class Node {
    Node links[] = new Node[26]; 
    int childCount = 0;
    boolean isTerminal = false;
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
    void increaseChildCount() {
        childCount++; 
    }
    int getChildCount() {
        return childCount;
    }
    void setEnd() {
        isTerminal = true; 
    }
    boolean isEnd() {
        return isTerminal; 
    }
}

public class Trie {
    private Node root; 
    Trie() {
        root = new Node(); 
    }

    public void insert(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node()); 
                node.increaseChildCount(); 
            }
           
            node = node.get(word.charAt(i));   
        }
        node.setEnd(); 
    }

    public void constructTrie(String[] strs){
        Node node = root;
        int n =strs.length;
        for(int i=0;i<n;i++){
            insert(strs[i]);
        }
    }

    public String lcp(String firstWord){
        Node node = root;
        StringBuilder prefix = new StringBuilder();
        for(int i =0;i<firstWord.length();i++){
           char curLetter = firstWord.charAt(i);
           if (node.containsKey(curLetter) && (node.getChildCount() == 1) && (!node.isEnd())) {
                prefix.append(curLetter);
                node = node.get(curLetter);
            }
            else
                return prefix.toString();

         }
         return prefix.toString();
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";  
         if (strs.length == 1)
           return strs[0];
         Trie trie = new Trie();      
        trie.constructTrie(strs);
        return trie.lcp(strs[0]);
    }       
}
