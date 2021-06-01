package graphDS;
import java.util.*;

public class MyGraph {

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter no. of Vertices and Edges");
		int v=sc.nextInt();
		int e=sc.nextInt();
		if(e > v*(v-1)/2)
		{
			System.out.println("ENTER correct edges"); return;
		}
		
		System.out.println("1. Insertion in Undirected graph");
		System.out.println("2. Insertion in Directed graph");
		System.out.println("3. Insertion with weight in Undirected graph");
		System.out.println("4. Insertion with weight in Directed graph");
		System.out.println("5. Insertion with weight in Undirected graph for Kruskal's Algorithm");
		System.out.println("6. Insertion with weight in directed graph for ShortestPath -ve Edge BellmanFord Algorithm");
		int ch=sc.nextInt();
		
		if(ch==3 || ch==4 || ch==5 || ch==6) {
			Graph2 g2=new Graph2(v);
			for(int i=0;i<e;i++) {
				System.out.println("Enter Source, destination and weight");
				int src=sc.nextInt();
				int des=sc.nextInt();
				int wt=sc.nextInt();
				if(ch==3)
					g2.addEdgeU(src, des,wt);
				else if(ch==4)
					g2.addEdgeD(src, des,wt);
				else if(ch==5) {
					g2.addEdgeU(src, des,wt);
					g2.addEdgeKruskal(src, des, wt);
				}
				else if(ch==6) {
					g2.addEdgeD(src, des,wt);
					g2.addEdgeBellman(src, des, wt);
				}
				else {System.out.println("Invalid Choice"); return;}
			}
			g2.printAdjaencyList();
			if(ch==4 || ch==6) {
			System.out.println("Shortes path DAG:-"+Arrays.toString(g2.shortestPathDAGtopo(0)));
			System.out.println("Shortes path DG Bellman's Algorithm:-"+Arrays.toString(g2.ShortestPathDGBellman(0)));
			}
			else {
				System.out.println("Shortes path UG:-"+Arrays.toString(g2.shortestPathBfsUW(0)));
				System.out.println("MST Prim's Algo:-"+Arrays.toString(g2.primMst()));
				System.out.println("MST Kruskal's Algo:-");g2.kruskalMst();
			}
		}
		
		else {
				Graph1 g1=new Graph1(v);
				for(int i=0;i<e;i++) {
					System.out.println("Enter Source and destination");
					int src=sc.nextInt();
					int des=sc.nextInt();
					if(ch==1)
						g1.addEdgeU(src, des);
					else if(ch==2)
						g1.addEdgeD(src, des);
					else {System.out.println("Invalid Choice"); return;}
				}
				g1.printAdjaencyList();
				System.out.println("BFS Print:-");
				g1.PrintBfs();
				System.out.println();
				System.out.println("DFS print:-");
				g1.printDfs();
				System.out.println();
				
				if(ch==1) {
					System.out.println("Bipartite Graph by BFS? - "+g1.isBipartiteBfs());
					System.out.println("Bipartite Graph by DFS? - "+g1.isBipartiteDfs());
					System.out.println("Cycle in UndirectedGraph by BFS? - "+g1.isCycleBfsU());
					System.out.println("Cycle in UndirectedGraph by DFS? - "+g1.isCycleDfsU());
					System.out.println("Shortest path in UndirectedGraph of 1 weight, by BFS:-"); g1.shortestPathBfsU(0);
					System.out.println("Bridges in undirected graph:-");g1.bridgeDfsU(); // this will give ArticulationPoints also.
				}
				if(ch==2) {
					System.out.println("Cycle in DirectedGraph by DFS? - "+g1.isCycleDfsD());
					System.out.println("Cycle in DirectedGraph by BFS? - "+g1.isCycleBfsD());
					System.out.println("Topological sort by Dfs:-");g1.printTopoDfs();
					System.out.println();
					System.out.println("Topological sort by Bfs:- "+Arrays.toString(g1.getTopoBfs()));
					System.out.println("Strongly Connected Components are:- ");g1.SCCprintDfs();
				}
		}
		
		
	}
	
}

