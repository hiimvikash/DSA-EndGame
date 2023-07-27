### **Problem Link:**

- #### [Next Greater Element I #496](https://leetcode.com/problems/next-greater-element-i/)
## Intution :-
- we r using stack coz for every arr[i] j is related to i in brute force
- Stack will store RightSide of Array - That's y started our traversal from rightSide
- if any ele comes which is greater than stackTop's then just pop them out
```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // find out all the nextGreaterElement for nums2 and store in map

        Stack<Integer> st=new Stack<>();
        HashMap<Integer, Integer> hm=new HashMap<>();
        int n = nums2.length;
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && nums2[i] > st.peek()) st.pop();
            if(!st.isEmpty()){
                hm.put(nums2[i], st.peek());
            }
            st.push(nums2[i]);
        }

        int ans[]=new int[nums1.length];
        for(int i = 0; i<nums1.length; i++){
            ans[i] = hm.getOrDefault(nums1[i],-1);
        }

        return ans;
    }
}
```
