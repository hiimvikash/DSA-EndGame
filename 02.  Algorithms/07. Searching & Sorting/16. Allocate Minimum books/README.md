# [**Allocate minimum number of pages**](https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1#)

## BS :- Math.min(max1,max2,max3...)
## [**Video Reference🔥**](https://youtu.be/gYmWHvRHu-s)
```java
class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]arr,int n,int s)
    {
        //Your code here
        if(s>n) return -1;
        int low=0;int high=0; int ans=0;
		// low is when no.Student=no.Books
		// high is when 1 student is there.
        for(int i=0;i<n;i++){ low=Math.max(arr[i],low); high+=arr[i]; }
        while(low<=high){
            int mid=(low+high)/2;
            if(isAllocationPossible(arr,mid,s)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public static boolean isAllocationPossible(int arr[], int barrier,int s){
        int studentAlc=1; int pages=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>barrier) return false;
            if(arr[i]+pages > barrier){
               studentAlc+=1;
               pages=arr[i];
            }
            else pages+=arr[i];
        }
        return studentAlc<=s
    }
    
};
```