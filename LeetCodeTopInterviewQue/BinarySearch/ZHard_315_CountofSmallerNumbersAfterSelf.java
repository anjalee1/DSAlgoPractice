
//ide: https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
//sol:https://leetcode.com/problems/count-of-smaller-numbers-after-self/solutions/622477/java-binary-search/
//tc: nlogn
//sc:o(n)

//at the end h=l=mid


class Solution {
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sortedAndVisited = new ArrayList<>();
        
        int[] arr = new int[nums.length];
        
        // Start visiting the numbers from back
        for(int i = (nums.length-1); i >= 0; i--){
            // Keep in mind this array is getting filled from back
            arr[i] = 
                binarySearchAndInsert(
                    nums[i], 0, sortedAndVisited.size(), sortedAndVisited);
        }
        
        List<Integer> output = new ArrayList<>();
        for(int i=0; i < arr.length; i++) {
            output.add(arr[i]);
        }

        return output;
    }

     public int binarySearchAndInsert(int currentNo, int l, int h, List<Integer> sortedAndVisited){
    int mid= l+(h-l)/2;
    while(l<h){
        if(currentNo<=sortedAndVisited.get(mid)){
           h=mid;
        }else{
         l=mid+1;
        } 
        mid= l+(h-l)/2;
    }
    sortedAndVisited.add(mid,currentNo);
    return mid;
    
}
}
