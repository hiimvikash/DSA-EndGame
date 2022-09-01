# 1. [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
![image](https://user-images.githubusercontent.com/71629248/187269865-cf0ddb0a-79c9-4b40-914d-159e4bb30fbf.png)

## Memonization

```java
class Solution {
    
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        
        return cs(n,dp);
        
    }
    public int cs(int n, int dp[]){
        if(n<=3) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=cs(n-1,dp)+cs(n-2,dp);
    }
}
```

## Tabulation
```java
class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
```

## Space Optimized
Here f(4) will say ```"My number of distinct way is distinctWay(3)+distinctWay(2)"```

```java
class Solution {
    public int climbStairs(int n) {
        if(n<=1) return 1;

        int prev2=1,prev=1,c=0;
        for(int i=2; i<=n; i++){
            c=prev+prev2;
            prev2=prev;
            prev=c;
        }
        return c;
    }
}
```
[Reference](https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/)

# 2. [Frog Jump](https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?leftPanelTab=0)
![image](https://user-images.githubusercontent.com/71629248/187431703-fee3f63e-2905-43fe-b622-9bcf8317369e.png)
![image](https://user-images.githubusercontent.com/71629248/187431763-254e2b92-2fe4-4a5f-b640-6d41f1c6b50d.png)


## Memonization

```java
import java.util.*;
public class Solution {
    public static int frogJump(int n, int h[]) {
            int dp[]=new int[n+1];
            Arrays.fill(dp,-1);
            
        return fj(n,h,dp);
    }
    public static int fj(int n, int h[], int dp[]){
        if(n<=2) return Math.abs(h[0]-h[n-1]);
        
        if(dp[n]!=-1) return dp[n];
        
        int jump1 = fj(n-1,h,dp)+Math.abs(h[n-1]-h[n-2]);
        int jump2 = fj(n-2,h,dp)+Math.abs(h[n-1]-h[n-3]);
        
        return dp[n] = Math.min(jump1,jump2);
    }

}
```

## Tabulation

```java
public class Solution {
    public static int frogJump(int n, int h[]) {

        // Write your code here..
        int dp[]=new int[n+1];
        dp[0]=dp[1]=0;
        dp[2] = Math.abs(h[1]-h[0]);
        for(int i=3; i<=n; i++){
            dp[i] = Math.min((dp[i-1]+Math.abs(h[i-1]-h[i-2])), (dp[i-2]+Math.abs(h[i-1]-h[i-3])));
        }
        return dp[n];
    }

}
```

## Space Optimized
```java
public class Solution {
    public static int frogJump(int n, int h[]) {

        // Write your code here..
        if(n<=2) return Math.abs(h[0]-h[n-1]);
        
        int prev = Math.abs(h[0]-h[1]);
        int prev2 = 0;
        int c=0;
        for(int i=3; i<=n; i++){
            c = Math.min((prev + Math.abs(h[i-1]-h[i-2])), (prev2+Math.abs(h[i-1]-h[i-3])));
            prev2=prev;
            prev=c;
        }
        return c;
    }

}
```
[Reference](https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/)

# 3. Frog Jump with K distance

## Memonization
```java
import java.util.*;
public class Solution {
    public static int frogJump(int n, int h[], int k) {
            int dp[]=new int[n+1];
            Arrays.fill(dp,-1);
            
        return fj(n,h,dp,k);
    }
    public static int fj(int n, int h[], int dp[], int k){
        if(n<=2) return Math.abs(h[0]-h[n-1]);
        
        if(dp[n]!=-1) return dp[n];

		int ans = Integer.MAX_VALUE;
		for(int j=1; j<=k; j++){
			ans = Math.min(ans, fj(n-j,h,dp,k)+Math.abs(h[n-1]-h[n-j+1]) )
		}
        
        return dp[n] = ans;
    }

}
```

## Tabulation

```java
public class Solution {
    public static int frogJump(int n, int h[]) {

        // Write your code here..
        int dp[]=new int[n+1];
        dp[0]=dp[1]=0;
        dp[2] = Math.abs(h[1]-h[0]);
        for(int i=3; i<=n; i++){
			int ans = Integer.MAX_VALUE;
			for(int j=1; j<=k; j++){
				ans = Math.min(ans, dp[i-j]+Math.abs(h[i-1]-h[i-j+1])); 
			}
            dp[i] = ans;
        }
        return dp[n];
    }

}
```
[Reference](https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/)

# [4. Maximum sum of non-adjacent elements](https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261)
# [198. House Robber - I](https://leetcode.com/problems/house-robber/)

## Reccursive
```java
import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
        return mnas(nums,nums.size());
	}
    public static int mnas(ArrayList<Integer> arr, int n){
        if(n==1) return arr.get(0);
        if(n==0) return 0;
        
        int p = arr.get(n-1) + mnas(arr,n-2);
        int np = mnas(arr,n-1);
        
        return Math.max(p,np);
    }
}
```

## Memonization
```java
import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
        int n = nums.size();
        int dp[]=new int[n+1]; Arrays.fill(dp,-1);
        
        return mnas(nums,n,dp);
	}
    public static int mnas(ArrayList<Integer> arr, int n, int dp[]){
        if(n==1) return arr.get(0);
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        
        int p = arr.get(n-1) + mnas(arr,n-2,dp);
        int np = mnas(arr,n-1,dp);
        
        return dp[n] = Math.max(p,np);
    }
}
```

## Tabulation
```java
import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> arr) {
		// Write your code here.
        int n = arr.size();
        int dp[]=new int[n+1];
        dp[0] = 0;
        dp[1] = arr.get(0);
        
        for(int i = 2; i<=n; i++){
            dp[i] = Math.max(arr.get(i-1) + dp[i-2], dp[i-1]);
        }
        return dp[n];
	}
}
```

## Space optimized
```java
import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> arr) {
		// Write your code here.
        int n = arr.size();
        
        int prev2 = 0;
        int prev = arr.get(0);
        if(n==1) return prev;
        if(n==0) return 0;
        
        int c=0;
        
        for(int i = 2; i<=n; i++){
           c = Math.max(arr.get(i-1) + prev2, prev);
            prev2 = prev;
            prev = c;
        }
        return c;
	}
}
```
[reference](https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/)


# [213. House Robber II](https://leetcode.com/problems/house-robber-ii/)

## Space Optimized
```java
class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        if(n==1) return arr[0];
        
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        
        for(int i=0; i<n; i++){
            if(i!=0) arr1.add(arr[i]);
            if(i!=n-1) arr2.add(arr[i]);
        }
        
        return Math.max(maximumNonAdjacentSum(arr1), maximumNonAdjacentSum(arr2));
    }
    
    public int maximumNonAdjacentSum(ArrayList<Integer> arr) {
		// Write your code here.
        int n = arr.size();
        
        
        if(n==1) return arr.get(0);
        if(n==0) return 0;
        
        int prev2 = 0;
        int prev = arr.get(0);
        
        int c=0;
        
        for(int i = 2; i<=n; i++){
           c = Math.max(arr.get(i-1) + prev2, prev);
            prev2 = prev;
            prev = c;
        }
        return c;
	}
}
```
[reference](https://takeuforward.org/data-structure/dynamic-programming-house-robber-dp-6/)