[**<h1 align="center">Sliding Window - Aditya Verma</h1>**](https://youtube.com/playlist?list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj)


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