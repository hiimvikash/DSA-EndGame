# [2855. Minimum Right Shifts to Sort the Array](https://leetcode.com/problems/minimum-right-shifts-to-sort-the-array/description/)

## Read the Q and think for what Inputs array is sortable by rightShift ?
**Array is sortable by rightShifts when it just have 1 break point where two halves are already sorted.**


```java
class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        // find breakPoint where nums[i] < nums[i-1]
        // assume +ve infinity at the both end of array this will help to visualize when nums[] will be sorted and bpi will lie at 0th index.

        int n = nums.size();
        int bpi = 0; // breakPointIndex
        int bpc = 0; // breakPointCount

        for(int i = 1; i<n; i++){
            if(nums.get(i) < nums.get(i-1)){
                bpi = i;
                bpc++;
            }
        }
        // [7, 8, 9, 4, 5, 6] --> rightShiftSortable coz 1 bp i.e., 4 only
        // [7, 8, 9, 4, 5, 6, 2, 3] --> !rightShiftSortable coz more than 1 bp i.e., 4 and 2
        if(bpc > 1) return -1; // right shift sorting not possible (this will tackle desc order nums[] too)
        if(bpi == 0) return 0; // if already sorted

        // now u can ask how u r so sure that after bpi elements are sorted ?
        // this is if ele would not be sorted after bpi then bpc should be > 1
        
        // even if u got bpi u can't rotate directly see this TC -> [7, 8, 9, 4, 5, 12]
        // here bp is still 4 but u can't rotate bcz nums[n-1] > nums[0] so if u rightShift, sorted order is impossible.

        return nums.get(n-1) > nums.get(0)? -1 : n-bpi;
    }
}
```