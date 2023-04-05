# [91. Decode Ways](https://leetcode.com/problems/decode-ways/)


# Recursion 
## 1.1
```java
class Solution {
    int ans = 0;
    public int numDecodings(String s) {
        if(s.length()==1){
            if(s.charAt(0)=='0') return 0;
            return 1;
        }
        
        helper(s.toCharArray(),1,false);
        return ans;
    }

    void helper(char c[], int i, boolean isPairUp){
        
        if(i==c.length){
            ans++;
            return;
        }
        if(c[0]=='0') return;



        if(c[i]!='0') helper(c,i+1, false); // if currChar is not0 then only it can proceed ALONE
        if(c[i-1]!='0' && (Integer.parseInt((String.valueOf(c[i-1])+String.valueOf(c[i]))) < 27) && !isPairUp ){
             helper(c,i+1,true);
        } // if prevChar is not0 + prevChar is notPaired up with it's prev + pairing leads to < 27 Then only Proceed PAIRING
         
        

    }
}
```

<hr>

## 1.2
```java
class Solution {
    int ans = 0;
    public int numDecodings(String s) {
        if(s.length()==1){
            if(s.charAt(0)=='0') return 0;
            return 1;
        }
        
        return helper(s.toCharArray(),1,false);
        
    }

    int helper(char c[], int i, boolean isPairUp){
        
        if(i==c.length){
            return 1;
        }
        if(c[0]=='0') return 0;


        int al=0, pu=0;
        if(c[i]!='0') al+=helper(c,i+1, false); // if currChar is not0 then only it can proceed ALONE
        if(c[i-1]!='0' && (Integer.parseInt((String.valueOf(c[i-1])+String.valueOf(c[i]))) < 27) && !isPairUp ){
             pu+=helper(c,i+1,true);
        } // if prevChar is not0 + prevChar is notPaired up with it's prev + pairing leads to < 27 Then only Proceed PAIRING
         
        return al+pu;

    }
}
```

<hr>

## 1.3
```java
class Solution {
    int ans = 0;
    public int numDecodings(String s) {
        if(s.length()==1){
            if(s.charAt(0)=='0') return 0;
            return 1;
        }
        
        return helper(s.toCharArray(),0,false);
        
    }

    int helper(char c[], int i, boolean isPairUp){
        
        if(i==c.length){
            return 1;
        }
        if(c[0]=='0') return 0;


        int al=0, pu=0;
        if(c[i]!='0') al+=helper(c,i+1, false); // if currChar is not0 then only it can proceed ALONE
        if(i!=0 && c[i-1]!='0' && (Integer.parseInt((String.valueOf(c[i-1])+String.valueOf(c[i]))) < 27) && !isPairUp){
             pu+=helper(c,i+1,true);
        } // if i!=0 && prevChar is not0 + prevChar is notPaired up with it's prev + pairing leads to < 27 Then only Proceed PAIRING
         
        return al+pu;

    }
}
```

<hr>
<hr>

![image](https://user-images.githubusercontent.com/71629248/202902601-4d86b52b-6b1d-4937-a54e-cecad4c0fbc2.png)

```java
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0') return 0;
        int dp[]=new int[n+1]; // dp[i] signifies no.OfWays possible of ith length
        dp[0] = dp[1] = 1;
        
        for(int i = 1; i<n; i++){
            int cnum = s.charAt(i) - '0'; // current num
            int pnum = s.charAt(i-1) - '0'; // prev num
            
            int nn = pnum*10 + cnum;
            
            
            
             // Milke 
            if(cnum == 0){
                if(pnum == 0 || pnum > 2) return 0;
                dp[i+1] = dp[i-1];
            }
            // naiMilke
            else if(pnum == 0 || nn > 26){
                dp[i+1] = dp[i];
            } 
            // milke + naiMilke
            else{
                dp[i+1] = dp[i] + dp[i-1];
            }
            
        }
        return dp[n];
    }
}
```
