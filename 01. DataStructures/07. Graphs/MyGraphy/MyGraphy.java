package graphDS;
import java.util.*;
public class MyGraphy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Vertices and edge");
		int v=sc.nextInt();
		int e=sc.nextInt();
		if(e > v*(v-1)/2) {
			System.out.println("Invalid edge"); return;
		}
		
		System.out.println("1. Add edge in undirected graph");
		System.out.println("2. Add edge in directed graph");
		System.out.println("3. Add edge in undirected graph with weights (#Graphy2)");
		System.out.println("4. Add edge in directed graph with weights (#Graphy2)");
		System.out.println("5. Add edge in undirected graph with weights (#Graphy2) for Kruskal's Algo");
		System.out.println("6. Add edge in directed graph with -VE weights (#Graphy2) for Bellmanford Algo");
		int ch=sc.nextInt();
		// choice which decides Graphy1 will be executed STARTS.
		if(ch==1 || ch==2) {
			Graphy1 g1=new Graphy1(v);
			
			for(int i=0;i<e;i++) {
				System.out.println("Enter source and destination");
				int src=sc.nextInt();
				int des=sc.nextInt();
				if(ch==1) g1.addEdgeU(src, des);
				else if(ch==2) g1.addEdgeD(src, des);
			}
			g1.printAdjaencyList();
			g1.printBfs();
			g1.printDFS();
			// for UG starts
			if(ch==1) {
				System.out.println("Cycle Detected  in UG using BFS : "+g1.isCycleBfsUg());
				System.out.println("Cycle Detected  in UG using DFS : "+g1.isCycleDfsUg());
				System.out.println("Bipartite graph detection in UG using BFS : "+g1.isBipartiteBFSug());
				System.out.println("Bipartite graph detection in UG using DFS : "+g1.isBipartiteDFSug());
				g1.sPath1wtUg(0);
				g1.bridgeUgDfs();
				
			}
			// for UG ends
			
			// for DG starts
			else {
				System.out.println("Cycle Detected  in DG using DFS : "+g1.isCycleDfsDg());
				g1.topoDfsDAG();
				g1.topoBfsDAG();
				System.out.println("Cycle Detected  in DG using BFS : "+g1.isCycleBfsDg());
				g1.printSccDgDfs();
			}
			// for DG ends
		}
		// choice which decides Graphy1 will be executed ENDS.
		else if(ch==3 || ch==4 || ch==5 || ch==6) {
			Graphy2 g2=new Graphy2(v);
			for(int i=0; i<e; i++) {
				System.out.println("Enter Source, destination and weight");
				int src=sc.nextInt();
				int des=sc.nextInt();
				int wt=sc.nextInt();
				if(ch==3 || ch==5) {
					g2.addEdgeU(src,des,wt);
					g2.addEdgeK(src,des,wt);
				}
				else if(ch==4 || ch==6) {
					g2.addEdgeD(src,des,wt);
					g2.addEdgeB(src,des,wt);
				}
				
				
			}
			g2.printAdjaencyList();
			if(ch==3 || ch==5) {
				g2.sPathUg(0);
				g2.mstPrims();
				g2.mstKruskal();
			}
			else if(ch==4) g2.sPathDagTopo(0);
			else if(ch==6) g2.ShortestPathDGBellman(0);
		}
	}

}

// Class Graphy1 is for graph vertices without weights or with unit weight
class Graphy1{
	private ArrayList<Integer> graph[];
	public Graphy1(int v) {
		graph=new ArrayList[v];
		for(int i=0;i<v;i++) graph[i]=new ArrayList<>();
	}
	
	
// 1. Representation ()s Starts
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
//				int j=0;
//				while(j<graph[i].size()) {
//					System.out.print(graph[i].get(j)+"  ");
//					j++;
//				}
				for(Integer adj: graph[i]) {
					System.out.print(adj+"  ");
				}
				System.out.println();
			}
		}
// 1. Representation ()s Ends
		
		
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
		
		
// for UG Starts		
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
// for UG Ends
			
