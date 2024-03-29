# **Trie DS ?**
![image](https://user-images.githubusercontent.com/71629248/192536555-5ac9ae2a-f273-410a-8bab-ddb95679d1fa.png)

### A trie is a tree-like data structure whose nodes **(it can have N no. of nodes)** store the letters of an alphabet. By structuring the nodes in a particular way, words and strings can be retrieved from the structure by traversing down a branch path of the tree.

<hr>

# **General overview on TRIE DS formation**

## **Remember :** Every Node has 26pointers (for each alphabets) although they are not shown here.

![](https://i.ibb.co/Z8j17Rs/1-K7-LHR1-JFGIP-4-Auz-Jel4-A.png)

<hr>

# **What's in a Single Node of Trie ?**

![](https://i.ibb.co/g3Zb6bj/Trie-DS.png)

<hr>

# **Insertion of Words in a Trie**

```java
public void insert(String wrd) {
		Node curr=root;
		for(char c: wrd.toCharArray() ) {
			if(curr.next[c-'a']==null) curr.next[c-'a']=new Node(c);
			curr.next[c-'a'].count++;
			curr=curr.next[c-'a'];
		}
		curr.isEnd=true;
	}
```

<hr>

## **[Video Reference](https://youtu.be/Kqfckuz0pcw)**

## **[Implementation of Trie using Array.](./Tries_Array.java)**

## **[Implementation of Trie using HashMap.](./Tries_Hash.java)**

**Trie using HashMap give you the edge in inserting any string containing any character over Trie using Array + Trie using HashMap has less space complexity.**

<hr>
<h1 align="center"><b>THANK YOU</b></h1>