class Graph1{
	
	ArrayList<Integer> graph[];
	int vertices;
	// array of ArrayList, index of graph=vertices and value of graph=adjacent node
	public Graph1(int v) {
		vertices=v;
		graph=new ArrayList[v];
		for(int i=0;i<v;i++) {
			graph[i]=new ArrayList<>();
		}
	}
	
	
	// 01 Insertion in graph and PrintAdjaency List STARTS
		public void addEdgeU(int source,int destination) { // insertion in undirected graph
			graph[source].add(destination);
			graph[destination].add(source);
		}
		public void addEdgeD(int source,int destination) { // insertion in directed graph
			graph[source].add(destination);
		}
		
		public void printAdjaencyList() {
			System.out.println("AdjaencyList:-");
			for(int i=0;i<vertices;i++) {
				System.out.print(i+"--> ");
				for(int j=0;j<graph[i].size();j++) {
					System.out.print(graph[i].get(j)+"  ");
				}
				System.out.println();
			}
		}
	// 01 Insertion in graph and PrintAdjaency List ENDS
	
	
		
	// 02 PrintBfs() STARTS	
		public void PrintBfs() {
			boolean vis[]=new boolean[vertices];
			
			for(int i=0;i<vertices;i++) {
				if(!vis[i]) {
					 
					Queue<Integer> q=new LinkedList<>();
					q.add(i);
					vis[i]=true;
					
					
					while(!q.isEmpty()) {
						Integer vert=q.poll();
						System.out.print(vert+" ");//print bfs
						
						for(Integer adj: graph[vert]) {
							if(vis[adj]==false) {
								vis[adj]=true;
								q.add(adj);
							}
						}
						
					}// while
				}//if
			}//for
		}//()
	// 02 PrintBfs() ENDS
	
		
	
	// 03 PrintDfs() STARTS
		public void printDfs() {
			boolean vis[]=new boolean[vertices];
			
			for(int i=0;i<vertices;i++) {
				if(!vis[i]) {
					vis[i]=true;
					Dfs(i,vis);
				}
			}
		}
		private void Dfs(int vert,boolean vis[]) {
			System.out.print(vert+" ");
			for(Integer adj: graph[vert]) {
				if(!vis[adj]) {
					vis[adj]=true;
					Dfs(adj,vis);
				}
			}
		}
	// 03 PrintDfs() ENDS
		
		
		
	// 04 isCycle() by BFS for Undirected graph STARTS
		class Node{
			int curr;
			int prev;
			public Node(int curr,int prev) {
				this.curr=curr; this.prev=prev;
			}
		}
		
		public boolean isCycleBfsU() {
			boolean vis[]=new boolean[vertices];
			for(int i=0;i<vertices;i++) {
				if(!vis[i]) {
					vis[i]=true;
					 if(cycleDetectionBfs(i,vis)) return true;
				}
			}
			return false;
		}
		
		private boolean cycleDetectionBfs(int node,boolean vis[]) {
			Queue<Node> q=new LinkedList<>();
			q.add(new Node(node,-1));
			while(!q.isEmpty()) {
				Integer vert=q.peek().curr;
				Integer prev=q.peek().prev;
				q.remove();
				
				for(Integer adj:graph[vert]) {
					if(!vis[adj]) {
						vis[adj]=true;
						q.add(new Node(adj,vert));
					}
					else if(adj!=prev) return true;
				}
			}
			return false;
		}
	// 04 isCycle() by BFS for Undirected graph ENDS
		
		
		
	// 05 isCycle() by DFS for Undirected graph STARTS
		public boolean isCycleDfsU() {
			boolean vis[]=new boolean[vertices];
			for(int i=0;i<vertices;i++) {
				if(!vis[i]) {
					vis[i]=true;
					if(cycleDetectionDfsU(i,-1,vis)) return true;
				}
			}
			return false;
		}


