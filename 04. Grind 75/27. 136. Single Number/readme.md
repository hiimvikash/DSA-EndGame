## [136. Single Number](https://leetcode.com/problems/single-number/)

## METHOD 3 : USING BITWISE XOR OPERATOR (USING CONSTANT SPACE )
To use this approach you first need to understand about Bitwise XOR operator.
Most of us who have a background in physics ( highschool level ) , are aware of the LOGIC GATES.
One of such gates is the XOR Gate :
According to this gate , the output is true , only if both the inputs are of opposite kind .
That is ,
- A B Y
- 0 0 0
- 0 1 1
- 1 0 1
- 1 1 0

We apply the extended version of this gate in our bitwise XOR operator.
If we do "a^b" , it means that we are applying the XOR gate on the 2 numbers in a bitwise fashion ( on each of the corresponding bits of the numbers).
Similarly , if we observe ,

- A^A=0
- A^B^A=B
- (A^A^B) = (B^A^A) = (A^B^A) = B This shows that position doesn't matter.
- Similarly , if we see , a^a^a......... (even times)=0 and a^a^a........(odd times)=a

We apply the above observations :

- Traverse the array and take the Bitwise XOR of each element.
- Return the value.

```java
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0; 
        for(int ele : nums) ans^=ele;
        return ans;
    }
}
```