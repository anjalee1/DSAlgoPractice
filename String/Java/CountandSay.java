//recursion
class Solution {
    public String countAndSay(int n) {
        
         if(n==1) return "1";
//         Recursion
        String s=countAndSay(n-1);
        StringBuilder res = new StringBuilder();
        // String res="";
        int counter=0;
        
        for(int i=0;i<s.length();i++)
        {
            counter++;
//             Segregating into groups
            if(i==s.length()-1 || s.charAt(i)!=s.charAt(i+1))
            {
                res.append(counter).append(s.charAt(i));
                // res=res+counter+s.charAt(i);
                counter=0;
            }
        }
          return res.toString();
       
        
    }
}

//ide: https://leetcode.com/problems/count-and-say/
//sol: https://www.youtube.com/watch?v=9fI_26Dl1IA
//tc: o(n^2)
//sc: o(1)

//iterative

//sol: https://leetcode.com/problems/count-and-say/discuss/2716712/Java-or-4-solutions

class Solution {
    public String countAndSay(int n) {
        
       StringBuilder currStr = new StringBuilder("1");

        for (int k = 0; k < n - 1; k++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int i = 1; i < currStr.length(); i++) {
                if (currStr.charAt(i) == currStr.charAt(i - 1)) count++;
                else{
                    sb.append(count).append(currStr.charAt(i - 1));
                    count = 1;
                }
            }
            sb.append(count).append(currStr.charAt(currStr.length()-1));
            currStr = sb;
        }
        return currStr.toString();
    }
}
