[**<h1 align="center">Sliding Window - Aditya Verma</h1>**](https://youtube.com/playlist?list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj)

**<h1 align="center">Fixed Size Windows</h1>**
# **[1. Sliding Windows Need .](https://youtu.be/EHCGAZBbB88)**
[**GFG Article**](https://www.geeksforgeeks.org/window-sliding-technique/)
![sw1](https://user-images.githubusercontent.com/71629248/131081293-996a541a-c339-4545-b2f2-101187e3f9e1.png)
# **[2. Max Sum Subarray of size K .](https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1)**

## **[Video Reference](https://youtu.be/KtpqeN0Goro)**
```java
class Solution{
    static int maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
        // code here
        int sum=0;
        int s=0,e=k-1;
        for(int i=s;i<=e;i++)
            sum+=arr.get(i);
        int max=sum;
        s++;
        e++;
        while(e<n){
            sum=sum-arr.get(s-1)+arr.get(e);
            max=Math.max(sum,max);
            s++;
            e++;
        }
        return max;
    }
}
```
## Note : Total Number of possible windows of size K in an Array os size N is **N-K+1**
# **[3. First negative integer in every window of size k .](https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1#)**
## **[Video Reference](https://youtu.be/uUXXEgK2Jh8)**
## Approach 1 - Nested Loop
```java
class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        long ans[]=new long[n-k+1]; // size of ans[] = number of possible windows
        int s=0,e=k-1;
        int j=0;
        boolean flag=false;
        while(e<n){
            for(int i=s;i<=e;i++){
                flag=false;
                if(arr[i]<0){
                    ans[j++]=arr[i]; flag=true;
                    break;
                }
            }
            if(!flag) j++; // this will automaticaly add 0
            s++;
            e++;
        }
        return ans;
    }
}
```
## Approach 2 - Using Q
- Step 1 : Create a Initial Answer means for 1st Window
- Step 2 : Make everything ready for next coming window
- Step 3 : Inside loop calculate ans for that window than s++; e++.
```java
class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        long ans[]=new long[n-k+1]; // size of ans[] = number of possible windows
        Queue<Long> q=new LinkedList<>();
        
        int s=0,e=k-1;
        int j=0;
        for(int i=s;i<=e;i++){
            if(arr[i]<0) q.add(arr[i]);
        }
        if(!q.isEmpty()){
            ans[j++]=q.peek();
            if(arr[s]==q.peek()) q.poll();
        }
        else ans[j++]=0;
        
        s++; e++;
        while(e<n){
            if(arr[e]<0) q.add(arr[e]);
            if(!q.isEmpty()){
                ans[j++]=q.peek();
                if(arr[s]==q.peek()) q.poll();
            }
            else ans[j++]=0;
            s++; e++;
        }
        q.clear();
        return ans;
    }
}
```
# **[4. Count Occurences of Anagrams GQ .](https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1)**
## **[Video Reference](https://youtu.be/MW4lJ8Y0xXk)**
```java
class Solution {

    int search(String pat, String str) {
        // code here
        int k=pat.length(); // window size
        int s=0,e=k-1;
        int ans=0;
        // making HM for pat
            HashMap<Character,Integer> hm=new HashMap<>();
            for(int i=0;i<k;i++){
                char ch=pat.charAt(i);
                if(hm.containsKey(ch)){
                    hm.put(ch,hm.get(ch)+1);
                }
                else hm.put(ch,1);
            }
            int count = hm.size();
        // making HM for pat ENDS
        
        // Initial ANS Making Starts
            for(int i=s;i<=e;i++){
                char ch=str.charAt(i);
                if(hm.containsKey(ch)){
                    hm.put(ch,hm.get(ch)-1);
                    if(hm.get(ch)==0)count--;
                }
            }
            if(count==0) ans++;
        // restoring Starts
            char ch=str.charAt(s);
            if(hm.containsKey(ch)){
                if(hm.get(ch)==0)count++;
                hm.put(ch,hm.get(ch)+1);
            }
            
            // sliding window start
            s++;e++;
            while(e<str.length()){
                ch=str.charAt(e);
                if(hm.containsKey(ch)){
                    hm.put(ch,hm.get(ch)-1);
                    if(hm.get(ch)==0)count--;
                }
                if(count==0) ans++;
                // restoring Starts
                ch=str.charAt(s);
                if(hm.containsKey(ch)){
                    if(hm.get(ch)==0)count++;
                    hm.put(ch,hm.get(ch)+1);
                }
                s++; e++;
            }
             return ans;   
    }
    
}
```
# **[5. Sliding Window Maximum LC-239 .](https://leetcode.com/problems/sliding-window-maximum/)**
## **[Video Reference](https://youtu.be/xFJXtB5vSmM)**
TCs - [13, 7, 12, 6, 5, 3, 6, 7]
```java
class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n=arr.length;
        Deque<Integer> dq=new LinkedList<>();
        int s=0,e=k-1;
        int ans[]=new int[n-k+1]; int j=0;
        
        // making Initial answer
            for(int i=s;i<=e;i++){
                if(dq.isEmpty())
                    dq.add(arr[i]);
                else{    
                    while(!dq.isEmpty() && arr[i]>dq.peekLast()){
                        dq.removeLast();
                    }
                    dq.add(arr[i]);
                }
            }
            ans[j++]=dq.peek();
        // restoring
            if(!dq.isEmpty() && dq.peek()==arr[s]) dq.pop();
        
        // sliding window start
            s++;e++;
        while(e<n){
            if(dq.isEmpty())
                dq.add(arr[e]);
            else{    
                while(!dq.isEmpty() &&arr[e]>dq.peekLast()){
                    dq.removeLast();
                }
                dq.add(arr[e]);
            }
            ans[j++]=dq.peek();
            // restoring
            if(!dq.isEmpty() && dq.peek()==arr[s]) dq.pop();
            s++; e++;
        }
        return ans;
    }
}
```
**<h1 align="center">Variable Size Windows</h1>**