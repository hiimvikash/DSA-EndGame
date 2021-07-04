# **[Minimum swaps and K together](https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1#)**
# My Intution : - Sliding Window Technique TC - O(N)
- We will count no. of elements <= k and initialize it as Window size.
- Create your window Initialize start=0; end=windowSize-1;
- In each window slide determine no. of elements > k say it as a bad.
- Minimum of all the bad's in every window will be our answer.
# Why Window Size = countOfElements <= k ?
## This is because Our Main Goal is to group all the elements less than equalto k together and No. of elements > k in each windows give swapREQUIRED to do SO.
```java
class Complete{

    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int n, int k) {
        //Complete the function
        int windowSize=0; // no. of elements <= k
        for(int ele:arr){
           if(ele<=k) windowSize++; 
        }
        int start=0,end=windowSize-1,ans=n+1,bad=0;
        while(end<n){
            for(int i=start;i<=end;i++){
                if(arr[i]>k)bad++;
            }
            ans=Math.min(ans,bad);
            bad=0;
            start++;
            end++;
        }
        return ans;
    }
}
``` 