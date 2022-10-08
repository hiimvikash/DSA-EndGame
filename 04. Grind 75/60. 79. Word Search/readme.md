# [79. Word Search](https://leetcode.com/problems/word-search/)

```java
class Solution {
    int di[] = {-1, 0, 1, 0}; int dj[] = {0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean vis[][]=new boolean[n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == word.charAt(0) && search(board, word, i, j, 0, vis, n, m)) return true;
            }
        }
        return false;
    }
    
    boolean search(char board[][], String wrd, int i, int j, int idx, boolean vis[][], int n, int m){
        if(board[i][j] != wrd.charAt(idx)) return false;
        if(idx == wrd.length()-1) return true;
        
        vis[i][j] = true;
        for(int k = 0; k<4; k++){
            if(i+di[k]>=0 && i+di[k]<n && j+dj[k]>=0 && j+dj[k]<m && !vis[i+di[k]][j+dj[k]]){
                if(search(board, wrd, i+di[k], j+dj[k], idx+1, vis, n, m)) return true;
            }
        }
        vis[i][j] = false;
        return false;
    }
}
```