# **[Recurrsion - Master's Notes.](https://www.youtube.com/playlist?list=PLN4aKSfpk8TR-A59O9qR2VL0wqt3LrrnK)**

# **[Lecture 1 :](https://youtu.be/cHMr5-0SDAA)**
## Reverse Array using recurssion
```java
public static void main(String[] args) {
		int arr[]= {1,3,5,6,7,12,15};
		int n=arr.length;
		reverseArr(arr,0,n-1);
		System.out.println(Arrays.toString(arr));
}
	static void reverseArr(int arr[],int s,int e) {
		if(s>=e) return;
		int temp=arr[s];
		arr[s]=arr[e];
		arr[e]=temp;
		reverseArr(arr,++s,--e);
	}
```
## isPalindrome String using recurssion
```java
public static void main(String[] args) {
		String str="madam";
		int l=str.length();
		
		System.out.println(isPalindrome(str,0,l-1));
	}
	static boolean isPalindrome(String str,int s,int e) {
		if(s>e) return true;
		if(str.charAt(s)==str.charAt(e)) {
			return isPalindrome(str,++s,--e);
		}
		else return false;
	}
```
## BS using recurrsion
```java
static boolean bs(int arr[],int s,int e, int x) {
		if(s<=e) {
			int mid=(s+e)/2;
			int midV=arr[mid];
			if(x==midV) return true;
			else if(x>midV) return bs(arr,mid+1,e,x);
			else if(x<midV) return bs(arr,s,mid-1,x);
		}
		return false;
}
```
# Bonus Videos : 
## 1.  **[Recursion & PMI relation by CN](https://youtu.be/MaAzewn3An8)**
## 2.  **[fibonacci by CN](https://youtu.be/4092LBz_BHQ)**
# **[Lecture 2 :](https://youtu.be/QbDAWmuOn5Y)**
## [Print all subsequence in string](https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-subsequence-official/ojquestion)
```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        fun(0,s,"",s.length());
    }

    public static void fun(int ind, String s, String ans, int n) {
        if(ind==n){
            System.out.println(ans);
            return;
        }
        // pick
        ans=ans+s.charAt(ind);
        fun(ind+1, s, ans, n);
        // not pick
        ans=ans.substring(0,ans.length()-1);
        fun(ind+1, s, ans, n);
    }

}
```
## Print all the subsequences whose sum are divisible by K.
```java
int k;
void fun(int ind, int arr[], int sum, ArrayList<Integer> al){
	if(ind==n && ans.size()!=0 && sum%k==0){
		print(al);
		return;
	}
	//pick
	al.add(arr[ind]);
	sum+=arr[ind];
	fun(ind+1,arr,sum,al);
	// not pick
	al.remove(al.size()-1);
	sum-=arr[ind];
	fun(ind+1,arr,sum,al);
}
```
## WAF which returns Count of all the subsequences whose sum are divisible by K.
**Note: You can't declare globally nor internally a count variable and use it as a counter.**
- **Example :** arr[]={3,6} k=3 ans=3(3 - 6 - 3,6)
```java
int k;
int fun(int ind, int arr[], int sum){
	if(ind==n){
		if(sum%k==0)
			return 1;
		else return 0;	
	}
	//pick
	sum+=arr[ind];
	left=fun(ind+1,arr,sum,al);
	// not pick
	sum-=arr[ind];
	right= fun(ind+1,arr,sum,al);
	return left+right;
}
ans=fun(0,arr,0)-1; // coz to avoid empty set
```
## [Subset sum problem](https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/#)
```java
class Solution{
	static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        if(fun(arr,0,0,sum,N)==1) return true;
        return false;
    }
    static int fun(int arr[],int ind,int sum,int target, int n){
        if(ind==n){
            if(sum==target)
                return 1;
            else return 0;
        }
        
        int l=0;
		//pick
        if(arr[ind]<=target) {
			sum+=arr[ind];
			l=fun(arr,ind+1,sum,target,n);
			//not pick
			sum-=arr[ind];
        }
        int r=fun(arr,ind+1,sum,target,n);

        if(l==0 && r==0) return 0;
        else return 1;
    }
}
```
## WAF which counts all the subset with sum=k.
```java
static int fun(int arr[],int ind,int target, int n){
		if(ind==n){
            if(target==0)
                return 1;
            else return 0;
        }
        int l=0;
		int r=0;
        // pick
        if(arr[ind]<=target) {
        	target-=arr[ind];
        	l=fun(arr,ind+1,target,n);
	        //not pick
	        target+=arr[ind];
        }
        r=fun(arr,ind+1,target,n);
        return l+r;
}
```
# **[Lecture 3 :](https://youtu.be/uisK9EJQcaY)**
## Print the subsequence whose sum=k repetation allowed.
- **For Examples:** arr={1,2,3} s=4
	- {1,1,1,1}, {1,3}, {1,1,2}, {2,2}.
- **Hint:** when you pick we don't go to next Index.	

```java
static int fun(int arr[],int ind,int target, int n){
		if(ind==n){
            if(target==0)
                return 1;
            else return 0;
        }
        int l=0;
		int r=0;
        // pick
        if(arr[ind]<=target) {
        	target-=arr[ind];
        	l=fun(arr,ind,target,n);
	        //not pick
	        target+=arr[ind];
        }
		// not pick means move to next Index
        r=fun(arr,ind+1,target,n);
        return l+r;
}
```

