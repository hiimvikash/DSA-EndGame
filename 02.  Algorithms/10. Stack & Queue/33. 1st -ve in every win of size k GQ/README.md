# **[First negative integer in every window of size k](https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1#)**

```java
class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        int s=0,e=0;
        int i=0;
        long ans[]=new long[n-k+1]; // no. of windows of size k
        Queue<Long> q=new LinkedList<>();
        while(e<n){
            
            if(arr[e]<0) q.add(arr[e]);
            
            if(e-s+1 < k) e++; 
            else if(e-s+1 == k){
                if(!q.isEmpty()){
                    ans[i++]=q.peek(); 
                }
                else i++;
                s++; e++;
                if(!q.isEmpty() && arr[s-1]==q.peek()) q.poll();
            }
        }
        return ans;
    }
    q.clear();
}
```

[**Video reference**](https://youtu.be/uUXXEgK2Jh8)