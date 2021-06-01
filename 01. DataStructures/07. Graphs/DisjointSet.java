package graphDS;

public class DisjointSet {

	int parent[];
	int rank[];
	int vertices;
	public DisjointSet(int vert) {
		vertices=vert;
		parent=new int[vertices];
		rank=new int[vertices];
		make();
	}
	public void make() {
		for(int i=0;i<vertices;i++) {
			parent[i]=i;
		}
	}
	public int findPar(int node) { // it finds the ultimate parent of node
		if(node==parent[node]) return node;
		return parent[node]=findPar(parent[node]);
	}
	public void union(int u,int v) {
		int pu=findPar(u);
		int pv=findPar(v);
		
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
	
	// is 2 and 3 belongs to the same component or not.
	public boolean isSameComponent(int a,int b) {
		return findPar(a)==findPar(b);
	}

}


