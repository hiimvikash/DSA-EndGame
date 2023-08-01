# [Check if it is possible to survive on Island](https://practice.geeksforgeeks.org/problems/check-if-it-is-possible-to-survive-on-island4922/1)

```java
class Solution{
    static int minimumDays(int S, int N, int M){
        // code here
        if(M > N) return -1; // if(foodReqToSurviveAday > foodUcanBuyEachDay)
        
        int numberOfSundaysInSdays = S/7;
        int maxNumberOfTimesWeCanBuy = S - numberOfSundaysInSdays;
        
        // Here We need to find Minimum no.OfTimes we need to buy food
        int TotalUnitOfFoodReq = S * M; // numOfDayWeNeedToSurvive * FoodReqEachDay
        int NumberOfTimesNeedToBuyFood = (int)Math.ceil((double)TotalUnitOfFoodReq / (double) N);  // here N is amount of food I can buy each time
        
        if(NumberOfTimesNeedToBuyFood > maxNumberOfTimesWeCanBuy) return -1;
        return NumberOfTimesNeedToBuyFood;
    }
}
```