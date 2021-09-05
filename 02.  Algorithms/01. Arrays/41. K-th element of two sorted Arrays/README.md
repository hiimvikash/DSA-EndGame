# **[K-th element of two sorted Arrays](https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1#)**
# My Intution : - Merge Sort Technique TC - O(N+M) SC - O(1)
```java
class Solution {
    public int kthElement( int arr1[], int arr2[], int m, int n, int k) {
        int i=0,j=0,count=0;
        while(i < m && j < n) {
    		if(arr1[i] <= arr2[j]) {
    			count++;
    			if(count==k) return arr1[i];
    			i++;
    		}
    		else {
    			count++;
    			if(count==k) return arr2[j];
    			j ++;
    		}
		}

		// add elements left in the first interval

        while(i < m) {
            count++;
            if(count==k) return arr1[i];
            i++;
        }


        // add elements left in the second interval

        while(j < n) {
            count++;
            if(count==k) return arr2[j];
            j++;
        }
        
        
        return -1;
    }
}
```
# My Intution : - Binary Search Technique TC - O(Min(log N1,log N2)) SC - O(1)
```java
class Solution {
    public long kthElement( int arr1[], int arr2[], int n1, int n2, int k) {
        if(n1>n2) return kthElement(arr2,arr1,n2,n1,k);
        // when k > n2 then it is not all sensible that we pick 0 element from arr1.
        // when k < n1 then it is not necessary to pick n1 element in high.
        int low = Math.max(0,k-n2), high = Math.min(k,n1); 
        int l1=0,l2=0,r1=0,r2=0;
        while(low<=high){
            int cut1=(low+high)/2;
            int cut2=k-cut1;
            
             l1= (cut1==0)? Integer.MIN_VALUE : arr1[cut1-1];
             l2= (cut2==0)? Integer.MIN_VALUE : arr2[cut2-1];
            
             r1= (cut1==n1)? Integer.MAX_VALUE : arr1[cut1];
             r2= (cut2==n2)? Integer.MAX_VALUE : arr2[cut2];
            
            if(l1<=r2 && l2<=r1) break;
            if(l1>r2) high=cut1-1; // want to take less element on left side
            else if(l2>r1) low=cut1+1;
        }
        return (long)Math.max(l1,l2);
    }
}
```
## **[Video Reference](https://youtu.be/nv7F4PiLUzo)**