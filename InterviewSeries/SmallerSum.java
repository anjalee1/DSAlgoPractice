
//ide: https://practice.geeksforgeeks.org/contest/weekly-interview-series-71/problems/#
//sol: https://www.youtube.com/watch?v=SghbzQm0lug
//tc: o(nlogn)
//sc:o(n)
class Solution
{
    public int binarysearch(int arr[],int key){
        
        int low=0;
        int high=arr.length-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(arr[mid]>=key){
                high=mid-1;
            }
            
            else{
                low=mid+1;
            }
        }
 
        return low;
        
    }
    public long[] smallerSum(int n,int arr[])
    {
        int temp[]= new int[n];
         for(int i=0;i<n;i++)

        {

            temp[i]=arr[i];

        }

         Arrays.sort(temp);//o(nlogn)
     
         long prefix[]=new long[n];
         prefix[0]=temp[0];
         
         for(int i=1;i<n;i++){
             prefix[i]=prefix[i-1]+temp[i];
         }
         
         long ans[]=new long[n];
         for(int i=0;i<n;i++){
             int idx=binarysearch(temp,arr[i]);
             //System.out.println(idx);
             if(idx==0){
                 ans[i]=0;
             }
             else{
                 idx--;
                 ans[i]=prefix[idx];
             }
         }
         
         return ans;
         
    }
}
