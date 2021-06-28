# **[Array Subset of another array](https://leetcode.com/problems/majority-element-ii/)**

## My Intution : - Set DS TC - O(N+M) SC - O(N+M)
```java
class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        Set<Long> arr1=new HashSet<>();
        Set<Long> arr2=new HashSet<>();
        for(long ele:a1){
            arr1.add(ele);
        }
        for(long ele:a2){
            arr2.add(ele);
        }
        return arr1.containsAll(arr2)?"Yes":"No";
    }
}
```
- ## Method 2 Using Set TC - O(N+M) SC - O(N)
```java
class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        Set<Long> arr1=new HashSet<>();
        for(long ele:a1){
            arr1.add(ele);
        }
        int beforeSize=arr1.size();
        for(long ele:a2){
            arr1.add(ele);
        }
        return beforeSize==arr1.size()?"Yes":"No";
    }
}
```

- ## Method 3 : - Using Set TC - O(N+M) SC - O(N)
    - Create a Hash Table for all the elements of arr1[].
    - Traverse arr2[] and search for each element of arr2[] in the Hash Table. If element is not found then return No.
    - If all elements are found then return Yes.
```java
class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        HashMap<Long,Integer> map=new HashMap<>();
        for(long ele:a1){
            map.put(ele,1);
        }
        for(long ele:a2){
            if(!map.containsKey(ele)) return "No";
        }
        return "Yes";
    }
}
```
