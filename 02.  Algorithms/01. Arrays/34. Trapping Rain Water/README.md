# **[Trapping Rain Water](https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1#)**

## My Intution : - Extra Space TC - O(N) SC - O(N)

```java
class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static int trappingWater(int arr[], int n) { 
        
        // Your code here
        int left[]=new int[n]; // this will store leftMax for each element
        int right[]=new int[n]; // this will store rightMax for each element
        int max=0;
        for(int i=0;i<n;i++){
            max=left[i]=Math.max(max,arr[i]);
        }
        max=0;
        for(int i=n-1;i>=0;i--){
            max=right[i]=Math.max(max,arr[i]);
        }
        int trapedSum=0;
        for(int i=0;i<n;i++){
            trapedSum+=Math.min(left[i],right[i])-arr[i];
        }
        return trapedSum;
    } 
}
```
## **[Video Reference](https://youtu.be/UZG3-vZlFM4)**
## My Intution : - 2 Pointer Technique TC - O(N) SC - O(1)
![rainTrap](https://user-images.githubusercontent.com/71629248/124331299-adb35100-dbac-11eb-85c6-b01123a8efbd.png)

```java
class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static int trappingWater(int arr[], int n) { 
        
        // Your code here
        int lMax=0, rMax=0, l=0, r=n-1, trapped=0;
        while(l<r){
            if(arr[l]<=arr[r]){
                if(arr[l]>lMax)
                    lMax=Math.max(lMax,arr[l]);
                else 
                    trapped+=lMax-arr[l];
                l++;
            }
            else{
                if(arr[r]>rMax)
                    rMax=Math.max(rMax,arr[r]);
                else // here previous rMax will become height for water trapped.
                    trapped+=rMax-arr[r];
                r--;    
            }
        }
        return trapped;
    } 
}
```
## **[Video Reference](https://youtu.be/pq7Xon_VXeU)**
