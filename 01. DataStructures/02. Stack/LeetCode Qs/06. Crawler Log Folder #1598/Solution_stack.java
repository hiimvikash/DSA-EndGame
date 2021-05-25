class Solution {
    public int minOperations(String[] logs) {
        Stack<Integer> st=new Stack();
        
        for(String log:logs){
            if(log.equals("../") && st.isEmpty())
                continue;
            else if(log.equals("../") )
                st.pop();
            else if(log.equals("./"))
                continue;
            else
                st.push(1);
        }
        
        return st.size();
    }
}