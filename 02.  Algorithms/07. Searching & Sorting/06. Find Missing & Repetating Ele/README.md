# [**Find Missing And Repeating**](https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1#)
## **Method 1 (Use Sorting) Approach:-**
1. Sort the input array.
2. Traverse the array and check for missing and repeating.

- **Time Complexity: O(nLogn) SC- O(1)**
## **Method 2 (Use a extra DS like HashMap) Approach:-**
1. Traverse array and keep adding element if not present.
2. if present then it is a repetating element
3. Now again traverse from 1 to N in array if element is not present then that is a missing element.
- **Time Complexity: O(n) SC - O(n)**
## **Method 3 (Use count array) Approach:**


1. Create a temp array temp[] of size n+1 with all initial values as 0.
2. Traverse the input array arr[], and do following for each arr[i] 
3. if(temp[arr[i]] == 0) temp[arr[i]] = 1;
4. if(temp[arr[i]] == 1) output "arr[i]" //repeating
5. Traverse temp[] 1 to N and output the array element having value as 0 (This is the missing element)

- **Time Complexity: O(n) Auxiliary Space: O(n)**

# **MAIN THOUGHT PROCESS :-**
## Things to Notice :-
- element inside array will range from 1 to N.
- every element can be used as index after doing minus 1.
## **Method Best - (Use elements as Index and mark the visited places)**

1. Traverse the Input array and consider ```index = (int)Math.abs(arr[i]) ```
2. go to that index element mark it visited by making it -ve
3. now the one which is already marked -ve is the repetating element.
4. traverse the input array once more and if(arr[i]) is +ve than i+1 is a +ve element.
- **Time Complexity: O(n) Auxiliary Space: O(1)**
- **TCs to DRY RUN :- [4,3,1,6,1,2] N=6**
```java
class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int re=-1,me=-1; // repetating element and missing element.
        for(int i=0;i<n;i++){
            int index=(int)Math.abs(arr[i])-1;
            if(arr[index]<0){ re = index+1; continue; }
            arr[index]=-arr[index];
        }
        for(int i=0;i<n;i++){
            if(arr[i]>0){ me=i+1; break;}
        }
        return new int[]{re,me};
    }
}
```
