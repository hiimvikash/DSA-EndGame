
# [**The Celebrity Problem**](https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1#)

[**Video Reference**](https://youtu.be/CiiXBvrX-5A)

```java
class Solution
{ 

    int celebrity(int arr[][], int n)
    {
    	// code here
    	Stack<Integer> st=new Stack<>();
    	for(int i=0;i<n;i++) st.push(i);
    	
    	while(st.size() > 1){
    	    int i = st.pop();
    	    int j = st.pop();
    	    
    	    if(arr[i][j]==1){
    	        // if i knows j ? --> i is not celebrity
    	        st.push(j);
    	    }else{
     	        // if i dont knows j --> j is not celebrity
     	        st.push(i);
    	    }
    	}
    	int pot = st.pop(); // potential candidate
    	
    	for(int i=0; i<n; i++){
    	    if(i!=pot)
    	        {if(arr[pot][i]==1 || arr[i][pot]==0) return -1;   }
    	}
    	return pot;
    	
    }
}
```