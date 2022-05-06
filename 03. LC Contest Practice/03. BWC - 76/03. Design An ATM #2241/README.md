# [**2241. Design an ATM Machine**](https://leetcode.com/problems/design-an-atm-machine/)



## My Approach : 
```java
class ATM {
    int denom[]={20,50,100,200,500};
    long bnc[];

    public ATM() {
        bnc=new long[5];
    }
    
    public void deposit(int[] bankNotesCount) { // bankNotesCount
        for(int i=0; i<5; i++) bnc[i]+=bankNotesCount[i]; // updating bnc with previous values
    }
    
    public int[] withdraw(int amount) {
        long ans[]=new long[5];
        int idx=4;
        while(idx>=0 && amount > 0){
            long takeThisMany = Math.min(amount/denom[idx], bnc[idx]); // Min(required, available)
            ans[idx]=takeThisMany;
            amount-=takeThisMany*denom[idx];
            idx--;
        }
        if(amount!=0) return new int[]{-1};
        
        for (int i = 0; i < 5; i++) bnc[i] -= ans[i]; // this update the bnc for next call
        return Arrays.stream(ans).mapToInt(e -> (int) e).toArray();
       
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
```