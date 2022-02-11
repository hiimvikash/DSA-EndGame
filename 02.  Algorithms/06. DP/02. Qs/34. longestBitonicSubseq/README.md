# [**Longest Bitonic Subseq.**](https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1/#)


## Using tabu
 ```java
class Solution
{
    public int LongestBitonicSequence(int[] arr)
    {
        int n=arr.length;
        // Code here
        // Step 1 : Make LIS[] from LtoR where each LIS[i] denotes length of LIS which should ends with arr[i]
        
        int lis[]=new int[n];
        lis[0]=1;
        
        for(int i=1; i<n; i++){
            int max=0;
            for(int j=i-1; j>=0; j--){
                if(arr[i]>arr[j]) max=Math.max(lis[j],max);
            }
            lis[i]=max+1;
        }
        
        // Step 2 : Make LDS[] from RtoL where each LDS[i] denotes length of LDS which should starts with arr[i]
        
        int lds[]=new int[n];
        lds[n-1]=1;
        
        for(int i=n-2; i>=0; i--){
            int max=0;
            for(int j=i+1; j<n; j++){
                if(arr[i]>arr[j]) max=Math.max(lds[j],max);
            }
            lds[i]=max+1;
        }
        
        int ans=1;
        
        for(int i=0; i<n; i++){
            ans=Math.max(ans,lds[i]+lis[i]-1);
        }
        return ans;
        
    }
}
```
## [**Video Reference**](https://youtu.be/jdfpGSSyN2I)