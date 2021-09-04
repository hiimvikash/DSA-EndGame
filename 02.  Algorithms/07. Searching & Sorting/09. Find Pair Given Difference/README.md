# [**532. K-diff Pairs in an Array**](https://leetcode.com/problems/k-diff-pairs-in-an-array/)
## Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

### **A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true :-**

- ```0 <= i < j < nums.length```
- ```nums[i] - nums[j]| == k```
## Thought Process :-
### Traverse the array and if ```arr[i]+d``` exists in array then ```count++``` to get unique pairs this is possible only when we use HashMap. Incase when ```d==0``` then any element which occurs more than 2 times will contribute in count by 1.
## Algorithm :-
1. Store all the elements of array in HashMap and map it with its corresponding frequency.
2. Now itterate the HashMap 
     1. if(d==0) then any key whose frequency is greater than = 2 will do count++;
     1. if(getKey()+d exists in hashmap) count++;
```java
class Solution {
    public int findPairs(int[] arr, int d) {
        int count=0,n=arr.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int ele : arr){
            hm.put(ele,hm.getOrDefault(ele,0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            if(d==0){
                if(entry.getValue()>=2) count++;
            }
            else if(hm.containsKey(entry.getKey()+d)) count++;
        }
        return count;
    }
}
```
