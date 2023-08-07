# [2808. Minimum Seconds to Equalize a Circular Array](https://leetcode.com/problems/minimum-seconds-to-equalize-a-circular-array/)

# Thought Process
so the first approach which comes in my mind is to find the maxm occured element
and then convert the all other element into it greedly. 
It might seem appropriate from given example test cases
but what if there are more than 1 element which has equal maxm frequency
now you might think choose any one it will be same , well in reality its not
- ### Now lets test with another test case
[1,11,11,11,19,12,8,7,19] , dry run it yourself once
you will find that converting all to 11 will take 3 sec
lets try again with 19
it takes only 2 sec and 19 is not even maxm occured element
it means greedy approach has not one but 2 errors and will not work here
## Solution I wrote for above wrong hai!❌
```java
class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();

        HashMap<Integer, Integer> hm=new HashMap<>();
        int mf = 0; // maximum frequency
        int target = 0;
        for(int ele : nums){
            hm.put(ele, hm.getOrDefault(ele, 0)+1);
            if(hm.get(ele) > mf){
                mf = hm.get(ele);
                target = ele;
            }
        }
        if(mf == n) return 0;
        int t = 1;
        boolean change[]=new boolean[n];
        boolean loop = true;
        while(loop){
            int flag = 0;
            for(int i = 0; i<n; i++){
                if(nums.get(i) == target || nums.get((i-1+n) % n) == target || nums.get((i+1) % n) == target){
                    change[i] = true;
                }
                else{
                    flag = 1;
                }
            }
            if(flag == 0) loop = false;
            else t++;

            for(int i = 0; i<n; i++){
                if(change[i] == true) nums.set(i, target);
            }
        }
        return t;
    }
}
```

**So greedy will not work bcz greedy was not able to choose a rightTargetEle - Now implementing greedy for each distinctElement will result to TLE.**

# New Approach is :- 

## 1. Understand this concept
- [2, 1, (3), 4, 6, 5, (3), 6, 7] --> this will take 2 sec (only Btw idx2 to idx6)
- to convert ELEMENTS btw index 2 to index 6 takes Math.ceil(noOfEleBtwThem/2)
- now why noOfEleBtwThem/2 ?
- coz everyTime 3 will convert two of it's adjacent so timeTaken to convert ALLelementBtwthem will be count/2 or u can say 
- ```2Ele ko convert hone me 1time lgra so ALLelementBtwthem ko convert hone m kitna lagega ? --> ALLelementBtwthem/2 ofcc```
## 2. Now the Approach
 - ### This Approach will be implemented for eachDistinct ELEMENT, now we r converting arrayEles to 3.
    - [2, 1, 3', 4, 5, 3', 6, 3', 7]
    - indexsOf3 = {2, 5, 7}
    - so my All Eles lies btw :- 
        - (2,5) --> EleBtwThem = 5-2-1 = 2
        - (5,7) --> EleBtwThem = 7-5-1 = 1
        - (7,2) --> EleBtwThem = elesAfter7 + eleBefore2
    - Now if we calculate the ```timeTaken``` for conversion of Eles btw the EachRanges 
    - and take maximum of all the ```timeTaken``` say ```maxt```
    - so this ```maxt``` defines timeTaken to convert AllEles to 3.
- ### Now everyDistinctEle will give their ```maxt```, our answer will be minimum of all maxt's.

```java
class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();

        HashMap<Integer, List<Integer>> hm=new HashMap<>();
        for(int i = 0; i<nums.size(); i++){
            int ele = nums.get(i);
            if(!hm.containsKey(ele)){
                hm.put(ele, new ArrayList<>());
                hm.get(ele).add(i);
            }else {
                hm.get(ele).add(i);
            }
        }
        
        int minAns = Integer.MAX_VALUE;
        for(int key : hm.keySet()){
            List<Integer> indexOfOccurence = hm.get(key);
            int size = indexOfOccurence.size();

            int prevIdx = indexOfOccurence.get(0);
            int maxt = -1;

            // from here 
            for(int i = 1; i<size; i++){ // here we deal with [2, 5, 7] -> eleBtw (2,5) & (5,7)
                int currIdx = indexOfOccurence.get(i);
                int eleBtw = currIdx - prevIdx - 1;

                int time2ConvertBtwEle = (int)Math.ceil((double)eleBtw/(double)2);
                maxt = Math.max(maxt, time2ConvertBtwEle);

                prevIdx = currIdx;
            }
            // now whatAboutEleBtw (7,2) this is due to circular property
            // i.e eleAfter7index + eleB42index
            int eleBtw = (n-indexOfOccurence.get(size-1)-1) + indexOfOccurence.get(0);
            int time2ConvertBtwEle = (int)Math.ceil((double)eleBtw/(double)2);
            maxt = Math.max(maxt, time2ConvertBtwEle);
            // to here we found maxTimeTaken to convert all ele to key.


            minAns = Math.min(minAns, maxt);
        }

        return minAns;
    }
}
```
**PS : ```Eles``` means Elements**
