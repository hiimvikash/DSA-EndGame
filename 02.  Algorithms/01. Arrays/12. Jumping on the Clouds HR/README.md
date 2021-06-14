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

# **[Jumping on the Clouds : Revisited](https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem)**

```java
public static int jumpingOnClouds(int c[],int k)
    {
        int currentC=0;
        int e=100;
        int len=c.length;
        // one jump is necessary for initial push that's why DO While loop.
        do{
            currentC=(currentC+k)%len;
            e--;
            if(c[currentC]==1)
                e-=2;
        }while(currentC!=0);
        return e;
    }
```
