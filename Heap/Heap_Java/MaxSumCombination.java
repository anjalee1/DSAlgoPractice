//solution: https://chatgpt.com/g/g-2DQzU5UZl-code-copilot/c/67399da5-c49c-8004-9914-94882651b560
//tc:
//sc:
### Total Time Complexity

1. Sorting the Arrays:
   - Sorting both arrays A and B takes O(N log N).

2. Extracting Maximum Sum and Inserting New Combinations into the Heap:
   - Extracting the maximum element and inserting new combinations into the heap takes O(K log K) since, in the worst case, we perform 2 * K operations on the heap.

3. Overall Time Complexity:
   O(N log N) + O(K log K)

### Space Complexity

1. Heap:
   - The heap stores at most K elements, so it requires O(K) space.

2. Visited Set:
   - The set tracks up to K entries to avoid duplicate index pairs, so it also takes O(K) space.

3. Result List:
   - The result list stores exactly K sums, so it takes O(K) space.

4. Overall Space Complexity:
   O(K)

//ide : https://www.geeksforgeeks.org/problems/maximum-sum-combination/0




class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // Step 1: Sort both arrays in descending order
        Arrays.sort(A);
        Arrays.sort(B);
        reverseArray(A);
        reverseArray(B);

        // Step 2: Initialize a max heap (priority queue) and a set for visited pairs
        PriorityQueue<SumCombination> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Set<String> visited = new HashSet<>();

        // Step 3: Push the first combination (A[0] + B[0]) into the heap
        maxHeap.offer(new SumCombination(A[0] + B[0], 0, 0));
        visited.add("0,0");

        // Step 4: List to store the result
        List<Integer> result = new ArrayList<>();

        // Step 5: Extract the maximum sum K times
        while (K > 0 && !maxHeap.isEmpty()) {
            SumCombination current = maxHeap.poll();
            result.add(current.sum);
            K--;

            int i = current.i, j = current.j;

            // Push the next possible combination (i + 1, j)
            if (i + 1 < N && !visited.contains((i + 1) + "," + j)) {
                maxHeap.offer(new SumCombination(A[i + 1] + B[j], i + 1, j));
                visited.add((i + 1) + "," + j);
            }

            // Push the next possible combination (i, j + 1)
            if (j + 1 < N && !visited.contains(i + "," + (j + 1))) {
                maxHeap.offer(new SumCombination(A[i] + B[j + 1], i, j + 1));
                visited.add(i + "," + (j + 1));
            }
        }
        return result;
    }

    // Helper method to reverse an array
    private static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Class to represent a combination of sum and its indices
    private static class SumCombination implements Comparable<SumCombination> {
        int sum, i, j;

        SumCombination(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(SumCombination other) {
            return Integer.compare(this.sum, other.sum);
        }
    }
}
