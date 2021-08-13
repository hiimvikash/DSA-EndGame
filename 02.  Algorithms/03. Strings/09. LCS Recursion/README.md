# **[Longest-Common-Subsequence](https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1#)**
- **[Video Reference.](https://youtu.be/4Urd0a0BNng)**
```java
class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
        return LCS(0,0,s1,s2,x,y);
    
    
    static int LCS(int i, int j, String s1, String s2, int n1, int n2){
	    if(i==n1 || j==n2) return 0;
	    if(s1.charAt(i)==s2.charAt(j))
	       return 1+LCS(i+1,j+1,s1,s2,n1,n2);
	    else
	       return Math.max(LCS(i,j+1,s1,s2,n1,n2), LCS(i+1,j,s1,s2,n1,n2));
	}    
}
```
