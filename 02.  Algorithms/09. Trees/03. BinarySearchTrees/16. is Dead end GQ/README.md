# [**isDead End**](https://practice.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1#)

[**Video Reference**](https://youtu.be/eZMCRBrMznA)

```java
/*class Node {
        int data;
        Node left, right;
 
        Node(int item) {
            data = item;
            left = right = null;
        }
    }*/

//Function should return true if a deadEnd is found in the bst otherwise return false.
class GFG
{
    public static boolean isDeadEnd(Node r)
    {
        //Add your code here.
        return isdead(r,1,Integer.MAX_VALUE);
    }
    private static boolean isdead(Node r, int min, int max){
        if(r==null) return false;
        if(min==max) return true;
        
        return isdead(r.left,min,r.data-1) || isdead(r.right,r.data+1,max);
    }
}
```