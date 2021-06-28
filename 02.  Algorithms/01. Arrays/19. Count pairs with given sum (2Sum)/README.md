# **[Count pairs with given sum](https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1#)**

# **My Intution :-**

- we will make HashMap<Integer, Integer> to store arr[i] as key and its frequencies as value.
- We will itterate through out the array and search wheather k-a[i] is present in HM or not.
  - if not present we will put arr[i] HM and increment it frequency by 1.
  - if present
    - then we store its frequency in count, because it frequency will only define how many pairs does it will make with arr[i].
    - then we will put arr[i] HM and increment it frequency by 1.

# **Dry Run :-** [5, 5, 1, 1, 4, 2] K=6 ans = 5 || [1, 1, 1, 1] K=2 ans = 6

```java
class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        int c=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        // storing array elements in HM with frequencies
        for(int e: arr){
                int i;
                if(hm.get(e)==null) i=0;
                else i=hm.get(e);
            if(!hm.containsKey(k-e)){
                hm.put(e,i+1);
            }
            else{
                c+=hm.get(k-e);
                hm.put(e,i+1);
            }
        }
        return c;
    }
}
```
