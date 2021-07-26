# **[Kth element in Matrix](https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1#)**
# Approach 1: Using PQ
```java
class Solution
{
	public static int kthSmallest(int[][]arr,int n,int k)
	{
        //code here.
        PriorityQueue<Integer> maxPq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(maxPq.size()<k) maxPq.add(arr[i][j]);
                else{
                    if(arr[i][j]<maxPq.peek()){
                        maxPq.remove();
                        maxPq.add(arr[i][j]);
                    }
                }
            }
        }
        return maxPq.peek();
    }
}
```
**Note:** BS is of two types :-
- BS on Indices // when array is full sorted
- BS on range // here we just need lowest value and highest value.
# Approach 2 : Using BS TC - N Log(maxValue)
```java
class Solution
{
	public static int kthSmallest(int[][]arr,int n,int k)
	{
        //code here.
        int low=arr[0][0],high=arr[n-1][n-1];
        while(low<=high){
            int mid=(low+high)/2;
            int count=countLessThanEqualMid(arr,n,mid);
            
            if(count<k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    // this we use when matrix is row+column wise sorted.
    private static int countLessThanEqualMid(int arr[][],int n,int mid){
        int i=n-1,j=0,count=0;
        while(i>=0 && j<n){
            if(arr[i][j]>mid) i--;
            else{
               count+=i+1;
               j++;
            }
        }
        return count;
    }
}
```

## Dry Run :-
![KthinMatrix](https://user-images.githubusercontent.com/71629248/126989559-01bd40f5-fe84-474e-a329-8fc896ec516e.jpg)

## **[Video Reference](https://youtu.be/G5wLN4UweAM)**
