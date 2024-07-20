## [**503. Next Greater Element II**](https://leetcode.com/problems/next-greater-element-ii/)
[video ref](https://youtu.be/7PrncD7v9YQ?si=0gZfBD6PfWB25Kn8)
```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st=new Stack<>();
        int nge[]=new int[n];

        for(int i = (2*n)-1; i>=0; i--){
            while(!st.isEmpty() && nums[i%n] >= st.peek()) st.pop();
            if(i<n){
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums[i%n]);
        }
        return nge;
    }
}
```
