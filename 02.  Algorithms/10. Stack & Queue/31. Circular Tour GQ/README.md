# **[Circular tour](https://practice.geeksforgeeks.org/problems/circular-tour/1#)**

```java
class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int p[], int d[])
    {
	// Your code here	
	    int n=p.length;
        int start=0;
        int ef=0; int rf=0; // extraFuel, requiredFuel
        for(int i=0; i<n; i++){
            ef+=p[i]-d[i];
            if(ef<0){
                start=i+1;
                rf+=ef;
                ef=0;
            }
        }
        if(ef+rf>=0) return start;
        return -1;
	    
    }
}
```
[**Video reference**](https://youtu.be/7WYwqvOSaa8)