		private boolean cycleDetectionDfsU(int node, int prev, boolean vis[]) {
			for(Integer adj: graph[node]) {
				if(!vis[adj]) {
					vis[adj]=true;
					if(cycleDetectionDfsU(adj,node,vis)) return true;
				}
				else if(adj!=prev) return true;
			}
			return false;
		}
	// 05 isCycle() by DFS for Undirected graph ENDS
		
		
		
		
	// 06 isBipartite() by BFS STARTS
		public boolean isBipartiteBfs() {
			int color[]=new int[vertices];
			Arrays.fill(color, -1);
			
			for(int i=0;i<vertices;i++) {
				if(color[i]==-1) {
					color[i]=1;
					if(!bipartiteDetectionBfs(i,color)) return false;
				}
			}
			return true;
		}

		private boolean bipartiteDetectionBfs(int node, int[] color) {
			Queue<Integer> q=new LinkedList<>();
			q.add(node);
			
			while(!q.isEmpty()) {
				int vert=q.poll();
				for(Integer adj: graph[vert]) {
					if(color[adj]==-1) {
						color[adj]=1-color[vert];
						q.add(adj);
					}
					else if(color[adj] == color[vert]) return false;
				}
			}
			return true;
		}
	// 06 isBipartite() by BFS ENDS
		
		
		
	// 07 isBipartite() by DFS STARTS
		public boolean isBipartiteDfs() {
			int color[]=new int[vertices];
			Arrays.fill(color, -1);
			for(int i=0;i<vertices;i++) {
				if(color[i]==-1) {
					color[i]=1;
					if(!bipartiteDetectionDfs(i,color)) return false;
				}
			}
			return true;
		}


		private boolean bipartiteDetectionDfs(int node, int[] color) {
			for(Integer adj: graph[node]) {
				if(color[adj]==-1) {
					color[adj]=1-color[node];
					if(!bipartiteDetectionDfs(adj,color)) return false;
				}
				else if(color[adj]==color[node]) return false;
			}
			return true;
		}
	// 07 isBipartite() by DFS ENDS
		
		
		
	// 08 isCycle() by DFS for Directed graph STARTS
		public boolean isCycleDfsD() {
			boolean vis[]=new boolean[vertices];
			boolean dfsVis[]=new boolean[vertices];
			
			for(int i=0;i<vertices;i++) {
				if(!vis[i]) {
					vis[i]=true; dfsVis[i]=true;
					if(cycleDetectionDfsD(i,vis,dfsVis)) return true;
				}
			}
			return false;
		}
	
		private boolean cycleDetectionDfsD(int vert, boolean[] vis, boolean[] dfsVis) {
			for(Integer adj: graph[vert]) {
				if(!vis[adj]) {
					vis[adj]=true; dfsVis[adj]=true;
					if(cycleDetectionDfsD(adj,vis,dfsVis)) return true;
				}
				else if(dfsVis[adj]) return true;
			}
			dfsVis[vert]=false;
			return false;
		}
	// 08 isCycle() by DFS for Directed graph ENDS	

		
		
		
	// 09 Topological sort for DAG by DFS STARTS
		public void printTopoDfs() {
			if(isCycleDfsD()) {
				System.out.println("Topological sort not possible for cyclic graph"); return;
			}
			boolean vis[]=new boolean[vertices];
			Stack<Integer> st=new Stack<>();
			for(int i=0;i<vertices;i++) {
				if(!vis[i]) {
					vis[i]=true;
					topoSort(i,vis,st);
				}
			}
			while(!st.isEmpty()) {
				System.out.print(st.pop()+" ");
			}
			
		}

