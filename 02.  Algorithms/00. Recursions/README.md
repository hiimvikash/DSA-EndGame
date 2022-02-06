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
## isPalindrome String using recurssion.
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
```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int n=str.length();
        printSS(str,"",n);
    }

    public static void printSS(String str, String ans, int n) {
        if(n==0){
            System.out.println(ans);
            return;
        }
        ans = str.charAt(n-1)+ans; // pick
        printSS(str,ans,n-1);
        
        ans = ans.substring(1); // not pick
        printSS(str,ans,n-1);
    }
}
```
## Print all the subsequences whose sum are divisible by K.
```java
int k;
void fun(int ind, int arr[], int sum, ArrayList<Integer> al){
	if(ind==n){
        if(ans.size()!=0 && sum%k==0)
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
## approach 2
```java
class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        return is(arr,sum,0, N);
    }
    static boolean is(int arr[], int sum, int ind, int n){
        if(ind==n){
            if(sum==0){
                return true;
            }
            return false;
        }
        // pick
        if(sum>=arr[ind]){
            sum-=arr[ind];
           boolean l = is(arr,sum,ind+1,n);
           if(l) return true;
           sum+=arr[ind]; //not pick
        }
        // not pick
        
        return is(arr,sum,ind+1,n);
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
// Print the subsequence whose sum=k repetation allowed.
	    void fun(int arr[], int ind, int sum, ArrayList<Integer> ans){
	        if(ind==n){
	            if(sum==0){
	                print(ans); return;
	            }
	        }
	        
	        // pick
	        if(arr[ind]>=sum){
	           sum-=arr[ind];
	           ans.add(arr[ind]);
	           fun(arr,ind,sum,ans); // here we don't move to next Index instead "we pick it, till we make it."
	           sum+=arr[ind]; // not pick
	        }
	        fun(arr,ind+1,sum,ans); // we move to next index without picking ind.
	    }
```
 ## Count :-
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
## Print all the paths in Matrix to GO from (0,0) to (n-1,n-1).
```java
public void findPath(int i, int j, String s){
	if(i==n-1 && j==m-1){
		System.out.println(s);
		return;
	}

	// going Down
    if(i+1 < n){
		s=s+'D';
		findPath(i+1,j,s);
		s=s.substring(0,s.length()-1);
    }
	// going right
    if(j+1 < m){
		s=s+'R';
		findPath(i,j+1,s);
		s=s.substring(0,s.length()-1);
    }
}
```
## [Rat in a Maze - I](https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1)
**Note:** In a path, no cell can be visited more than one time
- Hint : Q is same as above only difference is 4 directions are allowed.
```java
class Solution {
    public static ArrayList<String> findPath(int[][] arr, int n) {
        // Your code here
        ArrayList<String> ans=new ArrayList<>();
        boolean vis[][]=new boolean[n][n];
        fun(arr,0,0,vis,"",ans,n);
        return ans;
    }
    static void fun(int arr[][],int i, int j, boolean vis[][], String s, ArrayList<String> ans,int n){
        if(i<0 || i>=n || j<0 || j>=n ||arr[i][j]==0||vis[i][j]) return;
        if(i==n-1 && j==n-1){
            ans.add(s);
            return;
        }
        
        vis[i][j]=true;
        
        // go down
        s=s+'D';
        fun(arr,i+1,j,vis,s,ans,n);
        s=s.substring(0,s.length()-1);
        
        // go left
        s=s+'L';
        fun(arr,i,j-1,vis,s,ans,n);
        s=s.substring(0,s.length()-1);
        // go right
        s=s+'R';
        fun(arr,i,j+1,vis,s,ans,n);
        s=s.substring(0,s.length()-1);
        
        // go up
        s=s+'U';
        fun(arr,i-1,j,vis,s,ans,n);
        s=s.substring(0,s.length()-1);
        
        
        vis[i][j]=false;
    }
}
```
## **Little Optimized**
```java
class Solution {
    public static ArrayList<String> findPath(int[][] arr, int n) {
        // Your code here
        ArrayList<String> ans=new ArrayList<>();
        boolean vis[][]=new boolean[n][n];
        
        Character dir[]={'D','L','R','U'};
        int di[]={1,0,0,-1};
        int dj[]={0,-1,1,0};
        fun(arr,0,0,vis,"",ans,n,dir,di,dj);
        return ans;
    }
    static void fun(int arr[][],int i, int j, boolean vis[][], String s, ArrayList<String> ans,int n, Character dir[], int di[], int dj[]){
        if(i<0 || i>=n || j<0 || j>=n ||arr[i][j]==0||vis[i][j]) return;
        if(i==n-1 && j==n-1){
            ans.add(s);
            return;
        }
        
        vis[i][j]=true;
        
        for(int k=0;k<4;k++){
            s=s+dir[k];
            fun(arr,i+di[k],j+dj[k],vis,s,ans,n,dir,di,dj);
            s=s.substring(0,s.length()-1);
        }
        
        
        vis[i][j]=false;
    }
}
```
## Count paths
```java
class Solution {
    public static int findPath(int[][] arr, int n) {
        // Your code here
        
        boolean vis[][]=new boolean[n][n];
        
        Character dir[]={'D','L','R','U'};
        int di[]={1,0,0,-1};
        int dj[]={0,-1,1,0};
        return fun(arr,0,0,vis,n,dir,di,dj);
        
    }
    int void fun(int arr[][],int i, int j, boolean vis[][], int n, Character dir[], int di[], int dj[]){
        if(i<0 || i>=n || j<0 || j>=n ||arr[i][j]==0||vis[i][j]) return 0;
        if(i==n-1 && j==n-1){
            return 1;
        }
        
        vis[i][j]=true;
        int cnt=0;
        for(int k=0;k<4;k++){
          cnt+=fun(arr,i+di[k],j+dj[k],vis,s,ans,n,dir,di,dj);
        }
        vis[i][j]=false;
        return cnt;
    }
}
```
# **[Lecture 4 :](https://youtu.be/r9af_mSpBLo)**
## Print only one subsequences whose sum is divisible by K.
```java
int k;
boolean fun(int ind, int arr[], int sum, ArrayList<Integer> al){
	if(ind==n){
        if(ans.size()!=0 && sum%k==0){
            print(al);
            return true;
        }
        else return false;
	}
	//pick
	al.add(arr[ind]);
	sum+=arr[ind];
	if(fun(ind+1,arr,sum,al)) return true;
	// not pick
	al.remove(al.size()-1);
	sum-=arr[ind];
	if(fun(ind+1,arr,sum,al)) return true;
}
```
## N Queens This will print only one valid Nqueen **1st basic Approach**
```java
boolean isSafe(int row, int col, int mat[][]){
    //up digonal i--,j--
            for(int i=row,j=col; i>=0 && j>=0; i--,j--){
                if(mat[i][j]==1) return false;
            }

            // left i,j--
            for(int i=row,j=col; i>=0 && j>=0; j--){
                if(mat[i][j]==1) return false;
            }

            // down digonal i++, j-- 
            for(int i=row,j=col; i<n && j>=0; i++,j--){
                if(mat[i][j]==1) return false;
            }

            return true;
}
boolean nQueens(int col, int mat[][]){
    if(col==n){
        print(mat);
        return true;
    }

    for(int row=0; row<n; row++){
        if(isSafe(row,col,mat)){
            mat[row][col]=1;
            if(nQueens(col+1,mat)) return true;
            mat[row][col]=0;
        }
    }
    return false;
}
```
## [N Queens - LC](https://leetcode.com/problems/n-queens/) **1st basic Approach**
```java
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        
        // Initializing char with '.'
        char mat[][]=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                mat[i][j]='.';
        nQueens(0,mat,ans,n);
        return ans;    
    }
    
    public int ind=-1;
    void nQueens(int col, char mat[][], List<List<String>> ans,int n){
        if(col==n){
            ind=ind+1;
            ans.add(new ArrayList<String>());
            
            for(int i=0;i<n;i++){
                String s="";
                for(int j=0;j<n;j++){
                     s=s+mat[i][j];
                }
                ans.get(ind).add(s);
                
            }
            return;
        }

        for(int row=0; row<n; row++){
            if(isSafe(row,col,mat,n)){
                mat[row][col]='Q';
                nQueens(col+1,mat,ans,n);
                mat[row][col]='.';
            }
        }
        
    }
        boolean isSafe(int row, int col, char mat[][],int n){
            
            //up digonal i--,j--
            for(int i=row,j=col; i>=0 && j>=0; i--,j--){
                if(mat[i][j]=='Q') return false;
            }

            // left i,j--
            for(int i=row,j=col; i>=0 && j>=0; j--){
                if(mat[i][j]=='Q') return false;
            }

            // down digonal i++, j-- 
            for(int i=row,j=col; i<n && j>=0; i++,j--){
                if(mat[i][j]=='Q') return false;
            }

            return true;
    }
}
```
## [N Queens - LC](https://leetcode.com/problems/n-queens/)  **Approach 2**
### - Here we have optimised isSafe() method instead of ittirating we made 3 arrays to hash left, upLeftDigonal, downLeftDigonal so TC of isSafe() boils down to O(1).
```java
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        // create hash for 3 directions.
            int l[]=new int[n]; // left
            int uld[]=new int[2*n-1]; // upLeftDigonal
            int dld[]=new int[2*n-1]; // downLeftDigonal
        // Initializing char with '.'
        char mat[][]=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                mat[i][j]='.';
        nQueens(0,mat,ans,n,l,uld,dld);
        return ans;    
    }
    
    public int ind=-1;
    void nQueens(int col, char mat[][], List<List<String>> ans,int n, int l[], int uld[], int dld[]){
        if(col==n){
            ind=ind+1;
            ans.add(new ArrayList<String>());
            
            for(int i=0;i<n;i++){
                String s="";
                for(int j=0;j<n;j++){
                     s=s+mat[i][j];
                }
                ans.get(ind).add(s);
                
            }
            return;
        }

        for(int row=0; row<n; row++){
            if(isSafe1(row,col,mat,n,l,uld,dld)){
                l[row]=1;
                dld[row+col]=1;
                uld[(n-1)+(row-col)]=1;
                mat[row][col]='Q';
                nQueens(col+1,mat,ans,n,l,uld,dld);
                mat[row][col]='.';
                l[row]=0;
                dld[row+col]=0;
                uld[(n-1)+(row-col)]=0;
            }
        }
        
    }
        boolean isSafe1(int row, int col, char mat[][],int n,int l[], int uld[], int dld[]){
            if(l[row]==1 || dld[row+col]==1 || uld[(n-1)+(row-col)]==1) return false;
            return true;
    }
}
```
## [N Queens II - LC](https://leetcode.com/problems/n-queens-ii/)
```java
class Solution {
    public int totalNQueens(int n) {
        // Initializing char with '.'
        char mat[][]=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                mat[i][j]='.';
        return nQueens(0,mat,n);
    }
    
    int nQueens(int col, char mat[][],int n){
        if(col==n){
            return 1;
        }
        int cnt=0;
        for(int row=0; row<n; row++){
            if(isSafe(row,col,mat,n)){
                mat[row][col]='Q';
                cnt+=nQueens(col+1,mat,n);
                mat[row][col]='.';
            }
        }
        return cnt;
    }
        
    
    boolean isSafe(int row, int col, char mat[][],int n){
            
            //up digonal i--,j--
            for(int i=row,j=col; i>=0 && j>=0; i--,j--){
                if(mat[i][j]=='Q') return false;
            }

            // left i,j--
            for(int i=row,j=col; i>=0 && j>=0; j--){
                if(mat[i][j]=='Q') return false;
            }

            // down digonal i++, j-- 
            for(int i=row,j=col; i<n && j>=0; i++,j--){
                if(mat[i][j]=='Q') return false;
            }
            return true;
    }
}
```
