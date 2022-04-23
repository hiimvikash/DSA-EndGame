# [**Maximum sum Rectangle**](https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1#)
[**Video reference**](https://youtu.be/kKEX4P53MyY)

```java
class Solution {
    int maximumSumRectangle(int n, int m, int arr[][]) {
        // code here
        int dp[]=new int[m];
        int ans=Integer.MIN_VALUE;
        for(int a=0;a<n;a++){
            Arrays.fill(dp,0);
            
            for(int i=a; i<n; i++){
                for(int j=0; j<m; j++){
                    dp[j]+=arr[i][j];
                }
                ans=Math.max(ans,maxSumSubArr(dp,m)); // for filtering column wise
            }
        }
        return ans!=0?ans:-1;
    }
    
    
    // Kadane's Algorithm
    int maxSumSubArr(int arr[], int n){
        int bs=0,cs=0;
        
        for(int i=0; i<n; i++){
            if(cs>=0){
                cs+=arr[i];
            }
            else cs=arr[i];
            bs=Math.max(bs,cs);
        }
        return bs;
    }
};
```


