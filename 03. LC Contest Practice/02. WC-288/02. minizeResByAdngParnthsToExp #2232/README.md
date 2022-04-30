# [**2232. Minimize Result by Adding Parentheses to Expression**](https://leetcode.com/problems/minimize-result-by-adding-parentheses-to-expression/)

```java
class Solution {
    public String minimizeResult(String exp) {
        String e[]=exp.split("\\+"); // expression Array
        String le=e[0], re=e[1]; // left exp & right exp "247+38", here le="247" & re="38".
        
        String rexp="(" + exp + ")"; // resulting exp
        int rv=Integer.MAX_VALUE; // resulting value
        
        // add ( in le at (0,le.length()-1)
        // add ) in re at (1,re.length())
        // now your re are like lm * (ln+rn) * rm    lm is leftMultiple, ln is leftNumber similarly for right
        
        for(int i=0; i<le.length(); i++){
            int lm = le.substring(0,i).equals("") ? 1 : Integer.parseInt(le.substring(0,i));
            int ln = Integer.parseInt(le.substring(i));
            
            for(int j=1; j<=re.length(); j++){
                int rm = re.substring(j).equals("") ? 1 : Integer.parseInt(re.substring(j));
                int rn = Integer.parseInt(re.substring(0,j));
                
                int crv = lm*(ln+rn)*rm; // current rv
                
                if(crv<rv){
                    rv = crv;
                    rexp = le.substring(0,i) + "(" + le.substring(i) + "+" + re.substring(0,j) + ")" + re.substring(j);
                }
            }
        }
        return rexp;
    }
}
```