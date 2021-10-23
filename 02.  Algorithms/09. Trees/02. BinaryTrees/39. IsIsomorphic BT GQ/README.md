# [**Check if Tree is Isomorphic**](https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1#)
- [**Video Reference**](https://youtu.be/9Eo42meRcrY)
```java
class Solution  
{ 
    // Return True if the given trees are isomotphic. Else return False.
    boolean isIsomorphic(Node r1, Node r2)  
    { 
         // code here.
         if(r1==null && r2==null) return true;
         if(r1==null || r2==null) return false;
         if(r1.data != r2.data) return false;
         
         if((isIsomorphic(r1.left,r2.left) && isIsomorphic(r1.right,r2.right)) || (isIsomorphic(r1.left,r2.right) && isIsomorphic(r1.right,r2.left))) return true;
         return false;
    }
    
}
```
