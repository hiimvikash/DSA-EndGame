# [721. Accounts Merge](https://leetcode.com/problems/accounts-merge/)
![image](https://github.com/hiimvikash/DSA-EndGame/assets/71629248/29eaaacf-ed8f-4e4c-a5b7-6f1718481b0a)

## Intution : - 
- merge the AccountIndex which are having any emails in common
    - This can be done by using HASHMAP(EMAIL - ACC.INDEX)
        - iiterate through all emails and map them with their respective ACC.INDEX
        - if that Email is already seen above then, **merge currACC.INDEX & B4SeenACC.INDEX**
- Now you have created your HM
- Now itterate through HM and make ANSWER
    - each ACC.INDEX has unique parent
    - one's with same parent are considerd to be in one group and their parentINDEX is their groupID
    
```java
class UnionFind{
    int parent[]; int rank[];
    int groupCount; // here vertices refers to AccountsIndx
    
    public UnionFind(int v){
        groupCount = v;
        parent=new int[v]; rank=new int[v];
        for(int i = 0; i<v; i++) parent[i] = i;
    }
    
    public int getAbsoluteParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = getAbsoluteParent(parent[node]);
    }
    
    public void unify(int x, int y){
        groupCount--;
        int px = getAbsoluteParent(x);
        int py = getAbsoluteParent(y);
        
        if(rank[px] < rank[py]) parent[px] = py;
        else if(rank[py] < rank[px]) parent[py] = px;
        else{
            parent[px] = py; rank[py]++;
        }
    }
    
    public boolean sameComponents(int x, int y){
        return (getAbsoluteParent(x)==getAbsoluteParent(y));
    }
}






class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        
        UnionFind uf=new UnionFind(n);
        HashMap<String, Integer> emailToAccIdx=new HashMap<>();
        
        
        for(int i = 0; i<n; i++){ // i represent AccIdx
            List<String> acc = accounts.get(i);
            String name = acc.get(0);
            List<String> emails = acc.subList(1, acc.size());
            
            for(String e : emails){
                
                if(!emailToAccIdx.containsKey(e)) emailToAccIdx.put(e, i);
                else{
                    int parAccIdx = emailToAccIdx.get(e);
                    uf.unify(i,parAccIdx);
                }
            }
        }// itteration in ACCOUNT
        
        
        
        // ANSWER MAKING
        List<List<String>> mergedAns=new ArrayList<>();
        
        HashMap<Integer, Integer> grpId2Oidx = new HashMap<>();
        int nextIdx = 0;
        for(String e : emailToAccIdx.keySet()){
            int gid = uf.getAbsoluteParent(emailToAccIdx.get(e));
            
            if(!grpId2Oidx.containsKey(gid)){
                grpId2Oidx.put(gid,nextIdx);
                String name = accounts.get(emailToAccIdx.get(e)).get(0);
                mergedAns.add(new ArrayList<>());
                mergedAns.get(nextIdx).add(name);
                mergedAns.get(nextIdx).add(e);
                nextIdx++;
            }
            else{
                int oidx = grpId2Oidx.get(gid);
                mergedAns.get(oidx).add(e);
            }
        }
        
        // sorting
        for(List<String> lst : mergedAns){
            Collections.sort(lst.subList(1, lst.size()));
        }
        
        
        return mergedAns;
    }
    
}
```

[**Video reference**](https://youtu.be/QHniHFvxAl8)
