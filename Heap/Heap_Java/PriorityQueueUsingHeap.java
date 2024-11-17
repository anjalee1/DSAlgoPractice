import java.util.ArrayList;
import java.util.List;

class PriorityQueueUsingHeap {
    // Node class to store value and priority
    static class Node {
        int value;
        int priority;

        public Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    private List<Node> heap;

    // Constructor to initialize the heap
    public PriorityQueueUsingHeap() {
        heap = new ArrayList<>();
    }

    // Insert an element with priority into the heap
    public void insert(int value, int priority) {
        Node newNode = new Node(value, priority);
        heap.add(newNode);
        heapifyUp(heap.size() - 1);
    }

    // Extract the element with the highest priority
    public Node extractMax() {
        if (heap.isEmpty()) return null;

        Node root = heap.get(0);
        Node lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
        return root;
    }

    // Peek the element with the highest priority
    public Node peek() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Helper function to maintain the heap property after insertion (heapify-up)
    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap.get(index).priority > heap.get(parent).priority) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    // Helper function to maintain the heap property after extraction (heapify-down)
    private void heapifyDown(int index) {
        int size = heap.size();
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && heap.get(left).priority > heap.get(largest).priority) {
            largest = left;
        }
        if (right < size && heap.get(right).priority > heap.get(largest).priority) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // Swap two nodes in the heap
    private void swap(int i, int j) {
        Node temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Print the heap (for debugging)
    public void printHeap() {
        for (Node node : heap) {
            System.out.print("(" + node.value + ", " + node.priority + ") ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Testing the priority queue
        PriorityQueueUsingHeap pq = new PriorityQueueUsingHeap();

        pq.insert(5, 2);
        pq.insert(10, 5);
        pq.insert(3, 1);
        pq.insert(8, 4);
        pq.insert(6, 3);

        System.out.println("Heap after inserts:");
        pq.printHeap();

        System.out.println("Peek max: (" + pq.peek().value + ", " + pq.peek().priority + ")");
        System.out.println("Extract max: (" + pq.extractMax().value + ", " + pq.extractMax().priority + ")");
        pq.printHeap();

        System.out.println("Extract max: (" + pq.extractMax().value + ", " + pq.extractMax().priority + ")");
        pq.printHeap();

        System.out.println("Is empty? " + pq.isEmpty());
    }
}
