# **[Sum of minimum and maximum elements of all subarrays of size k.](https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/)**

```java
public int SumOfKsubArray(int[] arr, int k) {
        int n=arr.length;
        Deque<Integer> maxdq=new LinkedList<>();
        Deque<Integer> mindq=new LinkedList<>();
        int s=0,e=k-1;
        int ans=0;
        
        // making Initial answer
            for(int i=s;i<=e;i++){
                if(maxdq.isEmpty()) maxdq.add(arr[i]);
                else{    
                    while(!maxdq.isEmpty() && arr[i]>maxdq.peekLast()) maxdq.removeLast();
                    maxdq.add(arr[i]);
                }
                if(mindq.isEmpty()) mindq.add(arr[i]);
                else{
                    while(!mindq.isEmpty() && arr[i]<mindq.peekLast()) mindq.removeLast();
                    mindq.add(arr[i]);
                }
            }
            ans=maxdq.peek()+mindq.peek();
        // restoring
            if(!maxdq.isEmpty() && maxdq.peek()==arr[s]) maxdq.pop();
            if(!mindq.isEmpty() && mindq.peek()==arr[s]) mindq.pop();
        
        // sliding window start
            s++;e++;
        while(e<n){
            if(maxdq.isEmpty()) maxdq.add(arr[e]);
            else{    
                while(!maxdq.isEmpty() && arr[e]>maxdq.peekLast()) maxdq.removeLast();
                maxdq.add(arr[e]);
            }
            
            ans+=maxdq.peek();
            
            if(mindq.isEmpty()) mindq.add(arr[e]);
            else{
                while(!mindq.isEmpty() && arr[e]<mindq.peekLast()) mindq.removeLast();
                mindq.add(arr[e]);
            }
            
            ans+=mindq.peek();
            
            // restoring
            if(!maxdq.isEmpty() && maxdq.peek()==arr[s]) maxdq.pop();
            if(!mindq.isEmpty() && mindq.peek()==arr[s]) mindq.pop();
            s++; e++;
        }
        return ans;
    }
```

