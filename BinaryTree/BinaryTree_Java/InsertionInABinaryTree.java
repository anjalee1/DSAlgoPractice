//Time Complexity:  O(V) where V is the number of nodes.
//Auxiliary Space: O(B), where B is the width of the tree and in the worst case we need to hold all vertices of a level in the queue.

// Java program to insert element in binary tree
import java.util.LinkedList;
import java.util.Queue;
	

	/*function to insert element in binary tree */
	public void insert(Node temp, int key)
	{

		if (temp == null) {
			root = new Node(key);
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(temp);

		// Do level order traversal until we find
		// an empty place.
		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			if (temp.left == null) {
				temp.left = new Node(key);
				break;
			}
			else
				q.add(temp.left);

			if (temp.right == null) {
				temp.right = new Node(key);
				break;
			}
			else
				q.add(temp.right);
		}
	}

	
	// function call : insert(root, key);

	

