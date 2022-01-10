# [**nPr**](https://www.geeksforgeeks.org/permutation-coefficient/)
[**Video reference**](https://youtu.be/Ebj83h76VUU)
```java
TC-O(N) SC-O(1)

int p=1;
for(int i=0; i<k; i++){
    p*=(n-i);
}
return p;
```