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

## My Intution : - TC - O(N) SC - O(N)

- Create an empty hash.
- Insert all array elements to hash.
- Do following for every element arr[i]
- Check if this element is the starting point of a subsequence. To check this, simply look for arr[i] – 1 in the hash, if not found, then this is the first element a subsequence.
- If this element is the first element, then count the number of elements in the consecutive starting with this element. Iterate from arr[i] + 1 till the last element that can be found.
- If the count is more than the previous longest subsequence found, then update this.
  ![](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20190702121807/LongestConsecutiveSubsequence.png)

```java
class Solution
{
    //Function to return length of longest subsequence of consecutive integers.

	static int findLongestConseqSubseq(int arr[], int n)
	{
	    int count=0, ans=0,sVal=0;
	   // add your code here
	   Set<Integer> st=new HashSet<>();
	   for(int val:arr) st.add(val);
	   for(int i=0;i<n;i++){
	       if(!st.contains(arr[i]-1)){
	           count = 0;
	           sVal=arr[i];
	           while(st.contains(sVal++)) count++;
	       }
	       ans=Math.max(ans,count);
	   }
	   return ans;
	}
}
```
