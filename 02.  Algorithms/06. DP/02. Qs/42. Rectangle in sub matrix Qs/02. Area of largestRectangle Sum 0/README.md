# [**Largest rectangular sub-matrix whose sum is 0**](https://www.geeksforgeeks.org/largest-rectangular-sub-matrix-whose-sum-0/)

## prerequisite :-
- 01. Maximum sum rectangle
-  largest subarray with 0 sum

```java
import java.util.*;

class GFG {
	public static void main (String[] args) {
		int a[][] = { { 1, 2, 3, 4 }, { -1, -2, -4, -3 },
                      { -7, -9, 7, 9 }, { 7, -2, 0, 10 } };
  
    int row = 4, col = 4;
    System.out.println(larRecSumZero(a, row, col));
	}
	
    static int	larRecSumZero(int arr[][], int n, int m){
	    int dp[]=new int[m];
	    
	    int ans=0;
	    for(int a=0; a<n; a++){
	        Arrays.fill(dp,0);
	        
	        for(int i=a; i<n; i++){
	            for(int j=0; j<m; j++){
	                dp[j]+=arr[i][j];
	            }
	            int b = i-a+1;
	            int l = larSubArrZeroSum(dp,m);
	            
	            ans = Math.max(ans, l*b);
	        }
	    }
	    return ans;
	}
	
	
	
	static int larSubArrZeroSum(int arr[], int n){
	    int maxL=0;
	    int sum=0;
	    HashMap<Integer, Integer> si=new HashMap<>();
	    
	    for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0) maxL=i+1;
            else{
               if(si.containsKey(sum))
                    maxL=Math.max(maxL,i-si.get(sum));
               else
                    si.put(sum,i);
            }
        }
        return maxL;
	}
};
```


