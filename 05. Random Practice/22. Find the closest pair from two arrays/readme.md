## [Find the closest pair from two arrays](https://practice.geeksforgeeks.org/problems/find-the-closest-pair-from-two-arrays4215/1)


### The Approach is :-
- put pointer ```i``` at 0th index of one array.
- put pointer ```j``` at last index of another array.
- implement 2 pointer now.  
```java
class Solution{
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        // code here
        int i = 0; // arrP
        int j = m-1; // brrP
        
        int minD = Integer.MAX_VALUE;
        int minP[] = new int[2]; // minimumPair
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<n && j>=0){
            if(arr[i] + brr[j] < x){
                if(Math.abs((arr[i] + brr[j]) - x) < minD){
                    minD = Math.abs((arr[i] + brr[j]) - x);
                    minP[0] = arr[i];
                    minP[1] = brr[j];
                }
                i++;
            }
            else if(arr[i] + brr[j] > x){
                if(Math.abs((arr[i] + brr[j]) - x) < minD){
                    minD = Math.abs((arr[i] + brr[j]) - x);
                    minP[0] = arr[i];
                    minP[1] = brr[j];
                }
                j--;
            }
            else{
                ans.add(arr[i]);
                ans.add(brr[j]);
                return ans;
            }
        }
        ans.add(minP[0]);
        ans.add(minP[1]);
        return ans;
    }
}
```