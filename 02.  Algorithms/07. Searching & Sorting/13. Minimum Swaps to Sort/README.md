# [**Minimum Swaps to Sort**](https://practice.geeksforgeeks.org/problems/minimum-swaps/1#)
- [**Video Reference**](https://youtu.be/m-8_yQao-lI)
```java
class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int arr[])
    {
        // Code here
        int n=arr.length;
        Pair arr1[]=new Pair[n];
        for(int i=0;i<n;i++){
            arr1[i]=new Pair(arr[i],i);
        }
        Arrays.sort(arr1);
        int ans=0;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i] || arr1[i].ind==i) continue;
            int j=i;
            int clen=0;
            while(!vis[j]){
                vis[j]=true;
                clen++;
                j=arr1[j].ind;
            }
            ans+=(clen-1);
        }
        return ans;
    }
}
class Pair implements Comparable<Pair>{
    int val;
    int ind;
    public Pair(int val, int ind){
        this.val=val;
        this.ind=ind;
    }
    @Override
    public int compareTo(Pair o){
        return this.val-o.val;
    }
}
```
