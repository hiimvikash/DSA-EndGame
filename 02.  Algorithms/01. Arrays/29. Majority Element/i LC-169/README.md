# **[169. Majority Element - I](https://leetcode.com/problems/majority-element/)**

## My Intution 1 : - Using HashMap TC - O(N) SC - O(N)

- If element is not there in HashMap then we put that element in HM with frequency 1.
- If found we store the frequency+1 in count and check is it greater than n/2 if YES then return that element, else we put (ele,count)

```java
class Solution {
    public int majorityElement(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n=arr.length;
        int count =0;
        for(int ele:arr){
            if(hm.containsKey(ele)){
                count=hm.get(ele)+1;
                if(count > n/2) return ele;
                else hm.put(ele,count);
            }
            else hm.put(ele,1);
        }
        return arr[0]; // if input is [1]
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

## My Intution 3 : - Boyer-Moore Voting Algorithm TC - O(N) SC - O(1)

If we had some way of counting instances of the majority element as +1 and instances of any other element as -1, summing them would make it obvious that the majority element is indeed the majority element.

```java
class Solution {
    public int majorityElement(int[] arr) {
        int count =0,candi=0;
       for(int ele:arr){
           if(count==0) candi=ele;
           if(candi==ele) count++;
           else count--;
       }
        return candi;
    }
}
```

## **[Video Reference : Watch twice](https://youtu.be/AoX3BPWNnoE)**
