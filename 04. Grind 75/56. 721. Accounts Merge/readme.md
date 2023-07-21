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
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet dj=new DisjointSet(n);
        HashMap<String, Integer> emailToAccidx = new HashMap<>();

        for(int i = 0; i<n; i++){
            List<String> acc = accounts.get(i);
            List<String> emails = acc.subList(1,acc.size());

            for(String e : emails){
                if(!emailToAccidx.containsKey(e)) emailToAccidx.put(e,i);
                else{
                    int accidx = emailToAccidx.get(e);
                    dj.union(i,accidx);
                }
            }
        }

        List<String> mergedMail[] = new ArrayList[n];
        for(int i = 0; i<n; i++) mergedMail[i] = new ArrayList<>();
        for(String e: emailToAccidx.keySet()){
            int idx = dj.findPar(emailToAccidx.get(e));

            mergedMail[idx].add(e);
        }

        // now prepare answer
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(mergedMail[i].size() == 0) continue;
            List<String> subans = new ArrayList<>();
            subans.add(accounts.get(i).get(0));

            Collections.sort(mergedMail[i]);
            for(String em : mergedMail[i]) subans.add(em);

            ans.add(subans);
        }
        return ans;
    }
}

class DisjointSet{
    int n;
    int parent[];
    int rank[];
    
    public DisjointSet(int n){
        rank = new int[n];
        parent = new int[n];
        for(int i = 0; i<n; i++) parent[i] = i;
    }
    
    public int findPar(int n){
        if(parent[n] == n) return n;
        return parent[n] = findPar(parent[n]);
    }
    
    public void union(int u, int v){
        int pu = findPar(u);
        int pv = findPar(v);
        
        if(rank[pu] < rank[pv]) parent[pu] = pv;
        else if(rank[pu] > rank[pv]) parent[pv] = pu;
        else{
            parent[pu] = pv; rank[pu]++;
        }
    }
}
```

[**Video reference**](https://youtu.be/FMwpt_aQOGw)
