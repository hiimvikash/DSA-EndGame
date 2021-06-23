# **[Common elements in 3 sorted arrays](https://practice.geeksforgeeks.org/problems/common-elements1132/1#)**

# **My Intution :-**

- Make 3 crawler i, j, k for A[], B[], C[] initialize them to 0th index.
- Run a loop till any crawler crooses its boundry.
  - if A[i]=B[j]=C[k] add them in ArrayList
  - else find the smallest value in A[i], B[j], C[k] then increment crawler of it.

```java
class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3)
    {
        // code here
       // code here
        ArrayList<Integer> ans=new ArrayList<>();
        // crawler for 3 sorted arrays
        int i=0; int j=0; int k=0;
        while(i<n1 && j<n2 && k<n3){
            if((A[i]==B[j]) && (B[j]==C[k])){
                ans.add(A[i]); i++;j++;k++;
            }
            else{
                int small=smallest(A[i],B[j],C[k]);
                if(small==A[i] && small==B[j] ){i++;j++;}
                else if(small==B[j] && small==C[k] ){j++;k++;}
                else if(small==A[i] && small==C[k] ){i++;k++;}
                else if(small==A[i]) i++;
                else if(small==B[j]) j++;
                else k++;
            }
            // this to handle dublicate elements in array.
            while(i>0 && i<n1 && A[i]==A[i-1]) i++;
            while(j>0 && j<n2 && B[j]==B[j-1]) j++;
            while(k>0 && k<n3 && C[k]==C[k-1]) k++;
        }
        return ans;
    }
    int smallest(int a, int b, int c){
        if(a<=b && a<=c) return a;
        if(b<=a && b<=c) return b;
        return c;
    }

}
```
