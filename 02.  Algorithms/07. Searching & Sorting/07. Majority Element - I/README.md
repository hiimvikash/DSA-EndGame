# [**Majority Element**](https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1#)
## Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.

# **Method 1 : Use Brute-force i.e., two for loops TC - O(N<sup>2</sup>)**

```javat
count=0
for i=0 to i=n-1
    for j=0 to j=n-1
        if(arr[i]==arr[j]) count++;
    if(count>n/2) return arr[i];
return -1;         
```
# **Method 2 : Sorting TC - O(N log N) SC - O(1)**
![](https://leetcode.com/problems/majority-element/Figures/169/sorting.png)
## Now why n/2 ?

because wheather it be a odd length or even length, element with frequency greater than n/2 will lie in n/2 index after sorting.
### now ask yourself why so ?
- This is because refer the above image, any element with frequency greater than N/2 wil cross the n/2th index from back or from front.

#### **[169. Majority Element - I](https://leetcode.com/problems/majority-element/)**
```java
class Solution {
    public int majorityElement(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length/2];
    }
}
```
# **Method 3 : - Using HashMap TC - O(N) SC - O(N)**
## Approach :-
In Hashmap(key-value pair), at value, maintain a count for each element(key) and whenever the count is greater than half of the array length, return that key(majority element). 
- If element is not there in HashMap then we put that element in HM with frequency 1.
- If found we store the frequency+1 in count and check is it greater than n/2 if YES then return that element, else we put (ele,count)
```java
static int majorityElement(int arr[], int n)
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        if(n==1) return arr[0];
        int count =0;
        for(int ele:arr){
            if(hm.containsKey(ele)){
                count=hm.get(ele)+1;
                if(count > n/2) return ele;
                else hm.put(ele,count);
            }
            else hm.put(ele,1);
        }
        return -1; 
    }
```
# **Method 4 : - Boyer-Moore Voting Algorithm TC - O(N) SC - O(1)**
## Approach : 
### This algorithm works on the fact that if an element occurs more than N/2 times, it means that the remaining elements other than this would definitely be less than N/2. So our algorithm will be kind of cancelling majority elements with non-majority element and as majority elements are more so atleast one majority element will be left uncancelled in last. So let us check the proceeding of the algorithm:-
- First, choose a candidate from the given set of elements if it is the same as the candidate element, increase the count. Otherwise, decrease the count if count become 0, select another new element as the new candidate, this means till there element canceled themselves.

## **Intuition Behind Working :**
When the elements are the same as the candidate element, votes are incremented when some other element is found not equal to the candidate element. We decreased the count. This actually means that we are decreasing the priority of winning ability of the selected candidate, since we know that if the candidate is a majority it occurs more than N/2 times and the remaining elements are less than N/2. We keep decreasing the votes since we found some different element than the candidate element. When votes become 0, this actually means that there are the same number of different elements, which should not be the case for the element to be the majority element. So the candidate element cannot be the majority, so we choose the present element as the candidate and continue the same till all the elements get finished. The final candidate would be our majority element. We check using the 2nd traversal to see whether its count is greater than N/2. If it is true, we consider it as the majority element.
```java
class Solution
{
    static int majorityElement(int arr[], int n)
    {
        int cand=arr[0],count=1;
        for(int i=1;i<n;i++){
            if(cand==arr[i]) count++;
            else count--;
            if(count==0){ cand=arr[i]; count=1; }
        }
        count=0;
        for(int ele : arr){
            if(ele==cand) count++;
            if(count>n/2) return cand;
        }
        return  -1;
    }
}
```
