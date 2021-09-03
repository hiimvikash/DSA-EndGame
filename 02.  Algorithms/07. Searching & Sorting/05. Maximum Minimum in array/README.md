# [**Find minimum and maximum element in an array**](https://practice.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1#)
## Thought Process :-
- The Idea is to find MAX & MIN of **left part of array** & **right part of array**
- and the return MAX(leftPart,rightPart) & MIN(leftPart,rightPart)
- we will do these recursively using the concept of BS.
- BASE CASE : when 2 elements in array & when 1 element in array.
```java
/*
class pair  
{  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
} */

class Compute 
{
    static pair getMinMax(long a[], long n)  
    {
        //Write your code here
        return getMaxiMini(a,0,(int)n-1);
    }
    static pair getMaxiMini(long arr[], int start, int end){
        pair ans=new pair(0,0);
        if(start==end){
            // one element only
            ans.second=ans.first=arr[start];
            return ans;
        }
        if(start==end-1){
            // 2 elements
            ans.first=Math.min(arr[start],arr[end]);
            ans.second=Math.max(arr[start],arr[end]);
            return ans;
        }
        int mid= start + (end-start)/2;
        
        pair left = getMaxiMini(arr,start,mid);
        pair right = getMaxiMini(arr,mid+1,end);
        
        ans.first=Math.min(left.first,right.first);
        ans.second=Math.max(left.second,right.second);
        
        return ans;
    }
}
```

