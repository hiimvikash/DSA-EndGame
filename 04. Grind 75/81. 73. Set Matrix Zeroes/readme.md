# [73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        
        int colScan[]=new int[m];
        int rowScan[]=new int[n];
        
        // filling row&col Scan
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix[i][j] == 0) {
                    colScan[j] = -1;
                    rowScan[i] = -1;
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(rowScan[i]==-1 || colScan[j]==-1) matrix[i][j] = 0;
            }
        }
    }
}
```
[video reference](https://youtu.be/zgaOU5aInOc)

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        
        boolean isRow0 = false, isCol0 = false;
        for(int j = 0; j<m; j++) if(matrix[0][j] == 0){ isRow0 = true; break; }
        for(int i = 0; i<n; i++) if(matrix[i][0] == 0){ isCol0 = true; break; }
        
        for(int i = 1; i<n; i++){
            for(int j = 1; j<m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // now scanning col0 if any cell is 0 then we will convert every cell of that row to 0
        for(int i = 1; i<n; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j<m; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        // now scanning row0 if any cell is 0 then we will convert every cell of that column to 0
        for(int j = 1; j<m; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i<n; i++) matrix[i][j] = 0;
            }
        }
        
        if(isRow0){
            for(int j = 0; j<m; j++) matrix[0][j] = 0;
        }
        if(isCol0){
            for(int i = 0; i<n; i++) matrix[i][0] = 0;
        }
        
        
    }
}