class Solution {
    public String makeGood(String S) {
        int l=S.length();
        char st[]=new char[l];
        int top=-1;
        for(int i=0;i<l;i++){
            char currCh=S.charAt(i);
            if(top>-1 && Math.abs(st[top]-S.charAt(i)) == 32)
                top--;
            else{
                top++;
                st[top]=currCh;
            }
        }
        return new String(st,0,top+1);
    }
}








/**class Solution {
    public String makeGood(String S) {
        int l=S.length();
        char st[]=new char[l];
        int top=-1;
        for(int i=0;i<l;i++){
            char currCh=S.charAt(i);
            if(top>-1 && (st[top]==Character.toUpperCase(currCh) || Character.toUpperCase(st[top])==currCh) && (st[top]==Character.toLowerCase(currCh) || Character.toLowerCase(st[top])==currCh) )
                top--;
            else{
                top++;
                st[top]=currCh;
            }
        }
        return new String(st,0,top+1);
    }
}
**/

/**  Dry Run with this to understand---> 
(st[top]==Character.toUpperCase(currCh) || Character.toUpperCase(st[top])==currCh) && (st[top]==Character.toLowerCase(currCh) || Character.toLowerCase(st[top])==currCh)

Input: s = "leEeetcode"
Output: "leetcode"


Input:
"kkdsFuqUfSDKK"

Output:
"kkdsFuqUfSD"

Expected:
"kkdsFuqUfSDKK"



two lowecase adjacent character OR two uppercase adjacent character cannot pass this IF condition this.

B4 doing this Q, Do Qno. #1047
**/