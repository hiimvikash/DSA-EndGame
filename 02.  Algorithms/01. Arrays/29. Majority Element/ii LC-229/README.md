# **[229. Majority Element II](https://leetcode.com/problems/majority-element-ii/)**

## My Intution : - Boyer-Moore Voting Algorithm TC - O(N) SC - O(1)

Whenever crediblity for candidate1 tends to decreases then instead of decreasing its crediblity(count1) we assign it to new candidate2.

### **Note :** max two majority element is possible here.

```java
class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int candi1=-1,candi2=-1,count1=0,count2=0;
        for(int ele: arr){
            if(ele==candi1) count1++;
            else if(ele==candi2) count2++;
            else if(count1==0){
                candi1=ele;
                count1=1;
            }
            else if(count2==0){
                candi2=ele;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        count1=0; count2=0; int n=arr.length;
        for(int ele:arr){
            if(ele==candi1) count1++;
            else if(ele==candi2) count2++;
        }
        if(count1 > n/3) ans.add(candi1);
        if(count2 > n/3) ans.add(candi2);
        return ans;
    }
}
```

## **[Video Reference : TUF](https://youtu.be/yDbkQd9t2ig)**

## **[Video Reference : AnujBhaiya](https://youtu.be/X0G5jEcvroo?t=799)** Intution is of crediblity
