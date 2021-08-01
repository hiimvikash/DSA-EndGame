# **[Reverse a String](https://practice.geeksforgeeks.org/problems/reverse-a-string/1)**
# Approach 1 : Using Stack
```java
class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
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
}
```
# Approach 2 : Using 2 Pointer Swap
```java
class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        // Reverse the string str
        //Your code here
      char arr[]=str.toCharArray();
      int s=0;
      int e=arr.length-1;
  
      while(s<e){
          char temp=arr[s];
          arr[s]=arr[e];
          arr[e]=temp;
          s++;
          e--;
      }
      return String.valueOf(arr);
  }
}
```