# **[4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)**
# My Intution : - Merge Sort Technique TC - O(N+M) SC - O(1)
```java
class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int m=arr1.length, n=arr2.length;
        int i=0,j=0,count=-1,a=0,b=0;
        while(i < m && j < n) {
			if(arr1[i] <= arr2[j]) {
				count++;
                if(count==((n+m)/2)-1)  a=arr1[i];
                if(count==((n+m)/2)){ b=arr1[i]; break;}
				i++;
			}
			else {
                count++;
                if(count==((n+m)/2)-1)  a=arr2[j];
                if(count==((n+m)/2)){ b=arr2[j]; break;}
				j ++;
			}
			
		}

		// add elements left in the first interval
		if(count!=(n+m)/2){
            while(i < m) {
                count++;
                if(count==((n+m)/2)-1) a=arr1[i];
                if(count==((n+m)/2)){  b=arr1[i]; break;}
                i++;
            }


            // add elements left in the second interval

            while(j < n) {
                count++;
                if(count==((n+m)/2)-1) a=arr2[j];
                if(count==((n+m)/2)){ b=arr2[j]; break;}
                j++;
            }
        }
        
        if((n+m)%2!=0) return b;
        return (a+b)/2.0;
    }
}
```
