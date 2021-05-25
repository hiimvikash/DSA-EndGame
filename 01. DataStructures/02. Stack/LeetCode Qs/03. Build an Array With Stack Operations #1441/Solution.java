class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> arr = new ArrayList<String>();
        int input=1;//1,2,3..n
        
        for(int i=0;i<target.length;i++){
            while(input<target[i]){
                arr.add("Push");
                arr.add("Pop");
                input++;
            }
            arr.add("Push");
            input++;
        }
        return arr;
    }
}

/** if you want to use stack:-

import java.util.*;
class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> arr = new ArrayList<String>();
        Stack st=new Stack <String>();
        int input=1;//1,2,3..n
        
        for(int i=0;i<target.length;i++){
            while(input<target[i]){
                st.push("Push");
                st.push("Pop");
                input++;
            }
            st.push("Push");
            input++;
        }
        while(!st.isEmpty()){
            arr.add((String)st.pop());
        }
        Collections.reverse(arr);
        return arr;
    }
}

**/