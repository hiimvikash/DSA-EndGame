# **[Longest consecutive subsequence](https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1)**

## My Intution : - TC - O(N Log N) SC - O(N)

- First sort the array.
- add unique element in arrayList.
- if(ar.get(i)-ar.get(i-1)==1) count ++; this will check for consecutive.

```java
class Solution
{
    //Function to return length of longest subsequence of consecutive integers.
	static int findLongestConseqSubseq(int arr[], int n)
	{
	   // add your code here
	   Arrays.sort(arr);
	   // removing dublicate and adding them in ArrayList
	   ArrayList<Integer> ar=new ArrayList<>();
	   ar.add(arr[0]);
	   for(int i=1;i<n;i++){
	       if(arr[i]!=arr[i-1]) ar.add(arr[i]);
	   }
	   int count = 1, ans=1;
	   for(int i=1;i<ar.size();i++){
	       if(ar.get(i)-ar.get(i-1)==1) count++;
	       else count = 1;
	       ans=Math.max(ans,count);
	   }
	   return ans;
	}
}
```
