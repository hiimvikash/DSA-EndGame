# **[Sum of minimum and maximum elements of all subarrays of size k.](https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/)**

```java
class Solution {
    public int SumOfKsubArray(int[] arr, int k) {
        int n=arr.length;
        int ans=0;
        
        Deque<Integer> maxdq=new LinkedList<>();
        Deque<Integer> mindq=new LinkedList<>();
        
        int s=0,e=0;
        
        while(e<n){
            if(maxdq.isEmpty()) maxdq.add(arr[e]);
            else{
                while(!maxdq.isEmpty() && arr[e]>maxdq.peekLast()) maxdq.removeLast();
                maxdq.add(arr[e]);
            }
            
            if(mindq.isEmpty()) mindq.add(arr[e]);
            else{
                while(!mindq.isEmpty() && arr[e]<mindq.peekLast()) mindq.removeLast();
                mindq.add(arr[e]);
            }
            
            if(e-s+1 < k){
                e++;
            }
            else{
                ans+=mindq.peek()+maxdq.peek();
                s++; e++;
                
                if(!maxdq.isEmpty() && maxdq.peek()==arr[s-1]) maxdq.poll();
                if(!mindq.isEmpty() && mindq.peek()==arr[s-1]) mindq.poll();
            }
        }
        return ans;
        
    }
}
```

