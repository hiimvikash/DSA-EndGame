# [Fractional Knapsack](https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1)

```java
/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item a[], int n) 
    {
        Iteminfo arr[]=new Iteminfo[n];
        for(int i=0; i<n; i++){
            arr[i] = new Iteminfo(a[i].weight, a[i].value);
        }
        // Comparator<Iteminfo> des = (x,y)-> (x.c < y.c) ? 1 : -1;
        // Arrays.sort(arr,des);
        
        // Arrays.sort(arr, new Comparator<Iteminfo>() {
            
        //     public int compare(Iteminfo o1, Iteminfo o2)
        //     {
        //         if(o2.c > o1.c) return 1;
        //         return -1;
        //     }
        // });
        
        Arrays.sort(arr, new SortAccToRatio());
        
        double ans = 0.0;
        for(int i=0; i<n; i++){
            if(arr[i].w <= W){
                ans +=arr[i].c*arr[i].w;
                W-=arr[i].w;
            }
            else{
                ans+= W*arr[i].c;
                W = 0;
            }
        }
        return ans;
    }
}
class Iteminfo{
    int w; int v; Double c;
    public Iteminfo(int w, int v){
        this.w=w; this.v=v; 
        c = new Double((double)v/(double)w);
    }
}

class SortAccToRatio implements Comparator<Iteminfo> {
    public int compare(Iteminfo o1, Iteminfo o2)
    {
        if(o2.c > o1.c) return 1;
        return -1;
    }
}
```