		private void topoSort(int node, boolean[] vis,Stack<Integer> st) {
			
			for(Integer adj: graph[node]) {
				if(!vis[adj]) {
					vis[adj]=true;
					topoSort(adj,vis,st);
				}
			}
			st.push(node);
			
		}
	// 09 Topological sort for DAG by DFS STARTS
		
		
		
		
	// 10 Topological sort for DAG by BFS(Khan's Algorithm) STARTS
		public int[] getTopoBfs() {
			int topo[]=new int[vertices];
			int indeg[]=new int[vertices];
			
		//STEP 1: get Indegree for each vertices
			for(int i=0;i<vertices;i++) {
				for(Integer adj: graph[i]) {
					indeg[adj]++;
				}
			}
		// STEP 2: add all the vertices having indegree 0 into queue
			Queue<Integer> q=new LinkedList<>();
			for(int i=0;i<vertices;i++) {
				if(indeg[i]==0)
					q.add(i);
			}
		// Step 3: run queue till empty
			int ind=0;
			while(!q.isEmpty()) {
				int vert=q.poll();
				topo[ind++]=vert;
				
				for(Integer adj: graph[vert]) {
					indeg[adj]--;
					if(indeg[adj]==0)
						q.add(adj);
				}
				
			}
			
			return topo;
		}
	// 10 Topological sort for DAG by BFS(Khan's Algorithm) ENDS
		
		
		
	// 11 isCycle() by BFS for Directed graph STARTS
		public boolean isCycleBfsD() {
			int indeg[]=new int[vertices];
			for(int i=0;i<vertices;i++) {
				for(Integer adj: graph[i]) {
					indeg[adj]++;
				}
			}
			
			Queue<Integer> q=new LinkedList<>();
			for(int i=0;i<vertices;i++) {
				if(indeg[i]==0)
					q.add(i);
			}
			
			int cnt=0;
			while(!q.isEmpty()) {
				int vert=q.poll();
				cnt++;
				
				for(Integer adj:graph[vert]) {
					indeg[adj]--;
					if(indeg[adj]==0) {
						q.add(adj);
					}
				}
			}
			return cnt!=vertices;
		}
	// 11 isCycle() by BFS for Directed graph ENDS
		
		
		
		
	// 12 shortestPath() by BFS for Undirected graph with unit weight STARTS
		public void shortestPathBfsU(int src) {
			int dis[]=new int[vertices];
			Arrays.fill(dis, 999999);
			
			dis[src]=0;
			Queue<Integer> q=new LinkedList<>();
			q.add(src);
			
			while(!q.isEmpty()) {
				int vert=q.poll();
				
				for(Integer adj:graph[vert]) {
					if(dis[vert]+1 < dis[adj]) {
						dis[adj]=dis[vert]+1;
						q.add(adj);
					}
				}
			}
			System.out.println(Arrays.toString(dis));
		}
	// 12 shortestPath() by BFS for Undirected graph with unit weight ENDS
		
		
		
	// 17 BridgeInGraph + articulationPoint STARTS
			
			public void bridgeDfsU() {
				int timer=0;
				boolean vis[]=new boolean[vertices];
				int tad[]=new int[vertices];
				int connection[]=new int[vertices]; // value in this either can be of lowerTadVertices, OR = to tadOfItself.
				boolean articulationPoint[]=new boolean[vertices];
				for(int i=0;i<vertices;i++) {
					if(!vis[i]) {
						vis[i]=true;
						printBridgeDfs(i,-1,vis,tad,connection,timer,articulationPoint);
					}
				}
				System.out.println("Articulation Points:-");
				for(int i=0;i<vertices;i++) {
					if(articulationPoint[i])
						System.out.println(i);
				}
			}
		
			private void printBridgeDfs(int node, int parent, boolean[] vis, int[] tad, int[] connection,int timer, boolean articulationPoint[]) {
				tad[node]=connection[node]=timer++;
				
				for(Integer adj: graph[node]) {
					if(adj==parent) continue;
					
					if(!vis[adj]) {
						vis[adj]=true;
						printBridgeDfs(adj,node,vis,tad,connection,timer,articulationPoint);
						connection[node]=Math.min(connection[node], connection[adj]);
						
						if(connection[adj] > tad[node]) {
							System.out.println("("+node+", "+adj+")");
							articulationPoint[node]=true;
							articulationPoint[adj]=true;
						}
						
					}
					else {
						connection[node]=Math.min(connection[node], connection[adj]);
					}
				}
				
			}

