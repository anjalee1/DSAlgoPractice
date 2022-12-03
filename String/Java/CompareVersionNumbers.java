//without split
class Solution {
    public int compareVersion(String version1, String version2) {
        
        if (version1 == null || version2 == null) return 0;
        int v1 = 0, v2 = 0;
        int i = 0, j = 0;
        while(i < version1.length() || j < version2.length()) {
            while (i < version1.length() && version1.charAt(i) != '.') {
                v1 = v1*10+(version1.charAt(i)-'0');
                i++;
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                v2 = v2*10+(version2.charAt(j)-'0');
                j++;
            }
            if (v1 > v2) return 1;
            else if (v1 < v2) return -1;
            i++;
            j++;
            v1 = 0;
            v2 = 0;
        }
        return 0;
    }
}


//ide:https://leetcode.com/problems/compare-version-numbers/
//sol: https://leetcode.com/problems/compare-version-numbers/discuss/50939/JAVA-Iterative-Easy-to-understand-Beat-92-solution

//tc: o(max(v1,v2))
//sc: o(1)


//with split
//sol: https://www.youtube.com/watch?v=MTSetP6kcRI
//https://leetcode.com/problems/compare-version-numbers/discuss/1797472/Java-Concise-Solution
public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int max = Math.max(str1.length,str2.length);
        for(int i=0;i<max;i++){
            int num1 = i >= str1.length ? 0 : Integer.parseInt(str1[i]);
            int num2 = i >= str2.length ? 0 : Integer.parseInt(str2[i]);
            if(num1 < num2) return -1;
            if(num1 > num2) return 1;
        }

        return 0;
    }
