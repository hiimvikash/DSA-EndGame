## [2657. Find the Prefix Common Array of Two Arrays](https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/)

```java
class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n = a.length;
        int c[] = new int[n];
        // a[] = [2, 3, 5, 1, 4]
        // b[] = [3, 1, 5, 4, 2]
        
        Set<Integer> seen=new HashSet<>();

        for(int i = 0; i<n; i++){
            if(seen.isEmpty()){
                if(a[0] == b[0]) c[0] = 1;
            }else{
                if(a[i] == b[i]){
                    c[i] = c[i-1] + 1;
                }else{
                    if(seen.contains(a[i])) c[i]++;
                    if(seen.contains(b[i])) c[i]++;
                    c[i]+=c[i-1];
                }
            }
            seen.add(a[i]);
            seen.add(b[i]);
        }

        return c;
    }
}
```