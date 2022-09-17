## [278. First Bad Version](https://leetcode.com/problems/first-bad-version/)
```java
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return bs(1,n);
    }
    int bs(int s, int e){
        int ans = e;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(isBadVersion(mid)){ ans = mid; e = mid-1;}
            else s = mid+1;
        }
        return ans;
    }
    
}
```