# **[Plus1](https://www.interviewbit.com/problems/add-one-to-number/)**

## My Intution : - TC - O(N) SC - O(1)

- To increase the number by 1 we have to increase last digit only by 1.
  - for eg. Input is 435464--->435465

## Some Corner cases :-

- If last digit is 9 then last digit will be replaced with 0 and 1 will be addUp in 2nd last digit.
  - for eg. Input is 4589-->4590
- Simillarly if last 2 digit is 9 then they will be replaced with 0 and 1 will be addUp in 3rd last digit.
  - for eg. Input is 7599-->7600
- If all digit is 9 then every digit will be replaced with 0 and 1 will be placed in front.
  - for eg. Input is 9999-->10000

```java
public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> arr) {
        int rem=0;
        while(arr.size()>1 && arr.get(0)==0) arr.remove(0);
        for(int i=arr.size()-1;i>=0;i--){
            int num= arr.get(i);
            if(num==9){
                arr.set(i,0);
                rem=1;
            }else{
                arr.set(i,num+1);
                rem=0;
                break;
            }
        }
        if(rem==1) arr.add(0,1); // when input is 999
        return arr;
    }
}
```
