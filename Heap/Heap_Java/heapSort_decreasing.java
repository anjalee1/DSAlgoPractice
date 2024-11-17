import java.util.Arrays;

public class MinHeapSort {

    // Function to perform Heap Sort using a Min Heap
    public void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build a Min Heap from the input array
        buildMinHeap(arr, n);

        // Step 2: Extract elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move the current root (minimum) to the end of the array
            swap(arr, 0, i);
            
            // Reduce the heap size by 1 and heapify the root
            heapify(arr, i, 0);
        }
    }

    // Function to build a Min Heap
    private void buildMinHeap(int[] arr, int n) {
        // Start from the last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // Function to maintain the Min Heap property
    private void heapify(int[] arr, int n, int index) {
        int smallest = index;      // Initialize smallest as root
        int left = 2 * index + 1;  // Left child
        int right = 2 * index + 2; // Right child

        // Check if the left child exists and is smaller than the root
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        // Check if the right child exists and is smaller than the current smallest
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // If the smallest is not the root, swap and continue heapifying
        if (smallest != index) {
            swap(arr, index, smallest);
            heapify(arr, n, smallest);
        }
    }

    // Helper function to swap two elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Utility function to print the array
    public void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // Main function to test the Min Heap Sort
    public static void main(String[] args) {
        MinHeapSort sorter = new MinHeapSort();
        int[] arr = {12, 11, 13, 5, 6, 7};
        
        System.out.println("Original array:");
        sorter.printArray(arr);

        sorter.heapSort(arr);
        
        System.out.println("Sorted array (descending):");
        sorter.printArray(arr);
    }
}