// for DG Starts			
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
			
			
			
	// 9. topoDfsDAG() for DAG using DFS Starts
			public void topoDfsDAG() {
				System.out.println("Topological Sort using DFS :-");
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
			
			
			
			
	// 10. topoBfsDAG() for DAG using BFS Starts
			public void topoBfsDAG() {
				System.out.println("Topological Sort using BFS :-");
				// Step 1 : Make a indegree array
				int indeg[]=new int[graph.length];
				for(int i=0; i<graph.length; i++) {
					for(Integer adj: graph[i]) {
						indeg[adj]++;
					}
				}
				// Step 2 : Insert vertices with indegree 0 in queue.
				Queue<Integer> q=new LinkedList<>();
				for(int i=0; i<graph.length; i++) {
					if(indeg[i]==0) q.add(i);
				}
				// Step 3 : do BFS in Queue till its empty
				while(!q.isEmpty()) {
					int vert=q.poll();
					System.out.print(vert+" ");
					for(Integer adj: graph[vert]) {
						indeg[adj]--;
						if(indeg[adj]==0) q.add(adj);
					}
				}
				System.out.println();
			}
	// 10. topoBfsDAG() for DAG using BFS Ends
			
			
			
   // 11. isCycleBfsDg() Starts
			public boolean isCycleBfsDg() {
				// Step 1 : Make Indegree of each vertex
				int indeg[]=new int[graph.length];
				for(int i=0; i<graph.length; i++) {
					for(Integer adj: graph[i]) {
						indeg[adj]++;
					}
				}
				// Step 2 : Insert vertices with indegree 0 in Queue
				Queue<Integer> q=new LinkedList<>();
				for(int i=0;i<graph.length;i++) {
					if(indeg[i]==0) q.add(i);
				}
				// Step 3 : do BFS in queue till its empty
				int cnt=0;
				while(!q.isEmpty()) {
					int vert=q.poll();
					cnt++;
					for(Integer adj: graph[vert]) {
						indeg[adj]--;
						if(indeg[adj]==0) q.add(adj);
					}
				}
				return cnt!=graph.length;
			}
   // 11. isCycleBfsDg() Ends
// for DG Ends
			
			
	// 12. sPath1wtUg() Starts 
			public void sPath1wtUg(int src) {
				// Step 1 : Make dis[] array which stores distance from source to each vertex.
				int dis[]=new int[graph.length];
				// Initialize with the max value
				Arrays.fill(dis, Integer.MAX_VALUE);
				// distance from source to source is always 0
				dis[src]=0;
				// Step 2 : Make Queue and add source
				Queue<Integer> q=new LinkedList<>();
				q.add(src);
				// Step 3 : Traverse queue Adjacents till its empty
				while(!q.isEmpty()) {
					int vert=q.poll();
					int dist=dis[vert];
					for(Integer adj: graph[vert]) {
						if(dist+1<dis[adj]) {
							dis[adj]=dist+1;
							q.add(adj);
						}
					}
				}
				System.out.println("Shortest Path for UG with unit weight : "+Arrays.toString(dis));
			}
	// 12. sPath1wtUg() Ends
			
			
			
	// 17. Bridges in undirectedGraph + Articulation Points Starts
			public void bridgeUgDfs() {
				
				boolean vis[]=new boolean[graph.length];
				int tad[]=new int[graph.length]; // timeOfAdmission
				int connections[]=new int[graph.length];
				boolean aPoint[]=new boolean[graph.length];
				int timer=0;
				System.out.println("Bridges in Graphs are :-");
				for(int i=0; i<graph.length; i++) {
					if(!vis[i]) bridgeDfs(i,-1,vis,tad,connections,timer,aPoint);
				}
				
				System.out.println("Articulation Points:-");
				for(int i=0;i<graph.length;i++) {
					if(aPoint[i])
						System.out.print(i+" ");
				}
				System.out.println();
			}
			private void bridgeDfs(int node, int parent, boolean vis[],int tad[], int connection[],int timer, boolean aPoint[]) {
				vis[node]=true;
				tad[node]=connection[node]=timer++;
				
				for(Integer adj: graph[node]) {
					if(adj==parent) continue;
					
					if(!vis[adj]) {
						bridgeDfs(adj,node,vis,tad,connection,timer,aPoint);
						connection[node]=Math.min(connection[node], connection[adj]);
						if(tad[node]<connection[adj]) {
							System.out.println("("+node+", "+adj+") ");
							aPoint[node]=aPoint[adj]=true;
						}
					}
					else {
						connection[node]=Math.min(connection[node], connection[adj]);
					}
				}
			}
	// 17. Bridges in undirectedGraph + Articulation Points Ends
			
			
			
	// 18. SCC(Self) Starts
			// here we are doing reverse DFS
			public void printSccDgDfs() {
				boolean vis[]=new boolean[graph.length];
				System.out.println("Strongly Connected components are :-");
				for(int i=graph.length-1; i>=0; i--) {
					if(!vis[i]) scc(i,vis);
					else continue;
					System.out.println();
				}
				System.out.println();
			}
			private void scc(int vert, boolean vis[]) {
				vis[vert]=true;
				System.out.print(vert+ " ");
				for(Integer adj: graph[vert]) {
					if(!vis[adj]) scc(adj,vis);
				}
			}
    // 18. SCC(Self) Ends
				
}





