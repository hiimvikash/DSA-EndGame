class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>st=new Stack();
        for(char c :  s.toCharArray()){ 
               if(c=='(')
                   st.push(c);
               else{
                    if(c==')' && !st.isEmpty() && st.peek()=='(')
                        st.pop();
                   else
                       st.push(c);
               }
       }
        return st.size();
            
    }
}
