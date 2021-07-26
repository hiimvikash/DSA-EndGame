# **[Matrix Median](https://www.interviewbit.com/problems/matrix-median/)**
## **My Intution :-**
![MatrixMedian](https://user-images.githubusercontent.com/71629248/124987510-936ced80-e05a-11eb-9cd2-f55d9aafdf66.png)
# What is DesiredCount ?
Any element X whose count for **lessThan=toX = n/2+1(minimum)** then only they can be median.
```java
public class Solution {
    public int findMedian(int[][] arr) {
        int n=arr.length,m=arr[0].length;
        int low=Integer.MAX_VALUE,high=0;
        for(int i=0;i<n;i++){
            low=Math.min(arr[i][0],low);
            high=Math.max(arr[i][m-1],high);
        }
        high+=1;
               
        int desired=(n*m)/2; // when count > desired then we found our answer
        while(low<=high){
            int mid=low+high >> 1;
            int count=0;
            for(int i=0;i<n;i++)
                count+=countLessThanEqualToMid(arr[i],mid);
            if(count<=desired) low=mid+1;
            else if(count>desired) high=mid-1;    
        }
        return low;
    }

    // this will work when Matrix is rowWise sorted only.
    private int countLessThanEqualToMid(int arr[],int key){
        // here we will find number which is exactly first greater than key
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            int midVal=arr[mid];

            if(key>=midVal) low=mid+1; 
            else if(key<midVal) high=mid-1;
        }
        return low;
    }
}

```
## **[Video Reference](https://youtu.be/63fPPOdIr2c)**
