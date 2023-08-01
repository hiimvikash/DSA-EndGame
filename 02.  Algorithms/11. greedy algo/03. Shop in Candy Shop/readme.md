## [Shop in Candy Store](https://practice.geeksforgeeks.org/problems/shop-in-candy-store1145/1)

Problem Statement : you have been given N types of candies and a candies[i] denote the price of ith type of candy and a value K, which says for each candy u buy u get K candies for free.
Now you have to answer two questions. 
- Firstly, you have to find what is the minimum amount of money you have to spend to buy all the N different candies. 
- Secondly, you have to find what is the maximum amount of money you have to spend to buy all the N different candies.
In both the cases you must utilize the offer i.e. you buy one candy and get K other candies for free.

```java
class Solution{
    static ArrayList<Integer> candyStore(int candies[],int n,int k){
        // code here
        // Let's Focus on minimum
        // When we want MINIMUM RS. to be spend then we will buy LESS worth and take K MORE worth candies
        // will do the whole process till we accuire all N candies
        
        // So the Approach is :-
        // sort the candies
        // place buy at 0th index which says : we will buy this
        // place free at n-1th index which says : we will take that candy for FREE
        // once our both the buy and free move forward in there respective direction then it means we hv accuired that candies(candies[buy] and candies[free])
        // if both buy and free are standing at same place then we r allowed to buy only we can't take that for free
        
        Arrays.sort(candies);
        
        int minSpend = 0;
        int buy = 0;
        int free = n-1;
        while(buy<=free){
            minSpend+= candies[buy]; // buying
            free = free - k; // got Free
            buy++; // bought
        }
        
        // Let's Focus on maximum
        // When we want MAXIMUM RS. to be spend then we will buy MORE worth and take K LESS worth candies
        // will do the whole process till we accuire all N candies
        
        // Approach is just opposite
        
        int maxSpend = 0;
        buy = n-1;
        free = 0;
        
        while(buy>=free){
            maxSpend+= candies[buy];
            free = free + k;
            buy--;
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(minSpend); ans.add(maxSpend);
        return ans;
    }
}
```