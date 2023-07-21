class DisjointSet{
    int n;
    int parent[];
    int rank[];
    int size[];
    
    public DisjointSet(int n){
        rank = new int[n];
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i<n; i++) parent[i] = i;
        Arrays.fill(size,1);
    }
    
    public int findPar(int n){
        if(parent[n] == n) return n;
        return parent[n] = findPar(parent[n]);
    }
    
    public void unionR(int u, int v){
        int pu = findPar(u);
        int pv = findPar(v);
        
        if(rank[pu] < rank[pv]) parent[pu] = pv;
        else if(rank[pu] > rank[pv]) parent[pv] = pu;
        else{
            parent[pu] = pv; 
            rank[pv]++;
        }
    }
        public void unionS(int u, int v){
        int pu = findPar(u);
        int pv = findPar(v);
        
        if(size[pu] < size[pv]){ 
            parent[pu] = pv;
            size[pv]+=size[pu];
        }
        else if(size[pu] > size[pv]){ 
            parent[pv] = pu;
            size[pu]+=size[pv];
        }
        else{
            parent[pu] = pv; 
            size[pv]+=size[pu];
        }
    }
}
