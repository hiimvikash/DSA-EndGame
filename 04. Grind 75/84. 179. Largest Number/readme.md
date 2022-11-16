# [179. Largest Number](https://leetcode.com/problems/largest-number/)

```
String s1 = "9";
String s2 = "31";

String case1 =  s1 + s2; // 931
String case2 = s2 + s1; // 319
Apparently, case1 is greater than case2 in terms of value.
So, we should always put s1 in front of s2.
```

```java
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
		for(int i = 0; i < nums.length; i++) arr[i] = String.valueOf(nums[i]);
        
        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));
        if(arr[0].charAt(0) == '0') return "0";

        StringBuilder sb = new StringBuilder();
		for(String s: arr)
	        sb.append(s);
		
		return sb.toString();
    }
}
```