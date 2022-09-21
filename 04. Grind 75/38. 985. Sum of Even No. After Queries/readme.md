# [985. Sum of Even Numbers After Queries](https://leetcode.com/problems/sum-of-even-numbers-after-queries/)

## Brute
```java
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int ans[]=new int[n];
        
        for(int i = 0; i<n; i++){ // traverse in queries
            nums[queries[i][1]] += queries[i][0];
            int sum = 0;
            for(int ele : nums){
                if(ele%2==0) sum+=ele;
            }
            ans[i] = sum;
        }
        return ans;
    }
}
```

## Intution 1 
- find even sum before hand
- Now for each Query consider the element on which operation is performed as E if even and O if odd
- value added be x
- after state of resulting value is either NE or NO i.e., newEven or newOdd
    - E + x = NE   +x
    - E + x = NO   -E
    - O + x = NE   +NE
    - O + x = NO   +0
```java
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int ans[]=new int[n];
        
        int esum = 0;
        for(int ele : nums){
            if(ele%2==0) esum+=ele;
        }
        
        int prevState = 0; // 0-ev & 1-od
        int afterState = 0;
        
        for(int i = 0; i<n; i++){ // traverse in queries
           prevState = (nums[queries[i][1]] % 2 == 0) ? 0 : 1;
            
           nums[queries[i][1]] += queries[i][0];
           
           afterState = (nums[queries[i][1]] % 2 == 0) ? 0 : 1;
            
           if(prevState==0 && afterState==0) esum += queries[i][0];
           else if(prevState==0 && afterState==1) esum-= (nums[queries[i][1]]-queries[i][0]);
           else if(prevState==1 && afterState==0) esum+= nums[queries[i][1]];
           else if(prevState==1 && afterState==1) esum+=0;
            
            ans[i] = esum;
            
        }
        return ans;
    }
}
```

## Intution 2
- find EVENSUM before hand
- for each query 
    - if ELEMENT in which operation will be perfomed is even then ```ESUM -= thatELEMENT```
        - this is because after operation result can be ODD or EVEN
            - if ODD result then excluding ELEMENT was a good decision
            - if EVEN result then we will ADD RESULT in ESUM
    - if ELEMENT is ODD then just procced with operation
            - if EVEN result then we will ADD RESULT in ESUM        
```java
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        
        int ans[]=new int[n];
        int esum = 0;
        for(int ele : nums) if(ele%2==0) esum+=ele;
        
        
        for(int i =0; i<n; i++){
            int ele = nums[queries[i][1]]; // element in which operation will be performed;
            int x = queries[i][0]; // no. to be added
            
            if(ele%2==0) esum-=ele;
            
            nums[queries[i][1]] = ele + x;
            
            if(nums[queries[i][1]]%2==0) esum+=nums[queries[i][1]];
            
            ans[i] = esum;
        }
        return ans;
    }
}
```