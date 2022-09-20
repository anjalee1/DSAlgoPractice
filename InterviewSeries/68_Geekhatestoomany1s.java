

class Solution {
    public static int noConseBits(int query) {
        int countOnes=0;
        for(int i=30;i>=0;i--){
            if((query & (1<<i))>0){
                countOnes++;
                
                if(countOnes==3){
                    query ^=(1<<i);
                    countOnes=0;
                }
            }
            
            else{
                countOnes=0;
            }
        }
        
        return query;
    }
}
//ide:  https://practice.geeksforgeeks.org/contest/interview-series-68/problems/
//sol:   https://www.youtube.com/watch?v=fdnvPurbs9Y
// binary values : https://www.rapidtables.com/convert/number/decimal-to-binary.html
//check set or unset using &: https://www.geeksforgeeks.org/check-whether-k-th-bit-set-not/
//set or unset using xor: https://www.geeksforgeeks.org/bitwise-hacks-for-competitive-programming/
        
