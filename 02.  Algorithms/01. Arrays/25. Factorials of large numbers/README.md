# **[Factorials of large numbers](https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1#)**

```java
class Solution {
    static ArrayList<Integer> factorial(int N){
        //code here
        ArrayList<Integer> res=new ArrayList<>();
        res.add(1);
        for(int i=2;i<=N;i++){
            multiply(res,i);
        }
        // reversing ArrayList
        int start=0, end=res.size()-1;
        while(start<end){
            swap(res,start,end);
            start++;end--;
        }
        return res;
    }
    private static void multiply(ArrayList<Integer> res,int x){
        int carry=0;
        for(int i=0;i<res.size();i++){
            int prod=res.get(i)*x+carry;
            res.set(i,prod%10);
            carry=prod/10;
        }
        while(carry!=0){
            res.add(carry%10);
            carry/=10;
        }
    }
    private static void swap(ArrayList<Integer> res,int start,int end){
        int temp=res.get(start);
        res.set(start,res.get(end));
        res.set(end,temp);
    }
}
```

## **[Video Reference](https://youtu.be/LCDSigIDqnw)**
