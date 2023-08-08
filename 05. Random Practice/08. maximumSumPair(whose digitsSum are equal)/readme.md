# [maximum sum of two numbers whose digits add up to an equal sum](https://www.desiqna.in/13267/microsoft-coding-oa-sde-1-may-3-2023)
## Given an array A consisting of N integers, returns the maximum sum of two numbers whose digits add up to an equal sum.
If there are not two numbers whose digits have an equal sum, the function should return -1.
Constraints: N is integer within the range [1, 200000]
each element of array A is an integer within the range [1, 1000000000]

Example1:
Input:
A = [51, 71, 17, 42]
Output: 93
Explanation: There are two pairs of numbers whose digits add up to an equal sum: (51, 42) and (17, 71), The first pair sums up to 93

Example2:
Input:
A = [42, 33, 60]
Output: 102
Explanation: The digits of all numbers in A add up the same sum, and choosing to add 42 and 60 gives the result 102


Example3:
Input:
A = [51, 32, 43]
Output: -1
Explanation: All numbers in A have digits that add up to different, unique sums

<hr>

# Thought Process :-
- When I read the Q I saw pairs can be made if digitsSum of both the ele are same.
- Then How to store ele based on digitsSum ?
- So why not do something like if I get all the elements with same digitsSum in O(1).
- There comes the HashMap where I thought to store all ele with same digitsSum...i.e., digitsSum as keys and Values as List<Integer>
- for arr[] = {42, 71, 80, 51, 60} our HM would look like :-
- 6 -> 42, 51, 60    8 -> 71, 80
- Then itterate over HM keys implement a PQ or a sorting algo on each List and extracted two values and maintained the maxAnswer.
### The above approach would have lots of work to do in PQ implementing for each list
- As we see we r dealing with pairs only and all we need is two large ele in that list.
## So my approach would be
- while iterating maintain HashMap key:digitsSum & value:maxEleWithThatDigitsSum
- now whenever u get the ele with digitsSum which is already present in HM 
    - then find maxAns
    - and update digitsSum with maxEleWithThatDigitsSum

```java
private static int maximumSumOfPair(int arr[]){
      // we will make a hashMap<digitsSum - maximumElement>
      HashMap<Integer, Integer> hm=new HashMap<>();
      int maxAns = -1;
      for(int ele : arr){
        int digitsSum = findDigiSum(ele);
        if(!hm.containsKey(digitsSum)){
          hm.put(digitsSum, ele);
        }
        else{
          maxAns = Math.max(maxAns, hm.get(digitsSum) + ele);
          hm.put(digitsSum, Math.max(ele, hm.get(digitsSum)));
        }
      }
      
      return maxAns;
}
    
    private static int findDigiSum(int n){
      int sum = 0;
      while(n!=0){
        sum+=n%10;
        n/=10;
      }
      return sum;
    }
```
