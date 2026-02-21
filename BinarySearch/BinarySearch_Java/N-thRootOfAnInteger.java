class Solution {
    public int nthRoot(int n, int m) {
        // Handle m=0 or m=1 immediately
        if (m == 0) return 0;
        if (m == 1) return 1;

        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = func(mid, n, m);

            if (midN == 1) {
                return mid;
            } else if (midN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            
            if (ans > m) return 2; 
        }
        
        if (ans == m) return 1;
        return 0;
    }
}

//When we will come out of the loop we will have the answer which will be equal to low as well as high.
//tc: O( n.log(m) ) sc:o(1)
//ide: https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1
//sol vid: https://www.youtube.com/watch?v=rjEJeYCasHs&t=886s
