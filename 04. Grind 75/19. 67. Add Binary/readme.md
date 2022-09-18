## [67. Add Binary](https://leetcode.com/problems/add-binary/)

```java
class Solution {
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        
        StringBuilder ans=new StringBuilder();
        int i = n-1, j = m-1;
        int sum = 0, carry = 0;
        
        while(i>=0 || j>=0){
            sum = carry;
            if(i>=0) sum+= a.charAt(i) - '0';
            if(j>=0) sum+= b.charAt(j) - '0';
            
            ans.append(sum%2);
            carry = sum/2;
            
            i--; j--;
        }

        if(carry!=0){
            ans.append(carry);
        }
        
        return ans.reverse().toString();
    }
}
```