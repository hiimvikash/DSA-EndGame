class Solution {
    public String removeDuplicates(String S) {
        Stack st=new Stack<Character>();
        StringBuilder ans=new StringBuilder(S.length());
        for(int i=0; i<S.length(); i++) {
            if(!st.isEmpty() && (char)st.peek() == S.charAt(i)) {
                st.pop();
                ans.deleteCharAt(ans.length()-1);
            }
            else {
                st.add(S.charAt(i));
                ans.append(S.charAt(i));
            }
        }
        return ans.toString();
    }
}