
//IDE: https://www.codingninjas.com/codestudio/problems/number-of-distinct-substring_1465938?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
//sol: https://www.youtube.com/watch?v=RV0QeTyHZxo&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=6
//https://takeuforward.org/data-structure/number-of-distinct-substrings-in-a-string-using-trie/

//Time Complexity: O(n2), because we have to go through the entire string for all possible different starting points in order to generate all the substrings.


import java.util.ArrayList;

public class Solution 
{

	public static int countDistinctSubstrings(String s) 
	{
        Node root = new Node();
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
          Node node = root;

          for (int j = i; j < n; j++) {
            if (!node.containsKey(s.charAt(j))) {
              node.put(s.charAt(j), new Node());
              count++;
            }
            node = node.get(s.charAt(j));
          }
        }
        return count + 1;
	}
}


class Node {
  Node links[] = new Node[26];

  boolean containsKey(char ch) {
    return (links[ch - 'a'] != null);
  }

  Node get(char ch) {
    return links[ch - 'a'];
  }

  void put(char ch, Node node) {
    links[ch - 'a'] = node;
  }
};
