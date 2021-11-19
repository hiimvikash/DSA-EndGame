class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
            for (String log : logs) {
                if (log.equals("./")) 
                    continue;
                else if (log.equals("../")) {
                    depth--;
                    if (depth < 0) 
                        depth = 0;
                } 
                else 
                    depth++;
            }
            return depth;
    }
}