=> if length of arr is even
//All string should have their reverse

=> if length of arr is odd
//All string should have their reverse except one
//one string should not have it's reverse and it is palindromic string itself






class Solution {
    
    public static boolean isPalindrome(String str){
        for(int i=0 , j=str.length()-1;i<j;i++,j--){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
        }
        
        return true;
    }
    
    // public static String reverse(String str){
    //     String rev="";
    //     for(int i = str.length() - 1; i >= 0; i--) { 
    //          rev = rev + str.charAt(i); 
    //     }
    //     return rev;
    // }
        

    public static boolean makePalindrome(int n, String[] arr) {
       int numReverseAbsent=0;
       String possiblePalindrome="";
       HashMap<String,Integer> isPresent=new HashMap<>();
       for(String s : arr){
          isPresent.put(s, isPresent.getOrDefault(s, 0) + 1);
       }
       
        
        for(String s : arr){
             String str = new StringBuilder(s).reverse().toString();
           
              if(isPresent.get(str)!=isPresent.get(s)){
                  numReverseAbsent++;
                  possiblePalindrome=s;
                  
              }
              
        }
        
        if(numReverseAbsent==0)return true;
        else if(numReverseAbsent>1) return false;
        else return isPalindrome(possiblePalindrome);
        
      
    }
}
        
       //tc: o(n2) //stringbuilder reverse also takes o(n) time : refer: https://www.scaler.com/topics/reverse-a-string-in-java/
       //(with utility function reverse i was getting tle that is why I have string builder reverse which has same tc and sc)
       
       //sc=o(n)
