# **[18. 4Sum](https://leetcode.com/problems/4sum/)**

## My Intution : - Two Pointer Technique TC - O(N<sup>3</sup>) SC - O(1)

![4sum](https://user-images.githubusercontent.com/71629248/124089895-f7e3e780-da71-11eb-8df6-221757d8a935.png)


```java
class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        int n=arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-3;i++){
            int x3=target-arr[i]; // target for 3Sum
            
            if(i == 0 || arr[i] != arr[i-1]){
                
                for(int j=i+1;j<n-2;j++){
                    int s=j+1, e=n-1, x2=x3-arr[j]; // target for 2Sum
                    
                    if(j == i+1 || arr[j] != arr[j-1]){ // for every i this loop will run atleat 1 j==1 would be wrong X try this TCs [-2,-1,-1,1,1,2,2] target=0 ANS is [[-2,-1,1,2],[-1,-1,1,1]] but you'll get [[-2,-1,1,2]] 
                        
                        while(s<e){
                            if(arr[s]+arr[e]>x2){
                                // improve: skip duplicates
                                while (s < e && arr[e] == arr[e-1]) e--;
                                e--;
                             }
                             else if(arr[s]+arr[e]<x2){
                                // improve: skip duplicates
                                while (s < e && arr[s] == arr[s+1]) s++;
                                s++;  
                            } 
                            else {
                                ans.add(Arrays.asList(arr[i],arr[j],arr[s],arr[e]));
                                while (s < e && arr[s] == arr[s+1]) s++;
                                while (s< e && arr[e] == arr[e-1]) e--;
                                s++; e--;
                            }
                        }
                    }
                }

            }
        }
        return ans;
    }
}
```
## **[Video Reference](https://youtu.be/4ggF3tXIAp0)**
## Solved later
```java
class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        int n=arr.length;
        List<List<Integer>> ans=new ArrayList<>();
        if(n<4) return ans; // when quadraples is imposible
        Arrays.sort(arr);
        for(int i=0;i<n-3;i++){
            if(i==0 || arr[i]!=arr[i-1]){
                for(int j=i+1;j<n-2;j++){
                    int s=j+1,e=n-1,x=target-arr[j]-arr[i];
                    if(j==i+1 || arr[j]!=arr[j-1]){
                        while(s<e){
                            int innersum=arr[s]+arr[e];
                            if(innersum==x){
                                ans.add(Arrays.asList(arr[i],arr[j],arr[s],arr[e]));
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
            }
        }
        return ans;
    }
}
```
