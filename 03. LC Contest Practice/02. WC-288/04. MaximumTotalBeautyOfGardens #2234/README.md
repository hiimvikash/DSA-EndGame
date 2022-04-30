# [**2234. Maximum Total Beauty of the Gardens**](https://leetcode.com/problems/maximum-total-beauty-of-the-gardens/)

## [**Video reference for understanding only**](https://youtu.be/6QunjBjrJ_Y)
## Approach : 

```
the idea is to sort the array first (why?...it'll be clear as you go through the below explanation)

	the beauty value (which we have to optimize) depends on two things
		- full*(# of complete gardens) [value 1]
		- partial *(minimum value of all the partial gardens) [value 2]

	when we have to different things which our answer depends on, then it is better to fix on of them
	and vary the other

	here we will fix the first guy (full *(# of complete gardens))

	basically what we are trying to do is:
	first fix #of complete gardens to 1, and find the optimal value of the second value [partial *(minimum value of all the partial gardens)]
	then fix #of complete gardens to 2, and find the optimal value of the second value  [partial *(minimum value of all the partial gardens)]

	so in general fix #of complete gardens to x [by distributing some flowers to some gardens in some fashion (which we'll see in a while)],
	and for the remaining n - x gardens, distribute some/all of the remaining flowers in such a fashion such that  the minimum of all the remaining (incomplete)
	gardens in maximum

	and keep doing this
	now the first question arises : which x gardens should i chose to make full?
									A very intuitive answer would be to chose those x gardens which contain maximum number of flowers
									(so that we have to use minimum number of flowers, and can be left with more options for the second step)

									Now at each step we are chosing x largest values from the array (x :[1...N])
									so it means that we will sort the array and traverse from the back

									at i, we would have made all the gardens from [n - 1 to i] complete by adding the required number of flowers to each of them

	now the second step : how do we maximise the minimum value of all the partial / incomplete gardens?
						  we know that the range this value (minimum value of all the partial / incomplete gardens)
						  may lie in is [0, taret - 1]
						  that's where binary search comes into the picture

						  for a given value in this range (mid), we will see if it is possible to
						  somehow make the minimum value of this part of the array equal to mid?
						  if it is, then we have a candidate for this, and move ahead to find a larger value

						  if it is not, then we'll be forced to look for a smaller value
						  what we are doing here is, we find the first element greater than mid in the array (in the part before i) [let it's index be idx]
						  and we will make all the elements coming before this equal to mid

						  the number of flowers required to achive this will be mid*idx - sum[0..idx - 1] (quite easy to calculate)
```

```java
class Solution {
    public long maximumBeauty(int[] flw, long nf, int target, int full, int partial) {
        long n = flw.length;
        Arrays.sort(flw);
        
        // find prefixSum
        long ps[]=new long[(int)n];
        ps[0] = flw[0];
        for(int i=1; i<n; i++) ps[i] = ps[i-1] + flw[i];
        
        
        
        long ans = 0;
        
        for(int i=(int)n; i>=0; i--){ // i=n means full garden is considered to be incomplete, i=n-1 means last garden is complete & remaing flower needed is calculated, i=n-2 means last 2 gardens are complete & remaing flower needed is calculated.
            
            if(i<n){
                int toAdd = Math.max(0,target - flw[i]);
                if(toAdd > nf) break;
                nf-=toAdd;
            }
            
            long cfb = (long)((n-i) * full); // currentFullBeauty
            long cpb = 0; // currentPartialBeauty
            
            long low = 0; long high = target-1;
            while(low<=high){
                long mid = low + (high-low)/2; // mid is PossibleMinimumElement in incompleteGarden which we need to  maximize
                
                int idx = getUBIndex(flw,0,i, mid);
                                
                if(idx==0) low=mid+1; // this happens when ur mid lies btw [0 - minElement_in_incompleteGarden]
                else{
                    long needed = (long)mid*idx - (long)ps[idx-1];
                    
                    if(needed <= nf){
                        cpb = (long)mid*partial;
                        low = mid+1;
                    }
                    else high = mid-1;
                }
            } // while end
            ans = (long)Math.max(ans, cfb + cpb);
            
        } // for end
        return ans;
    }
    
    
    
    
    
int getUBIndex(int arr[], int si, int ei, long val){
       
	    while(si<ei){
	        int mid = si + (ei-si)/2;
	        
	        if(arr[mid] > val){
	            // ans = mid;
	            ei=mid;
	        }else if(arr[mid] <= val) si = mid+1;
	    }
	    return si;
    }
}
```