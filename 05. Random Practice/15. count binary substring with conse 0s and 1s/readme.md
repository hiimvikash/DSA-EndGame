# [696. Count Binary Substrings](https://leetcode.com/problems/count-binary-substrings/description/)


## The Thought Process
- When u have ```10``` --> ans = 1;
- When u have ```1100``` --> ans = 2; --> ```10, 1100```
- When u have ```1111000``` --> ans = 3; --> ```10, 1100, 111000```
- The observation is ```No.OfSubstring Possible with equal 0s & 1s btw 2 sets of consecutive ele is Math.min(countOfSet1, countOfSet2)```;

## The Approach :-
- make a array which stores countOfConsecutiveElement
    - 11110000011000 --> 4,5,2,3
- according to our thought process make subans with adjacentConsecutiveELE and add that subans with other two adjacentConsecutiveELE subans
- For Example : 11110000011000 --> 4,5,2,3
    - min(4,5) --> 4
    - min(5,2) --> 2
    - min(2,3) --> 2
    - ans = 4 + 2 + 2 = 8

```java
class Solution {
    public int countBinarySubstrings(String s) {
        ArrayList<Integer> freq = new ArrayList<>();

        int count = 1;
        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)) count++;
            else{
                freq.add(count);
                count = 1;
            }
        }
        freq.add(count);
        
        // System.out.println(freq);
        count = 0;
        for(int i = 0; i<freq.size()-1; i++){
            count+= Math.min(freq.get(i), freq.get(i+1));
        }
        return count;
    }
}
```

## Same thought process with noExtraSpace
```java
class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        
        int currC = 1, prevC = 0, count = 0;
        for(int i = 1; i<n; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                currC++;
            }
            else{
                count+= Math.min(currC, prevC);
                prevC = currC;
                currC = 1;
            }
        }
        count+= Math.min(currC, prevC);

        return count;
    }
}
```