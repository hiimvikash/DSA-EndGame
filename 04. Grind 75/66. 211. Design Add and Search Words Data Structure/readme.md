# [211. Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/)


```java
class WordDictionary {
    Node root;
    
    class Node{
        char d;
        boolean isEnd;
        int cnt;
        Node next[];
            public Node(char data){
                d = data;
                isEnd = false;
                cnt = 0;
                next = new Node[26];
            }
    }

    public WordDictionary() {
        root = new Node('0');
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){
                if(curr.next[c-'a']==null) curr.next[c-'a'] = new Node(c);
                else curr.cnt++;
                curr = curr.next[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return search(word,root);
    }
    
    private boolean search(String word, Node curr){
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            if(c=='.'){
                for(Node nexy : curr.next){
                    if(nexy!=null && search(word.substring(i+1), nexy)) return true;
                }
                return false;
            }
            if(curr.next[c-'a']!=null) curr = curr.next[c-'a'];
            else return false;
        }
        return curr.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
```

[LC - Explanation](https://leetcode.com/problems/design-add-and-search-words-data-structure/discuss/1725207/Java-Simulation-%2B-Complete-Explanation-or-Brute-Force-Optimised-Solution)