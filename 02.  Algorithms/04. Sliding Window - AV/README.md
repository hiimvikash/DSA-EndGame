[**<h1 align="center">Sliding Window - Aditya Verma</h1>**](https://youtube.com/playlist?list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj)

**<h1 align="center">Fixed Size Windows</h1>**
# **[1. Sliding Windows Need .](https://youtu.be/EHCGAZBbB88)**
[**GFG Article**](https://www.geeksforgeeks.org/window-sliding-technique/)
![sw1](https://user-images.githubusercontent.com/71629248/131081293-996a541a-c339-4545-b2f2-101187e3f9e1.png)
# **[2. Max Sum Subarray of size K .](https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1)**

## **[Video Reference](https://youtu.be/KtpqeN0Goro)**
```java
class Solution{
    static long maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
        // code here
        int s = 0;
        int e = 0;
        long sum = 0;
        long ans = -1;
        
        while(e<n){
            if(e < k){
                sum+=arr.get(e);
                e++;
            }
            else if(e>=k){
                ans = Math.max(ans,sum);
                sum += arr.get(e) - arr.get(s);
                s++;
                e++;
            }
        }
        ans = Math.max(ans,sum);
        return ans;
    }
}
```
```java
class Solution{
    static long maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
        // code here
        int s = 0, e = 0;
        
        long sum = 0, max = 0;
        while(e<n){
            if(e<k){
                sum+=arr.get(e);
                e++;
            }
            else {
                max = Math.max(sum, max);
                sum = sum - arr.get(s) + arr.get(e);
                s++; e++;
            }
        }
        max = Math.max(sum,max);
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
        Queue<Long> q=new LinkedList<>();
        
        int s = 0; 
        int e = 0;
        long[] ans = new long[n-k+1]; int idx = 0;
        while(e<n){
            if(e<k){
                if(arr[e] < 0) q.add(arr[e]); 
                e++;
            }
            else if(e>=k){
                if(!q.isEmpty()) ans[idx] = q.peek();
                idx++;
                
                if(!q.isEmpty() && arr[s] == q.peek()){
                    q.remove();
                }
                s++;
                
                if(arr[e] < 0) q.add(arr[e]); 
                e++;
            }
        }
        
        if(!q.isEmpty()) ans[idx] = q.peek();
        
        return ans;
    }
}
```
# **[4. Count Occurences of Anagrams GQ .](https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1)**
## **[Video Reference](https://youtu.be/MW4lJ8Y0xXk)**
# Intution
- HM which u make from pat think it as a AvailabilityList for window. i.e., in a window How Many distictcharacter can accomodate.
- say like in a window 3a's 1b can live. or else say in a window a has 3bed b has 1bed
- count denotes no.OfDistinct Character which can accomodate i.e count of Distinctcharacter who can stay in window
- so whenever u add a charcter in window then u occupy 1bed of that character if available so u do -1 from that character's beds.
- if beds of that character turnsout to be 0 after -1 then count--;
- let's say u r going to remove one character from that window that means bed of that character will increase by +1.
- if bed of that character is already 0 then u do count++
```java
class Solution {

    int search(String pat, String txt) {
        // code here
        HashMap<Character, Integer> hm=new HashMap<>();
        for(char c: pat.toCharArray()){
            if(!hm.containsKey(c)){
                hm.put(c,1);
            }
            else {
                hm.put(c, hm.get(c)+1);
            }
        }
        int count = hm.size();
        // HM made - here if -ve value says extra & +ve value says deficient 
        
        // if u look HM with txt then value says "Window k pass # ki kami hai orelse meh = hoejata"
        
        char ch[] = txt.toCharArray();
        
        int s = 0;
        int e = 0;
        int k = pat.length();
        int ans = 0;
        int n = ch.length;
        while(e<n){
            if(e<k){
                if(hm.containsKey(ch[e])){
                    hm.put(ch[e], hm.get(ch[e])-1);
                    if(hm.get(ch[e]) == 0) count--;
                }
                e++;
            }
            else {
                if(count == 0) ans++;
                
                // start slide means if someone going then +1
                if(hm.containsKey(ch[s])){
                    if(hm.get(ch[s]) == 0) count++;
                    hm.put(ch[s], hm.get(ch[s]) + 1);
                }
                s++;
                // end slide
                if(hm.containsKey(ch[e])){
                    hm.put(ch[e], hm.get(ch[e])-1);
                    if(hm.get(ch[e]) == 0) count--;
                }
                e++;
            }
        }
        if(count==0) ans++;
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
        int ans[]=new int[n-k+1]; int i=0;
        Deque<Integer> dq=new LinkedList<>();
        int s=0,e=0;
        
        while(e<n){
            if(dq.isEmpty()) dq.add(arr[e]);
            else{
                while(!dq.isEmpty() && arr[e]>dq.peekLast()) dq.removeLast();
                dq.add(arr[e]);
            }
            
            if(e-s+1 < k) e++;
            else if(e-s+1 == k){
                ans[i++]=dq.peek();
                s++; e++;
                // restoring
                if(!dq.isEmpty() && dq.peek()==arr[s-1]) dq.poll();
            }
        }
        return ans;
    }
}
```
[**<h1 align="center">Variable Size Window Feel</h1>**](https://youtu.be/cyu_nuW5utA)
# [**6. Largest Subarray of sum K**](https://youtu.be/TfQPoaRDeMQ)
**Note : This will work only for +VE Integer in array**
### Q. Will the discussed approach work with negative numbers in the array?
A. **No.** 
Because let's say in the given array [4,1,1,1,2,3,5] when we found the sum within the window to be greater than the desired value 5 (i=0, j=2 -> [4,1,1]), we started reducing the size of the window by doing i++. Here we assumed that once the sum of elements within the window becomes greater than 5 then increasing the window size will just add to the sum and hence we will not attain the sum 5 again. This is true when all the element are positive and hence reducing the window size by doing i++ makes sense. But this might not be true if array also contains negative numbers. Consider the array [4,1,1,-2,1,5], here we would have found the sum to be greater than 5 for i=0, j=2 and if we would have now started reducing the window size by doing i++, we would have missed the potential subarray (i=0, j=4).
In short, the discussed approach will not work with array having negative numbers.
```java
private static int lsa(int arr[],int n, int k) {
		int max=0,sum=0;
		int s=0,e=0;
		while(e<n) {
			sum+=arr[e];
			while(sum>k) {
				sum-=arr[s];
				s++;
			}
			if(sum==k) {
				max=Math.max(max,e-s+1);
			}
			e++;
		}
		return max;
}
```
## **[Problem Link](https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1)**
### **TCs- [8, -1, -1, -1, 9, -3, -1, 0, 10, -5] k=5**
## Hashmap Approach
```java
class Solution{
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int arr[], int n, int k) {
        //Complete the function
        HashMap<Integer,Integer> hm=new HashMap<>();
        int sum=0,max=0;
        hm.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(!hm.containsKey(sum)) hm.put(sum,i); // we may get the sum which is already present in HM so to always get the longest subarray we are not modifying 
            if(hm.containsKey(sum-k)){
                max=Math.max(max,i-hm.get(sum-k));
            }
        }
        return max;
    }
}
``` 
# **[7. General Format Of Fixed Size windows & Variable Size windows](https://youtu.be/LV-BgyeH8yo)**
![FsVS](https://user-images.githubusercontent.com/71629248/131221449-95aaea06-39bc-49df-9e2a-53a189c0d817.png)

# **[8. Longest substring with K unique characters](https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1)**
## **[Video Reference](https://youtu.be/Lav6St0W_pQ)**
```java
class Solution {
    public int longestkSubstr(String str, int k) {
        // code here
        int n=str.length();
        int s=0,e=0;
        int uc=0,ans=-1;
        HashMap<Character,Integer> hm=new HashMap<>();
        while(e<n){
            char ch=str.charAt(e);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            uc=hm.size();
            while(uc>k){
                ch=str.charAt(s);
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch)==0) hm.remove(ch);
                uc=hm.size();
                s++;
            }
            if(uc==k){
                ans=Math.max(ans,e-s+1);
            }
            e++;
        }
        return ans;
    }
}
```
or
```java
class Solution {
    public int longestkSubstr(String str, int k) {
        // code here
        int s = 0, e = 0, n = str.length();
        int ans = -1, l=0; // length of substring
        int uc = 0; // unique character
        HashMap<Character, Integer> hm=new HashMap<>();
        while(e<n){
            char c = str.charAt(e);
            hm.put(c, hm.getOrDefault(c,0)+1);
            uc = hm.size(); l++;
            
            if(uc > k){
                char sc = str.charAt(s);
                hm.put(sc, hm.get(sc)-1); l--;
                if(hm.get(sc)==0) hm.remove(sc);
                s++;
            }
            else if(uc==k){
                ans = Math.max(ans,l);
            }
            e++;
        }
        return ans;
    }
}
```
# **[9. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)**
## Can also be called **Longest substring with all unique character** i.e., WS==UC
## **[Video Reference](https://youtu.be/L6cffskouPQ)**
```java
class Solution {
    public int lengthOfLongestSubstring(String str) {
        int n=str.length();
        int s=0,e=0;
        int uc=0,ans=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        while(e<n){
            char ch=str.charAt(e);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            uc=hm.size();
            while(uc<(e-s+1)){
                ch=str.charAt(s);
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch)==0) hm.remove(ch);
                uc=hm.size();
                s++;
            }
            if(uc==(e-s+1)){
                ans=Math.max(ans,e-s+1);
            }
            e++;
        }
        return ans;
    }
}
```
or
```java
class Solution {
    public int lengthOfLongestSubstring(String str) {
        int s = 0, e = 0, n = str.length();
        int ans = 0, l=0; // length of substring
        int uc = 0; // unique character
        HashMap<Character, Integer> hm=new HashMap<>();
        while(e<n){
            char c = str.charAt(e);
            hm.put(c, hm.getOrDefault(c,0)+1);
            uc = hm.size(); l++;
            
            if(l > uc){
                char sc = str.charAt(s);
                hm.put(sc, hm.get(sc)-1); l--;
                if(hm.get(sc)==0) hm.remove(sc);
                s++;
            }
            else if(l==uc){
                ans = Math.max(ans,l);
            }
            e++;
        }
        return ans;
    }
}
```
# **[10. Pick Toys](https://www.lintcode.com/problem/longest-substring-with-at-most-two-distinct-characters/description)**

## **[Video Reference](https://youtu.be/seOKHXB_w74)**
```java
public int lengthOfLongestSubstringTwoDistinct(String str) {
        // Write your code here
        int n=str.length();
        int s=0,e=0;
        int uc=0,ans=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        while(e<n){
            char ch=str.charAt(e);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            uc=hm.size();
            while(uc>2){
                ch=str.charAt(s);
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch)==0) hm.remove(ch);
                uc=hm.size();
                s++;
            }
            if(uc==2 || uc<2){
                ans=Math.max(ans,e-s+1);
            }
            e++;
        }
        return ans;
}
```
# **[11. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)**

## **[Video Reference](https://youtu.be/iwv1llyN6mo)**
```java
class Solution {
    public String minWindow(String str, String t) {
        // Step 1 Make HM for String t
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int count=hm.size();
        // Step 2 Variable Sliding window Starts
        int s=0,e=0;
        int ans=Integer.MAX_VALUE,as=0,ae=0;
        int n=str.length();
        while(e<n){
            char ch=str.charAt(e);
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch)==0) count--;
            }
            while(count==0){
                if((e-s+1)<ans){
                    ans=e-s+1;
                    as=s;
                    ae=e;
                }
                ch=str.charAt(s);
                if(hm.containsKey(ch)){
                    hm.put(ch,hm.get(ch)+1);
                    if(hm.get(ch)>0) count++;
                }
                s++;
            }
            e++;
        }
        if(as==ae && s==0) return "";
        return str.substring(as,ae+1);
    }
}
```
