# [22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)
```I would like to share my understanding about this algorithm. Hope will make people easier to understand the beauty of this code. Chip in your ideas if I am wrong.

The goal is to print a string of “(“ ,”)” in certain order. The length of string is 2n. The constraints are that “(“s need to match “)”s.
Without constraints, we just simply print out “(“ or “)” until length hits n. So the base case will be length ==2 n, recursive case is print out “(“ and “)”. The code will look like

//base case
if(string length == 2*n) {
add(string);
return;
}
//recursive case
add a “(“
add a “)"

Let’s add in constraints now. We need to interpret the meanings of constraints. First, the first character should be “(“. Second, at each step, you can either print “(“ or “)”, but print “)” only when there are more “(“s than “)”s. Stop printing out “(“ when the number of “(“ s hit n. The first actually merges into the second condition.
The code will be:

//base case
if(string length == 2*n) {
add(string);
return;
}
//recursive case
if(number of “(“s < n){
add a “(“
}
if(number of “(“s > number of “)”s){
add a “)"
}
```
## Example to understand this solution 
```
(0,0) -> ("-(", 1, 0)  ______
(1,0) -> ("(-(", 2, 0)  ______            |
(2,0) -> ("((-(", 3, 0)  _______          | ("((-)", 2, 1) -> ("(()-(", 3, 1) -> ("(()(-)", 3, 2) -> ("(()()-)", 3, 3) -> added in  ans
(3,0) -> XXXXXXXXXXX ("(((-)", 3, 1)      | 🔝
(3,1) -> XXXXXXXXXXX ("((()-)", 3, 2)     | 🔝
(3,2) -> XXXXXXXXXXX ("((())-)", 3, 3)    | 🔝
(3,3) -> added in ans                     | 🔝




an example to understand this solution:
(
((
(((
((()
((())
((()))
(()
(()(
(()()
(()())
(())
(())(
(())()
()
()(
()((
()(()
()(())
()()
()()(
()()()
```
```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        fun("",0,0,ans,n);
        
        return ans;
    }
    
    private void fun(String s, int o, int c, List<String> ans, int n){
        if(s.length()==2*n){
            ans.add(s);
            return;
        }
        
        if(o<n) fun(s+"(", o+1, c, ans, n);
        if(c<o) fun(s+")", o, c+1, ans, n);
    }
}
```