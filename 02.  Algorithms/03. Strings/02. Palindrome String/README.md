# **[Palindrome String](https://practice.geeksforgeeks.org/problems/palindrome-string0817/1)**
# Approach 1 : Using Reverse() TC - O(N) SC - O(N)
```java
class Solution {
    int isPlaindrome(String str) {
        // code here
        String revStr=reverseWord(str);
        if(str.equals(revStr)) return 1;
        else return 0;
    }
    public String reverseWord(String str)
    {
        // Reverse the string str
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            st.push(str.charAt(i));
        }
        str="";
        while(!st.isEmpty()){
            str=str+st.pop();
        }
        return str;
    }
};
```
# Approach 2 : Using 2 Pointer Technique TC - O(N) SC - O(1)
```java
class Solution {
    int isPlaindrome(String str) {
        // code here
        int s=0,e=str.length()-1;
        while(s<e){
            if(str.charAt(s)!=str.charAt(e))
                return 0;
            s++;
            e--;
        }
        return 1;
    }
};
```
# Using Recurssion
```java
public static void main(String[] args) {
		String str="madam";
		int l=str.length();
		
		System.out.println(isPalindrome(str,0,l-1));
	}
	static boolean isPalindrome(String str,int s,int e) {
		if(s>e) return true;
		if(str.charAt(s)==str.charAt(e)) {
			return isPalindrome(str,++s,--e);
		}
		else return false;
	}
```