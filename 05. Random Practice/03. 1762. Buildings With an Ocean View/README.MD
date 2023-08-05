# 1762. Buildings With an Ocean View

There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.

The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.

Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.

 

- Example 1:
Input: heights = [4,2,3,1]
Output: [0,2,3]
Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.

- Example 2:
Input: heights = [4,3,2,1]
Output: [0,1,2,3]
Explanation: All the buildings have an ocean view.

- Example 3:

Input: heights = [1,3,2,4]
Output: [3]
Explanation: Only building 3 has an ocean view.
- Example 4:
Input: heights = [2,2,2,2]
Output: [3]
Explanation: Buildings cannot see the ocean if there are buildings of the same height to its right.

<hr>

# Approach 1 : FIND NextGreaterThan= element for each index (Stack Concept)

- If there are no ```NextGreaterThan= element``` for that index of i element then store N
- else store index of ```NextGreaterThan= element```

```java
public static List<Integer> oceanView(int heights[], int n){
        // here we r finding nextGreaterThan=right(indexArray)
        
        int ngEr[]=new int[n]; // nextGreaterThan=right
        Stack<Integer> st=new Stack<>();
        
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && heights[i] > heights[st.peek()]) st.pop();
            
            if(st.isEmpty()) ngEr[i] = n;
            else ngEr[i] = st.peek();
            
            st.push(i);
        }
        
        List<Integer> ans=new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(ngEr[i] == n) ans.add(i);
        }
        return ans;
}
```

# Approach 2 : Maintain the maxH from back and compare it with current building height.

```java
public static List<Integer> oceanView(int heights[], int n){
        // traverse from back and keep maintaining the maxHeight
        // this will work coz OceanView will be blocked for height H if there is greaterThan= height on right no matter justNext 
        
        int maxH = 0; 
        boolean oceanview[] = new boolean[n];
        for(int i = n-1; i>=0; i--){
            if(heights[i] > maxH) oceanview[i] = true;
            maxH = Math.max(maxH, heights[i]);
        }
        
        List<Integer> ans=new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(oceanview[i]) ans.add(i);
        }
        return ans;
}
```