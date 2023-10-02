# [2865. Beautiful Towers I](https://leetcode.com/problems/beautiful-towers-i/description/)

## The Q is : you have been given with the maxHeights of the towers which you can setup at the ith index. Now you have to setup towers at each ith index and make a ```heights[]```, such that the full configuration of towers looks like mountain.
![Alt text](image.png)
## TestCases :-
![Alt text](save-1.png)

## Intuition :-

### See TC 1 : Here we selected one peak ele i.e., 9(at index 3) and then we went left side to setup the tower, as we know while going left side from 9 we should be in decreasing or equal to order so we kept on going all to the left side and maintained the ```maxtill : which says maximum till now```. and did same thing on rightside of 9.
- when I went to ```index 2``` then ```maxtill = 9```, and I setup the tower of ```height = Math.min(maxtill, maxHeight[2])``` and updated my ```maxtill = 3```. 
    - at index 2 maxtill value signifies that I can setup tower of ```height <= 9``` **to maintain the mountain configuration** but ```maxHeight[2]``` did'nt allow me
    - updated my ```maxtill = 3``` bcz when I will go to index 1 to setup my tower then maxtill value will signifies that I can setup tower of ```height <= 3``` **to maintain the mountain configuration**
    - so maxtill and maxHeight[] for every index is a type of restriction which they are giving to setup the tower that's why we are selecting minimum where they both agree.
### As u saw in other tcs that there is no pattern to find peak element of the mountain array so we are trying to make every index as peakElement and finding sum based on that peak ele.

```java
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();

        long ans = 0;
        for(int i = 0; i<n; i++){
             long sum = maxHeights.get(i);
             int maxtill = maxHeights.get(i);
            for(int j = i-1; j>=0; j--){
                sum+= Math.min(maxtill, maxHeights.get(j));
                maxtill = Math.min(maxtill, maxHeights.get(j));
            }
            maxtill = maxHeights.get(i);
            for(int j = i+1; j<n; j++){
                sum+=Math.min(maxtill, maxHeights.get(j));
                maxtill = Math.min(maxtill, maxHeights.get(j));
            }

            ans = Math.max(ans,sum);
        }

        return ans;
    }
}
```


## O(N)
## for every ith index we are calculating :-
- sum from ith to 0 with decreasing or equal element.
    - see if currEle is going to be peakElement then
        - if it is greater than previous ele then that ele can easily be added into the answer of ldms[i-1] bcz ldms[i-1] says maximum sum possible from LHside while considering the ele in decreasing or equal.
        - else if currEle is smaller than previous ele then for currEle to become peak of mountain u need to chop down the previousEles which are greater to currEle
- sum from ith to n-1 with decreasing or equal element.
simillarly...

```java
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();

        // Step 1 : make a array which gives LeftDecreasing Mountain sum -> / till ith index.
            // Step 1.1 Make pse[] previousSmallerEle index
            Stack<Integer> st=new Stack<>();
            int pse[]=new int[n];
            for(int i = 0; i<n; i++){
                while(!st.isEmpty() && maxHeights.get(i) <= maxHeights.get(st.peek())) st.pop();

                if(st.isEmpty()) pse[i] = -1;
                else pse[i] = st.peek();

                st.push(i);
            }
            // pse[] made.
        
        long ldms[]=new long[n]; // ldms[i] will give sum from ith to 0 index with mountainEle(decreasing or equal)
        ldms[0] = maxHeights.get(0);
        for(int i = 1; i<n; i++){
            if(maxHeights.get(i) >= maxHeights.get(i-1)){
                ldms[i] = ldms[i-1] + maxHeights.get(i);
            }else{
                long tailSum = pse[i]==-1 ? 0 : ldms[pse[i]];
                ldms[i] = (long)(i-pse[i])*maxHeights.get(i) + tailSum;
            }
        }
        st.clear();
        // ldms[] done


        // Step 2 : make rdms[] : rightDecresing Mountain sum -> \
            // Step 1.1 Make nse[] nextSmallerEle index
            int nse[] = new int[n];
            for(int i = n-1; i>=0; i--){
                while(!st.isEmpty() && maxHeights.get(i) <= maxHeights.get(st.peek())) st.pop();

                if(st.isEmpty()) nse[i] = n;
                else nse[i] = st.peek();

                st.push(i);
            }
            // nse[] done

        long rdms[]=new long[n];
        rdms[n-1] = maxHeights.get(n-1);
        for(int i = n-2; i>=0; i--){
            if(maxHeights.get(i) >= maxHeights.get(i+1)){
                rdms[i] = maxHeights.get(i) + rdms[i+1];
            }else{
                long tailSum = nse[i] == n ? 0 : rdms[nse[i]];
                rdms[i] = (long)(nse[i]-i)*maxHeights.get(i) + tailSum; // cutting down all the ele greater than mh[i] to mh[i]
            }
        }
        // rdms[] done


        long ans = 0;
        for(int i = 0; i<n; i++) ans = Math.max(ans, ldms[i]+rdms[i]-maxHeights.get(i));

        return ans;
    }
}
```