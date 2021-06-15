# **[Merge Without Extra Space](https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays5135/1#)**

# **Approach 1 :** Using MergeSort Technique - TC= O(N+M) SC = O(1)

**Note:** This method is efficient AF but usefull only when your goal is to show output, this will be not accepted in gfg because gfg expect from you to modify arr1 and arr2 so that in MAIN() after merging both they give sorted array.

```java
class Solution {

    public void merge(int arr1[], int arr2[], int n, int m) {
        int i=0; int j=0;
	    while(i<n && j<m){
	       if(arr1[i]<arr2[j]){
	           System.out.print(arr1[i]+" ");
	           i++;
	       }
	       else if(arr2[j]<arr1[i]){
	         System.out.print(arr2[j]+" ");
	         j++;
	       }
	       else{
	           System.out.print(arr1[i]+" "+arr2[j]+" ");
	           i++;j++;
	       }
	   }
	   while(j<m){
	       System.out.print(arr2[j]+" ");
	       j++;
	   }
	   while(i<n){
	       System.out.print(arr1[i]+" ");
	       i++;
	   }
    }
}
```

# **Approach 2 :** Using Extra Space - TC= O(2N+2M) SC = O(N+M)

**Note:** This method is same as Approach 1 difference is, instead of printing we store in temp[] and then modify arr1 and arr2 by temp[] value.

```java
class Solution {

     public void merge(int arr1[], int arr2[], int n, int m) {
        int temp[]=new int[m+n]; int k=0;
        int i=0; int j=0;
	    while(i<n && j<m){
	       if(arr1[i]<arr2[j]){
	           temp[k++]=arr1[i];
	           i++;
	       }
	       else if(arr2[j]<arr1[i]){
	         temp[k++]=arr2[j];
	         j++;
	       }
	       else{
	           temp[k++]=arr1[i];
               temp[k++]=arr2[j];
	           i++;j++;
	       }
	   }
	   while(j<m){
	       temp[k++]=arr2[j];
	       j++;
	   }
	   while(i<n){
	       temp[k++]=arr1[i];
	       i++;
	   }
       // modifying arr1 and arr2
       int p=0;
       for(k=0; k < n+m; k++){
           if(k < n)
            arr1[k]=temp[k];
           else
            arr2[p++]=temp[k];
       }
    }
}
```

# **Approach 3 :** Insertion Sort Intution - TC= O(N X M) SC = O(1)

## Our Goal here is to modify arr1[] & arr2[] such that arr1[] contains **FIRST** N sorted elements and arr2[] contains next M sorted element i.e., continuation of arr1[] elements then only toh in main() arr1[] and arr2[] will be merged and it will still remain sorted.

## **The Intution is :-**

- As both arr1[] and arr2[] are sorted in itself so our main aim will be sort arr1[] with **FIRST** N sorted elements which will automatically fulfill our goal.
- We will itterate linearly in arr1[] and compare each element with arr2[0] and if(arr2[0] < arr[i]) we will swap them and then sort(arr2[]) i.e., we will place arr2[0] in its correct position.

- ## **Now WHY arr2[0] ?**
  - This is because our aim was to modify arr1[] with **FIRST** N sorted elements and as arr2[] will be sorted so smallest element will lie in 0th index.

```java
class Solution {

    public void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        for(int i=0;i<n;i++){
            if(arr2[0] < arr1[i]){
                swap(arr1,i,arr2); // swap arr1[i] with arr2[0]

                // remember arr2[1...n-1] is sorted
                int first=arr2[0];
                int k=0;
                for(k=1; k < m && arr2[k] < first; k++){
                    arr2[k-1]=arr2[k]; // here we are making suitable space for first by shifting elements towards left if they are smaller than first.
                }
                arr2[k-1]=first; // inserting first in its correct position
            }
        }
    }
    static void swap(int arr1[], int i, int arr2[]){
        int temp=arr2[0];
        arr2[0]=arr1[i];
        arr1[i]=temp;
    }
}
```

## [**Video Reference**](https://youtu.be/hVl2b3bLzBw)
