# **[54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)**
![SpiralMatrix](https://user-images.githubusercontent.com/71629248/124712016-674b5280-df1c-11eb-86d7-7d8c1caa3d57.png)

```java
class Solution {
    public ArrayList<Integer> spiralOrder(int[][] arr) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length, m=arr[0].length;
        int miR=0, miC=0, maR=n-1, maC=m-1; // minimumRow, minimumCol, maximumRow, maximumCol respectively.
        int tne=n*m;
        int count=0;
        
        while(count<tne){
            // topWall miC-->maC, miR-constant
                for(int i=miC,j=miR; i<=maC && count<tne; i++){
                    ans.add(arr[j][i]);
                    count++;
                }
                miR++; 
            // rightWall miR-->maR, maC-constant
                for(int i=miR,j=maC; i<=maR && count<tne; i++){
                    ans.add(arr[i][j]);
                    count++;
                }
                maC--;
            // bottomWall maC-->miC, maR-constant
                for(int i=maC,j=maR; i>=miC && count<tne; i--){
                        ans.add(arr[j][i]);
                        count++;
                }
                maR--;
            // leftWall maR-->miR, miC-constant
                for(int i=maR,j=miC; i>=miR && count<tne; i--){
                        ans.add(arr[i][j]);
                        count++;
                }
                miC++;
        }
        return ans;
    }
}
```
**[Video Reference](https://youtu.be/SVFXEqn3Ceo)**
