
import java.util.* ;
import java.io.*; 
public class Solution {
    
    public static double pow(double num,int p){
        if (p==0){
         return 1;
        }
        else{
            double pw=pow(num,p/2);
            double pv=pw*pw;
            if (p%2 ==1){
                pv=pv*num;
            }   
           return pv;
        }
    }
	public static double findNthRootOfM(int n, int m) {
		double epsilon=1e-8;
        double low,high;
        
        if(m >=0 && m<=1){
           low =m;
           high=1;
        }
        else{
           low =1;
           high=m;
        }
        
        
        while((high-low)>epsilon){
            double mid =(low+high)/2.0;
            if(pow(mid,n)<m){
                low=mid;
            }
            else{
                high=mid;
            }
        }
        
        return low;
            
	}
}


//tc: O( log( m * 10^d)*log(n) )
//ide: https://www.codingninjas.com/codestudio/problems/1062679?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
//sol vid: https://www.youtube.com/watch?v=WjpswYrS2nY&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=63
//code expln: https://www.geeksforgeeks.org/calculating-n-th-real-root-using-binary-search/
