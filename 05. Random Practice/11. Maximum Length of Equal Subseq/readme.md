You are given array of length N, u need to replace ```arr[i] with arr[i] + x``` **one time only** where x lies btw [-k, k] such that resulting arrays gives **maximum length subsequence having equal element.**
- Example : 
    - [4, 7, 3, 8] k = 2 
    - output = **3** because after performing operation - {+2, -1, +0, -2} array would look like : {6, 6, 3, 6}
    - Explanation :- 
        - 4 can be converted to {2, 3, 4, 5, **6**}
        - 7 can be converted to {5, **6**, 7, 8, 9}
        - 3 can be converted to {1, 2, 3, 4, 5}
        - 8 can be converted to {**6**, 7, 8, 9, 10}


```java
public static void main(String[] args) {
        int arr[] = {4, 7, 3, 8};
        int n = arr.length;
        System.out.println("Maximum Length Equal Subseq = "+equalSubseqCount(arr, n, 2));
    }
    
    private static int equalSubseqCount(int arr[], int n, int k){
        int h = Integer.MIN_VALUE;
        int l = Integer.MAX_VALUE;
        for(int ele : arr){
            l = Math.min(ele, l);
            h = Math.max(ele, h);
        }
        l-=k;
        h+=k;
        
        int darr[] = new int[h+1];
        for(int i = 0; i<n; i++){
            int lr = arr[i] - k;
            int rr = arr[i] + k;
            
            darr[lr]+=1;
            if(rr < h)darr[rr+1]-=1;
        }
        
        int max = darr[l];
        for(int i = l+1; i<=h; i++){
            darr[i] = darr[i] + darr[i-1];
            max = Math.max(darr[i], max);
        }
        
        ArrayList<Integer> eleMakingSubs=new ArrayList<>();
        for(int i = l; i<=h; i++){
            if(darr[i] == max) eleMakingSubs.add(i);
        }
        System.out.println();
        System.out.println(eleMakingSubs);
        return max;
    }
```