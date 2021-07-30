# **Graphs**

### Max no. of Edge in graph of N nodes can be **N x (N-1) / 2.**

### Min no. of Edge in graph of N nodes can be **N-1.**

# Prerequisites:-

- Stack
- Queue
- PriorityQueue

# Step 1 : Graph Representation
**[Video Reference by Anuj Bhaiya](https://youtu.be/D21-XVw6nYw)**
```java
package graphDS;
import java.util.*;
public class MyGraph2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Vertices and edge");
		int v=sc.nextInt();
		int e=sc.nextInt();
		if(e > v*(v-1)/2) {
			System.out.println("Invalid edge"); return;
		}
		Graphy1 g1=new Graphy1(v);
		System.out.println("1. Add edge in undirected graph");
		System.out.println("2. Add edge in directed graph");
		int ch=sc.nextInt();
		
		
		for(int i=0;i<e;i++) {
			System.out.println("Enter source and destination");
			int src=sc.nextInt();
			int des=sc.nextInt();
			if(ch==1) g1.addEdgeU(src, des);
			else if(ch==2) g1.addEdgeD(src, des);
		}
		g1.printAdjaencyList();
		
		
	}

}
class Graphy1{
	private ArrayList<Integer> graph[];
	public Graphy1(int v) {
		graph=new ArrayList[v];
		for(int i=0;i<v;i++) graph[i]=new ArrayList<>();
	}
	public void addEdgeU(int source, int destination) {
		graph[source].add(destination);
		graph[destination].add(source);
	}
	public void addEdgeD(int source, int destination) {
		graph[source].add(destination);
	}
	public void printAdjaencyList() {
		System.out.println("Adjaency List : -");
		for(int i=0; i<graph.length; i++) {
			System.out.print(i+" --> ");
			int j=0;
			while(j<graph[i].size()) {
				System.out.print(graph[i].get(j)+"  ");
				j++;
			}
			System.out.println();
		}
	}
}

```
# Step 2 : Components in Graph
**[Video Reference](https://youtu.be/I6v0itcISSY)**
![componentsGraph](https://user-images.githubusercontent.com/71629248/127270730-a4dd8ef2-10fe-4942-82f2-5e5305a73784.png)

- This all are the 3 components of a single graph.
- From now whenever we will do any operations we will do for every components.
- To do that we will make a boolean visited array.
```java
boolean vis[]=new boolean[v];
for(int i=1; i<v; i++){
    if(!vis[i]){
        bfs(); or dfs(); // any operations.
    }
}
```
- To count number of components just add a counter inside if statement

# Step 3 : BFSprint()
**[Video Reference](https://youtu.be/UeE67iCK2lQ)**
- Make a boolean visited array of size v
- Run a loop from (0-->n-1)
	- if(!vis[i]) then call BFSPrint() for every component.
		1. make vis[i]=true;
		2. Make Queue and add i
		3. run a loop till queue is empty.
			- extract vertex from queue and print it.
			- add adjacent(if not visited) of this vertex into Queue and mark true in visited array.
```java
// 2. BFS print() Starts
		public void printBfs() {
			System.out.println("BFS Traversal : -");
			boolean vis[]=new boolean[graph.length];
			for(int i=0; i<graph.length; i++) {
				if(!vis[i]) {
					vis[i]=true;
					Queue<Integer> q=new LinkedList<>();
					q.add(i);
					
					while(!q.isEmpty()) {
						int vert=q.poll();
						System.out.print(vert+" ");
						for(Integer adj: graph[vert]) {
							if(!vis[adj]) {
								vis[adj]=true;
								q.add(adj);
							}
						}// adjacent for
					}// queue while
				}// outer component if
			}// // outer component for
			System.out.println();
		}// outer ()
// 2. BFS print() Ends
```			
# Step 4 : DFSprint()
**[Video Reference](https://youtu.be/uDWljP2PGmU)**
- Make a visited array of vertices
- dfs(i)
	- mark visited and print i
	- for each adjacent of i
		- if not visited call dfs(i)
```java
// 3. DFS print() Starts
		public void printDFS() {
			System.out.println("DFS Traversal :-");
			boolean vis[]=new boolean[graph.length];
			for(int i=0; i<graph.length; i++) {
				if(!vis[i]) {
					dfs(i,vis);
				}
			}
			System.out.println();
		}
		private void dfs(int vert, boolean vis[]) {
			vis[vert]=true;
			System.out.print(vert+" ");
			
			for(Integer adj: graph[vert]) {
				if(!vis[adj]) {
					dfs(adj,vis);
				}
			}
		}
// 3. DFS print() Ends
```		
# Step 5 : isCycle() for UG using BFS
**[Video Reference](https://youtu.be/A8ko93TyOns)**
- For being a cycle forward coming adjacent node must be visited.
- That's why we keep track for parent node for each vertex.
	- this is because parent node is also adjacent node so to tackle the clash **we will return true if (adj node is visited and adj!=parent)**
```java
// 4. isCycleBfsUg() Starts
		class Pair{
			int current;
			int parent;
			public Pair(int curr, int par) {
				current=curr;
				parent=par;
			}
		}
		public boolean isCycleBfsUg() {
			boolean vis[]=new boolean[graph.length];
			for(int i=0; i<graph.length; i++) {
				if(!vis[i])
					if(cycleBfsUg(i,vis)) return true;
			}
			return false;
		}
		private boolean cycleBfsUg(int i, boolean vis[]) {
			
			vis[i]=true;
			
			Queue<Pair> q=new LinkedList<>();
			q.add(new Pair(i,-1));
			
			while(!q.isEmpty()) {
				int vert=q.peek().current;
				int par=q.poll().parent; // assume it as a grandParent for adj nodes of vertex
				
				for(Integer adj: graph[vert]) {
					if(!vis[adj]) {
						vis[adj]=true;
						q.add(new Pair(adj,vert));
					}
					else if(vis[adj] && adj!=par) return true;
				}
			}
			return false;
		}
// 4. isCycleBfsUg() Ends
```
# Step 6 : isCycle() for UG using DFS
**[Video Reference](https://youtu.be/Y9NFqI6Pzd4)**
- Same Concept
```java
// 5. isCycleDfsUg() Starts
		public boolean isCycleDfsUg() {
			boolean vis[]=new boolean[graph.length];
			for(int i=0; i<graph.length; i++) {
				if(!vis[i]) {
					if(cycleDfsUg(i,-1,vis))return true;
				}
			}
			return false;
		}
		private boolean cycleDfsUg(int vert,int parent, boolean vis[]) {
			vis[vert]=true;
			for(Integer adj:graph[vert]) {
				if(!vis[adj]) {
					if(cycleDfsUg(adj, vert, vis)) return true;
				}
				else if(adj!=parent) return true;
			}
			return false;
		}
// 5. isCycleDfsUg() Ends
```
# Step 7 : isBipartite() for UG using BFS
**[Video Reference](https://youtu.be/nbgaEu-pvkU)**
- Except **oddLengthCycleGraph** every graph is a bipartite graph.
- ![bipartiteBFS](https://user-images.githubusercontent.com/71629248/127450745-d47a9f4e-15e3-442b-a6bf-d0fad172fc20.png)

```java
// 6. isBipartiteBFSug() Starts
		public boolean isBipartiteBFSug() {
			int color[]=new int[graph.length];
			Arrays.fill(color, -1);
			for(int i=0; i<graph.length; i++){
				if(color[i]==-1)
					if(!bipartiteBfsUg(i,color)) return false;
			}
			return true;
		}
		private boolean bipartiteBfsUg(int i, int color[]) {
			color[i]=0;
			Queue<Integer> q=new LinkedList<>();
			q.add(i);
			
			while(!q.isEmpty()) {
				int vert=q.poll();
				for(Integer adj: graph[vert]) {
					if(color[adj]==-1) {
						color[adj]=1-color[vert];
						q.add(adj);
					}
					else if(color[adj]==color[vert]) return false;
				}
			}
			return true;
		}
// 6. isBipartiteBFSug() Ends
```
# Step 8 : isBipartite() for UG using DFS
**[Video Reference](https://youtu.be/uC884ske2uQ)**
- Same concept as step 7.
```java
// 7. isBipartiteDFSug() Starts
		public boolean isBipartiteDFSug() {
			int color[]=new int[graph.length];
			Arrays.fill(color, -1);
			
			for(int i=0; i<graph.length; i++) {
				if(color[i]==-1) {
					color[i]=0;
					if(!bipartiteDfsUg(i,color)) return false;
				}
			}
			return true;
		}
		private boolean bipartiteDfsUg(int vert, int color[]) {
			for(Integer adj: graph[vert]) {
				if(color[adj]==-1) {
					color[adj]=1-color[vert];
					if(!bipartiteDfsUg(adj,color)) return false;
				}
				else if(color[adj]==color[vert]) return false;
			}
			return true;
		}
// 7. isBipartiteDFSug() Ends
```
# Step 9 : isCycle() for DG using DFS
![isCycleDG](https://user-images.githubusercontent.com/71629248/127507105-59916cd3-e520-4055-b074-f39dc5168309.png)

**[Video Reference](https://youtu.be/uzVUw90ZFIg)**
- Here we will have two boolean array vis[] & dfsvis[] (this will tell current standing position of recurssion ())
- If there is no adjacent for current vertex we roll back to calling() after making dfsvis[vert]=false
- If adjacent is already visited(i.e., vis[adj]==true) then we will check wheather dfsvis[adj]==true.
	- If true than we return True
	- else we make dfsvis[vert]=false and rollback to calling().
```java
// 8. isCycleDfsDg() Starts
			public boolean isCycleDfsDg() {
				boolean vis[]=new boolean[graph.length];
				boolean dfsvis[]=new boolean[graph.length];
				for(int i=0; i<graph.length; i++) {
					if(!vis[i]) {
						if(cycleDfsDg(i,vis,dfsvis)) return true;
					}
				}
				return false;
			}
			private boolean cycleDfsDg(int vert, boolean vis[], boolean dfsvis[]) {
				vis[vert]=dfsvis[vert]=true;
				
				for(Integer adj: graph[vert]) {
					if(!vis[adj]) {
						if(cycleDfsDg(adj,vis,dfsvis)) return true;
					}
					else if(dfsvis[adj]) return true;
				}
				dfsvis[vert]=false;
				return false;
			}
// 8. isCycleDfsDg() Ends
```	
# Step 10 : Topological Sort for DAG using DFS
 ### **Topological Sort :** Linear ordering of vertices such that if there is an edge between u-->v, u will apper before v.
 - That's why we do dfs traversal and insert the inner most vertex in stack then above it we insert the parent and so on..
 ```java
 // 9. topoDfsDAG() for DAG using DFS Starts
			public void topoDfsDAG() {
				System.out.println("Topological Sort :-");
				boolean vis[]=new boolean[graph.length];
				Stack<Integer> st=new Stack<>();
				for(int i=0; i<graph.length; i++) {
					if(!vis[i]) {
						topoDfs(i,vis,st);
					}
				}
				while(!st.isEmpty())
					System.out.print(st.pop()+" ");
				System.out.println();
			}
			private void topoDfs(int vert, boolean vis[], Stack<Integer> st) {
				vis[vert]=true;
				for(Integer adj: graph[vert]) {
					if(!vis[adj]) {
						topoDfs(adj,vis,st);
					}
				}
				st.push(vert);
			}
// 9. topoDfsDAG() for DAG using DFS Ends	
 ```
