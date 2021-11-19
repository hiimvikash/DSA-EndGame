## [**503. Next Greater Element II**](https://leetcode.com/problems/next-greater-element-ii/)

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        
        int res[]=new int[n];
        Arrays.fill(res,-1);
        
        for(int i=0; i<n*2; i++){ 
            int ele = nums[i%n];
            while(!st.isEmpty() && ele > nums[st.peek()]){
                res[st.pop()] = ele;
            }
            st.push(i%n);
        }
        return res;
    }
}
```
