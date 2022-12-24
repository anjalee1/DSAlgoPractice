//ide:https://www.codingninjas.com/codestudio/problems/975277?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

//sol: https://www.youtube.com/watch?v=mVg9CfJvayM&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=49
//https://takeuforward.org/data-structure/find-minimum-number-of-coins/

// Time Complexity:O(V)
// Space Complexity:O(1)



import java.util.* ;
import java.io.*; 
public class Solution
{
public static int findMinimumCoins(int amount)
 { 
    int cointCount =0;
    int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
    int n = coins.length;
    for (int i = n - 1; i >= 0; i--) {
      while (amount >= coins[i]) {
        amount -= coins[i];
        cointCount++;
        
      }
    }
    return cointCount;
  }
}


