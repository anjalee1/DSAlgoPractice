import java.util.Arrays;

public class HeapSort {

    // Function to perform Heap Sort
    public void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build a Max Heap from the input array
        buildMaxHeap(arr, n);

        // Step 2: Extract elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move the current root (maximum) to the end of the array
            swap(arr, 0, i);
            
            // Reduce the heap size by 1 and heapify the root element
            heapify(arr, i, 0);
        }
    }

    // Function to build a Max Heap
    private void buildMaxHeap(int[] arr, int n) {
        // Start from the last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // Function to maintain the Max Heap property
    private void heapify(int[] arr, int n, int index) {
        int largest = index;        // Initialize largest as root
        int left = 2 * index + 1;   // Left child
        int right = 2 * index + 2;  // Right child

        // Check if the left child exists and is greater than the root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if the right child exists and is greater than the current largest
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the largest is not the root, swap and continue heapifying
        if (largest != index) {
            swap(arr, index, largest);
            heapify(arr, n, largest);
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

    // Main function to test the Heap Sort
    public static void main(String[] args) {
        HeapSort sorter = new HeapSort();
        int[] arr = {12, 11, 13, 5, 6, 7};
        
        System.out.println("Original array:");
        sorter.printArray(arr);

        sorter.heapSort(arr);
        
        System.out.println("Sorted array:");
        sorter.printArray(arr);
    }
}
