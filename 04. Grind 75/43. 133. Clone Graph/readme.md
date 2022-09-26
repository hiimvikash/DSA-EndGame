# [133. Clone Graph](https://leetcode.com/problems/clone-graph/)
## BFS
```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        HashMap<Node, Node> hm=new HashMap<>(); // oriNode-duplicateNode
        Node copy=new Node(node.val);
        hm.put(node,copy);
        
        Queue<Node> q= new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node n = q.remove();
            
            for(Node adj : n.neighbors){
                if(!hm.containsKey(adj)){
                    hm.put(adj, new Node(adj.val));
                    q.add(adj);
                    Node cn = hm.get(n); // copy vertex node
                    cn.neighbors.add(hm.get(adj));
                }
                else {
                    Node cn = hm.get(n);
                    cn.neighbors.add(hm.get(adj));
                }
            }
        }
        return copy;
    }
}
```
[Video Reference](https://youtu.be/-mtFEpNYQvo)