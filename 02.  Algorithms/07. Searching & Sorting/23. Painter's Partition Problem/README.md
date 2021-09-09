# [**Painter's Partition Problem**](https://www.interviewbit.com/problems/painters-partition-problem/)
## Thought Process:- Math.min(max1,max2,max3,max4...)
```java
public class Solution {
    public int paint(int painters, int B, int[] time) {
        int n=time.length;
        int low=0,high=0;
        // Step 1 find low and high
            for(int i=0;i<n;i++){
                high+=time[i];
                low=Math.max(low,time[i]);
            }
        // Step 2 find ans considering 1unitLength of board requires 1unitTime to paint.
        long ans=-1;
        while(low<=high){
            int mid= (low+high)/2;
            if(isMidPossibleAns(time, mid, painters)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        ans*=B;
        return (int)(ans%10000003);     
    }
    boolean isMidPossibleAns(int time[], int mid, int painters){
        int painterCount=1; int timereq=0;
        for(int i=0;i<time.length;i++){
            if(time[i]>mid) return false;
            if(time[i]+timereq > mid){
                painterCount+=1;
                timereq=time[i];
            }
            else timereq+=time[i];
        }
        return painterCount<=painters;
    }
}

```