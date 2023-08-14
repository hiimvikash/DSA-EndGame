## You're given binary subarray, count subarrays with = 0s and 1s
- Input : {1,0,1,0,1}  Output : 6

```java
private static int countSubArrayWithEquals01(int arr[], int n){
        // Step 1 : convert 0 -> -1
        for(int i = 0; i<n; i++) if(arr[i] == 0) arr[i] = -1;
        
        // Step 2 : Now ur Q is count subarray with 0 sum
        // make a HM which store count of occurencesOfSum
        HashMap<Integer, Integer> hm=new HashMap<>();
        hm.put(0, 1);
        
        int count = 0;
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum+=arr[i];
            if(hm.containsKey(sum)) count+=hm.get(sum);
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        return count;
    }
```