    // 17 BridgeInGraph + articulationPoint ENDS
			
			
			
			
	// 18 SCC(OWN) STARTS
		// PrintDfs() STARTS
			public void SCCprintDfs() {
				boolean vis[]=new boolean[vertices];
				
				for(int i=vertices-1;i>=0;i--) {
					if(!vis[i]) {
						vis[i]=true;
						SCCDfs(i,vis);
						System.out.println();
					}
					
				}
			}
			private void SCCDfs(int vert,boolean vis[]) {
				System.out.print(vert+" ");
				for(Integer adj: graph[vert]) {
					if(!vis[adj]) {
						vis[adj]=true;
						SCCDfs(adj,vis);
					}
				}
			}
		// PrintDfs() ENDS	
	// 18 SCC(OWN) ENDS		


	}

class Graph2{
	
	class pair implements Comparable<pair>{
		int des;
		int weight;
		int par;
		public pair(int des,int wt,int par) {
			this.des=des;
			weight=wt;
			this.par=par;
		}
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
	}
	ArrayList<pair> graph[];
	int vertices;
	// array of ArrayList, index of graph=vertices and value of graph=adjacent node
	public Graph2(int v) {
		vertices=v;
		graph=new ArrayList[v];
		for(int i=0;i<v;i++) {
			graph[i]=new ArrayList<>();
		}
	}
	
	
	// Insertion in graph and PrintAdjaency List STARTS
		public void addEdgeU(int source,int destination,int weight) { // insertion in undirected graph
			graph[source].add(new pair(destination,weight,source));
			graph[destination].add(new pair(source,weight,destination));
		}
		public void addEdgeD(int source,int destination,int weight) { // insertion in directed graph
			graph[source].add(new pair(destination,weight,source));
		}
		
		public void printAdjaencyList() {
			System.out.println("AdjaencyList:-");
			for(int i=0;i<vertices;i++) {
				System.out.print(i+"--> ");
				for(int j=0;j<graph[i].size();j++) {
					System.out.print("( "+graph[i].get(j).des+", "+graph[i].get(j).weight+", "+graph[i].get(j).par+" )  ");
				}
				System.out.println();
			}
		}
	// Insertion in graph and PrintAdjaency List ENDS
	
		
		
	// 13 Shortest path in DAG using Toposort STARTS
		private void topoSort(int vert, boolean[] vis, Stack<Integer> st) {
			for(pair adj: graph[vert]) {
				if(!vis[adj.des]) {
					vis[adj.des]=true;
					topoSort(adj.des,vis,st);
				}
			}
			st.push(vert);
		}
		
