# **[48. Rotate Image](https://leetcode.com/problems/rotate-image/)**
```java
class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }
    private void transpose(int arr[][]){
        int n=arr.length;
        for(int i=0;i<n;i++){
           for(int j=i;j<n;j++)
           {   
               int temp=arr[i][j];
               arr[i][j]=arr[j][i];
               arr[j][i]=temp;
           }
        }
    }
    private void reverseRows(int arr[][]){
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            int start=0,end=n-1;
            while(start<end){
                int temp=arr[i][start];
                arr[i][start]=arr[i][end];
                arr[i][end]=temp;
                start++;
                end--;
            }
        }
    }
}
```
## **[Video Reference](https://youtu.be/SoxrXQbhCPI)**