# **[15. 3Sum](https://leetcode.com/problems/3sum/)**

## My Intution : - Two Pointer Technique TC - O(N<sup>2</sup>) SC - O(1)

For each array element **ele,** we will find pair whose sum is **X-ele,** because **ele + (X - ele) = X .** If such pair found we return true.

```java
class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-2;i++){
            int s=i+1, e=n-1, x=-arr[i];
            if(i == 0 || arr[i] != arr[i-1]){
                while(s<e){
                    if(arr[s]+arr[e]>x){
                        // improve: skip duplicates
                        while (s < e && arr[e] == arr[e-1]) e--;
                        e--;
                    }
                    else if(arr[s]+arr[e]<x){
                        // improve: skip duplicates
                        while (s < e && arr[s] == arr[s+1]) s++;
                        s++;  
                    } 
                    else {
                        ans.add(Arrays.asList(arr[i],arr[s],arr[e]));
                        while (s < e && arr[s] == arr[s+1]) s++;
                        while (s< e && arr[e] == arr[e-1]) e--;
                        s++; e--;
                    }
                }
            }
       }
        return ans;
    }
}
```
## **[Video Reference](https://youtu.be/onLoX6Nhvmg)**