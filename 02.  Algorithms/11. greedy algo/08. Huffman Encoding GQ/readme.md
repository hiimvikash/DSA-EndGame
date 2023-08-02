# [Huffman Encoding](https://practice.geeksforgeeks.org/problems/huffman-encoding3345/1)
```java
class Solution {
    public ArrayList<String> huffmanCodes(String s, int f[], int n)
    {
        // Code here
        char ch[] = s.toCharArray();
        // 1. Add all the frequency in PQ
        
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b) -> (a.val - b.val) >= 0 ? 1 : -1);
        for(int i = 0; i<n; i++){
            pq.add(new Node(f[i], ch[i]));
        }
        // 2. Now Make Tree
        
        while(pq.size() > 1){
            Node left = pq.remove();
            Node right = pq.remove();
            
            Node nn = new Node(left.val + right.val);
            
            nn.left = left;
            nn.right = right;
            
            pq.add(nn);
        }
        
        // Now leaf nodes contain alphabet
        
        Node root = pq.remove();
        ArrayList<String> ans=new ArrayList<>();
        
        preorderTraversal(root, "", ans);
        
        return ans;
    }
    
    void preorderTraversal(Node root, String subans, ArrayList<String> ans){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans.add(subans);
            return;
        }
            preorderTraversal(root.left, subans+"0", ans);
            preorderTraversal(root.right, subans+"1", ans);
    }
}

class Node{
    int val;
    char c;
    Node left;
    Node right;
    public Node(int data, char ch){
        c = ch;
        val = data;
        left = null;
        right = null;
    }
    public Node(int data){
        c = '#';
        val = data;
        left = null;
        right = null;
    }
}
```