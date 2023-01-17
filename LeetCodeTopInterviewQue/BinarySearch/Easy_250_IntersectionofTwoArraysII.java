
//ide:
//sol: https://www.youtube.com/watch?v=dTmYy5yCSX8 -- two pointer 

//method 1 - binary search tc: m(logn)  sc: o(m)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length){
		  return intersect(nums2, nums1);
	    }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> dummy=new ArrayList<>();
        int left=0;

        for(int num: nums1){
            int index =binarySearch(num,left,nums2);
            if(index!=-1){
                dummy.add(num);
                left=index+1;
            }

        }

        int[] ans = new int[dummy.size()];
        int i=0;
        for(int val : dummy) ans[i++]=val;
        return ans;

    }
    public int binarySearch(int target,int left,int nums2[]){
        int right =nums2.length-1;
        int index=-1;

        while(left<=right){
            int mid =left+(right-left)/2;

            if(nums2[mid]==target)
            {
              index=mid;
              right=mid-1;
            }
            else if(nums2[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;  
            }


        }
        return index;


    }

}

//method - two pointer tc: o(m+n)  sc:o(m)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
             Arrays.sort(nums1);
             Arrays.sort(nums2);
             int m = nums1.length;
             int n = nums2.length;
             int i=0;
             int j=0;
             ArrayList<Integer> result = new ArrayList<>(); 
             while(i<m && j<n ){
                 if(nums1[i]==nums2[j]){
                     result.add(nums1[i]);
                     i++;
                     j++;
                 }
                 else if(nums1[i]<nums2[j]){
                     i++;
                 }
                 else{
                     j++;
                 }
             }

            int[] ans = new int[result.size()];
            int idx=0;
            for(int val : result){
                ans[idx++]=val;
            } 
            return ans;

    }   

}



