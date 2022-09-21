# [15. 3Sum](https://leetcode.com/problems/3sum/)
```java
class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans=new ArrayList<>();
        
        int n = arr.length;
        
        for(int i =0; i<n-2; i++){
                       
            if(i==0 || arr[i]!=arr[i-1]){
                int s=i+1, e = n-1 , x = -arr[i];
                while(s<e){
                    if(arr[s] + arr[e] < x) s++;
                    else if(arr[s] + arr[e] > x) e--;
                    else{
                         ans.add(Arrays.asList(arr[i], arr[s], arr[e]));
                         while(s<e && arr[s]==arr[s+1]) s++;
                         while(s<e && arr[e]==arr[e-1]) e--;
                         s++; e--;
                    }
                }
            }
        }
        return ans;
    }
}
```