// Class Graphy2 is for graph vertices with weights
class Graphy2{
	
	class Tripy implements Comparable<Tripy>{
		int curr;
		int par;
		int wt;
		
		public Tripy(int destination,int source,int weight) {
			curr=destination;
			par=source;
			wt=weight;
		}

		@Override
		public int compareTo(Tripy o) {
			// TODO Auto-generated method stub
			return this.wt-o.wt;
		}
	}
	
	private ArrayList<Tripy> graph[];
	public Graphy2(int v) {
		graph=new ArrayList[v];
		for(int i=0;i<v;i++) graph[i]=new ArrayList<>();
	}
	
	public void addEdgeU(int par, int curr, int wt) {
		graph[par].add(new Tripy(curr,par,wt));
		graph[curr].add(new Tripy(par,curr,wt));
	}
	public void addEdgeD(int par, int curr, int wt) {
		graph[par].add(new Tripy(curr,par,wt));
	}
	public void printAdjaencyList() {
		for(int i=0; i<graph.length; i++) {
			System.out.print(i+"--> ");
			for(Tripy adj: graph[i]) {
				System.out.print("("+adj.curr+", "+adj.wt+")  ");
			}
			System.out.println();
		}
	}
	
	// 13. Shortest path in DAG using TopoSort STARTS
		private void topoSortDfs(int vert, boolean vis[], Stack<Integer> st) {
			vis[vert]=true;
			for(Tripy adj: graph[vert]) {
				if(!vis[adj.curr]) topoSortDfs(adj.curr,vis,st);
			}
			st.push(vert);
		}
		public void sPathDagTopo(int src) {
			// Step 1 : Arrange all the vertices in toposort order
			Stack<Integer> st=new Stack<>();
			boolean vis[]=new boolean[graph.length];
			for(int i=0; i<graph.length; i++) {
				if(!vis[i]) {
					topoSortDfs(i,vis,st);
				}
			}
			
			// Step 2 : Make dis[] array initialize all of them with INF and dis[src]=0
			int dis[]=new int[graph.length];
			Arrays.fill(dis, Integer.MAX_VALUE);
			dis[src]=0;
			
			// Step 3 : pull out elements from stack 1by1
			while(!st.isEmpty()) {
				int vert=st.pop();
				
				if(dis[vert]!=Integer.MAX_VALUE) {
					for(Tripy adj: graph[vert]) {
						dis[adj.curr]=Math.min(dis[adj.curr], dis[vert]+adj.wt);
					}
				}
			}
			System.out.println("Shortest path in DAG with weights using TopoSort : "+ Arrays.toString(dis));
		}
	// 13. Shortest path in DAG using TopoSort ENDS
		
		
		
		
	// 14. Shortest path in UG #Dijkstra's Algorithms Starts
		class Pair implements Comparable<Pair>{
			int curr;
			int disFsrc;
			public Pair(int curr,int dis) {
				this.curr=curr;
				disFsrc=dis;
			}
			@Override
			public int compareTo(Pair o) {
				// TODO Auto-generated method stub
				return this.disFsrc-o.disFsrc;
			}
		}
		
		public void sPathUg(int src) {
			// Step 1 : Initialize dis[] array with INF value
			int dis[]=new int[graph.length];
			Arrays.fill(dis, Integer.MAX_VALUE);
			dis[src]=0;
			// Step 2 : Make PQ and add source
			PriorityQueue<Pair> pq=new PriorityQueue<>();
			pq.add(new Pair(src,0));
			// Step 3 : Traverse PQ
			while(!pq.isEmpty()) {
				Pair vert=pq.remove();
				for(Tripy adj: graph[vert.curr]) {
					if(dis[adj.curr] > vert.disFsrc+adj.wt) {
						dis[adj.curr]=vert.disFsrc+adj.wt;
						pq.add(new Pair(adj.curr,dis[adj.curr]));
					}
				}
			}
			System.out.println("Shortest path in UG with weights using PQ : "+ Arrays.toString(dis));
		}
	// 14. Shortest path in UG #Dijkstra's Algorithms Ends
		
		
		
