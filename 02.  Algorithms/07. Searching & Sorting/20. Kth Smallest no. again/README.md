# [**Kth Number Again**](https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/kth-smallest-number-again-2/)

[**Video Reference**](https://youtu.be/SvM5Y1PDiiA)
```java
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
       
        // Write your code here
        Scanner sc = new Scanner(System.in);
        ArrayList<Pair> arr=new ArrayList<>();
        int t=sc.nextInt();
        while(t != 0){
            int n=sc.nextInt();
            int q=sc.nextInt();
            for(int i=0;i<n;i++){
                long a=sc.nextInt();
                long b=sc.nextInt();
                arr.add(new Pair(a,b));
            }
            Collections.sort(arr); // this will sort the interval array Step 1
            // Merge the Interval Step 2
            int idx=0;
            for(int i=1;i<arr.size();i++){
                if(arr.get(idx).b >= arr.get(i).a){
                    arr.get(idx).b=(int)Math.max(arr.get(idx).b, arr.get(i).b);
                    arr.remove(i);
                    i--;
                }
                else{idx++; }
            }
            // search Step 3
            while(q != 0){
                int ans=-1;
                int k=sc.nextInt();
                for(int i=0;i<arr.size();i++){
                    if((int)(arr.get(i).b - arr.get(i).a + 1l) >= k){
                        ans=(int)arr.get(i).a + k - 1;
                        break;
                    }
                    else k = k-(int)(arr.get(i).b - arr.get(i).a + 1l);
                }
                System.out.println(ans);
                q--;
            }
            t--;
        }

    }
}
class Pair implements Comparable<Pair>{
    long a;
    long b;
    public Pair(long a, long b){
        this.a=a;
        this.b=b;
    }
    @Override
	public int compareTo(Pair o) {
		return (int)this.a-(int)o.a;
	}
}
```