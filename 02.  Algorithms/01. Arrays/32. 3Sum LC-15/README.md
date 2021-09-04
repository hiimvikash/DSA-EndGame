# **[15. 3Sum](https://leetcode.com/problems/3sum/)**

## My Intution : - Two Pointer Technique TC - O(N<sup>2</sup>) SC - O(1)

For each array element **ele,** we will find pair whose sum is **X-ele,** because **ele + (X - ele) = X .** If such pair found we return true.

```java
class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n= arr.length;
        List<List<Integer>> ans=new ArrayList<>();
        if(n<3) return ans; // when array don't have triplets
        Arrays.sort(arr);
        for(int i=0;i<n-2;i++){ // n-2 to prevent indexOB 
            int s=i+1,e=n-1,x=-arr[i]; // we will search for pair which will give -arr[i] to get triplet 0
            if(i==0 || arr[i]!=arr[i-1]){ // this is to prevent searching for duplicates, we allow in i=0 bcz its 1st element
                while(s<e){
                    int innersum=arr[s]+arr[e];
                    if(innersum==x){
                        ans.add(Arrays.asList(arr[i],arr[s],arr[e]));
                        while(s<e && arr[s]==arr[s+1]) s++;
                        while(s<e && arr[e]==arr[e-1]) e--;
                        s++; e--;
                    }
                    else if(innersum > x){
                        while(s<e && arr[e]==arr[e-1]) e--;
                        e--;
                    }
                    else if(innersum < x){
                        while(s<e && arr[s]==arr[s+1]) s++;
                        s++;
                    }
                }
            }
        }
        return ans;
    }
}
```
## **[Video Reference](https://youtu.be/onLoX6Nhvmg)**