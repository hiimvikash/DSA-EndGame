## [169. Majority Element](https://leetcode.com/problems/majority-element/)

## Use HM
```java
class Solution {
    public int majorityElement(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = arr.length;
        for(int i = 0; i<n; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i],0) + 1);
            if(hm.containsKey(arr[i]) && hm.get(arr[i]) > n/2) return arr[i];
        }
        return -1;
    }
}
```

## My Intution 2 : - Sorting TC - O(N log N) SC - O(1)

![](https://leetcode.com/problems/majority-element/Figures/169/sorting.png)

## Now why n/2 ?

because wheather it be a odd length or even length, element with frequency greater than n/2 will lie in n/2 index after sorting.

```java
class Solution {
    public int majorityElement(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length/2];
    }
}
```
## Intution 3 :- 
```java
class Solution {
    public int majorityElement(int[] arr) {
        int candi = arr[0]; int count = 1, n = arr.length;
        
        for(int i = 1; i<n; i++){
            if(arr[i] == candi) count++;
            else count--;
            if(count == 0){ candi = arr[i]; count = 1; }
        }
        return candi;
    }
}
```
## **[Video Reference : AnujBhaiya](https://youtu.be/X0G5jEcvroo?t=799)** Intution is of crediblity