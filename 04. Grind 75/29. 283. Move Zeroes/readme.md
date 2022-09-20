# [283. Move Zeroes](https://leetcode.com/problems/move-zeroes/)
The idea is that we go through the array and gather all zeros on our road.
![image](https://user-images.githubusercontent.com/71629248/191180361-443a7ea0-982a-4d20-84a1-064906ec0474.png)

Let's take our example:
the first step - we meet 0.
Okay, just remember that now the size of our snowball is 1. Go further.
![image](https://user-images.githubusercontent.com/71629248/191180444-1b1982da-e134-4b70-8364-a6980371f341.png)

Next step - we encounter 1. Swap the most left 0 of our snowball with element 1.
![image](https://user-images.githubusercontent.com/71629248/191180484-655ca4ec-a3cb-4530-b470-d3e19c7be8b8.png)

Next step - we encounter 0 again!

![image](https://user-images.githubusercontent.com/71629248/191180535-0535cc46-0b4d-4ad7-b276-015e026f8de8.png)

Our ball gets bigger, now its size = 2.

![image](https://user-images.githubusercontent.com/71629248/191180569-87222b09-fc6f-4883-bcd8-213a9c1f14cb.png)

Next step - 3. Swap again with the most left zero.

![image](https://user-images.githubusercontent.com/71629248/191180622-52637372-a51c-4f12-8969-4be1f87a57a7.png)

Looks like our zeros roll all the time
![image](https://user-images.githubusercontent.com/71629248/191180652-28d6e728-2d9c-49fe-bfbe-6ea1369055cf.png)

Next step - 12. Swap again:

![image](https://user-images.githubusercontent.com/71629248/191180793-0004dff2-db4c-4554-92b1-6e21e1a22ead.png)

We reached finish! Congratulations!

![image](https://user-images.githubusercontent.com/71629248/191180859-592723d1-4dea-4339-8ec4-d6796e359a16.png)

Here's the code
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int snowBallSize = 0;
        
        for(int i = 0; i<n; i++){
            if(nums[i]==0) snowBallSize++;
            else if(snowBallSize > 0){
                int t = nums[i];
                nums[i] = 0;
                nums[i-snowBallSize] = t;
            }
        }
    }
}
```
