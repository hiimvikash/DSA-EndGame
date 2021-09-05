# [**238. Product of Array Except Self**](https://leetcode.com/problems/product-of-array-except-self/)
## **Approach 1 : Naive approach**
## Create two extra space i.e., two arrays prefix[] and suffix[] to store prefix product from (0 to i-1) and suffix product from (n-1 to i+1) and then make a new ans[] array and update ans[i]=prefix[i]*suffix[i].
- **TC - O(N) SC - O(2N)**
## **Approach 2 : optimised approach 1**
## In approach 1 we created 2 extra arrays. Here we will create one ans[] array and store the prefix and suffix product in the ans[] array itself. Thus reducing the space required.
## **Algorithm :-**
- First traverse array from i=0 to i=n-1.
- and store prefixProduct for each index in 1st GO i.e., from i=0 to i=n-1.
    - initialise temp=1;
    - inside loop :-
        - ans[i]=temp;
        - temp*=arr[i];
- Now you have installed prefixProduct for each index so now to get final ANS multiply ans[i] with suffixProduct of each index.
- Traverse the array again from back i.e., i=n-1 to i=0.
    - initialise temp=1;
    - inside loop :-
        - ans[i]*=temp;
        - temp*=arr[i];
- **return ans;**  
- **TC - O(N) SC - O(1)**             
```java
class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n=arr.length;
        int ans[]=new int[n];
        int temp=1;
        // install prefix product in ANSarray
        for(int i=0;i<n;i++){
            ans[i]=temp;
            temp*=arr[i];
        }
        // now install final product by multiplying suffix product with prefixvalues
        temp=1;
        for(int i=n-1;i>=0;i--){
            ans[i]*=temp;
            temp*=arr[i];
        }
        return ans;
    }
```