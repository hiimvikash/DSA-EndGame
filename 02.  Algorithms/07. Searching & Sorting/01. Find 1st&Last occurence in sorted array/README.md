# [**First and last occurrences of x**](https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1)
## Thought Process : -
- Sorted array think of BS.
- In BS whenever we find arr[mid]==x we return mid.
- Here when we find mid then it can be the possible candidate for our answer.
- so to find most capable answer whenever we find ans we store it and 
    - if we are told to find **First Ocurrence** then we do **end=mid-1** because it is possible that our answer may lie on **left side** of sorted array.
    - if we are told to find **Last Ocurrence** then we do **start=mid+1** because it is possible that our answer may lie on **right side** of sorted array.
```java
class GFG
{
    ArrayList<Long> find(long arr[], int n, int x)
    {
        // code here
        ArrayList<Long> ans=new ArrayList<>();
        ans.add((long)findFlByBs(arr,0,n,x,true));
        ans.add((long)findFlByBs(arr,0,n,x,false));
        return ans;
        
    }
    int findFlByBs(long arr[],int fromIndex,int toIndex, int x, boolean isFirst){
        int start=fromIndex;
        int end=toIndex-1;
        int ansF=-1, ansL=-1; // store 1st and last ocurrence
        while(start<=end){
            int mid= start + (end-start)/2;
            if((long)x==arr[mid]){
                ansF=mid;
                ansL=mid;
                if(isFirst) end=mid-1; else start=mid+1;
            }
            else if((long)x>arr[mid]) start = mid + 1;
            else if((long)x<arr[mid]) end = mid - 1;
        }
        if(isFirst) return ansF; else return ansL;
    }
}
```