# **[287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)**
**Note :** All the elements in array range from 1 to n-1.

# **Approach 1 :** Sorting & Comparing Adjacent - TC= O(N + N Log N) SC = O(1)

```java
import java.util.*;
class Solution {
    public int findDuplicate(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1]){
                return arr[i];
            }
        }
        return -1;
    }
}
```

# **Approach 2 :** Using Extra Space - TC= O(N) SC = O(N)

## - **Using Set**

```java
class Solution {
    public int findDuplicate(int[] arr) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : arr) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }
}
```

## - **Using Array**

```java
class Solution {
    public int findDuplicate(int[] arr) {
        int n=arr.length;
        boolean visited[]=new boolean[n];
        for (int num : arr){
            if(visited[num]){
                return num;
            }
            visited[num]=true;
        }
        return -1;
    }
}
```

# **Approach 3 :** Tortoise Method - TC= O(N) SC = O(1)

```java
class Solution {
    public int findDuplicate(int[] arr) {
        int slow=arr[0];
        int fast=arr[0];
        // While islie nhi use kre rhe kyunki turant match hojaega aur *instant fuck hojaega*
        do{
            slow=arr[slow];
            fast=arr[arr[fast]];
        }while(slow!=fast);

        slow=arr[0];
        while(slow!=fast){
            slow=arr[slow];
            fast=arr[fast];
        }

        return slow;
    }
}
```

## [**Video Reference**](https://youtu.be/32Ll35mhWg0)
