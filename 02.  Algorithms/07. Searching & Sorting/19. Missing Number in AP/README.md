# [**Arithmetic Number**](https://practice.geeksforgeeks.org/problems/arithmetic-number2815/1#)

## Thought Process :-
## A<sub>n</sub>=A<sub>1</sub>+(n-1)d
```java
class Solution{
    static int inSequence(int A, int B, int C){
        // code here
        if(C==0){
            if(A==B) return 1; else return 0;
        }
        if((B-A)/C<0) return 0;
        if((B-A) % C == 0) return 1;
        return 0;
    }
}
```