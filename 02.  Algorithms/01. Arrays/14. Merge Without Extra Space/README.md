# **[Merge Without Extra Space](https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays5135/1#)**

# **Approach 1 :** Using MergeSort Technique - TC = O(N+M) SC = O(1)

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

# **Approach 2 :** Using Extra Space - TC = O(2N+2M) SC = O(N+M)

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

# **Approach 3 :** Insertion Sort Intution - TC = O(N X M) SC = O(1)

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

# **Approach 4 :** Gap Method - TC = O( (N+M)log(N+M) ) SC = O(1)

```java
class Solution {

    public void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        int gap=nextGap(n+m);
        while(gap > 0){
            int i=0; int j=gap; // crawler

            // 1st array comparison
            while(j < n){
                if(arr1[j] < arr1[i]){
                    swapSingle(arr1,i,j);
                }
                i++;j++;
            }

            // reinitializing j to point arr2[] as it has overpass its itteration in arr1[]
            if(j==n) j=0;
            else if(j>n) j=j-n;

            // both array comparison
            while(j < m && i < n){ // both array comparison is possible when i lie in arr1[] and j lie in arr2[]
                if(arr2[j] < arr1[i]){
                    swapBoth(arr1,arr2,i,j);
                }
                i++;j++;
            }

            // 2nd array comparison
            if(i==n && j<m){
                i=0;// for arr2
                while(j < m){
                    if(arr2[j] < arr2[i]){
                        swapSingle(arr2,i,j);
                    }
                    i++;j++;
                }
            }
            gap=nextGap(gap);
        }
    }
    int nextGap(int gap){
        if(gap<=1) return 0;
        return (int)Math.ceil(gap/2.0);
    }
    void swapSingle(int arr[], int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    void swapBoth(int arr1[], int arr2[], int i, int j){
        int temp=arr1[i];
        arr1[i]=arr2[j];
        arr2[j]=temp;
    }
}
```

## [**Video Reference**](https://youtu.be/hVl2b3bLzBw)

# **Approach 5 :** Injection Method - TC = O(N+M) SC = O(1) only works with +ve elements

DRY RUN :- arr1[] = {1, 4, 7, 8, 10} arr2[] = {2, 3, 9}

```java
public static void merge(int arr1[], int arr2[], int n, int m) {
        // code here
         int mx = 0;

    // Find maximum element of both array
    for(int i = 0; i < n; i++)
    {
        mx = Math.max(mx, arr1[i]);
    }

    for(int i = 0; i < m; i++)
    {
        mx = Math.max(mx, arr2[i]);
    }

    // Increment one two avoid collision of
    // 0 and maximum element of array in
    // modulo operation
    mx++;
    int i = 0, j = 0, k = 0; // crawler

    while (i < n && j < m)
    {

        // extracting original element
        int e1 = arr1[i] % mx;
        int e2 = arr2[j] % mx;

        if (e1 <= e2)
        {

            //injecting e1
            if (k < n)
                arr1[k] += (e1 * mx);
            else
                arr2[k - n] += (e1 * mx);

            i++;
            k++;
        }
        else
        {

            // injecting e2
            if (k < n)
                arr1[k] += (e2 * mx);
            else
                arr2[k - n] += (e2 * mx);

            j++;
            k++;
        }
    }

    // Process those elements which are
    // left in arr1[]
    while (i < n)
    {
        int el = arr1[i] % mx;
        if (k < n)
            arr1[k] += (el * mx);
        else
            arr2[k - n] += (el * mx);

        i++;
        k++;
    }

    // Process those elements which are
    // left in array arr2[]
    while (j < m)
    {
        int el = arr2[j] % mx;

        if (k < n)
            arr2[k] += (el * mx);
        else
            arr2[k - n] += (el * mx);

        j++;
        k++;
    }

    // Finally update elements by dividing
    // with maximum element this will give you the injected element.
    for(int in = 0; in < n; in++)
        arr1[in] = arr1[in] / mx;

    // Finally update elements by dividing
    // with maximum element this will give you the injected element.
    for(int in = 0; in < m; in++)
        arr2[in] = arr2[in] / mx;
}
```
# Dry Run :-
**Note :-** Try to see each step without arrows, except previous injections. 
![Injection Method_1](https://user-images.githubusercontent.com/71629248/122254190-80974b00-ceea-11eb-9e92-f8423ea9ccdf.jpg)
