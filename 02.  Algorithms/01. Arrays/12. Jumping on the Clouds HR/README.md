# **[Jumping on the Clouds](https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem)**

```java
static int jumpingOnClouds(int arr[],int n){
        int jump=0;
        int i=0;
        while(i<n-1){ // as soon as i is n-1, means we have reached end so we break and return jump.
            if(arr[i]==0){
                // ATQ if we are in 0 we can atmost go to +1 or +2 index from there, so as our preference would be to reach end with minimum jump so we check for i+2 before.
                if(i<n-2 && arr[i+2]==0)// if not i<n-2 then ArrayIndexOutOfBound
                    i=i+2;
                else
                    i+=1;
                jump++; // this will happen always because its guaranteed in Q that game will end.
            }
        }
        return jump;
}
```