		public int[] shortestPathDAGtopo(int src) {
			// topoSort START
				boolean vis[]=new boolean[vertices];
				Stack<Integer> st=new Stack<>();
				
				for(int i=0;i<vertices;i++) {
					if(!vis[i]) {
						vis[i]=true;
						topoSort(i,vis,st);
					}
				}
			// topoSort DONE
				
				int dis[]=new int[vertices];
				final int INF=999999;
				Arrays.fill(dis, INF);
				
				dis[src]=0;
				
				while(!st.isEmpty()) {
					int vert=st.pop();
					if(dis[vert]!=INF) {
						
						for(pair adj:graph[vert]) {
							dis[adj.des]=Math.min(dis[vert]+adj.weight, dis[adj.des]);
							/**if( dis[vert]+adj.weight < dis[adj.des] ) {
								dis[adj.des]=dis[vert]+adj.weight;
							}**/
							
						}
					}
				}
				return dis;
		}
	// 13 Shortest path in DAG using Toposort ENDS

		
		
		
	// 14 Shortest path in weighted undirected graph(dijkstra's Algorithm) STARTS
		public int[] shortestPathBfsUW(int src) {
			final int INF=999999;
			int dis[]=new int[vertices];
			Arrays.fill(dis, INF);
			
			dis[src]=0;
			PriorityQueue<pair> pq=new PriorityQueue();
			pq.add(new pair(src,0,-1));// ignore -1
			
			while(!pq.isEmpty()) {
				pair vert=pq.remove();
				for(pair adj: graph[vert.des]) {
					if(adj.weight+vert.weight<dis[adj.des]) {
						dis[adj.des]=adj.weight+vert.weight;
						pq.add(new pair(adj.des,dis[adj.des],vert.des)); // ignore vert.des
					}
				}
			}
			return dis;
		}
	// 14 Shortest path in weighted undirected graph(dijkstra's Algorithm) ENDS
		
	
		
		
	// 15 MST - Prim's Algorithm STARTS
		public int[] primMst() {
			int parent[]=new int[vertices];
			boolean vis[]=new boolean[vertices];
			
			PriorityQueue<pair> pq=new PriorityQueue();
			pq.add(new pair(0,0,-1));
			
			while(!pq.isEmpty()) {
				
				pair vert=pq.remove(); // remove
				if(!vis[vert.des]) {
					vis[vert.des]=true; // mark
					parent[vert.des]=vert.par; // work
					for(pair adj: graph[vert.des]) {
						if(!vis[adj.des]) {
							pq.add(adj); // add
						}
					}
				}
			}
			return parent;
		}
	// 15 MST - Prim's Algorithm ENDS	
		
		
	
		
	// 16 MST - Kruskal's Algorithm STARTS
		//DisJoint functions STARTS
			private int findPar(int node,int parent[]) { // it finds the ultimate parent of node
				if(node==parent[node]) return node;
				return parent[node]=findPar(parent[node],parent);
			}
			private void union(int u,int v,int parent[],int rank[]) {
				int pu=findPar(u,parent);
				int pv=findPar(v,parent);
				
				if(rank[pu]<rank[pv]) {
					parent[pu]=pv; // hey pu from now your parent is pv.
				}
				else if(rank[pv]<rank[pu]) {
					parent[pv]=pu; // hey pv from now your parent is pu.
				}
				else {
					parent[pv]=pu;
					rank[pu]++;
				}
			}
		//DisJoint functions ENDS
		ArrayList<pair> edge=new ArrayList<>();
		public void addEdgeKruskal(int src,int des,int weight) {
			edge.add(new pair(des,weight,src));
		}
		public void kruskalMst() {
			Collections.sort(edge);
			int parent[]=new int[vertices];
			int rank[]=new int[vertices];

			ArrayList<pair> mst=new ArrayList<>();
			
			for(int i=0;i<vertices;i++)
				parent[i]=i;
			
			for(pair ege: edge) {
				if(findPar(ege.des,parent) != findPar(ege.par,parent)) {
					union(ege.des,ege.par,parent,rank);
					mst.add(ege);
				}
			}
			for(pair print: mst) {
				System.out.println(print.des+", "+print.par);
			}
		}
	// 16 MST - Kruskal's Algorithm ENDS
		
		
		
		
	// 19 ShortestPath-DG(containing +ve,-ve weights) BellmanFord's Algorithm STARTS
		ArrayList<pair> edgeB=new ArrayList<>();
		public void addEdgeBellman(int src,int des,int weight) {
			edgeB.add(new pair(des,weight,src));
		}
		public int[] ShortestPathDGBellman(int src) {
			int dis[]=new int[vertices];
			
			final int INF=999999;
			int error[]= {INF};
			Arrays.fill(dis,INF);
			dis[src]=0;
			// Step 1 : 1st relaxation
			for(int i=1;i<vertices;i++) {
				for(pair ege:edgeB) {
					if(dis[ege.par]+ege.weight<dis[ege.des])
						dis[ege.des]=dis[ege.par]+ege.weight;
				}
			}
			// Step 2 : 2nd relaxation for checking -Ve cycle
			for(pair ege:edgeB) {
				if(dis[ege.par]+ege.weight<dis[ege.des])
				{	System.out.println("NEGATIVE CYCLE FOUND"); return error;}
			}
			return dis;
		}
	// 19 ShortestPath-DG(containing +ve,-ve weights) BellmanFord's Algorithm ENDS
	
		
}