	// 15. MST - Prim's Algorithm Starts
		public void mstPrims() {
			boolean vis[]=new boolean[graph.length];
			int parent[]=new int[graph.length]; // here we will store parents of each vertex
			
			// Step 1 : Make PQ
			PriorityQueue<Tripy> pq=new PriorityQueue<>();
			pq.add(new Tripy(0,-1,0));
			
			// Step 2 : Traverse in PQ
			while(!pq.isEmpty()) {
				Tripy vert=pq.remove(); // remove
				if(!vis[vert.curr]) {
					vis[vert.curr]=true; // mark
					parent[vert.curr]=vert.par; // work
					// Now add
					for(Tripy adj: graph[vert.curr]) {
						if(!vis[adj.curr]) {
							pq.add(adj);
						}
					}
				}
			}
			System.out.println("Minimum Spanning Tree using Prim's Algo : "+ Arrays.toString(parent));
		}
	// 15. MST - Prim's Algorithm Ends
		
		
		
		
	// 16. MST - Kruskal's Algorithm Starts
		// disjointSet() Starts
			private void make(int parent[]) {
				for(int i=0; i<parent.length; i++)
					parent[i]=i;
			}
			private int findPar(int node, int parent[]) {
				if(node==parent[node]) return node;
				return parent[node]=findPar(parent[node],parent);
			}
			private void union(int u, int v, int parent[], int rank[]) {
				int pu=findPar(u,parent);
				int pv=findPar(v,parent);
				
				if(rank[pu]<rank[pv]) { // hey pu from now your parent is pv.
					parent[pu]=pv;
				}
				else if(rank[pv]<rank[pu]) { // hey pv from now your parent is pu.
					parent[pv]=pu;
				}
				else {
					parent[pv]=pu;
					rank[pu]++;
				}
			}
		// disjointSet() Ends
		ArrayList<Tripy> edges=new ArrayList<>();
		public void addEdgeK(int par, int curr, int wt) {
			edges.add(new Tripy(curr,par,wt));
		}
		public void mstKruskal() {
			// Step 1 : sort arrayList of edges weight wise
			Collections.sort(edges);
			// Step 2 : set the vertices as selfParents & Initialize rank.
			int rank[]=new int[graph.length];
			int parent[]=new int[graph.length];
			make(parent);
			// Making outputParent
			int outParent[]=new int[graph.length];
			outParent[0]=-1;
			//Step 3 : Traverse in edges AL
			for(Tripy edge : edges) {
				if(findPar(edge.curr,parent)!=findPar(edge.par,parent)) {
					union(edge.curr,edge.par,parent,rank);
					outParent[edge.curr]=edge.par;
				}
			}
			System.out.println("Minimum Spanning Tree using Kruskal's Algo : "+ Arrays.toString(outParent));
		}
	// 16. MST - Kruskal's Algorithm Ends
		
		
		
	// 19 ShortestPath-DG(containing +ve,-ve weights) BellmanFord's Algorithm STARTS
			ArrayList<Tripy> edgeB=new ArrayList<>();
			public void addEdgeB(int par, int curr, int wt) {
				edgeB.add(new Tripy(curr,par,wt));
			}
			public void ShortestPathDGBellman(int src) {
				System.out.println("Shortest Path for DG with -ve weights :-");
				int dis[]=new int[graph.length];
					
				final int INF=999999;
				Arrays.fill(dis,INF);
				dis[src]=0;
				// Step 1 : 1st relaxation
				for(int i=1;i<graph.length;i++) {
					for(Tripy ege:edgeB) {
						if(dis[ege.par]+ege.wt<dis[ege.curr])
							dis[ege.curr]=dis[ege.par]+ege.wt;
					}
				}
				// Step 2 : 2nd relaxation for checking -Ve cycle
				for(Tripy ege:edgeB) {
					if(dis[ege.par]+ege.wt<dis[ege.curr])
					{	System.out.println("NEGATIVE CYCLE FOUND"); return;}
				}
				System.out.println(Arrays.toString(dis)); 
			}
	// 19 ShortestPath-DG(containing +ve,-ve weights) BellmanFord's Algorithm ENDS	
		
}


